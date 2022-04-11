package io.eqoty.crypto.elliptic.ec

import io.eqoty.crypto.elliptic.Curve
import io.eqoty.crypto.elliptic.ShortCurve
import io.eqoty.crypto.elliptic.biginteger.BN
import io.eqoty.crypto.elliptic.curves.Scep256k1Preset
import kotlin.random.Random
import kotlin.random.nextUBytes

class EC(val curve: Curve) {

    val n = curve.n
    val nh = n!!.shr(1)
    val g = curve.g


    fun keyFromPrivate(privkey: UByteArray, enc: String? = null): KeyPair =
        KeyPair.fromPrivate(this, privkey, enc)

    fun keyFromPublic(pubkey: UByteArray, enc: String? = null): KeyPair =
        KeyPair.fromPublic(this, pubkey, enc)

    fun sign(_msg: UByteArray, key: KeyPair, enc: String?, _options: KeyPairSignOptions?): Signature {
        var options = _options ?: KeyPairSignOptions(k = null)

        val msg = this.truncateToN(BN(_msg))

        // Zero-extend key to provide enough entropy
        val bytes = this.n!!.byteLength()
        var bkey = key.getPrivate()!!

        // Zero-extend nonce to have the same byte size as N
        var nonce = msg

        // todo: use a HmacDRBG implementation
//        // Instantiate Hmac_DRBG
//        var drbg = new HmacDRBG({
//            hash: this.hash,
//            entropy: bkey,
//            nonce: nonce,
//            pers: options.pers,
//            persEnc: options.persEnc || 'utf8',
//        });

        // Number of bytes to generate
        val ns1 = this.n.subtract(BN(1))
        var iter = -1
        while (true) {
            iter++
            var k : BN = if (options.k!= null) {
                TODO() /* options.k(iter) */
            } else {
                BN(Random.nextUBytes(this.n.byteLength()))
            }
            k = this.truncateToN(k, true)
            if (k <= 1 || k >= ns1)
                continue;

            val kp = this.g!!.mul(k);
            if (kp.isInfinity())
                continue;

            val kpX = kp.x!!
            val r = kpX.mod(this.n)
            if (r.compareTo(0) == 0)
                continue

            var s = k.invm(this.n).multiply(r.multiply(BN(key.getPrivate()!!)).add(msg))
            s = s.mod(this.n)
            if (s.compareTo(0) == 0)
                continue

            var recoveryParam = (if (kp.y!!.isOdd())  1 else 0) or (if (kpX.compareTo(r) != 0) 2 else 0)

            // Use complement of `s`, if it is > `n / 2`
            if (options.canonical == true && s > this.nh) {
                s = this.n.subtract(s)
                recoveryParam =  recoveryParam xor 1
            }

            return Signature(r = r, s = s, recoveryParam = recoveryParam)
        }
    }


    private fun truncateToN(_msg: BN, truncOnly: Boolean = false): BN {
        var msg = _msg
        val delta = msg.byteLength() * 8 - n!!.bitLength().toInt()
        if (delta > 0)
            msg = msg.shr(delta)
        if (!truncOnly && msg >= this.n)
            return msg.subtract(this.n)
        else
            return msg
    }


    companion object {
        val scep256k1: EC
            get() = EC(ShortCurve(Scep256k1Preset))

    }
}