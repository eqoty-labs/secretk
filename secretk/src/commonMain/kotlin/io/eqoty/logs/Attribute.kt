package io.eqoty.logs

@kotlinx.serialization.Serializable
data class Attribute(
    var key: String,
    var value: String
)