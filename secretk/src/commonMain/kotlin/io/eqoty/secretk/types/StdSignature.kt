package io.eqoty.secretk.types

import io.eqoty.secretk.types.response.PubKey
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class StdSignature(
    @SerialName("pub_key")
    val pubKey: PubKey,
    val signature: String
)