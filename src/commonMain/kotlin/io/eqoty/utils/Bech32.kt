package io.eqoty.utils

import kotlin.experimental.and
import kotlin.math.floor

sealed class Bech32Error(override val message: String): Error()
class InvalidDataLength(message: String): Bech32Error(message)
class InvalidCharacter(character: Char, index: Int): Bech32Error("Invalid char:$character, at index: $index")
class InvalidPrefix(message: String): Bech32Error(message)
class InvalidChecksum(): Bech32Error("InvalidChecksum")
class RangeError(message: String): Bech32Error(message)

// Based on:
//https://github.com/bitcoinj/bitcoinj/tree/master/core/src/main/java/org/bitcoinj/core
//https://github.com/slowli/bech32-buffer

/**
 *
 * Implementation of the Bech32 encoding.
 *
 *
 * See [BIP350](https://github.com/bitcoin/bips/blob/master/bip-0350.mediawiki) and
 * [BIP173](https://github.com/bitcoin/bips/blob/master/bip-0173.mediawiki) for details.
 */
object Bech32 {
    /** The Bech32 character set for encoding.  */
    private const val CHARSET = "qpzry9x8gf2tvdw0s3jn54khce6mua7l"

    /** The Bech32 character set for decoding.  */
    private val CHARSET_REV = byteArrayOf(
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        15, -1, 10, 17, 21, 20, 26, 30, 7, 5, -1, -1, -1, -1, -1, -1,
        -1, 29, -1, 24, 13, 25, 9, 8, 23, -1, 18, 22, 31, 27, 19, -1,
        1, 0, 3, 16, 11, 28, 12, 14, 6, 4, 2, -1, -1, -1, -1, -1,
        -1, 29, -1, 24, 13, 25, 9, 8, 23, -1, 18, 22, 31, 27, 19, -1,
        1, 0, 3, 16, 11, 28, 12, 14, 6, 4, 2, -1, -1, -1, -1, -1
    )
    private const val BECH32_CONST = 1
    private const val BECH32M_CONST = 0x2bc830a3

    /** Find the polynomial with value coefficients mod the generator as 30-bit.  */
    private fun polymod(values: ByteArray): Int {
        var c = 1
        for (v_i in values) {
            val c0 = c ushr 25 and 0xff
            c = c and 0x1ffffff shl 5 xor (v_i and 0xff.toByte()).toInt()
            if (c0 and 1 != 0) c = c xor 0x3b6a57b2
            if (c0 and 2 != 0) c = c xor 0x26508e6d
            if (c0 and 4 != 0) c = c xor 0x1ea119fa
            if (c0 and 8 != 0) c = c xor 0x3d4233dd
            if (c0 and 16 != 0) c = c xor 0x2a1462b3
        }
        return c
    }

    /** Expand a HRP for use in checksum computation.  */
    private fun expandHrp(hrp: String): ByteArray {
        val hrpLength = hrp.length
        val ret = ByteArray(hrpLength * 2 + 1)
        for (i in 0 until hrpLength) {
            val c = hrp[i].code and 0x7f // Limit to standard 7-bit ASCII
            ret[i] = (c ushr 5 and 0x07).toByte()
            ret[i + hrpLength + 1] = (c and 0x1f).toByte()
        }
        ret[hrpLength] = 0
        return ret
    }

    /** Verify a checksum.  */
    private fun verifyChecksum(hrp: String, values: ByteArray): Encoding? {
        val hrpExpanded = expandHrp(hrp)
        val combined = ByteArray(hrpExpanded.size + values.size)
        hrpExpanded.copyInto(combined, 0, 0, hrpExpanded.size)
        values.copyInto(combined, hrpExpanded.size, 0, values.size)
        val check = polymod(combined)
        return if (check == BECH32_CONST) Encoding.BECH32 else if (check == BECH32M_CONST) Encoding.BECH32M else null
    }

    /** Create a checksum.  */
    private fun createChecksum(encoding: Encoding, hrp: String, values: ByteArray): ByteArray {
        val hrpExpanded = expandHrp(hrp)
        val enc = ByteArray(hrpExpanded.size + values.size + 6)
        hrpExpanded.copyInto(enc, 0, 0, hrpExpanded.size)
        values.copyInto(enc, hrpExpanded.size, 0, values.size)
        val mod = polymod(enc) xor if (encoding == Encoding.BECH32) BECH32_CONST else BECH32M_CONST
        val ret = ByteArray(6)
        for (i in 0..5) {
            ret[i] = (mod ushr 5 * (5 - i) and 31).toByte()
        }
        return ret
    }

    /** Encode a Bech32 string.  */
    fun encode(bech32: Bech32Data): String {
        return encode(bech32.encoding, bech32.hrp, bech32.data)
    }

    /** Encode a Bech32 string.  */
    fun encode(encoding: Encoding, hrp: String, values: ByteArray): String {
        var hrp = hrp
        require(hrp.length >= 1) {"Human-readable part is too short"}
        require(hrp.length <= 83) {"Human-readable part is too long"}
        hrp = hrp.lowercase()
        val checksum = createChecksum(encoding, hrp, values)
        val combined = ByteArray(values.size + checksum.size)
        values.copyInto(combined, 0, 0, values.size)
        checksum.copyInto(combined, values.size, 0, checksum.size)
        val sb = StringBuilder(hrp.length + 1 + combined.size)
        sb.append(hrp)
        sb.append('1')
        for (b in combined) {
            sb.append(CHARSET[b.toInt()])
        }
        return sb.toString()
    }

    /** Decode a Bech32 string.  */
    fun decodeTo5BitArray(str: String): Bech32Data {
        var lower = false
        var upper = false
        if (str.length < 8) throw InvalidDataLength("Input too short: " + str.length)
        if (str.length > 90) throw InvalidDataLength("Input too long: " + str.length)
        for (i in 0 until str.length) {
            val c = str[i]
            if (c.code < 33 || c.code > 126) throw InvalidCharacter(c, i)
            if (c >= 'a' && c <= 'z') {
                if (upper) throw InvalidCharacter(c, i)
                lower = true
            }
            if (c >= 'A' && c <= 'Z') {
                if (lower) throw InvalidCharacter(c, i)
                upper = true
            }
        }
        val pos = str.lastIndexOf('1')
        if (pos < 1) throw InvalidPrefix("Missing human-readable part")
        val dataPartLength = str.length - 1 - pos
        if (dataPartLength < 6) throw InvalidDataLength("Data part too short: $dataPartLength")
        val values = ByteArray(dataPartLength)
        for (i in 0 until dataPartLength) {
            val c = str[i + pos + 1]
            if (CHARSET_REV[c.code].toInt() == -1) throw InvalidCharacter(c, i + pos + 1)
            values[i] = CHARSET_REV[c.code]
        }
        val hrp = str.substring(0, pos).lowercase()
        val encoding = verifyChecksum(hrp, values) ?: throw InvalidChecksum()
        return Bech32Data(encoding, hrp, values.copyOfRange(0, values.size - 6))
    }
    fun decode(message: String): Bech32Data {
        val fiveBitBech32Data = decodeTo5BitArray(message);
        return Bech32Data(fiveBitBech32Data.encoding, fiveBitBech32Data.hrp, from5BitArray(fiveBitBech32Data.data))
    }

    fun from5BitArray(src: ByteArray): ByteArray {
        val len = floor((src.size.toDouble() * 5.0) / 8.0).toInt()
        val realDst = ByteArray(len){ 0 }

        return fromBits(src, 5, realDst)
    }

    fun fromBits(
    src: ByteArray,
    bits: Int,
    dst: ByteArray,
    ): ByteArray {
        if ((bits > 8) || (bits < 1)) {
            throw RangeError("Invalid bits per element; 1 to 8 expected")
        }

        convert(src, bits, dst, 8, false);
        return dst
    }

    /**
     * Converts an array from one number of bits per element to another.
     *
     * @api private
     */
    fun convert(
    src: ByteArray,
    srcBits: Int,
    dst: ByteArray,
    dstBits: Int,
    pad: Boolean,
    ) {
        val mask : Int = (1 shl dstBits) - 1
        var acc = 0
        var bits = 0
        var pos = 0
        src.forEach{ b ->
            // Pull next bits from the input buffer into accumulator.
            acc = (acc shl srcBits) + b;
            bits += srcBits;

            // Push into the output buffer while there are enough bits in the accumulator.
            while (bits >= dstBits) {
                bits -= dstBits;
                dst[pos] = ((acc shr bits) and mask).toByte()
                pos += 1;
            }
        }

        if (pad) {
            if (bits > 0) {
                // `dstBits - rem.bits` is the number of trailing zero bits needed to be appended
                // to accumulator bits to get the trailing bit group.
                dst[pos] = ((acc shl (dstBits - bits)) and mask).toByte()
            }
        } else {
            // Truncate the remaining padding, but make sure that it is zeroed and not
            // overly long first.
            if (bits >= srcBits) {
                throw Error("Excessive padding: ${bits} (max ${srcBits - 1} allowed)");
            }
            if (acc % (1 shl bits) != 0) {
                throw Error("Non-zero padding");
            }
        }
    }

    enum class Encoding {
        BECH32, BECH32M
    }

    class Bech32Data constructor(val encoding: Encoding, val hrp: String, val data: ByteArray)
}