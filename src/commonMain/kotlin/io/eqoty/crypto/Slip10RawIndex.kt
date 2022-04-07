package io.eqoty.crypto;

import kotlin.jvm.JvmInline
import kotlin.math.pow

@JvmInline
value class Slip10RawIndex(val data: UInt)  {

  companion object {
    fun hardened(hardenedIndex: UInt): Slip10RawIndex =
      Slip10RawIndex(hardenedIndex + 2.toDouble().pow(31.toDouble()).toUInt())

    fun normal(normalIndex: UInt): Slip10RawIndex =
      Slip10RawIndex(normalIndex)
  }

  fun isHardened(): Boolean {
    return this.data >= 2.toDouble().pow(31.toDouble()).toUInt()
  }

  public infix fun shr(bitCount: Int): UInt =
    data.shr(bitCount)

  fun toInt(): Int = data.toInt()

  infix fun and(i: Long): UInt = data.and(i.toUInt())

  fun toUByte(): UByte = data.toUByte()

}