package io.eqoty.crypto

import io.eqoty.crypto.elliptic.biginteger.BN
import io.eqoty.crypto.elliptic.ec.EC

object Secp256k1 {

    val secp256k1 = EC.scep256k1

    private val secp256k1N = BN("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141")
    /**
     * Takes a 32 byte private key and returns a privkey/pubkey pair.
     *
     * The resulting pubkey is uncompressed. For the use in Cosmos it should
     * be compressed first using `Secp256k1.compressPubkey`.
     */
    fun makeKeypair(privkey: UByteArray): Secp256k1Keypair {
        if (privkey.size != 32) {
            // is this check missing in secp256k1.validatePrivateKey?
            // https://github.com/bitjson/bitcoin-ts/issues/4
            throw Error("input data is not a valid secp256k1 private key");
        }

        val keypair = secp256k1.keyFromPrivate(privkey)
        println(keypair.priv)
        if (!keypair.validate().result) {
            throw Error("input data is not a valid secp256k1 private key");
        }

        // range test that is not part of the elliptic implementation
        val privkeyAsBigInteger = BN(privkey)
        if (privkeyAsBigInteger >= secp256k1N) {
            // not strictly smaller than N
            throw Error("input data is not a valid secp256k1 private key");
        }

        val out = Secp256k1Keypair(
            privkey = keypair.getPrivate()!!,
            // encodes uncompressed as
            // - 1-byte prefix "04"
            // - 32-byte x coordinate
            // - 32-byte y coordinate
            pubkey = keypair.getPublicEncoded()
        )
        return out
    }

    /**
     * Takes a compressed or uncompressed pubkey and return a compressed one.
     *
     * This function is idempotent.
     */
    fun compressPubkey(pubkey: UByteArray): UByteArray {
        when (pubkey.size) {
            33 ->
            return pubkey;
            65 ->
            return secp256k1.keyFromPublic(pubkey).getPublicEncoded(true)
            else ->
            throw Error("Invalid pubkey length");
        }
    }

    fun createSignature(message: UByteArray, privkey: UByteArray): ExtendedSecp256k1Signature {
        TODO("Not yet implemented")
    }
}


data class Secp256k1Keypair (
    /** A 32 byte private key */
    val pubkey: UByteArray,
    /**
     * A raw secp256k1 public key.
     *
     * The type itself does not give you any guarantee if this is
     * compressed or uncompressed. If you are unsure where the data
     * is coming from, use `Secp256k1.compressPubkey` or
     * `Secp256k1.uncompressPubkey` (both idempotent) before processing it.
     */
    val privkey: UByteArray
)