package io.eqoty.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/compute/v1beta1/msg.ts
 */
@kotlinx.serialization.Serializable
class MsgInstantiateContractProto(
    @ProtoNumber(1) val sender: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val callbackCodeHash: String = "",
    @ProtoNumber(3) val codeId: String = "",
    @ProtoNumber(4) val label: String = "",
    @ProtoNumber(5) val initMsg: ByteArray = byteArrayOf(),
    @ProtoNumber(6) val sentFunds: List<CoinProto> = emptyList(),
    @ProtoNumber(7) val callbackSig: ByteArray? = null,
) : MsgProto()