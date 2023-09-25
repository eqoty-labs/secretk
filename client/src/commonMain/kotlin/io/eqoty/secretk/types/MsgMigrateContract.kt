package io.eqoty.secretk.types

import io.eqoty.secretk.types.proto.MsgMigrateContractProto
import io.eqoty.secretk.types.proto.ProtoMsg
import io.eqoty.secretk.utils.EncryptionUtils
import io.eqoty.secretk.utils.logger
import io.ktor.util.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

class MsgMigrateContract(
    override val sender: String,
    val contractAddress: String,
    val msg: String,
    var codeId: Int,
    codeHash: String? = null
) : EncryptedMsg<MsgMigrateContractProto> {

    private var msgEncrypted: UByteArray? = null
    override var codeHash: String? = codeHash
        set(value) {
            field = if (!value.isNullOrBlank()) {
                value.replace("0x", "").lowercase()
            } else {
                logger.w { getMissingParameterWarning("MsgMigrateContract", "codeHash") }
                null
            }
        }

    init {
        // set isn't triggered otherwise
        this.codeHash = codeHash
    }

    override suspend fun toProto(utils: EncryptionUtils): ProtoMsg<MsgMigrateContractProto> {
        if (codeHash.isNullOrBlank()) {
            throw RuntimeException(getMissingParameterWarning("MsgMigrateContract", "codeHash"))
        }


        if (msgEncrypted == null) {
            // The encryption uses a random nonce
            // toProto() & toAmino() are called multiple times during signing
            // so to keep the msg consistent across calls we encrypt the msg only once
            msgEncrypted = utils.encrypt(codeHash!!, Json.parseToJsonElement(msg).jsonObject)
        }

        val msgContent = MsgMigrateContractProto(
            sender = sender,
            contract = contractAddress,
            codeId = codeId,
            msg = msgEncrypted!!.asByteArray(),
            // callbackSig & callbackCodeHash are internal stuff that doesn't matter here
//            callbackSig = byteArrayOf(),
            callbackCodeHash = null,
        )

        return ProtoMsg(
            typeUrl = "/secret.compute.v1beta1.MsgMigrateContract",
            value = msgContent
        )
    }

    override suspend fun toAmino(utils: EncryptionUtils): MsgAmino {
        if (codeHash.isNullOrBlank()) {
            throw RuntimeException(getMissingParameterWarning("MsgMigrateContract", "codeHash"))
        }

        if (msgEncrypted == null) {
            // The encryption uses a random nonce
            // toProto() & toAmino() are called multiple times during signing
            // so to keep the msg consistent across calls we encrypt the msg only once
            msgEncrypted = utils.encrypt(codeHash!!, Json.parseToJsonElement(msg).jsonObject)
        }

        return MsgMigrateContractAmino(
            MsgMigrateContractAminoData(
                sender = sender,
                contract = contractAddress,
                msg = msgEncrypted!!.asByteArray().encodeBase64(),
                codeId = codeId,
            )
        )
    }
}

