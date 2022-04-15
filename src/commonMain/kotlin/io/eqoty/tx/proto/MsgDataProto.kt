package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class MsgDataProto(
    @ProtoNumber(1) val msgType: String = "",
    @ProtoNumber(2) val data: ByteArray = byteArrayOf(),
) : MsgProto()