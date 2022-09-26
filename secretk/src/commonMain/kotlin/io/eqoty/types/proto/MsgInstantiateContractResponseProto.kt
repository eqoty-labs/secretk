package io.eqoty.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
@kotlinx.serialization.Serializable
class MsgInstantiateContractResponseProto(
    @ProtoNumber(1) val address: String,
    @ProtoNumber(2) val data: ByteArray? = null
) : MsgProto()