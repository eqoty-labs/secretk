package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class TxMsgDataProto(
    @ProtoNumber(1) val data: List<MsgDataProto> = emptyList()
) : MsgProto()