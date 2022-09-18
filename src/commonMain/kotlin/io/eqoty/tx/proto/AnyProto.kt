package io.eqoty.tx.proto

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
                val msgInstantiateContract: MsgInstantiateContractProto = ProtoBuf.decodeFromByteArray(value)
                msgInstantiateContract
            }

            "/secret.compute.v1beta1.MsgExecuteContract" -> {
                val msgExecuteContract: MsgExecuteContractProto = ProtoBuf.decodeFromByteArray(value)
                msgExecuteContract
            }

            else -> throw UnsupportedOperationException("calling toMsg() on an Any proto with typeUrl:${typeUrl} is not supported")
        }
    }
}