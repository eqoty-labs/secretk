package io.eqoty.types

@kotlinx.serialization.Serializable
data class StdFee(
    val amount: List<Coin>,
    val gas: String,
    val granter: String? = null
) {
    constructor(amount: List<Coin>, gas: Int, granter: String? = null) : this(amount, gas.toString(), granter)
}