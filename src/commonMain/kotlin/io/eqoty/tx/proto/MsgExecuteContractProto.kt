package io.eqoty.tx.proto

import io.eqoty.types.Coin
import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class MsgExecuteContractProto(
    @ProtoNumber(1) val sender: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val contract: ByteArray = byteArrayOf(),
    @ProtoNumber(3) val msg: ByteArray = byteArrayOf(),
    @ProtoNumber(4) val callbackCodeHash: String = "",
    @ProtoNumber(5) val sentFunds: List<CoinProto> = emptyList(),
    @ProtoNumber(6) val callbackSig: ByteArray = byteArrayOf(),
) : MsgProto()