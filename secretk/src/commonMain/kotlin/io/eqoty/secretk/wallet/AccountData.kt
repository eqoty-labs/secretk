package io.eqoty.secretk.wallet

data class AccountData(
    /** A printable address (typically bech32 encoded) */
    val address: String,
    val algo: Algo,
    val pubkey: UByteArray
)
