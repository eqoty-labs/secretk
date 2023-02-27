package io.eqoty.secret.std.types

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class StdSignature(
    @SerialName("pub_key")
    val pubKey: PubKey,
    val signature: String
)