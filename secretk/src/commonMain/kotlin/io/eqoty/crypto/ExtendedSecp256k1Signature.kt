package io.eqoty.crypto

data class ExtendedSecp256k1Signature(val r: UByteArray, val s: UByteArray, val recoveryParam: Int)