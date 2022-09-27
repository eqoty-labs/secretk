package io.eqoty.secretk.crypto

import io.eqoty.secretk.crypto.elliptic.biginteger.BN
import io.eqoty.secretk.crypto.elliptic.ec.EC
import io.eqoty.secretk.crypto.elliptic.ec.KeyPairSignOptions

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
            throw Error("input data is not a valid secp256k1 private key")
        }

        val keypair = secp256k1.keyFromPrivate(privkey)
        if (!keypair.validate().result) {
            throw Error("input data is not a valid secp256k1 private key")
        }

        // range test that is not part of the elliptic implementation
        val privkeyAsBigInteger = BN(privkey)
        if (privkeyAsBigInteger >= secp256k1N) {
            // not strictly smaller than N
            throw Error("input data is not a valid secp256k1 private key")
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
                return pubkey

            65 ->
                return secp256k1.keyFromPublic(pubkey).getPublicEncoded(true)

            else ->
                throw Error("Invalid pubkey length")
        }
    }

    fun createSignature(messageHash: UByteArray, privkey: UByteArray): ExtendedSecp256k1Signature {
        if (messageHash.isEmpty()) {
            throw Error("Message hash must not be empty")
        }
        if (messageHash.size > 32) {
            throw Error("Message hash length must not exceed 32 bytes")
        }

        val keypair = secp256k1.keyFromPrivate(privkey)
        // the `canonical` option ensures creation of lowS signature representations
//        var messageHash = intArrayOf(123, 34, 97, 99, 99, 111, 117, 110, 116, 95, 110, 117, 109, 98, 101, 114, 34, 58, 34, 49, 49, 34, 44, 34, 99, 104, 97, 105, 110, 95, 105, 100, 34, 58, 34, 115, 101, 99, 114, 101, 116, 100, 101, 118, 45, 49, 34, 44, 34, 102, 101, 101, 34, 58, 123, 34, 97, 109, 111, 117, 110, 116, 34, 58, 91, 123, 34, 100, 101, 110, 111, 109, 34, 58, 34, 117, 115, 99, 114, 116, 34, 44, 34, 97, 109, 111, 117, 110, 116, 34, 58, 34, 53, 48, 95, 48, 48, 48, 34, 125, 93, 44, 34, 103, 97, 115, 34, 58, 34, 50, 48, 48, 95, 48, 48, 48, 34, 125, 44, 34, 109, 101, 109, 111, 34, 58, 34, 34, 44, 34, 109, 115, 103, 115, 34, 58, 91, 123, 34, 116, 121, 112, 101, 34, 58, 34, 119, 97, 115, 109, 47, 77, 115, 103, 69, 120, 101, 99, 117, 116, 101, 67, 111, 110, 116, 114, 97, 99, 116, 34, 44, 34, 118, 97, 108, 117, 101, 34, 58, 123, 34, 115, 101, 110, 100, 101, 114, 34, 58, 34, 115, 101, 99, 114, 101, 116, 49, 102, 100, 107, 100, 109, 102, 108, 110, 114, 121, 115, 114, 118, 103, 51, 110, 99, 52, 121, 109, 55, 122, 100, 115, 110, 50, 114, 109, 53, 97, 116, 115, 122, 110, 57, 113, 50, 121, 34, 44, 34, 99, 111, 110, 116, 114, 97, 99, 116, 34, 58, 34, 115, 101, 99, 114, 101, 116, 49, 56, 118, 100, 56, 102, 112, 119, 120, 122, 99, 107, 57, 51, 113, 108, 119, 103, 104, 97, 106, 54, 97, 114, 104, 52, 112, 55, 99, 53, 110, 56, 57, 55, 56, 118, 115, 121, 103, 34, 44, 34, 109, 115, 103, 34, 58, 34, 82, 75, 51, 100, 72, 103, 70, 73, 115, 74, 70, 68, 57, 105, 55, 119, 120, 113, 49, 97, 73, 102, 115, 104, 85, 104, 102, 98, 66, 66, 79, 55, 48, 48, 56, 82, 102, 104, 73, 50, 110, 55, 118, 114, 99, 98, 71, 122, 49, 56, 51, 83, 47, 88, 67, 73, 108, 112, 98, 119, 87, 85, 98, 48, 88, 103, 120, 110, 114, 118, 56, 99, 104, 101, 55, 57, 101, 75, 87, 80, 47, 54, 69, 47, 70, 105, 55, 73, 122, 79, 98, 80, 48, 82, 103, 114, 121, 70, 115, 101, 71, 71, 56, 104, 116, 43, 69, 97, 80, 80, 51, 76, 108, 120, 69, 108, 108, 87, 121, 79, 113, 52, 86, 108, 50, 98, 65, 122, 65, 78, 112, 104, 118, 97, 99, 102, 52, 97, 97, 98, 107, 105, 109, 66, 86, 105, 66, 87, 110, 54, 116, 76, 122, 79, 73, 49, 79, 112, 120, 68, 107, 50, 77, 112, 100, 106, 101, 84, 85, 57, 75, 77, 47, 56, 57, 110, 68, 56, 120, 122, 121, 115, 66, 74, 54, 84, 76, 68, 99, 109, 105, 102, 75, 115, 97, 71, 112, 87, 52, 112, 77, 106, 47, 67, 51, 70, 72, 90, 112, 113, 114, 122, 66, 66, 65, 78, 88, 51, 48, 76, 116, 47, 49, 88, 47, 81, 97, 85, 98, 43, 69, 82, 107, 109, 72, 88, 54, 73, 112, 112, 77, 48, 116, 78, 98, 107, 71, 87, 98, 110, 66, 76, 79, 103, 87, 120, 52, 80, 53, 69, 102, 87, 115, 83, 69, 80, 120, 122, 101, 113, 51, 103, 121, 55, 53, 109, 75, 122, 98, 74, 34, 44, 34, 115, 101, 110, 116, 95, 102, 117, 110, 100, 115, 34, 58, 91, 93, 125, 125, 93, 44, 34, 115, 101, 113, 117, 101, 110, 99, 101, 34, 58, 34, 49, 49, 34, 125);
//        var messageHash2 = messageHash.map { it.toUByte() }.toUByteArray()
        val keyPairSignResult = keypair.sign(messageHash, null, KeyPairSignOptions(canonical = true, k = null))
        val recoveryParam = keyPairSignResult.recoveryParam ?: throw Error("Recovery param missing")
        val r = keyPairSignResult.r
        val s = keyPairSignResult.s
        return ExtendedSecp256k1Signature(r.number.toUByteArray(), s.number.toUByteArray(), recoveryParam)
    }
}


data class Secp256k1Keypair(
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