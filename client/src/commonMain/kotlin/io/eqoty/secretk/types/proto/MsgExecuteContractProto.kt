package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/compute/v1beta1/msg.ts
 */
@kotlinx.serialization.Serializable
class MsgExecuteContractProto(
    @ProtoNumber(1) val sender: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val contract: ByteArray = byteArrayOf(),
    @ProtoNumber(3) val msg: ByteArray = byteArrayOf(),
    @ProtoNumber(4) val callbackCodeHash: String?,
    @ProtoNumber(5) val sentFunds: List<CoinProto> = emptyList(),
    @ProtoNumber(6) val callbackSig: ByteArray? = null
) : MsgProto()