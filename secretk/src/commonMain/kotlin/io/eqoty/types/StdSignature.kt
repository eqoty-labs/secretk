package io.eqoty.types

import io.eqoty.response.PubKeySecp256k1

@kotlinx.serialization.Serializable
data class StdSignature(
    val pub_key: PubKeySecp256k1,
    val signature: String
)