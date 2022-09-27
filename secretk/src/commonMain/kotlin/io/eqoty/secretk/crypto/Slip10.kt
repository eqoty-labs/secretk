package io.eqoty.secretk.crypto

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.Sign
import io.eqoty.secretk.crypto.elliptic.biginteger.BN
import io.eqoty.secretk.crypto.elliptic.ec.EC
import io.eqoty.secretk.utils.toByteString
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

    val secp256k1 = EC.scep256k1

    fun derivePath(curve: Slip10Curve, seed: UByteArray, path: Array<Slip10RawIndex>): Slip10Result {
        var result = this.master(curve, seed)
        for (rawIndex in path) {
            result = this.child(curve, result.privkey, result.chainCode, rawIndex)
        }
        return result
    }

    private fun master(curve: Slip10Curve, seed: UByteArray): Slip10Result {
        val firstKey = curve.key.encodeToByteArray().toByteString()
        val i = seed.toByteString().hmacSha512(firstKey).toByteArray().toUByteArray()
        val il = UByteArray(32).apply {
            i.copyInto(this, 0, 0, i.size / 2)
        }
        val ir = UByteArray(32).apply {
            i.copyInto(this, 0, i.size / 2, i.size)
        }

        if (curve !== Slip10Curve.Ed25519 && (isZero(il) || isGteN(curve, il))) {
            return this.master(curve, i)
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
                throw Error("Normal keys are not allowed with ed25519")
            } else {
                // Step 1 of https://github.com/satoshilabs/slips/blob/master/slip-0010.md#private-parent-key--private-child-key
                // Calculate I = HMAC-SHA512(Key = c_par, Data = ser_P(point(k_par)) || ser_32(i)).
                // where the functions point() and ser_p() are defined in BIP-0032
                val rawIndexBigEndian = Buffer().writeInt(rawIndex.toInt()).readByteArray().toUByteArray()
                val data = (serializedPoint(
                    curve,
                    BigInteger.fromUByteArray(parentPrivkey, Sign.POSITIVE)
                ) + rawIndexBigEndian).toByteString()
                i = data.hmacSha512(parentChainCode.toByteString()).toByteArray().toUByteArray()
            }
        }

        return this.childImpl(curve, parentPrivkey, parentChainCode, rawIndex, i)
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

            else -> throw Error("curve not supported")
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
            i.copyInto(this, 0, 0, i.size / 2)
        }
        val ir = UByteArray(32).apply {
            i.copyInto(this, 0, i.size / 2, i.size)
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
            val payload = (byteArrayOf(0x01) + ir.toByteArray() + Buffer().writeInt(rawIndex.toInt())
                .readByteArray()).toByteString()
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

            else -> throw Error("curve not supported")
        }
    }


    private fun isZero(privkey: UByteArray): Boolean =
        privkey.all { it == 0.toUByte() }


}