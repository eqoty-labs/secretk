package io.eqoty.crypto.elliptic;

import io.eqoty.crypto.elliptic.biginteger.BN
import io.eqoty.crypto.elliptic.biginteger.bitLength
import io.eqoty.crypto.elliptic.json.Doubles
import io.eqoty.crypto.elliptic.json.Naf
import io.eqoty.crypto.elliptic.json.PrecomputedScep256k1
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonPrimitive
import kotlin.math.ceil

data class PreComputed <C: Curve>(
    var beta: BasePoint<C>?,
    val doubles: PreComputedDoubles<C>?,
    val naf: PreComputedNaf<C>
)
data class PreComputedDoubles<C: Curve>(val step: Int, val points: List<BasePoint<C>>)
data class PreComputedNaf<C: Curve>(val wnd: Int, val points: List<BasePoint<C>>)


sealed class BasePoint <C: Curve> (val curve: C, val type: String) {
    abstract fun isInfinity(): Boolean

    var precomputed : PreComputed<C>? = null



    fun hasDoubles(k: BN): Boolean {
        val doubles = precomputed?.doubles ?: return false

        return doubles.points.size >= ceil(((k.number.bitLength() + 1u) / doubles.step.toUInt()).toDouble());
    }


    companion object

}

class ShortCurvePoint: BasePoint<ShortCurve>{

    private var x: BN?
    private var y: BN?
    private var inf: Boolean

    constructor(curve: ShortCurve, type: String, x: String?, y: String?, isRed: Boolean?) :
            this(curve,
                type,
                if (x!= null) BN(x, 16) else x,
                if (y!= null) BN(y, 16) else y,
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
                this.x =  this.x!!.forceRed(this.curve.red);
                this.y = this.y!!.forceRed(this.curve.red);
            }
            if (this.x?.red == null)
                this.x = this.x!!.toRed(this.curve.red);
            if (this.y?.red == null)
                this.y = this.y!!.toRed(this.curve.red);
            this.inf = false;
        }
    }

    override fun isInfinity(): Boolean = inf


    fun mul(k: BN): ShortCurvePoint {
        if (this.isInfinity())
            return this;
        else if (this.hasDoubles(k))
            TODO()
            //return this.curve._fixedNafMul(this, k);
        else if (this.curve.endo != null)
            return this.curve.endoWnafMulAdd(listOf(this), listOf(k));
        else
            return TODO()
//            //return this.curve._wnafMul(this, k);
    }

    fun getBeta(): ShortCurvePoint? {
        if (this.curve.endo == null)
            return null

        var pre = this.precomputed
        if (pre?.beta != null)
            return pre.beta as ShortCurvePoint


        var beta = this.curve.point(this.x!!.redMul(this.curve.endo.beta), this.y!!, null);
        if (pre != null) {
            var curve = this.curve
            val endoMul : (ShortCurvePoint) -> ShortCurvePoint = { p->
                curve.point(p.x!!.redMul(curve.endo!!.beta), p.y!!, null)
            }

            pre.beta = beta
            beta.precomputed = PreComputed(
                beta = null,
                naf = PreComputedNaf(
                    wnd = pre.naf.wnd,
                    points = pre.naf.points.map{endoMul(it as ShortCurvePoint)}
                ),
                doubles = PreComputedDoubles(
                    step = pre.doubles!!.step,
                    points = pre.doubles!!.points.map{endoMul(it as ShortCurvePoint)}
                )
            )
        }
        return beta
    };

}



fun BasePoint.Companion.fromJSON(curve: ShortCurve, obj: JsonArray, red: Boolean): ShortCurvePoint {
    val obj0 = obj[0].jsonPrimitive.content
    val obj1 = obj[1].jsonPrimitive.content
    val res = curve.point(obj0, obj1, red)

    if (obj.size == 2)
        return res

   val obj2point : (List<String>) -> BasePoint<ShortCurve> = {
       curve.point(it[0], it[1], red);
    }

    val pre : PrecomputedScep256k1 = Json.decodeFromJsonElement(obj[2])

    res.precomputed = PreComputed(
        beta = null,
        doubles = PreComputedDoubles(
            step = pre.doubles.step,
            points =  listOf(res)  + pre.doubles.points.map(obj2point)
        ),
        naf = PreComputedNaf(
            wnd = pre.naf.wnd,
            points =  listOf(res)  + pre.naf.points.map(obj2point)
        )
    )
    return res
}