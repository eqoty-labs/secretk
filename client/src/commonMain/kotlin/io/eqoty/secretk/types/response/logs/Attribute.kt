package io.eqoty.secretk.types.response.logs

@kotlinx.serialization.Serializable
data class Attribute(
    var key: String,
    var value: String
)