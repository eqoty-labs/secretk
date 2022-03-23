package io.eqoty.client

import io.eqoty.BroadcastMode
import kotlinx.coroutines.Deferred
import kotlinx.serialization.json.JsonObject

open class CosmWasmClient(
    apiUrl: String,
    seed: UByteArray? = null,
    broadcastMode: BroadcastMode = BroadcastMode.Block
) {
    val restClient = RestClient(apiUrl, broadcastMode, seed)


    /**
     * Makes a smart query on the contract, returns the parsed JSON document.
     *
     * Promise is rejected when contract does not exist.
     * Promise is rejected for invalid query format.
     * Promise is rejected for invalid response format.
     *
     * Note: addedParams allows for query string additions such as "&height=1234567"
     */
    suspend fun queryContractSmart(
    contractAddress: String,
    queryMsg: JsonObject,
    addedParams: JsonObject? = null,
    contractCodeHash: String? = null,
    ): JsonObject {
        try {
            return this.restClient.queryContractSmart(
                contractAddress,
                queryMsg,
                addedParams,
                contractCodeHash,
            )
        } catch (t: Throwable) {
            if (t is Error) {
                if (t.message?.startsWith("not found: contract") == true) {
                    throw Error("No contract found at address $contractAddress")
                } else {
                    throw t
                }
            } else {
                throw t
            }
        }
    }

}