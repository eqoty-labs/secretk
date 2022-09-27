package io.eqoty.secretk.types.proto

@kotlinx.serialization.Serializable
class ProtoMsg<M : MsgProto>(
    val typeUrl: String,
    val value: M,
)