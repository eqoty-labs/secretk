package io.eqoty.types;

import io.eqoty.response.TypeValue
import io.eqoty.tx.proto.MsgProto

/** An Amino/Cosmos SDK StdTx */
@kotlinx.serialization.Serializable
data class StdTx<T: MsgProto> (
  val msg: List<TypeValue<T>>,
  val fee: StdFee,
  val signatures: List<StdSignature>,
  val memo: String?
)
