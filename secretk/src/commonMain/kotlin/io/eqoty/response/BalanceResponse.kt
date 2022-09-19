package io.eqoty.response

import io.eqoty.types.Coin

@kotlinx.serialization.Serializable
data class BalanceResponse(
    val balances: List<Coin>
)