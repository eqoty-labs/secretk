package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
@kotlinx.serialization.Serializable
class MsgMigrateContractProto(
    @ProtoNumber(1) val sender: String,
    @ProtoNumber(2) val contract: String,
    @ProtoNumber(3) val codeId: Int,
    @ProtoNumber(4) val msg: ByteArray = byteArrayOf(),
    @ProtoNumber(7) val callbackSig: ByteArray? = null,
    @ProtoNumber(8) val callbackCodeHash: String?,
) : MsgProto()