package io.eqoty.logs

@kotlinx.serialization.Serializable
data class Attribute(
    val key: String,
    val value: String
)