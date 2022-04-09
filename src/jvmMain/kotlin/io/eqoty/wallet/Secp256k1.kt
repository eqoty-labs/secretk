package io.eqoty.wallet

import fr.acinq.secp256k1.Secp256k1

actual object Secp256k1 {
    actual fun makeKeypair(privkey: UByteArray): UByteArray {
        val secp256k1 = Secp256k1.get()
        return secp256k1.pubkeyCreate(privkey.toByteArray()).toUByteArray()
    }
}