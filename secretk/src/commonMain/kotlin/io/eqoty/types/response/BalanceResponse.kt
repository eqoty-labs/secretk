package io.eqoty.types.response

import io.eqoty.types.Coin

@kotlinx.serialization.Serializable
data class BalanceResponse(
    val balances: List<Coin>
)