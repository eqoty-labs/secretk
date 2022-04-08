package io.eqoty.crypto

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.Sign
import io.eqoty.crypto.elliptic.Curve
import io.eqoty.crypto.elliptic.biginteger.BN
import io.eqoty.crypto.elliptic.biginteger.toArray
import io.eqoty.utils.toByteString
import okio.Buffer
import okio.ByteString.Companion.toByteString

/**
 * Raw values must match the curve string in SLIP-0010 master key generation
 *
 * @see https://github.com/satoshilabs/slips/blob/master/slip-0010.md#master-key-generation
 */
enum class Slip10Curve(val key: String) {
    Secp256k1("Bitcoin seed"),
    Ed25519("ed25519 seed")
}

data class Slip10Result(
    val chainCode: UByteArray,
    val privkey: UByteArray
)

//https://github.com/bluesky66-dev/X-Wallet-iOS/blob/master/Modules/walletkit/WalletKitCore/src/hedera/BRHederaCrypto.c
object Slip10 {

    val secp256k1 = Curve.scep256k1

    fun derivePath(curve: Slip10Curve, seed: UByteArray, path: Array<Slip10RawIndex>): Slip10Result {
        var result = this.master(curve, seed);
        for (rawIndex in path) {
            result = this.child(curve, result.privkey, result.chainCode, rawIndex);
        }
        return result;
    }

    private fun master(curve: Slip10Curve, seed: UByteArray): Slip10Result {
        val firstKey = curve.key.encodeToByteArray().toByteString()
        val i = seed.toByteString().hmacSha512(firstKey).toByteArray().toUByteArray()
        val il = UByteArray(32).apply {
            i.copyInto(this,0,0, i.size/2)
        }
        val ir = UByteArray(32).apply {
            i.copyInto(this,0,i.size/2, i.size)
        }

        if (curve !== Slip10Curve.Ed25519 && (isZero(il) || isGteN(curve, il))) {
            return this.master(curve, i);
        }

        return Slip10Result(
                chainCode = ir,
                privkey = il
        )
    }

    private fun child(
        curve: Slip10Curve,
        parentPrivkey: UByteArray,
        parentChainCode: UByteArray,
        rawIndex: Slip10RawIndex,
    ): Slip10Result {
        val i: UByteArray
        if (rawIndex.isHardened()) {
            val rawIndexBigEndian = Buffer().writeInt(rawIndex.toInt()).readByteArray().toUByteArray()
            val payload = (ubyteArrayOf(0.toUByte()) + parentPrivkey + rawIndexBigEndian).toByteString()
            i = payload.hmacSha512(parentChainCode.toByteString()).toByteArray().toUByteArray()
        } else {
            if (curve == Slip10Curve.Ed25519) {
                throw Error("Normal keys are not allowed with ed25519");
            } else {
                // Step 1 of https://github.com/satoshilabs/slips/blob/master/slip-0010.md#private-parent-key--private-child-key
                // Calculate I = HMAC-SHA512(Key = c_par, Data = ser_P(point(k_par)) || ser_32(i)).
                // where the functions point() and ser_p() are defined in BIP-0032
                val rawIndexBigEndian = Buffer().writeInt(rawIndex.toInt()).readByteArray().toUByteArray()
                val data = (Slip10.serializedPoint(curve, BigInteger.fromUByteArray(parentPrivkey, Sign.POSITIVE)) + rawIndexBigEndian).toByteString()
                i = data.hmacSha512(parentChainCode.toByteString()).toByteArray().toUByteArray()
            }
        }

        return this.childImpl(curve, parentPrivkey, parentChainCode, rawIndex, i);
    }

    /**
     * Implementation of ser_P(point(k_par)) from BIP-0032
     *
     * @see https://github.com/bitcoin/bips/blob/master/bip-0032.mediawiki
     */
    private fun serializedPoint(curve: Slip10Curve, p: BigInteger): UByteArray {
        when (curve) {
            Slip10Curve.Secp256k1 -> {
                return secp256k1.g!!.mul(BN(p)).encodeCompressed()
            }
            else -> throw Error("curve not supported");
        }
    }

    private fun childImpl(
    curve: Slip10Curve,
    parentPrivkey: UByteArray,
    parentChainCode: UByteArray,
    rawIndex: Slip10RawIndex,
    i: UByteArray,
    ): Slip10Result {
        // step 2 (of the Private parent key → private child key algorithm)

        val il = UByteArray(32).apply {
            i.copyInto(this,0,0, i.size/2)
        }
        val ir = UByteArray(32).apply {
            i.copyInto(this,0,i.size/2, i.size)
        }

        // step 3
        val returnChainCode = ir

        // step 4
        if (curve === Slip10Curve.Ed25519) {
            return Slip10Result(
                    chainCode = returnChainCode,
                    privkey = il
            )
        }

        // step 5
        val n = n(curve)
        val ilBi = BigInteger.fromUByteArray(il, Sign.POSITIVE)
        val parentPrivkeyBi = BigInteger.fromUByteArray(parentPrivkey, Sign.POSITIVE)
        val returnChildKeyAsNumber = ilBi.add(parentPrivkeyBi).mod(n)
        val returnChildKey = returnChildKeyAsNumber.toUByteArray()

        // step 6
        if (isGteN(curve, il) || isZero(returnChildKey)) {
            val payload = (byteArrayOf(0x01) + ir.toByteArray() + Buffer().writeInt(rawIndex.toInt()).readByteArray()).toByteString()
            val newI = payload.hmacSha512(parentChainCode.toByteString()).toByteArray().toUByteArray()
            return this.childImpl(curve, parentPrivkey, parentChainCode, rawIndex, newI)
        }

        // step 7
        return Slip10Result(
            chainCode = returnChainCode,
            privkey = returnChildKey
        )
    }



    private fun isGteN(curve: Slip10Curve, privkey: UByteArray): Boolean {
        val keyAsNumber = BigInteger.fromUByteArray(privkey, Sign.POSITIVE)
        return keyAsNumber >= n(curve)
    }

    private fun n(curve: Slip10Curve): BigInteger {
        when (curve) {
            Slip10Curve.Secp256k1 ->
                return BigInteger.parseString("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16)
            else -> throw Error("curve not supported");
        }
    }


    private fun isZero(privkey: UByteArray): Boolean =
        privkey.all { it == 0.toUByte() }


    /**
     * Derives only the private key for ED25519 in the manor defined in
     * [SLIP-0010](https://github.com/satoshilabs/slips/blob/master/slip-0010.md).
     *
     * @param seed    Seed, the BIP0039 output.
     * @param indexes an array of indexes that define the path. E.g. for m/1'/2'/3', pass 1, 2, 3.
     * As with Ed25519 non-hardened child indexes are not supported, this function treats all indexes
     * as hardened.
     * @return Private key.
     */
    fun derivePrivateKey(curve: Slip10Curve, _seed: ByteArray, indexes: Array<Slip10RawIndex>): UByteArray {
        val seed = _seed.toByteString()
        val I = ByteArray(64) {0}
        val chainCode = ByteArray(32)

        // I = HMAC-SHA512(Key = bytes("ed25519 seed"), Data = seed)
        val firstKey = curve.key.encodeToByteArray().toByteString()
        seed.hmacSha512(firstKey)
            .copyInto(0, I, 0, I.size)

        for (i in indexes) {
            println(i.isHardened())
            I.copyInto(chainCode,0,I.size/2, chainCode.size)
            // I = HMAC-SHA512(Key = c_par, Data = 0x00 || ser256(k_par) || ser32(i'))
            // which is simply:
            // I = HMAC-SHA512(Key = Ir, Data = 0x00 || Il || ser32(i'))
            // Key = Ir
            val data = Buffer()
            // Data = 0x00
            data.writeByte(0x00)
            // Data += Il : This is the "secret"
            data.write(I, 0, 32)
            // Data += ser32(i')
//            println(i)
//            println((i and 0xFF000000) shr 24) // and 0xFF000000
//            println((i and 0x00FF0000) shr 16)
//            println((i and 0x0000FF00) shr 8)
//            println(i and 0x00000000FF)
//            println()
//            println(i shr 24 or 128u)
//            println(i shr 16)
//            println(i shr 8)
//            println()
//            println()
//            data.writeByte(((i and 0xFF000000) shr 24).toInt())
//            data.writeByte(((i and 0x00FF0000) shr 16).toInt())
//            data.writeByte(((i and 0x0000FF00) shr 8).toInt())
//            data.writeByte((i and 0x00000000FF).toInt())

            data.writeByte((i shr 24 or 128u).toInt())
            data.writeByte((i shr 16).toInt())
            data.writeByte((i shr 8).toInt())
            data.writeByte(i.toInt())
            // compute HMAC-SHA512 and Write to I
            // For the remaining hashing the key is the chaincode from the previous hash
            data.hmacSha512(chainCode.toByteString())
                .copyInto(0, I, 0, I.size)
        }
        val Il = ByteArray(32)
        // copy head 32 bytes of I into Il
        I.copyInto(Il, 0, 0,32)
        return Il.toUByteArray()
    }
}