package io.eqoty.types.response.logs

@kotlinx.serialization.Serializable
data class Event(
    val type: String,
    val attributes: List<Attribute>
)