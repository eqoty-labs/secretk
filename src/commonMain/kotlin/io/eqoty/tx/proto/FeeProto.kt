package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/cosmos/cosmos-sdk/blob/main/proto/cosmos/tx/v1beta1/tx.proto
 */
@kotlinx.serialization.Serializable
class FeeProto(
    @ProtoNumber(1) val amount: List<CoinProto> = emptyList(),
    @ProtoNumber(2) val gasLimit: Int? = null,
    @ProtoNumber(3) val payer: String? = null,
    @ProtoNumber(4) val granter: String? = null,
    ) : MsgProto()