package io.eqoty.utils

import okio.ByteString
import okio.ByteString.Companion.toByteString


fun UByteArray.toIntArray() : IntArray =
    map { it.toInt() }.toIntArray()

fun IntArray.toUByteArray() : UByteArray =
    map { it.toUByte() }.toUByteArray()


fun UByteArray.toByteString() : ByteString =
    toByteArray().toByteString()