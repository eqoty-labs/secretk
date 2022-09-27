package io.eqoty.secretk.types

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.secretk.types.proto.AnyProto

data class Signer(
    val pubkey: AnyProto,
    val sequence: BigInteger,
)