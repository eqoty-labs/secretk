package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

@kotlinx.serialization.Serializable
class FeeProto(
    @ProtoNumber(1) val amount: List<CoinProto> = emptyList(),
    @ProtoNumber(2) val gasLimit: Int? = null,
    @ProtoNumber(3) val payer: String? = null,
    @ProtoNumber(4) val granter: String? = null,
    ) : MsgProto()