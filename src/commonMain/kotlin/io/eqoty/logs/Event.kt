package io.eqoty.logs

@kotlinx.serialization.Serializable
data class Event (
    val type: String,
    val attributes: List<Attribute>
)