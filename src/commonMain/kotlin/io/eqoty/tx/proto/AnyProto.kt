package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class AnyProto (
  @ProtoNumber(1) val typeUrl: String = "",
  @ProtoNumber(2) val value: ByteArray = byteArrayOf(),
)