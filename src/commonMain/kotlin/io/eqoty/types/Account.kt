package io.eqoty.types

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.response.PubKeySecp256k1

data class Account (
    /** Bech32 account address */
  val address: String,
    val balance: List<Coin>,
    val pubkey: PubKeySecp256k1?,
    val accountNumber: BigInteger,
    val sequence: BigInteger,
)