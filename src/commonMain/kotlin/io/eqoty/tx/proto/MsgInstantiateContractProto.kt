package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class MsgInstantiateContractProto(
    @ProtoNumber(1) val sender: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val callbackCodeHash: String = "",
    @ProtoNumber(3) val codeId: String = "",
    @ProtoNumber(4) val label: String = "",
    @ProtoNumber(5) val initMsg: ByteArray = byteArrayOf(),
    @ProtoNumber(6) val sentFunds: List<CoinProto> = emptyList(),
    @ProtoNumber(7) val callbackSig: ByteArray = byteArrayOf(),
    ) : MsgProto()