package io.eqoty.secretk.types

import io.eqoty.secretk.types.proto.CoinProto

@kotlinx.serialization.Serializable
data class Coin(
    val denom: String,
    val amount: String
) {
    constructor(denom: String, amount: Int) : this(denom, amount.toString())

    fun toProto() = CoinProto(denom, amount)
}