package io.eqoty.secretk.types.response

import com.ionspin.kotlin.bignum.integer.BigInteger

data class GetNonceResult(
    val accountNumber: BigInteger,
    val sequence: BigInteger
)