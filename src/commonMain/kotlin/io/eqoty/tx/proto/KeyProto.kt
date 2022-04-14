package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class KeyProto(
    @ProtoNumber(1) val key: ByteArray,
) : MsgProto()