package io.eqoty.crypto.elliptic.biginteger

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.DecimalMode
import com.ionspin.kotlin.bignum.decimal.RoundingMode
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.Sign
import kotlin.math.ceil
import kotlin.math.max

class BN {
    val number: BigInteger
    // Reduction context
    val red : Red?

    constructor(number: BigInteger, red: Red? = null){
        this.number = number
        this.red = red
    }
    constructor(string: String, base: Int, red: Red? = null){
        this.number = BigInteger.parseString(string.replace(" ", ""), base)
        this.red = red
    }
    constructor(num: Int, red: Red? = null){
        this.number = BigInteger.fromInt(num)
        this.red = red
    }

    fun bitLength() = number.bitLength()


    fun toRed(ctx: Red): BN {
        require(red == null) {"Already a number in reduction context"}
        require(!number.isNegative) {"red works only with positives"}
        return ctx.convertTo(this).forceRed(ctx);
    }

    internal fun forceRed(ctx: Red): BN = BN(this.number, ctx)

    fun fromRed (): BN {
        require(this.red!=null) {"fromRed works only with numbers in reduction context" }
        return this.red.convertFrom(this)
    }



    val negative : Boolean
    get() = number.isNegative

    val zero : Boolean
        get() = number.isZero()

    /**
     * The least significant 26 bits == Word[0] in https://github.com/indutny/bn.js/
     */
    val word0 : BN
    get() = this.and(BN(0x3ffffff))


    fun shl(n: Int): BN = BN(number.shl(n), red)
    fun shr(n: Int): BN = BN(number.shr(n), red)

    fun subtract(n: BN): BN = BN(number.subtract(n.number), red)

    fun mod(n: BN): BN = BN(number.mod(n.number), red)

    fun multiply(n: BN): BN = BN(number.multiply(n.number), red)

    fun negate(): BN = BN(number.negate(), red)

    fun add(n: BN): BN = BN(number.add(n.number), red)

    fun and(n: BN): BN = BN(number.and(n.number), red)

    fun divRound(divisor: BN): BN {
        val resultAndRem = number.divideAndRemainder(divisor.number)
        var result = resultAndRem.first
        val remainder = resultAndRem.second

        if (!result.isNegative) {
            val remainderDec = BigDecimal.fromBigInteger(remainder)
            val divisorDec = BigDecimal.fromBigInteger(divisor.number)
            val oneHalf = BigDecimal.fromDouble(0.5)
            val remainderOverDivisor = remainderDec.divide(divisorDec, DecimalMode(decimalPrecision= 2, roundingMode = RoundingMode.FLOOR))
            if (remainderOverDivisor >=  oneHalf) {
                // round by adding one if remainder over divisor is >= 0.5
                result += 1
            }
            return BN(result, red)
        } else {
            return TODO("Handle negative round")
        }
    }



    // This is reduced incarnation of the binary EEA
    // above, designated to invert members of the
    // _prime_ fields F(p) at a maximal speed
    fun _invmp(p: BN): BN {
        require(!p.negative)
        require(!p.zero)

        var a = this
        var b = p

        if (a.negative) {
            a = a.mod(p)
        }

        var x1 = BN(1)
        var x2 =  BN(0)

        var delta = b


        while (a > 1 && b > 1) {
            var i = 0
            var im = 1
            while ( (a.word0.number.intValue() and im) == 0 && i < 26) {
                i++
                im = im shl 1
            }
            if (i > 0) {
                a = a.shr(i)
                while (i-- > 0) {
                    if (x1.isOdd()) {
                        x1 = x1.add(delta)
                    }

                    x1 = x1.shr(1)
                }
            }

            var j = 0
            var jm = 1
            while ((b.word0.number.intValue() and jm) == 0 && j < 26) {
                j++
                jm = jm shl 1
            }
            if (j > 0) {
                b = b.shr(j)
                while (j-- > 0) {
                    if (x2.isOdd()) {
                        x2 = x2.add(delta)
                    }

                    x2 = x2.shr(1)
                }
            }


            if (a >= b) {
                a = a.subtract(b)
                x1 = x1.subtract(x2)
            } else {
                b = b.subtract(a)
                x2 = x2.subtract(x1)
            }
        }

        val res: BN
        if (a.compareTo(1) == 0) {
            res = x1;
        } else {
            res = x2;
        }

        if (res < 0) {
            res.add(p);
        }

        return res;
    }

    fun redMul (num: BN): BN {
        require(this.red != null) {"redMul works only with red numbers"}
        this.red.verify2(this, num);
        return this.red.mul(this, num);
    };

    operator fun compareTo(i: Int): Int = number.compareTo(i)
    operator fun compareTo(i: BN): Int = number.compareTo(i.number)

    override fun equals(other: Any?): Boolean {
        if (other is BN){
            if (number == other.number && red != other.red) {
                println("Warning: Comparing two BN numbers with same number, but different red values. Returning false. This may not be the desired behavior")
            }
            return number == other.number && red == other.red
        }
        return super.equals(other)
    }

    fun redNeg(): BN {
        require(this.red != null) {"redMul works only with red numbers"}
        this.red.verify1(this);
        return this.red.neg(this);
    }

    fun andln(num: Int): Int {
        val leastSignificant26Bits = word0.number.intValue()
        return leastSignificant26Bits.and(num)
    }

    fun isOdd(): Boolean {
        val one = BN(1)
        return this.and(one).number.abs() == one.number
    }
    fun isEven(): Boolean {
        return !isOdd()
    }


    fun redAdd(num: BN): BN {
        require(this.red != null) {"redMul works only with red numbers"}
        return this.red.add(this, num);
    }

    fun redInvm(): BN {
        require(this.red != null) {"redMul works only with red numbers"}
        this.red.verify1(this);
        return this.red.invm(this);
    }

    fun redSqr(): BN {
        require(this.red != null) {"redMul works only with red numbers"}
        this.red.verify1(this);
        return this.red.sqr(this);
    }

    fun redSub(num: BN): BN {
        require(this.red != null) {"redMul works only with red numbers"}
        return this.red.sub(this, num);
    }




    companion object {
        val ZERO = BN(BigInteger.ZERO)
        val ONE = BN(BigInteger.ONE)
    }

}






fun BN.Companion.red(m: String) = Red(m)
fun BN.Companion.mont(m: BN) = Mont(m)

fun BN.Companion.prime(name: String): MPrime {
    // Cached version of prime
    if (primes[name] != null) return primes[name]!!

    val prime =
        if (name == "k256") {
            MPrime(
                "k256",
                BN(
                    "ffffffff ffffffff ffffffff ffffffff ffffffff ffffffff fffffffe fffffc2f",
                    16
                )
            )
        } else if (name === "p224") {
            TODO()
            //P224()
        } else if (name === "p192") {
            TODO()
            //P192()
        } else if (name === "p25519") {
            TODO()
            //P25519()
        } else {
            throw Error("Unknown prime $name");
        }
    primes[name] = prime

    return prime;
}



private val primes = mutableMapOf<String, MPrime?>(
    // Prime numbers with efficient reduction
    "k256" to null,
    "p224" to null,
    "p192" to null,
    "p25519" to null
)

// Pseudo-Mersenne prime
class MPrime (val name: String, val p: BN) {
    // P = 2 ^ N - K
    val n = p.bitLength().toInt()
    val k = BN.ONE.shl(this.n).subtract(this.p)

//    val tmp = _tmp()
//
//    private fun _tmp(): BN {
//        val words : WordArray = ULongArray(ceil(this.n.toDouble() / 13.toDouble()).toInt()) { 0u }
//        return BN(BigInteger.createFromWordArray(words, Sign.ZERO))
//    }

    fun ireduce(num: BN): BN {
        // Assumes that `num` is less than `P^2`
        // num = HI * (2 ^ N - K) + HI * K + LO = HI * K + LO (mod P)
        var r = num
        var rlen : ULong = 0u

        do {
            val split = this.split(r)
            r = split.first
            val tmp = split.second
            r = this.mulK(r)
            r = r.add(tmp)
            rlen = r.bitLength()
        } while (rlen.toInt() > this.n);
        val cmp = if(rlen < n.toULong()) -1 else r.compareTo(this.p);
        if (cmp == 0) {
            TODO()
//            r.words[0] = 0;
//            r.length = 1;
        } else if (cmp > 0) {
            r = r.subtract(this.p);
        }

        return r;
    }

    private fun split(input: BN): Pair<BN,BN> {
        val a = BN(input.number.shr(n), input.red)
        val numBytesShifted = n/8
        val inputByteArray = input.number.toByteArray()
        val inputByteSize = inputByteArray.size
        val bByteSize = inputByteSize - (inputByteSize - numBytesShifted)
        val bByteArray = ByteArray(bByteSize)
        inputByteArray.copyInto(bByteArray,0,inputByteSize - numBytesShifted, inputByteSize)
        val b = BN(BigInteger.fromByteArray(bByteArray,Sign.POSITIVE), input.red)
        return Pair(a,b)
    }

    private fun mulK (num: BN): BN {
        return num.multiply(this.k)
    }

}

open class Red {
    val m : BN
    var prime : MPrime?

    constructor(m: String) {
        val prime = BN.prime(m);
        this.m = prime.p
        this.prime = prime
    }
    constructor(m: BN){
        require(m > 1) { "modulus must be greater than 1" }
        this.m = m
        this.prime = null
    }

    open fun convertTo(num: BN): BN {
        val r = num.mod(this.m)
        return r
    }

    open fun convertFrom (num: BN): BN {
        return BN(num.number)
    }

    internal fun verify2(a: BN, b: BN) {
        require(!a.negative && !b.negative) {"red works only with positives"}
        require(a.red != null && a.red == b.red) {"red works only with red numbers"}
    }

    fun mul(a: BN, b: BN) : BN {
        this.verify2(a, b)
        return this.imod(a.multiply(b));
    }

    fun imod (a: BN) : BN {
        if (this.prime != null) {
            return this.prime!!.ireduce(a).forceRed(this)
        }
        else return a.mod(this.m).forceRed(this);
    }

    fun verify1(a: BN) {
        require(!a.negative) {"red works only with positives"}
        require(a.red != null) {"red works only with red numbers"}
    }

    fun neg(num: BN): BN {
        if (num.number.isZero()){
            return num
        }
        return m.subtract(num).forceRed(this)
    }

    fun invm(num: BN): BN {
        var inv = num._invmp(this.m)
        if (inv.negative) {
            return this.imod(inv).redNeg();
        } else {
            return this.imod(inv);
        }
    }

    fun sqr(num: BN): BN {
        return this.mul(num, num)
    }

    fun add(a: BN, b: BN): BN {
        this.verify2(a, b)

        var res = a.add(b);
        if (res >= this.m) {
            res = res.subtract(this.m)
        }
        return res.forceRed(this)
    }

    fun sub(a: BN, b: BN): BN {
        this.verify2(a, b)

        var res = a.subtract(b)
        if (res < 0) {
            res = res.add(this.m)
        }
        return res.forceRed(this)
    }
}

class Mont(m: BN): Red(m) {


    init {
        TODO()
    }
    val shift : ULong
        get() {
            var tmpShift = this.m.number.bitLength()
            if (tmpShift % 26u != 0.toULong()) {
                tmpShift += 26u - (tmpShift % 26u)
            }
            return tmpShift
        }


//    val r = BN.ONE.shl(shift.toInt())
//    val r2 = this.imod(this.r.sqr());
//    this.rinv = this.r._invmp(this.m);
//
//    this.minv = this.rinv.mul(this.r).isubn(1).div(this.m);
//    this.minv = this.minv.umod(this.r);
//    this.minv = this.r.sub(this.minv);

    override fun convertTo(num: BN): BN {
        TODO()
    }

    override fun convertFrom(num: BN): BN {
        TODO()
    }
}

// And first word and num
fun BigInteger.andln(num: ULong): ULong {
    return getBackingArrayCopy()[0] and num
}



fun BigInteger.countBits(w: ULong): ULong {
    var t = w
    var r = 0u
    if (t >= 4096u) {
        r += 13u
        t = t shr 13
    }
    if (t >= 64u) {
        r += 7u
        t = t shr 7
    }
    if (t >= 8u) {
        r += 4u
        t = t shr 4;
    }
    if (t >= 2u) {
        r += 2u
        t = t shr 2;
    }
    return r + t
}

fun BigInteger.bitLength(): ULong {
    val byteArray = toByteArray()
    val leadingZeros = byteArray[0].countLeadingZeroBits().toULong()
    return byteArray.size.toULong() * 8u - leadingZeros
}

fun BigInteger.byteLength() : ULong {
    return ceil((this.bitLength() / 8u).toDouble()).toULong()
}

fun BigInteger.toArray(endian: String, length: Int?): ULongArray {
    var byteLength = this.byteLength().toInt()
    var reqLength = length ?: max(1, byteLength)
    require(byteLength <= reqLength){ "byte array longer than desired length"}
    require(reqLength > 0) {"Requested array length <= 0"}

    var littleEndian = endian == "le"
    var res = ULongArray(reqLength) {0u}

    var b : ULong
    var q = BigInteger.fromBigInteger(this)
    if (!littleEndian) {
        // Assume big-endian
        for (i in 0 until (reqLength - byteLength)) {
            res[i] = 0u
        }
        var i = 0
        while(!q.isZero()) {
            b = q.andln(255u/*0xff*/);
            q = q shr 8

            res[reqLength - i - 1] = b
            i++
        }
    } else {
        var i = 0
        while(!q.isZero()) {
            b = q.andln(255u/*0xff*/);
            q = q shr 8

            res[i] = b
            i++
        }

        while (i < reqLength) {
            res[i] = 0u
            i++
        }
    }

    return res
}