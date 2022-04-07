package io.eqoty.types;

/** An Amino/Cosmos SDK StdTx */
@kotlinx.serialization.Serializable
data class StdTx<T: MsgValue> (
  val msg: List<Msg<T>>,
  val fee: StdFee,
  val signatures: List<StdSignature>,
  val memo: String?
)
