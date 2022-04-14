package io.eqoty.types

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.tx.proto.AnyProto

data class Signer(
  val pubkey: AnyProto,
  val sequence: BigInteger,
)