package io.eqoty.types;

@kotlinx.serialization.Serializable
data class StdFee(
  val amount: List<Coin>,
  val gas: String
){
  constructor(amount: List<Coin>, gas: Int) : this(amount, gas.toString())
}