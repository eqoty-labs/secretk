package io.eqoty.types

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.response.PubKey

data class Account (
    /** Bech32 account address */
  val address: String,
    val balance: List<Coin>,
    val pubkey: PubKey?,
    val accountNumber: BigInteger,
    val sequence: BigInteger,
)