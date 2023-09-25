package io.eqoty.secretk.types

import io.eqoty.secretk.types.proto.MsgUpdateAdminProto
import io.eqoty.secretk.types.proto.ProtoMsg

class MsgUpdateAdmin(
    override val sender: String,
    val newAdmin: String,
    val contractAddress: String,
) : UnencryptedMsg<MsgUpdateAdminProto> {

    override suspend fun toProto(): ProtoMsg<MsgUpdateAdminProto> {
        val msgContent = MsgUpdateAdminProto(
            sender = sender,
            newAdmin = newAdmin,
            contract = contractAddress,
        )

        return ProtoMsg(
            typeUrl = "/secret.compute.v1beta1.MsgUpdateAdmin",
            value = msgContent
        )
    }

    override suspend fun toAmino(): MsgAmino {
        return MsgUpdateAdminAmino(
            MsgUpdateAdminAminoData(
                sender = sender,
                newAdmin = newAdmin,
                contract = contractAddress,
            )
        )
    }

}

