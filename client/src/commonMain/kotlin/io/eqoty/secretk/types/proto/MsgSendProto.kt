package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
@kotlinx.serialization.Serializable
class MsgSendProto(
    @ProtoNumber(1) val fromAddress: String,
    @ProtoNumber(2) val toAddress: String,
    @ProtoNumber(3) val amount: List<CoinProto> = emptyList(),
) : MsgProto()