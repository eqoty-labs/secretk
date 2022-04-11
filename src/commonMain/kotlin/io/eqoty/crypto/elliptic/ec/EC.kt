package io.eqoty.crypto.elliptic.ec

import io.eqoty.crypto.elliptic.Curve
import io.eqoty.crypto.elliptic.ShortCurve
import io.eqoty.crypto.elliptic.curves.Scep256k1Preset

class EC(val curve: Curve) {

    val n = curve.n
    val nh = n!!.shr(1)
    val g = curve.g


    fun keyFromPrivate(privkey: UByteArray, enc: String? = null): KeyPair =
        KeyPair.fromPrivate(this, privkey, enc)

    fun keyFromPublic(pubkey: UByteArray, enc: String? = null): KeyPair =
        KeyPair.fromPublic(this, pubkey, enc)


    companion object {
        val scep256k1: EC
            get() = EC(ShortCurve(Scep256k1Preset))

    }
}