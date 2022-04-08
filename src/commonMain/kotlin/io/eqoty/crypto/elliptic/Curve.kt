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
import io.eqoty.crypto.elliptic.utils.getNAF
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlin.math.max

sealed class Curve(presetCurve: PresetCurve) {
    val p = presetCurve.p
    val n = presetCurve.n
    val red = if (presetCurve.prime != null) BN.red(presetCurve.prime!!) else BN.mont(p)

    // Useful for many curves
    val zero = BN(0).toRed(this.red)
    val one = BN(1).toRed(this.red)
    val two = BN(2).toRed(this.red)

    // Temporary arrays
    protected val _wnafT1 = Array<Int?>(4) {null}
    protected val _wnafT2 = Array<List<BasePoint<*>>?>(4) {null}
    protected val _wnafT3 = Array<Array<Int>?>(4) {null}
    protected val _wnafT4 = Array<Int?>(4) {null}

    protected val bitLength = if (this.n != null) this.n.bitLength() else 0u



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
    //val tinv = two.redInvm();

    val zeroA = a.fromRed() == BN.ZERO
    val threeA = this.a.fromRed().subtract(this.p).compareTo(-3) == 0

    val endo = getEndomorphism()
    val endoWnafT1 = MutableList<BasePoint<ShortCurve>?>(4){null}
    val endoWnafT2 = MutableList<BN?>(4){null}
    fun point(x: String, y: String, isRed: Boolean?): ShortCurvePoint =
        ShortCurvePoint(this, "affine", x, y, isRed)
    fun point(x: BN?, y: BN?, isRed: Boolean?): ShortCurvePoint =
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

    fun endoWnafMulAdd(points: List<ShortCurvePoint>, coeffs: List<BN>, jacobianResult: Any? = null) : BasePoint<ShortCurve> {
        val npoints = endoWnafT1;
        val ncoeffs = endoWnafT2;
        for (i in points.indices) {
            val split = this.endoSplit(coeffs[i])
            var p = points[i];
            var beta = p.getBeta()!!
            if (split.k1.negative) {
                split.k1 = split.k1.negate()
                p = p.neg(true)
            }
            if (split.k2.negative) {
                split.k2 = split.k2.negate()
                beta = beta.neg(true)
            }

            npoints[i * 2] = p
            npoints[i * 2 + 1] = beta
            ncoeffs[i * 2] = split.k1;
            ncoeffs[i * 2 + 1] = split.k2;
        }
        val res = this.wnafMulAdd(1, npoints, ncoeffs.toList(), points.size * 2, jacobianResult)

        // Clean-up references to points and coefficients
        for (j in 0 until  npoints.size) {
            npoints[j] = null;
            ncoeffs[j] = null;
        }
        return res
    }

    fun wnafMulAdd(defW: Int,
                   points: MutableList<BasePoint<ShortCurve>?>,
                   coeffs: List<BN?>,
                   len: Int,
                   jacobianResult: Any? = null): BasePoint<ShortCurve> {
        var wndWidth = this._wnafT1;
        var wnd = this._wnafT2 as Array<List<ShortCurvePoint>?>
        var naf = this._wnafT3;

        // Fill all arrays
        var max = 0;
//        var i;
//        var j;

        for (i in 0 until len) {
            val p = points[i]!!
            val nafPoints = p.getNAFPoints(defW)
            wndWidth[i] = nafPoints.wnd
            wnd[i] = nafPoints.points as List<ShortCurvePoint>
        }
        var p = points[len-1]
        // Comb small window NAFs
        for (i in len - 1 downTo  1 step 2) {
            var a = i - 1;
            var b = i;
            if (wndWidth[a] != 1 || wndWidth[b] != 1) {
                naf[a] = getNAF(coeffs[a]!!, wndWidth[a]!!, this.bitLength.toInt())
                naf[b] = getNAF(coeffs[b]!!, wndWidth[b]!!, this.bitLength.toInt())
                max = max(naf[a]!!.size, max);
                max = max(naf[b]!!.size, max);
                continue
            }
            TODO()
//            val comb = arrayOf(
//                points[a] as ShortCurvePoint, /* 1 */
//                null, /* 3 */
//                null, /* 5 */
//                points[b] as ShortCurvePoint, /* 7 */
//            )

//            // Try to avoid Projective points, if possible
//            if (points[a].y!!.compareTo(points[b].y!!) == 0) {
//                comb[1] = points[a].add(points[b])
//                comb[2] = points[a].toJ().mixedAdd(points[b].neg())
//            } else if (points[a].y.cmp(points[b].y.redNeg()) === 0) {
//                comb[1] = points[a].toJ().mixedAdd(points[b])
//                comb[2] = points[a].add(points[b].neg())
//            } else {
//                comb[1] = points[a].toJ().mixedAdd(points[b])
//                comb[2] = points[a].toJ().mixedAdd(points[b].neg())
//            }
//
//            var index = [
//                -3, /* -1 -1 */
//                -1, /* -1 0 */
//                -5, /* -1 1 */
//                -7, /* 0 -1 */
//                0, /* 0 0 */
//                7, /* 0 1 */
//                5, /* 1 -1 */
//                1, /* 1 0 */
//                3,  /* 1 1 */
//            ];
//
//            var jsf = getJSF(coeffs[a], coeffs[b]);
//            max = Math.max(jsf[0].length, max);
//            naf[a] = new Array(max);
//            naf[b] = new Array(max);
//            for (j = 0; j < max; j++) {
//            var ja = jsf[0][j] | 0;
//            var jb = jsf[1][j] | 0;
//
//            naf[a][j] = index[(ja + 1) * 3 + (jb + 1)];
//            naf[b][j] = 0;
//            wnd[a] = comb;
//        }
        }

        var acc = JPoint(this,null, null, null)
        var tmp = this._wnafT4;
        var i = max
        while (i >= 0) {
            var k = 0;

            while (i >= 0) {
                var zero = true;
                for (j in 0 until len) {
                    tmp[j] = naf[j]!!.getOrElse(i) { 0 }
                    if (tmp[j] != 0)
                        zero = false;
                }
                if (!zero)
                    break;
                k++
                i--
            }
            if (i >= 0)
                k++
            acc = acc.dblp(k);
            if (i < 0)
                break
            for (j in 0 until len) {
                var z = tmp[j];

                if (z == 0)
                    continue
                else if (z!! > 0)
                    p = wnd[j]!![(z - 1) shr 1];
                else if (z < 0)
                p = wnd[j]!![(-z - 1) shr 1].neg()

                if (p!!.type == "affine")
                    acc = acc.mixedAdd(p as ShortCurvePoint)
                else
                    acc = acc.add(p as JPoint)
            }
            i--
        }
        // Zeroify references
        for (i in 0 until len) {
            wnd[i] = null
        }
        if (jacobianResult!= null)
            return acc
        else
            return acc.toP()
    }

    fun jpoint(x: BN?, y: BN?, z: BN?): JPoint = JPoint(this, x, y, z)

    fun fixedNafMul(p: ShortCurvePoint, k: BN): BasePoint<ShortCurve> {
        require(p.precomputed != null)
        var doubles = p.getDoubles()

        var naf = getNAF(k, 1, this.bitLength.toInt())
        var I = (1 shl (doubles.step + 1)) - (if (doubles.step % 2 == 0) 2 else 1)
        I /= 3;

        // Translate into more windowed form
        var repr = mutableListOf<Int>()
        var j = 0
        var nafW: Int?
        while (j < naf.size) {
            nafW = 0;
            for (l in j + doubles.step - 1 downTo  j) {
                nafW = naf.getOrNull(l)?.plus (nafW?.shl(1) ?: 0)
            }
            repr.add(nafW!!)
            j += doubles.step
        }

        var a = this.jpoint(null, null, null);
        var b = this.jpoint(null, null, null);
        for (i in I downTo  1) {
            for (l in 0 until repr.size) {
                nafW = repr[l];
                if (nafW == i)
                    b = b.mixedAdd(doubles.points[l] as ShortCurvePoint);
                else if (nafW == -i)
                    b = b.mixedAdd((doubles.points[l] as ShortCurvePoint).neg());
            }
            a = a.add(b);
        }
        return a.toP();
    };

}