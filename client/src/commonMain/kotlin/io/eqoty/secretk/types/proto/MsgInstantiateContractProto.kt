package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
@kotlinx.serialization.Serializable
class MsgInstantiateContractProto(
    @ProtoNumber(1) val sender: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val callbackCodeHash: String?,
    @ProtoNumber(3) val codeId: Int,
    @ProtoNumber(4) val label: String = "",
    @ProtoNumber(5) val initMsg: ByteArray = byteArrayOf(),
    @ProtoNumber(6) val initFunds: List<CoinProto> = emptyList(),
    @ProtoNumber(7) val callbackSig: ByteArray? = null,
) : MsgProto()