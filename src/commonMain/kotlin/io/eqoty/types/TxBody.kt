package io.eqoty.types

import io.eqoty.tx.ProtoMsg
import io.eqoty.tx.proto.MsgProto

@kotlinx.serialization.Serializable
data class TxBody<M : MsgProto>(
    val typeUrl: String = "/cosmos.tx.v1beta1.TxBody",
    val value: TxBodyValue<M>,
)

@kotlinx.serialization.Serializable
data class TxBodyValue<M : MsgProto>(
    val messages: List<ProtoMsg<M>>,
    val memo: String = ""
)
