package io.eqoty.types.response.logs

@kotlinx.serialization.Serializable
data class Attribute(
    var key: String,
    var value: String
)