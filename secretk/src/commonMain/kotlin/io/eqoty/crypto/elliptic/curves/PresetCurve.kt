package io.eqoty.crypto.elliptic.curves

import io.eqoty.crypto.elliptic.biginteger.BN


sealed interface PresetCurve {
    val gRed: Boolean
    val a: BN
    val b: BN
    val g: String?
    val n: BN?
    val type: String
    val prime: String?
    val p: BN
    val h: String
    val hash: String
    val lambda: BN
    val beta: BN?
    val basis: List<Basis>
}

data class Basis(val a: BN, val b: BN)

data class Endomorphism(
    val beta: BN,
    val lambda: BN,
    val basis: List<Basis>
)