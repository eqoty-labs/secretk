package io.eqoty.logs

@kotlinx.serialization.Serializable
data class Log(
    val msg_index: Long,
    val log: String,
    val events: List<Event>
)