package io.eqoty.utils


fun UByteArray.toIntArray() : IntArray =
    map { it.toInt() }.toIntArray()

fun IntArray.toUByteArray() : UByteArray =
    map { it.toUByte() }.toUByteArray()