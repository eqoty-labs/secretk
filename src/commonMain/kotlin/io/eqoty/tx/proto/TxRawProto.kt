package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class TxRawProto(
    @ProtoNumber(1) val bodyBytes: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val authInfoBytes: ByteArray = byteArrayOf(),
    @ProtoNumber(3) val signatures: List<ByteArray> = emptyList(),
    ) : MsgProto()