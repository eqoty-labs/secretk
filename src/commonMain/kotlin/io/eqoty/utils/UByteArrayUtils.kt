package io.eqoty.utils

import okio.ByteString
import okio.ByteString.Companion.toByteString


fun UByteArray.toIntArray() : IntArray =
    map { it.toInt() }.toIntArray()

fun IntArray.toUByteArray() : UByteArray =
    map { it.toUByte() }.toUByteArray()


fun UByteArray.toByteString() : ByteString =
    toByteArray().toByteString()

fun UByteArray.decodeToString() : String =
    toByteArray().decodeToString()

fun ByteString.toUByteArray() : UByteArray =
    toByteArray().toUByteArray()

fun UByteArray.getPadded(length: Int): UByteArray {
    val paddingLength = length - this.size
    if (paddingLength < 0) {
        throw Error("Length too small to hold parameter r");
    }
    val padding = UByteArray(paddingLength) {0u}
    return padding + this
}