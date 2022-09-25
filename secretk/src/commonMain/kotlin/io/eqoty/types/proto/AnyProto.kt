package io.eqoty.types.proto

import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/google/protobuf/any.ts
 */
@kotlinx.serialization.Serializable
class AnyProto(
    @ProtoNumber(1) val typeUrl: String = "",
    @ProtoNumber(2) val value: ByteArray = byteArrayOf(),
) {
    fun toMsg(): MsgProto {
        return when (typeUrl) {
            "/secret.compute.v1beta1.MsgInstantiateContract" -> {
                ProtoBuf.decodeFromByteArray(value) as MsgInstantiateContractProto
            }

            "/secret.compute.v1beta1.MsgExecuteContract" -> {
                ProtoBuf.decodeFromByteArray(value) as MsgExecuteContractProto
            }

            "/secret.compute.v1beta1.MsgStoreCode" -> {
                ProtoBuf.decodeFromByteArray(value) as MsgStoreCodeProto
            }

            else -> throw UnsupportedOperationException("calling toMsg() on an Any proto with typeUrl:${typeUrl} is not supported")
        }
    }
}