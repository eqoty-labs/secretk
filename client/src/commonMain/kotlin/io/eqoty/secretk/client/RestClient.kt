package io.eqoty.secretk.client

import io.eqoty.cosmwasm.std.types.CodeInfo
import io.eqoty.secretk.BroadcastMode
import io.eqoty.secretk.types.proto.MsgExecuteContractResponseProto
import io.eqoty.secretk.types.proto.MsgInstantiateContractResponseProto
import io.eqoty.secretk.types.proto.MsgProto
import io.eqoty.secretk.types.response.*
import io.eqoty.secretk.types.response.logs.Log
import io.eqoty.secretk.utils.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.toByteString

/**
 * Creates a new client to interact with a Cosmos SDK light client daemon.
 * This class tries to be a direct mapping onto the API. Some basic decoding and normalizatin is done
 * but things like caching are done at a higher level.
 *
 * When building apps, you should not need to use this class directly. If you do, this indicates a missing feature
 * in higher level components. Feel free to raise an issue in this case.
 *
 * @param apiUrl The URL of a Cosmos SDK light client daemon API (sometimes called REST server or REST API)
 * @param broadcastMode Defines at which point of the transaction processing the postTx method (i.e. transaction broadcasting) returns
 * @param seed - The seed used to generate sender TX encryption key. If empty will generate random new one
 */
internal class RestClient(
    val apiUrl: String,
    val broadcastMode: BroadcastMode = BroadcastMode.Block,
    val enigmautils: EncryptionUtils
) {
    val codeHashCache: MutableMap<Any, String> = mutableMapOf()

    val client: HttpClient = HttpClient {
        install(DefaultRequest) {
            contentType(ContentType.Application.Json)
        }
        install(ContentNegotiation) {
            json(Json)
        }
        install(HttpTimeout) {
            socketTimeoutMillis = 60_000
        }
    }


    suspend inline fun <reified T> get(path: String): T {
        val response = try {
            this.client.get(this.apiUrl + path)
        } catch (e: ResponseException) {
            throw parseError(e)
        }
        return response.body()
    }

    suspend inline fun <reified T> post(path: String, params: JsonObject): T {
        val response = try {
            this.client.post(this.apiUrl + path) {
                setBody(params)
            }
        } catch (e: ResponseException) {
            throw parseError(e)
        }
        return response.body()
    }

    /**
     * We want to get message data from 500 errors
     * https://stackoverflow.com/questions/56577124/how-to-handle-500-error-message-with-axios
     * this should be chained to catch one error and throw a more informative one
     */
    suspend fun parseError(err: ResponseException): Error {
        // use the error message sent from server, not default 500 msg
        val body = err.response.bodyAsText()
        if (body != "") {
            throw Error("$body (HTTP ${err.response.status})")
        } else {
            throw err
        }
    }

    /**
     * Broadcasts a signed transaction to into the transaction pool.
     * Depending on the RestClient's broadcast mode, this might or might
     * wait for checkTx or deliverTx to be executed before returning.
     *
     * @param tx a signed transaction as StdTx (i.e. not wrapped in type/value container)
     */
    suspend inline fun <reified T : Any> postTx(tx: UByteArray, simulate: Boolean): T {
        val txString = tx.toByteString().base64()
        val params =
            Json.parseToJsonElement(
                """{
                "tx_bytes": "$txString",
                "mode": "${this.broadcastMode.mode}"
            }"""
            ).jsonObject
        // https://v1.cosmos.network/rpc/v0.45.1
        val path = if (simulate) "/cosmos/tx/v1beta1/simulate" else "/cosmos/tx/v1beta1/txs"
        return post(path, params)
    }


    suspend fun getCodeHashByContractAddr(addr: String): String {
        val codeHashFromCache = codeHashCache[addr]
        if (codeHashFromCache != null) {
            return codeHashFromCache
        }
        // Works... for now...
        // But we may need to switch to getting hash by grpc gateway endpoints:
        // getting codeId from /compute/v1beta1/contract/{address}
        // then using codeId to get hash with:
        // /compute/v1beta1/code/{code_id} endpoint
        val path = "/wasm/contract/${addr}/code-hash"
        val responseData: WasmResponse<String> = get(path)

        codeHashCache[addr] = responseData.result
        return responseData.result
    }

    suspend fun getLabelByContractAddr(addr: String): String {
        val path = "/compute/v1beta1/label/$addr"
        val response: LabelResponse = get(path)
        return response.label
    }

    suspend fun getCodeInfoByCodeId(codeId: Int): CodeInfo {
        val path = "/compute/v1beta1/code/$codeId"
        val responseData: CodeInfoResponse = get(path)
        return responseData.codeInfo
    }


    /**
     * Makes a smart query on the contract and parses the reponse as JSON.
     * Throws error if no such contract exists, the query format is invalid or the response is invalid.
     */
    suspend fun queryContractSmart(
        contractAddress: String,
        query: JsonObject,
        _contractCodeHash: String? = null,
    ): String {
        val contractCodeHash = if (_contractCodeHash == null) {
            this.getCodeHashByContractAddr(contractAddress)
        } else {
            this.codeHashCache[contractAddress] = _contractCodeHash
            _contractCodeHash
        }

        val encrypted = this.enigmautils.encrypt(contractCodeHash, query)

        val nonce = encrypted.sliceArray(IntRange(0, 31)).toUByteArray()

        val encoded = encrypted.toByteArray().toByteString().base64Url()

        val path = "/compute/v1beta1/query/${contractAddress}?query=${encoded}"

        val response: String = try {
            val responseData: SmartQueryResponse = get(path)
            when (responseData.data != null) {
                true -> {
                    val decryptedResponse =
                        enigmautils.decrypt(responseData.data.decodeBase64()!!.toUByteArray(), nonce)
                    decryptedResponse.decodeToString().decodeBase64()!!.utf8().trimEnd()
                }

                false -> {
                    throw Error(responseData.message)
                }
            }
        } catch (t: Throwable) {
            throw decrypt(t, nonce)
        }
        return response
    }

    suspend fun decrypt(t: Throwable, nonce: UByteArray): Throwable {
        val message = t.message ?: return t
        val errorMessageRgx = Regex("""encrypted: (.+?): (?:instantiate|execute|migrate|query|reply to) contract failed""")
        val matches = errorMessageRgx.findAll(message).toList()
        if (matches.isEmpty() || matches.first().groupValues.size < 2) {
            return t
        }
        val decodedError: Error = try {
            val errorCipherB64 = matches.first().groupValues[1]
            val errorCipherBz = errorCipherB64.decodeBase64()!!.toUByteArray()
            val errorPlainBz = enigmautils.decrypt(errorCipherBz, nonce).decodeToString()
            Error(errorPlainBz)
        } catch (decryptionError: Throwable) {
            Error("Failed to decrypt the following error message: ${t.message}. Due to decryptionError: $decryptionError")
        }
        return decodedError
    }

    suspend fun decryptDataField(msg: MsgProto, nonce: UByteArray?): UByteArray {
        val dataField = when (msg) {
            is MsgExecuteContractResponseProto -> {
                msg.data?.toUByteArray() ?: UByteArray(0) { 0u }
            }

            is MsgInstantiateContractResponseProto -> {
                msg.data?.toUByteArray() ?: UByteArray(0) { 0u }
            }

            else -> UByteArray(0) { 0u }
        }
        if (nonce == null) {
            // nonce was not extracted from message. Nothing to decrypt
            return dataField
        }
        val wasmOutputDataCipherBz = dataField

        val error: Throwable
        try {
            val data = enigmautils
                .decrypt(wasmOutputDataCipherBz, nonce)
                .decodeToString()
                .decodeBase64()!!
                .toUByteArray()

            return data
        } catch (t: Throwable) {
            error = t
        }

        throw error
    }

    suspend fun decryptLogs(logs: List<Log>, nonces: List<UByteArray?>): List<Log> {
        for (l in logs) {
            for (e in l.events) {
                if (e.type == "wasm") {
                    for (nonce in nonces.filterNotNull()) {

                        var nonceOk = false
                        for (a in e.attributes) {
                            try {
                                a.key = this.enigmautils.decrypt(a.key.decodeBase64()!!.toUByteArray(), nonce)
                                    .decodeToString()
                                nonceOk = true
                            } catch (_: Throwable) {
                            }
                            try {
                                a.value = this.enigmautils.decrypt(a.value.decodeBase64()!!.toUByteArray(), nonce)
                                    .decodeToString()
                                nonceOk = true
                            } catch (_: Throwable) {
                            }
                        }
                        if (nonceOk) {
                            continue
                        }
                    }
                }
            }
        }

        return logs
    }

}
