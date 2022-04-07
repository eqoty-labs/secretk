package io.eqoty.types;

@kotlinx.serialization.Serializable
data class StdFee(
  val amount: List<Coin>,
  val gas: String
)