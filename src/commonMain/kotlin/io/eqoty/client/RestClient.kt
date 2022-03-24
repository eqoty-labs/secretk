package io.eqoty.client

import com.ionspin.kotlin.crypto.util.LibsodiumUtil.fromBase64
import com.ionspin.kotlin.crypto.util.hexStringToUByteArray
import io.eqoty.BroadcastMode
import io.eqoty.response.ContractHashResponse
import io.eqoty.response.SmartQueryResponse
import io.eqoty.response.WasmResponse
import io.eqoty.utils.EnigmaUtils
import io.eqoty.utils.SecretUtils
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
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.encodeUtf8

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
    var enigmautils: SecretUtils = EnigmaUtils(apiUrl, seed)
    val codeHashCache: MutableMap<Any, String> = mutableMapOf()

    private val json: Json = Json {
        ignoreUnknownKeys = true
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

    suspend fun getCodeHashByContractAddr(addr: String): String {
        val codeHashFromCache = codeHashCache[addr]
        if (codeHashFromCache != null) {
            return codeHashFromCache
        }

        val path = "/wasm/contract/${addr}/code-hash"
        val responseData: ContractHashResponse = get(path)

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
        val nonce = encrypted.slice(IntRange(0, 32)).toUByteArray()

        val encoded = encrypted.toByteArray().encodeBase64().encodeUtf8().hex()

        // @ts-ignore
        val paramString = ""//URLSearchParams(addedParams).toString();

        val path = "/wasm/contract/${contractAddress}/query/${encoded}?encoding=hex&${paramString}"

        val responseData : WasmResponse<SmartQueryResponse> = try {
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
        val decryptedResponse =  enigmautils.decrypt(responseData.result.smart.decodeBase64Bytes().toUByteArray(), nonce)
        println("decryptedResponse: ${decryptedResponse.map { it.toUInt() }}")

        println(decryptedResponse.toByteArray().decodeToString().decodeBase64String().toByteArray().decodeToString())
        TODO()
    }

}
