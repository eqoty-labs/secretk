package io.eqoty.client

import co.touchlab.kermit.Logger
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.serialization.kotlinx.biginteger.bigIntegerhumanReadableSerializerModule
import io.eqoty.BroadcastMode
import io.eqoty.logs.Log
import io.eqoty.response.*
import io.eqoty.utils.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.decodeHex
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
class RestClient(
    val apiUrl: String,
    val broadcastMode: BroadcastMode = BroadcastMode.Block,
    seed: UByteArray? = null
) {
    var enigmautils: EncryptionUtils = EnigmaUtils(apiUrl, seed)
    val codeHashCache: MutableMap<Any, String> = mutableMapOf()

    val json: Json = Json {
        ignoreUnknownKeys = true
        serializersModule = bigIntegerhumanReadableSerializerModule + SerializersModule {
            polymorphic(TypeValue::class) {
                subclass(AuthAccountsResult::class, AuthAccountsResult.serializer())
            }
        }
    }

    val client: HttpClient = HttpClient {
        install(DefaultRequest) {
            contentType(ContentType.Application.Json)
        }
        install(ContentNegotiation) {
            json(json)
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
            this.client.post(this.apiUrl + path){
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
            throw Error("$body (HTTP ${err.response.status})");
        } else {
            throw err;
        }
    }

    /**
     * Broadcasts a signed transaction to into the transaction pool.
     * Depending on the RestClient's broadcast mode, this might or might
     * wait for checkTx or deliverTx to be executed before returning.
     *
     * @param tx a signed transaction as StdTx (i.e. not wrapped in type/value container)
     */
    suspend inline fun postTx(tx: UByteArray): TxsResponseData {
        val txString = tx.toByteString().base64()
        val params =
            json.parseToJsonElement("""{
                "tx_bytes": "$txString",
                "mode": "${this.broadcastMode.mode}"
            }""").jsonObject

        val responseData : TxsResponse = post("/cosmos/tx/v1beta1/txs", params);
        if (responseData.tx_response.txhash.isBlank()) {
            throw Error("Unexpected response data format");
        }
        return responseData.tx_response
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


    /**
     * Makes a smart query on the contract and parses the reponse as JSON.
     * Throws error if no such contract exists, the query format is invalid or the response is invalid.
     */
    suspend fun queryContractSmart(
        contractAddress: String,
        query: JsonObject,
        addedParams: JsonObject? = null,
        _contractCodeHash: String? = null,
    ): JsonObject {
        val contractCodeHash = if (_contractCodeHash == null) {
            this.getCodeHashByContractAddr(contractAddress)
        } else {
            this.codeHashCache[contractAddress] = _contractCodeHash
            _contractCodeHash
        }

        val encrypted = this.enigmautils.encrypt(contractCodeHash, query)

        val nonce = encrypted.sliceArray(IntRange(0, 31)).toUByteArray()

        val encoded = encrypted.toByteArray().toByteString().base64Url()

        val paramString = if (addedParams != null) {
            TODO() //URLSearchParams(addedParams).toString();
        } else ""

        val encodedContractAddress = Bech32.decode(contractAddress).data.toByteString().base64Url()

        val path = "/compute/v1beta1/contract/${encodedContractAddress}/smart?query_data=${encoded}"//&${paramString}"

        val responseData : SmartQueryResponse = try {
            get(path)
        } catch (err: Throwable) {
//            const errorMessageRgx = /encrypted: (.+?): (?:instantiate|execute|query) contract failed/g;
//            const rgxMatches = errorMessageRgx.exec(err.message);
//            if (rgxMatches == null || rgxMatches?.length != 2) {
//                throw err;
//            }
//
//            try {
//                const errorCipherB64 = rgxMatches[1];
//                const errorCipherBz = Encoding.fromBase64(errorCipherB64);
//
//                const errorPlainBz = await this.enigmautils.decrypt(errorCipherBz, nonce);
//
//                err.message = err.message.replace(errorCipherB64, Encoding.fromUtf8(errorPlainBz));
//            } catch (decryptionError) {
//                throw new Error(`Failed to decrypt the following error message: ${err.message}.`);
//            }

            throw err;
        }
        val decryptedResponse =  enigmautils.decrypt(responseData.data.decodeBase64Bytes().toUByteArray(), nonce)

        val decodedResponse = decryptedResponse.toByteArray().decodeToString().decodeBase64String().toByteArray().decodeToString()

        return json.parseToJsonElement(decodedResponse).jsonObject
    }

    suspend fun decryptDataField(dataField : UByteArray, nonces: List<UByteArray>): UByteArray {
        val wasmOutputDataCipherBz = dataField

        var error: Throwable? = null
        for (nonce in nonces) {
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
        }

        throw error!!
    }

    suspend fun authAccounts(address: String): CosmosSdkAccount {
        val authResp : AccountResponse = get("/cosmos/auth/v1beta1/accounts/${address}")
        val bankResp : BalanceResponse = get("/cosmos/bank/v1beta1/balances/${address}")

        return CosmosSdkAccount(
            address= authResp.account.address,
            coins = bankResp.balances,
            public_key = PubKeySecp256k1(authResp.account.pub_key.key),
            account_number= authResp.account.account_number ?: BigInteger.ZERO,
            sequence= authResp.account.sequence ?: BigInteger.ZERO,
        )
    }

    // The /node_info endpoint
    suspend fun nodeInfo(): NodeInfoResponse {
        return get("/node_info");
    }

    suspend fun decryptLogs(logs: List<Log>, nonces: MutableList<UByteArray>): List<Log> {
        for (l in logs) {
            for (e in l.events) {
                if (e.type == "wasm") {
                    for (nonce in nonces) {
                        var nonceOk = false
                        for (a in e.attributes) {
                            try {
                                a.key = this.enigmautils.decrypt(a.key.decodeBase64()!!.toUByteArray(), nonce).decodeToString()
                                nonceOk = true
                            } catch (_: Throwable) {}
                            try {
                                a.value = this.enigmautils.decrypt(a.value.decodeBase64()!!.toUByteArray(), nonce).decodeToString()
                                nonceOk = true;
                            } catch (_: Throwable) {}
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
