package io.eqoty.utils.bech32

import io.eqoty.utils.bech32.BitConverter.from5BitArray
import io.eqoty.utils.bech32.BitConverter.to5BitArray
import kotlin.experimental.and

sealed class Bech32Error(override val message: String) : Error()
class InvalidDataLength(message: String) : Bech32Error(message)
class InvalidCharacter(character: Char, index: Int) : Bech32Error("Invalid char:$character, at index: $index")
class InvalidPrefix(message: String) : Bech32Error(message)
class InvalidChecksum : Bech32Error("InvalidChecksum")
class RangeError(message: String) : Bech32Error(message)

// Based on:
//https://github.com/bitcoinj/bitcoinj/tree/master/core/src/main/java/org/bitcoinj/core
//https://github.com/slowli/bech32-buffer
//https://github.com/bitcoinjs/bech32/blob/master/src/index.ts
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
    val CHARSET = "qpzry9x8gf2tvdw0s3jn54khce6mua7l"

    /** The Bech32 character set for decoding.  */
    val CHARSET_REV = byteArrayOf(
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        15, -1, 10, 17, 21, 20, 26, 30, 7, 5, -1, -1, -1, -1, -1, -1,
        -1, 29, -1, 24, 13, 25, 9, 8, 23, -1, 18, 22, 31, 27, 19, -1,
        1, 0, 3, 16, 11, 28, 12, 14, 6, 4, 2, -1, -1, -1, -1, -1,
        -1, 29, -1, 24, 13, 25, 9, 8, 23, -1, 18, 22, 31, 27, 19, -1,
        1, 0, 3, 16, 11, 28, 12, 14, 6, 4, 2, -1, -1, -1, -1, -1
    )


    val CHECKSUM_LENGTH = 6

    // Minimum char code that could be present in the encoded message
    private val MIN_CHAR_CODE = 33

    // Maximum char code that could be present in the encoded message
    private val MAX_CHAR_CODE = 126

    // Maximum encoded message length
    private val MAX_ENC_LENGTH = 90

    /** Encode a Bech32 string.  */
    fun encode(bech32: Bech32Data): String {
        return encode(bech32.encoding, bech32.hrp, bech32.data)
    }


    /**
     * Encodes binary data into Bech32 encoding.
     *
     * @param {string} prefix
     *   Human-readable prefix to place at the beginning of the encoding
     * @param {ByteArray} data
     *   Binary data to encode
     * @param {Encoding} encoding
     *   Encoding to use influences the checksum computation. If not specified,
     *   Bech32 encoding will be used.
     * @returns {string}
     *   Bech32 encoding of data in the form `<prefix>1<base32 of data><checksum>`
     *
     * @api public
     */
    fun encode(encoding: Encoding = Encoding.BECH32, prefix: String, data: ByteArray): String =
        encode5BitArray(prefix, to5BitArray(data), encoding)

    /**
     * Based on: https://github.com/bitcoinjs/bech32/blob/master/src/index.ts
     */
    private fun encode5BitArray(prefix: String, data: ByteArray, encoding: Encoding): String {
        // 1. Allocate buffer for all operations
        // expanded prefix + five-bit data encoding + CHECKSUM_LENGTH
        val len = 2 * prefix.length + 1 + data.size + CHECKSUM_LENGTH

        if (len - prefix.length > MAX_ENC_LENGTH) {
            throw Error("Message to be produced is too long (max $MAX_ENC_LENGTH supported)")
        }

        // determine chk mod
        var chk = prefixChk(prefix)
        var result = prefix + "1"
        for (i in data.indices) {
            val x = data[i].toInt()
            if (x shr 5 != 0) throw Error("Non 5-bit word")

            chk = polymodStep(chk) xor x
            result += CHARSET[x]
        }

        for (i in 0 until CHECKSUM_LENGTH) {
            chk = polymodStep(chk)
        }
        chk = chk xor encoding.checksum

        for (i in 0 until CHECKSUM_LENGTH) {
            val v = (chk shr ((5 - i) * 5)) and 0x1f
            result += CHARSET[v]
        }

        return result
    }

    fun decode(message: String): Bech32Data {
        val fiveBitBech32Data = decodeTo5BitArray(message)
        return Bech32Data(fiveBitBech32Data.encoding, fiveBitBech32Data.hrp, from5BitArray(fiveBitBech32Data.data))
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

    fun prefixChk(prefix: String): Int {
        var chk = 1
        for (i in prefix.indices) {
            val c = prefix[i].code
            if (c < MIN_CHAR_CODE || c > MAX_CHAR_CODE) {
                throw RangeError("Invalid char in prefix: $c should be in ASCII range $MIN_CHAR_CODE-$MAX_CHAR_CODE")
            }
            chk = polymodStep(chk) xor (c shr 5)
        }

        chk = polymodStep(chk)

        for (i in prefix.indices) {
            val v = prefix[i].code
            chk = polymodStep(chk) xor (v and 0x1f)
        }
        return chk
    }

    fun polymodStep(pre: Int): Int {
        val b = pre shr 25
        return (
                ((pre and 0x1ffffff) shl 5) xor
                        (-((b shr 0) and 1) and 0x3b6a57b2) xor
                        (-((b shr 1) and 1) and 0x26508e6d) xor
                        (-((b shr 2) and 1) and 0x1ea119fa) xor
                        (-((b shr 3) and 1) and 0x3d4233dd) xor
                        (-((b shr 4) and 1) and 0x2a1462b3)
                )
    }

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
    fun verifyChecksum(hrp: String, values: ByteArray): Encoding? {
        val hrpExpanded = expandHrp(hrp)
        val combined = ByteArray(hrpExpanded.size + values.size)
        hrpExpanded.copyInto(combined, 0, 0, hrpExpanded.size)
        values.copyInto(combined, hrpExpanded.size, 0, values.size)
        val check = polymod(combined)
        return when (check) {
            Encoding.BECH32.checksum -> Encoding.BECH32
            Encoding.BECH32M.checksum -> Encoding.BECH32M
            else -> null
        }
    }


    enum class Encoding(val checksum: Int) {
        BECH32(1),
        BECH32M(0x2bc830a3)
    }

    class Bech32Data constructor(val encoding: Encoding, val hrp: String, val data: ByteArray)
}