package io.eqoty.secretk.crypto.elliptic.json

@kotlinx.serialization.Serializable
data class Doubles(
    val step: Int,
    val points: List<List<String>>
)