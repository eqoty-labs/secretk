package io.eqoty.response

import io.eqoty.logs.Log

@kotlinx.serialization.Serializable
data class TxsResponse(
    val tx_response: TxsResponseData,
)

@kotlinx.serialization.Serializable
data class TxsResponseData(
    val height: String,
    val timestamp: String,
    val txhash: String,
    val code: Int?,
    val raw_log: String?,
    var data: String,
    /** The same as `raw_log` but deserialized? */
    val logs: List<Log>?,
    /** The gas limit as set by the user */
    val gas_wanted: String?,
    /** The gas used by the execution */
    val gas_used: String?,
)