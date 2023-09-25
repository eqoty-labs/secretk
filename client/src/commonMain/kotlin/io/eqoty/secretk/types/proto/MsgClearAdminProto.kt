package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
@kotlinx.serialization.Serializable
class MsgClearAdminProto(
    @ProtoNumber(1) val sender: String,
    @ProtoNumber(3) val contract: String,
    @ProtoNumber(7) val callbackSig: ByteArray? = null,
) : MsgProto()