package io.eqoty.crypto.elliptic

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.DecimalMode
import com.ionspin.kotlin.bignum.decimal.RoundingMode
import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.crypto.elliptic.biginteger.BN
import io.eqoty.crypto.elliptic.biginteger.mont
import io.eqoty.crypto.elliptic.biginteger.red
import io.eqoty.crypto.elliptic.curves.Endomorphism
import io.eqoty.crypto.elliptic.curves.PresetCurve
import io.eqoty.crypto.elliptic.curves.Scep256k1Preset
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray

sealed class Curve(presetCurve: PresetCurve) {
    val p = presetCurve.p
    val n = presetCurve.n
    val red = if (presetCurve.prime != null) BN.red(presetCurve.prime!!) else BN.mont(p)

    companion object {
        val scep256k1: ShortCurve
        get() = ShortCurve(Scep256k1Preset)

    }
}

class ShortCurve(val presetCurve: PresetCurve): Curve(presetCurve) {

    val g : ShortCurvePoint? = presetCurve.g?.let { g->
        BasePoint.fromJSON(this, Json.parseToJsonElement(g).jsonArray, presetCurve.gRed)
    }
    val a = presetCurve.a.toRed(red)
    val b = presetCurve.b.toRed(red)
    val zeroA = a.fromRed() == BN.ZERO
    val endo = getEndomorphism()
    val endoWnafT1 = MutableList<ShortCurvePoint?>(4){null}
    val endoWnafT2 = MutableList<BN?>(4){null}
    fun point(x: String, y: String, isRed: Boolean?): ShortCurvePoint =
        ShortCurvePoint(this, "affine", x, y, isRed)
    fun point(x: BN, y: BN, isRed: Boolean?): ShortCurvePoint =
        ShortCurvePoint(this, "affine", x, y, isRed)


    private fun getEndomorphism(): Endomorphism? {
        // No efficient endomorphism
        if (!this.zeroA || this.g == null || this.n == null || p.mod(BN(3)) != BN.ONE)
            return null

        // Compute beta and lambda, that lambda * P = (beta * Px; Py)


        val beta = presetCurve.beta!!.toRed(red)
        val lambda = presetCurve.lambda


        // Get basis vectors, used for balanced length-two representation
        val basis = presetCurve.basis

        return Endomorphism(
                beta = beta,
                lambda = lambda,
                basis = basis,
        )
    }

    private data class EndoSplit(var k1: BN, var k2: BN)

    private fun endoSplit(k: BN): EndoSplit {
        val basis = this.endo!!.basis
        val v1 = basis[0]
        val v2 = basis[1]

        val c1 = v2.b.multiply(k).divRound(n!!)
        var c2 = v1.b.negate().multiply(k).divRound(n!!)


        val p1 = c1.multiply(v1.a);
        val p2 = c2.multiply(v2.a);
        val q1 = c1.multiply(v1.b);
        val q2 = c2.multiply(v2.b);

        // Calculate answer
        var k1 = k.subtract(p1).subtract(p2);
        var k2 = q1.add(q2).negate();
        return EndoSplit( k1 = k1, k2 = k2 )
    };

    fun endoWnafMulAdd(points: List<ShortCurvePoint>, coeffs: List<BN>, jacobianResult: Any? = null) : ShortCurvePoint {
        val npoints = endoWnafT1;
        val ncoeffs = endoWnafT2;
        for (i in points.indices) {
            val split = this.endoSplit(coeffs[i])
            val p = points[i];
            val beta = p.getBeta()!!
            if (split.k1.negative) {
                split.k1 = split.k1.negate()
                TODO()
//                p = p.neg(true);
            }
            if (split.k2.negative) {
                split.k2 = split.k2.negate()
                TODO()
//                beta = beta.neg(true);
            }

            npoints[i * 2] = p
            npoints[i * 2 + 1] = beta
            ncoeffs[i * 2] = split.k1;
            ncoeffs[i * 2 + 1] = split.k2;
        }
        TODO()
//        var res = this.wnafMulAdd(1, npoints, ncoeffs, points.size * 2, jacobianResult);

//        // Clean-up references to points and coefficients
//        for (var j = 0; j < i * 2; j++) {
//            npoints[j] = null;
//            ncoeffs[j] = null;
//        }
//        return res;
    }

}