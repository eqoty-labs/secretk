package io.eqoty.crypto.elliptic.json

@kotlinx.serialization.Serializable
data class PrecomputedScep256k1(
    val doubles: Doubles,
    val naf: Naf
)
