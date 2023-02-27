package io.eqoty.secretk.types

import io.eqoty.secretk.types.proto.MsgProto
import io.eqoty.secretk.types.proto.ProtoMsg

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
