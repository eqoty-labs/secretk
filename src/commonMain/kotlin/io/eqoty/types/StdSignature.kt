package io.eqoty.types

import io.eqoty.response.PubKey

@kotlinx.serialization.Serializable
data class StdSignature(
    val pub_key: PubKey,
    val signature: String
)