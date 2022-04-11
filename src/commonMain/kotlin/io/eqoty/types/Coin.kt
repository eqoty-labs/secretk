package io.eqoty.types;

@kotlinx.serialization.Serializable
data class Coin(
  val denom: String,
  val amount: String
) {
  constructor(denom: String, amount: Int) : this(denom, amount.toString())
}