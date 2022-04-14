package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class SignerInfoProto(
    @ProtoNumber(1) val publicKey: AnyProto? = null,
    @ProtoNumber(2) val modeInfo: ModeInfoProto? = null,
    @ProtoNumber(3) val sequence: Int? = null,
    ) : MsgProto()