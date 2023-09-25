package io.eqoty.secretk.types.proto

import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
@kotlinx.serialization.Serializable
class MsgDataProto(
    @ProtoNumber(1) val msgType: String = "",
    @ProtoNumber(2) val data: ByteArray? = null,
) : MsgProto() {
    fun toMsgResponseType(): MsgProto = when (msgType) {

        "/secret.compute.v1beta1.MsgExecuteContract" -> {
            ProtoBuf.decodeFromByteArray(data ?: byteArrayOf()) as MsgExecuteContractResponseProto
        }

        "/cosmos.bank.v1beta1.MsgSend" -> {
            ProtoBuf.decodeFromByteArray(data ?: byteArrayOf()) as MsgSendResponseProto
        }

        "/secret.compute.v1beta1.MsgInstantiateContract" -> {
            ProtoBuf.decodeFromByteArray(data ?: byteArrayOf()) as MsgInstantiateContractResponseProto
        }

        "/secret.compute.v1beta1.MsgMigrateContract" -> {
            ProtoBuf.decodeFromByteArray(data ?: byteArrayOf()) as MsgMigrateContractResponseProto
        }

        "/secret.compute.v1beta1.MsgStoreCode" -> {
            ProtoBuf.decodeFromByteArray(data ?: byteArrayOf()) as MsgStoreCodeResponseProto
        }

        "/secret.compute.v1beta1.MsgClearAdmin" -> {
            ProtoBuf.decodeFromByteArray(data ?: byteArrayOf()) as MsgClearAdminResponseProto
        }

        "/secret.compute.v1beta1.MsgUpdateAdmin" -> {
            ProtoBuf.decodeFromByteArray(data ?: byteArrayOf()) as MsgUpdateAdminResponseProto
        }


        else -> throw UnsupportedOperationException("calling toMsg() on an Any proto with typeUrl:${msgType} is not supported")
    }
}
