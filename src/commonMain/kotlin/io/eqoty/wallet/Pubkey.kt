package io.eqoty.wallet

import io.eqoty.response.PubKeySecp256k1
import io.eqoty.utils.toByteString

fun encodeSecp256k1Pubkey(pubkey: UByteArray): PubKeySecp256k1 {
    if (pubkey.size != 33 || (pubkey[0] != 0x02u.toUByte() && pubkey[0] != 0x03.toUByte())) {
        throw Error("Public key must be compressed secp256k1, i.e. 33 bytes starting with 0x02 or 0x03");
    }
    return PubKeySecp256k1(
        value = pubkey.toByteString().base64()
    )
}