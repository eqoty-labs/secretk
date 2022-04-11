package io.eqoty.types;

import io.eqoty.response.MsgValue
import io.eqoty.response.TypeValue

/** An Amino/Cosmos SDK StdTx */
@kotlinx.serialization.Serializable
data class StdTx<T: MsgValue> (
  val msg: List<TypeValue<T>>,
  val fee: StdFee,
  val signatures: List<StdSignature>,
  val memo: String?
)
