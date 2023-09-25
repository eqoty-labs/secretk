package io.eqoty.secretk.types

import io.eqoty.secretk.types.proto.MsgClearAdminProto
import io.eqoty.secretk.types.proto.ProtoMsg

/***
 *  MsgSend represents a message to send coins from one account to another.
 */
class MsgClearAdmin(
    override val sender: String,
    val contractAddress: String,
) : UnencryptedMsg<MsgClearAdminProto> {

    override suspend fun toProto(): ProtoMsg<MsgClearAdminProto> {
        val msgContent = MsgClearAdminProto(
            sender = sender,
            contract = contractAddress,
        )

        return ProtoMsg(
            typeUrl = "/secret.compute.v1beta1.MsgClearAdmin",
            value = msgContent
        )
    }

    override suspend fun toAmino(): MsgAmino {
        return MsgClearAdminAmino(
            MsgClearAdminAminoData(
                sender = sender,
                contract = contractAddress,
            )
        )
    }

}

