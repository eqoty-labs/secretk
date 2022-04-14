package io.eqoty.tx.proto;

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
data class CoinProto(
  @ProtoNumber(1) val denom: String = "",
  @ProtoNumber(2) val amount: String = ""
)