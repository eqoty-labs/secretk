package io.eqoty.secretk.crypto.elliptic.json

@kotlinx.serialization.Serializable
data class Naf(
    val wnd: Int,
    val points: List<List<String>>
)