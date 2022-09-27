package io.eqoty.secretk.types.response

import io.eqoty.secretk.types.Coin

@kotlinx.serialization.Serializable
data class BalanceResponse(
    val balances: List<Coin>
)