package io.eqoty.wallet

import fr.acinq.secp256k1.Secp256k1

actual object Secp256k1 {
    val secp256k1 = Secp256k1.get()

    actual fun pubkeyCreate(privkey: UByteArray): UByteArray =
        secp256k1.pubkeyCreate(privkey.toByteArray()).toUByteArray()


    actual fun pubKeyCompress(pubkey: UByteArray): UByteArray =
        secp256k1.pubKeyCompress(pubkey.toByteArray()).toUByteArray()

}