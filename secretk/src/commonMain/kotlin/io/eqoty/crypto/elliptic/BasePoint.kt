package io.eqoty.crypto.elliptic

import io.eqoty.crypto.elliptic.biginteger.BN
import io.eqoty.crypto.elliptic.biginteger.bitLength
import io.eqoty.crypto.elliptic.json.PrecomputedScep256k1
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonPrimitive
import kotlin.math.ceil

data class PreComputed<C : Curve>(
    var beta: BasePoint<C>?,
    val doubles: ComputedDoubles<C>?,
    val naf: ComputedNaf<C>
)

data class ComputedDoubles<C : Curve>(val step: Int, val points: List<BasePoint<C>>)
data class ComputedNaf<C : Curve>(val wnd: Int, val points: List<BasePoint<C>>)


sealed class BasePoint<C : Curve>(val curve: C, val type: String) {
    abstract fun isInfinity(): Boolean

    var precomputed: PreComputed<C>? = null
    abstract val inf: Boolean


    abstract fun mul(k: BN): BasePoint<C>

    fun hasDoubles(k: BN): Boolean {
        val doubles = precomputed?.doubles ?: return false

        return doubles.points.size >= ceil(((k.number.bitLength() + 1u) / doubles.step.toUInt()).toDouble())
    }

    fun getNAFPoints(wnd: Int): ComputedNaf<C> {
        if (precomputed?.naf != null)
            return precomputed!!.naf
        val res = mutableListOf(this)
        val max = (1 shl wnd) - 1
        val dbl = if (max == 1) null else this.dbl()
        for (i in 1 until max) {
            TODO()// res[i] = res[i - 1].add(dbl)
        }
        return ComputedNaf(
            wnd = wnd,
            points = res,
        )
    }

    fun encodeCompressed(): UByteArray = encode(true)

    abstract fun encode(compact: Boolean): UByteArray

    protected abstract fun dbl(): BasePoint<C>

    fun validate(): Boolean =
        curve.validate(this)

    abstract fun neg(precompute: Boolean? = null): BasePoint<C>
    abstract var x: BN?
    abstract var y: BN?

    companion object

}

class ShortCurvePoint : BasePoint<ShortCurve> {

    override var x: BN?
    override var y: BN?
    override val inf: Boolean

    constructor(curve: ShortCurve, type: String, x: String?, y: String?, isRed: Boolean?) :
            this(
                curve,
                type,
                if (x != null) BN(x, 16) else x,
                if (y != null) BN(y, 16) else y,
                isRed
            )

    constructor(curve: ShortCurve, type: String, x: BN?, y: BN?, isRed: Boolean?) : super(curve, type) {
        if (x == null && y == null) {
            this.x = null
            this.y = null
            this.inf = true
        } else {
            this.x = x
            this.y = y
            // Force redgomery representation when loading from JSON
            if (isRed == true) {
                this.x = this.x!!.forceRed(this.curve.red)
                this.y = this.y!!.forceRed(this.curve.red)
            }
            if (this.x?.red == null)
                this.x = this.x!!.toRed(this.curve.red)
            if (this.y?.red == null)
                this.y = this.y!!.toRed(this.curve.red)
            this.inf = false
        }
    }

    override fun isInfinity(): Boolean = inf


    override fun mul(k: BN): BasePoint<ShortCurve> {
        if (this.isInfinity())
            return this
        else if (this.hasDoubles(k))
            return this.curve.fixedNafMul(this, k)
        else if (this.curve.endo != null)
            return this.curve.endoWnafMulAdd(listOf(this), listOf(k))
        else
            return TODO()
//            //return this.curve._wnafMul(this, k);
    }


    fun getDoubles(step: Int? = null, power: Int? = null): ComputedDoubles<ShortCurve> {
        if (precomputed?.doubles != null)
            return precomputed!!.doubles!!

//        var doubles = listOf(this)
//        var acc = this;
//        for ( i in 0 until  power!! step step!!) {
//            for (j in 0 until step) {
//                acc = acc.dbl();
//            }
//            doubles.push(acc);
//        }
//        return {
//                step: step,
//                points: doubles,
//        }
        return TODO()
    }

    fun getBeta(): ShortCurvePoint? {
        if (this.curve.endo == null)
            return null

        var pre = this.precomputed
        if (pre?.beta != null)
            return pre.beta as ShortCurvePoint


        var beta = this.curve.point(this.x!!.redMul(this.curve.endo.beta), this.y!!, null)
        if (pre != null) {
            var curve = this.curve
            val endoMul: (ShortCurvePoint) -> ShortCurvePoint = { p ->
                curve.point(p.x!!.redMul(curve.endo!!.beta), p.y!!, null)
            }

            pre.beta = beta
            beta.precomputed = PreComputed(
                beta = null,
                naf = ComputedNaf(
                    wnd = pre.naf.wnd,
                    points = pre.naf.points.map { endoMul(it as ShortCurvePoint) }
                ),
                doubles = ComputedDoubles(
                    step = pre.doubles!!.step,
                    points = pre.doubles!!.points.map { endoMul(it as ShortCurvePoint) }
                )
            )
        }
        return beta
    }

    override fun neg(precompute: Boolean?): ShortCurvePoint {
        if (this.inf)
            return this

        val res = this.curve.point(this.x!!, this.y!!.redNeg(), null)
        if (precompute != null && this.precomputed != null) {
            val pre = this.precomputed!!

            val negate: (ShortCurvePoint) -> ShortCurvePoint = { p ->
                p.neg()
            }

            res.precomputed = PreComputed(
                beta = null,
                naf = ComputedNaf(
                    wnd = pre.naf.wnd,
                    points = pre.naf.points.map { negate(it as ShortCurvePoint) }
                ),
                doubles = ComputedDoubles(
                    step = pre.doubles!!.step,
                    points = pre.doubles.points.map { negate(it as ShortCurvePoint) }
                )
            )
        }
        return res
    }

    fun toJ(): JPoint {
        if (this.inf)
            return this.curve.jpoint(null, null, null)

        val res = this.curve.jpoint(this.x, this.y, this.curve.one)
        return res
    }

    override fun encode(compact: Boolean): UByteArray {
        val x = x!!.number.toUByteArray()

        if (compact) {
            val prepend = ubyteArrayOf(if (y!!.isEven()) 0x02u else 0x03u)
            return prepend + x
        }

        return ubyteArrayOf(0x04u) + x + y!!.number.toUByteArray()
    }

    override fun dbl(): BasePoint<ShortCurve> {
        TODO("Not yet implemented")
    }

    fun add(p: ShortCurvePoint): ShortCurvePoint {
        // O + P = P
        if (this.inf)
            return p

        // P + O = P
        if (p.inf)
            return this

        // P + P = 2P
        if (this == p)
            return dbl() as ShortCurvePoint

        // P + (-P) = O
        if (neg() == p)
            return this.curve.point(null, null)

        // P + Q = O
        if (this.x!!.compareTo(p.x!!) == 0)
            return this.curve.point(null, null)

        var c = this.y!!.redSub(p.y!!)
        if (c.compareTo(0) != 0)
            c = c.redMul(this.x!!.redSub(p.x!!).redInvm())
        val nx = c.redSqr().redSub(this.x!!).redSub(p.x!!)
        val ny = c.redMul(this.x!!.redSub(nx)).redSub(this.y!!)
        return this.curve.point(nx, ny)
    }

}


class JPoint(curve: ShortCurve, x: BN?, y: BN?, z: BN?) : BasePoint<ShortCurve>(curve, "jacobian") {

    private var zOne: Boolean
    override var x: BN? = null
    override var y: BN? = null
    var z: BN?
    override val inf: Boolean
        get() = isInfinity()

    init {
        if (x === null && y === null && z === null) {
            this.x = this.curve.one
            this.y = this.curve.one
            this.z = BN(0)
        } else {
            this.x = x
            this.y = y
            this.z = z
        }
        if (this.x!!.red == null)
            this.x = this.x!!.toRed(this.curve.red)
        if (this.y!!.red == null)
            this.y = this.y!!.toRed(this.curve.red)
        if (this.z!!.red == null)
            this.z = this.z!!.toRed(this.curve.red)

        this.zOne = this.z === this.curve.one
    }


    override fun isInfinity(): Boolean = this.z?.compareTo(0) == 0

    private fun zeroDbl(): JPoint {
        var nx: BN
        var ny: BN
        var nz: BN
        // Z = 1
        if (this.zOne) {
            // hyperelliptic.org/EFD/g1p/auto-shortw-jacobian-0.html
            //     #doubling-mdbl-2007-bl
            // 1M + 5S + 14A

            // XX = X1^2
            val xx = this.x!!.redSqr()
            // YY = Y1^2
            val yy = this.y!!.redSqr()
            // YYYY = YY^2
            val yyyy = yy.redSqr()
            // S = 2 * ((X1 + YY)^2 - XX - YYYY)
            var s = this.x!!.redAdd(yy).redSqr().redSub(xx).redSub(yyyy)
            s = s.redAdd(s)
            // M = 3 * XX + a; a = 0
            val m = xx.redAdd(xx).redAdd(xx)
            // T = M ^ 2 - 2*S
            val t = m.redSqr().redSub(s).redSub(s)

            // 8 * YYYY
            var yyyy8 = yyyy.redAdd(yyyy)
            yyyy8 = yyyy8.redAdd(yyyy8)
            yyyy8 = yyyy8.redAdd(yyyy8)

            // X3 = T
            nx = t
            // Y3 = M * (S - T) - 8 * YYYY
            ny = m.redMul(s.redSub(t)).redSub(yyyy8)
            // Z3 = 2*Y1
            nz = this.y!!.redAdd(this.y!!)
        } else {
            // hyperelliptic.org/EFD/g1p/auto-shortw-jacobian-0.html
            //     #doubling-dbl-2009-l
            // 2M + 5S + 13A

            // A = X1^2
            val a = this.x!!.redSqr()
            // B = Y1^2
            val b = this.y!!.redSqr()
            // C = B^2
            val c = b.redSqr()
            // D = 2 * ((X1 + B)^2 - A - C)
            var d = this.x!!.redAdd(b).redSqr().redSub(a).redSub(c)
            d = d.redAdd(d)
            // E = 3 * A
            val e = a.redAdd(a).redAdd(a)
            // F = E^2
            val f = e.redSqr()

            // 8 * C
            var c8 = c.redAdd(c)
            c8 = c8.redAdd(c8)
            c8 = c8.redAdd(c8)

            // X3 = F - 2 * D
            nx = f.redSub(d).redSub(d)
            // Y3 = E * (D - X3) - 8 * C
            ny = e.redMul(d.redSub(nx)).redSub(c8)
            // Z3 = 2 * Y1 * Z1
            nz = this.y!!.redMul(this.z!!)
            nz = nz.redAdd(nz)
        }

        return JPoint(curve, nx, ny, nz)
    }

    override fun dbl(): JPoint {
        if (this.isInfinity())
            return this

        if (this.curve.zeroA) {
            return this.zeroDbl()
        } else if (this.curve.threeA) {
            return TODO()
//            return this._threeDbl();
        } else {
            return dbl()
        }
    }

    fun dblp(pow: Int?): JPoint {
        if (pow == 0)
            return this
        if (this.isInfinity())
            return this
        if (pow == null)
            return this.dbl()

        var i: Int = 0
        if (this.curve.zeroA || this.curve.threeA) {
            var r = this
            while (i < pow) {
                r = r.dbl()
                i++
            }
            return r
        }
        return TODO()

//        // 1M + 2S + 1A + N * (4S + 5M + 8A)
//        // N = 1 => 6M + 6S + 9A
//        var a = this.curve.a;
//        var tinv = this.curve.tinv;
//
//        var jx = this.x;
//        var jy = this.y;
//        var jz = this.z;
//        var jz4 = jz.redSqr().redSqr();
//
//        // Reuse results
//        var jyd = jy.redAdd(jy);
//        for (i in 0 until pow) {
//            var jx2 = jx.redSqr();
//            var jyd2 = jyd.redSqr();
//            var jyd4 = jyd2.redSqr();
//            var c = jx2.redAdd(jx2).redIAdd(jx2).redIAdd(a.redMul(jz4));
//
//            var t1 = jx.redMul(jyd2);
//            var nx = c.redSqr().redISub(t1.redAdd(t1));
//            var t2 = t1.redISub(nx);
//            var dny = c.redMul(t2);
//            dny = dny.redIAdd(dny).redISub(jyd4);
//            var nz = jyd.redMul(jz);
//            if (i + 1 < pow)
//                jz4 = jz4.redMul(jyd4);
//
//            jx = nx;
//            jz = nz;
//            jyd = dny;
//        }
//
//        return this.curve.jpoint(jx, jyd.redMul(tinv), jz);
    }

    fun mixedAdd(p: ShortCurvePoint): JPoint {
        // O + P = P
        if (this.isInfinity())
            return p.toJ()

        // P + O = P
        if (p.isInfinity())
            return this

        // 8M + 3S + 7A
        val z2 = this.z!!.redSqr()
        val u1 = this.x!!
        val u2 = p.x!!.redMul(z2)
        val s1 = this.y!!
        val s2 = p.y!!.redMul(z2).redMul(this.z!!)

        val h = u1.redSub(u2)
        val r = s1.redSub(s2)
        if (h.compareTo(0) == 0) {
            return if (r.compareTo(0) != 0)
                this.curve.jpoint(null, null, null)
            else
                this.dbl()
        }

        val h2 = h.redSqr()
        val h3 = h2.redMul(h)
        val v = u1.redMul(h2)

        val nx = r.redSqr().redAdd(h3).redSub(v).redSub(v)
        val ny = r.redMul(v.redSub(nx)).redSub(s1.redMul(h3))
        val nz = this.z!!.redMul(h)

        return this.curve.jpoint(nx, ny, nz)
    }

    fun add(p: JPoint): JPoint {
        // O + P = P
        if (this.isInfinity())
            return p

        // P + O = P
        if (p.isInfinity())
            return this

        // 12M + 4S + 7A
        val pz2 = p.z!!.redSqr()
        val z2 = this.z!!.redSqr()
        val u1 = this.x!!.redMul(pz2)
        val u2 = p.x!!.redMul(z2)
        val s1 = this.y!!.redMul(pz2.redMul(p.z!!))
        val s2 = p.y!!.redMul(z2.redMul(this.z!!))

        val h = u1.redSub(u2)
        val r = s1.redSub(s2)
        if (h.compareTo(0) == 0) {
            return if (r.compareTo(0) != 0)
                this.curve.jpoint(null, null, null)
            else
                this.dbl()
        }

        val h2 = h.redSqr()
        val h3 = h2.redMul(h)
        val v = u1.redMul(h2)

        val nx = r.redSqr().redAdd(h3).redSub(v).redSub(v)
        val ny = r.redMul(v.redSub(nx)).redSub(s1.redMul(h3))
        val nz = this.z!!.redMul(p.z!!).redMul(h)

        return this.curve.jpoint(nx, ny, nz)
    }

    fun toP(): ShortCurvePoint {
        if (this.isInfinity())
            return this.curve.point(null, null, null)

        val zinv = this.z!!.redInvm()
        val zinv2 = zinv.redSqr()
        val ax = this.x!!.redMul(zinv2)
        val ay = this.y!!.redMul(zinv2).redMul(zinv)

        return this.curve.point(ax, ay, null)
    }

    override fun encode(compact: Boolean): UByteArray {
        TODO("Not yet implemented")
    }

    override fun mul(k: BN): JPoint {
        return TODO()
        //return this.curve.wnafMul(this, k);
    }

    override fun neg(precompute: Boolean?): JPoint {
        return TODO()
    }

}


fun BasePoint.Companion.fromJSON(curve: ShortCurve, obj: JsonArray, red: Boolean): ShortCurvePoint {
    val obj0 = obj[0].jsonPrimitive.content
    val obj1 = obj[1].jsonPrimitive.content
    val res = curve.point(obj0, obj1, red)

    if (obj.size == 2)
        return res

    val obj2point: (List<String>) -> BasePoint<ShortCurve> = {
        curve.point(it[0], it[1], red)
    }

    val pre: PrecomputedScep256k1 = Json.decodeFromJsonElement(obj[2])

    res.precomputed = PreComputed(
        beta = null,
        doubles = ComputedDoubles(
            step = pre.doubles.step,
            points = listOf(res) + pre.doubles.points.map(obj2point)
        ),
        naf = ComputedNaf(
            wnd = pre.naf.wnd,
            points = listOf(res) + pre.naf.points.map(obj2point)
        )
    )
    return res
}