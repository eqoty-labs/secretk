package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class AuthInfoProto(
    @ProtoNumber(1) val signerInfos: List<SignerInfoProto> = emptyList(),
    @ProtoNumber(2) val fee: FeeProto,
    ) : MsgProto()