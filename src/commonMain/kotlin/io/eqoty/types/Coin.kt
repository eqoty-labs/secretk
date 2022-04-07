package io.eqoty.types;

@kotlinx.serialization.Serializable
data class Coin(
  val denom: String,
  val amount: String
)