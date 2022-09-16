package io.eqoty.utils.bech32

import kotlin.math.ceil
import kotlin.math.floor

internal object BitConverter {
    /**
     * Converts a Uint8Array into a Uint8Array variant, in which each element
     * encodes 5 bits of the original byte array.
     *
     * @param {Uint8Array} src
     *   Input to convert
     * @param {?Uint8Array} dst
     *   Optional output buffer. If specified, the sequence of 5-bit chunks will be written there
     *   if not specified, the output buffer will be created from scratch. The length
     *   of `outBuffer` is not checked.
     * @returns {Uint8Array}
     *   Output buffer consisting of 5-bit chunks
     *
     * @api public
     */
    fun to5BitArray(src: ByteArray, dst: ByteArray? = null): ByteArray {
        val len = ceil((src.size.toDouble() * 8.0) / 5.0).toInt()
        val realDst = dst ?: ByteArray(len) { 0 }

        return toBits(src, 5, realDst)
    }

    fun from5BitArray(src: ByteArray, dst: ByteArray? = null): ByteArray {
        val len = floor((src.size.toDouble() * 5.0) / 8.0).toInt()
        val realDst = dst ?: ByteArray(len) { 0 }

        return fromBits(src, 5, realDst)
    }


    /**
     * Encodes a `ByteArray` buffer as an array with a lesser number of bits per element.
     *
     * @api private
     */
    fun toBits(
        src: ByteArray,
        bits: Int,
        dst: ByteArray,
    ): ByteArray {
        if ((bits > 8) || (bits < 1)) {
            throw RangeError("Invalid bits per element 1 to 8 expected")
        }
        // `BitArray<8>` is equivalent to `Uint8Array` unfortunately, Flow
        // has problems expressing this, so the explicit conversion is performed here.
        convert(src, 8, dst, bits, true)
        return dst
    }

    fun fromBits(
        src: ByteArray,
        bits: Int,
        dst: ByteArray,
    ): ByteArray {
        if ((bits > 8) || (bits < 1)) {
            throw RangeError("Invalid bits per element 1 to 8 expected")
        }

        convert(src, bits, dst, 8, false)
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
        val mask: Int = (1 shl dstBits) - 1
        var acc = 0
        var bits = 0
        var pos = 0
        src.forEach { b ->
            // Pull next bits from the input buffer into accumulator.
            // when converting b to int only take first byte (matters for negatives)
            acc = (acc shl srcBits) or (b.toInt() and 0xff)
            bits += srcBits

            // Push into the output buffer while there are enough bits in the accumulator.
            while (bits >= dstBits) {
                bits -= dstBits
                dst[pos] = ((acc shr bits) and mask).toByte()
                pos += 1
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
                throw Error("Excessive padding: ${bits} (max ${srcBits - 1} allowed)")
            }
            if (acc % (1 shl bits) != 0) {
                throw Error("Non-zero padding")
            }
        }
    }

}
