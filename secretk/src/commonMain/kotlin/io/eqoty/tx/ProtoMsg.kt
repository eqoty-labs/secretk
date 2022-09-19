package io.eqoty.tx

import io.eqoty.tx.proto.MsgProto

@kotlinx.serialization.Serializable
class ProtoMsg<M : MsgProto>(
    val typeUrl: String,
    val value: M,
)