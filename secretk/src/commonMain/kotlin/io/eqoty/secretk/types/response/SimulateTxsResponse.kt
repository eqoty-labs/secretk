package io.eqoty.secretk.types.response

import io.eqoty.secretk.types.response.logs.Event
import io.eqoty.secretk.types.response.logs.Log
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class SimulateTxsResponse(
    @SerialName("gas_info")
    val gasInfo: GasInfo,
    val result: SimulateTxsResponseData,
)

@kotlinx.serialization.Serializable
data class GasInfo(
    /** Amount of gas requested for transaction. */
    @SerialName("gas_wanted")
    val gasWanted: String,
    /** Amount of gas consumed by transaction. */
    @SerialName("gas_used")
    val gasUsed: String,
)

@kotlinx.serialization.Serializable
data class SimulateTxsResponseData(
    /** Result bytes, if any. */
    val data: String,
    /** The output of the application's logger (typed). May be non-deterministic. */
    val logs: List<Log> = emptyList(),
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