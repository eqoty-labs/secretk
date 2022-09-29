package io.eqoty.secretk.types.response

import io.eqoty.secretk.types.proto.AnyProto
import io.eqoty.secretk.types.response.logs.Event
import io.eqoty.secretk.types.response.logs.Log
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TxsResponse(
    val tx_response: TxsResponseData,
)

@kotlinx.serialization.Serializable
data class TxsResponseData(
    /** The block height */
    val height: String,
    /** The transaction hash. */
    val txhash: String,
    /** Namespace for the Code */
    val codespace: String,
    /** Response code. */
    val code: Int?,
    /** Result bytes, if any. */
    @SerialName("data")
    val rawData: String,
    @SerialName("unused")
    var data: List<String> = emptyList(),
    /**
     * The output of the application's logger (raw string). May be
     * non-deterministic.
     */
    @SerialName("raw_log")
    val rawLog: String?,
    /** The output of the application's logger (typed). May be non-deterministic. */
    val logs: List<Log> = emptyList(),
    /** Additional information. May be non-deterministic. */
    val info: String?,
    /** Amount of gas requested for transaction. */
    @SerialName("gas_wanted")
    val gasWanted: String?,
    /** Amount of gas consumed by transaction. */
    @SerialName("gas_used")
    val gasUsed: String?,
    /** The request transaction bytes. */
    var tx: AnyProto?,
    /**
     * Time of the previous block. For heights > 1, it's the weighted median of
     * the timestamps of the valid votes in the block.LastCommit. For height == 1,
     * it's genesis time.
     */
    val timestamp: String,
    /**
     * Events defines all the events emitted by processing a transaction. Note,
     * these events include those emitted by processing all the messages and those
     * emitted from the ante handler. Whereas Logs contains the events, with
     * additional metadata, emitted only by processing the messages.
     *
     * Since: cosmos-sdk 0.42.11, 0.44.5, 0.45
     */
    val events: List<Event>
)