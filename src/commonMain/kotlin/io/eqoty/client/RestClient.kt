package io.eqoty.client

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.BroadcastMode
import io.eqoty.response.*
import io.eqoty.types.Coin
import io.eqoty.types.MsgValue
import io.eqoty.types.StdTx
import io.eqoty.utils.Bech32
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
import kotlinx.serialization.json.jsonObject
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
    suspend fun <T: MsgValue> postTx(tx: StdTx<T>): PostTxsResponse {
        val params =
            json.parseToJsonElement("""{
                tx: tx,
                mode: this.broadcastMode,
            }""").jsonObject

        val responseData : PostTxsResponse = post("/txs", params);
        if (responseData.txhash.isBlank()) {
            throw Error("Unexpected response data format");
        }
        return responseData
    }


    suspend fun getCodeHashByContractAddr(addr: String): String {
        val codeHashFromCache = codeHashCache[addr]
        if (codeHashFromCache != null) {
            return codeHashFromCache
        }

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

    suspend fun authAccounts(address: String): WasmResponse<AuthAccountsResult> {
        val authResp : WasmResponse<TypeValue<AuthResponseResult>> = get("/auth/accounts/${address}")
        val bankResp : WasmResponse<List<Coin>> = get("/bank/balances/${address}")

        return WasmResponse<AuthAccountsResult>(
            height = bankResp.height,
            result = AuthAccountsResult(
                value = CosmosSdkAccount(
                    address= authResp.result.value.address,
                    coins = bankResp.result,
                    public_key = authResp.result.value.public_key,
                    account_number= authResp.result.value.account_number ?: BigInteger.ZERO,
                    sequence= authResp.result.value.sequence ?: BigInteger.ZERO,
                )
            )
        )
    }

    // The /node_info endpoint
    suspend fun nodeInfo(): NodeInfoResponse {
        return get("/node_info");
    }

}
