package io.eqoty.secretk.types

import co.touchlab.kermit.Logger
import io.eqoty.secretk.types.proto.MsgExecuteContractProto
import io.eqoty.secretk.types.proto.MsgInstantiateContractProto
import io.eqoty.secretk.types.proto.ProtoMsg
import io.eqoty.secretk.utils.EncryptionUtils
import io.eqoty.secretk.utils.addressToBytes
import io.eqoty.secretk.utils.getMissingCodeHashWarning
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

class MsgInstantiateContract(
    val sender: String,
    /** The id of the contract's WASM code */
    val codeId: Int,
    /** A unique label across all contracts */
    val label: String,
    /** The input message to the contract's constructor */
    val initMsg: String,
    /** Funds to send to the contract */
    val initFunds: List<Coin> = emptyList(),
    /** The SHA256 hash value of the contract's WASM bytecode, represented as case-insensitive 64
     * character hex string.
     * This is used to make sure only the contract that's being invoked can decrypt the query data.
     *
     * codeHash is an optional parameter but using it will result in way faster execution time.
     *
     * Valid examples:
     * - "af74387e276be8874f07bec3a87023ee49b0e7ebe08178c49d0a49c3c98ed60e"
     * - "0xaf74387e276be8874f07bec3a87023ee49b0e7ebe08178c49d0a49c3c98ed60e"
     * - "AF74387E276BE8874F07BEC3A87023EE49B0E7EBE08178C49D0A49C3C98ED60E"
     * - "0xAF74387E276BE8874F07BEC3A87023EE49B0E7EBE08178C49D0A49C3C98ED60E"
     */
    codeHash: String?
) : EncryptedMsg<MsgInstantiateContractProto> {
    private var initMsgEncrypted: UByteArray? = null
    var codeHash: String? = null
    private val warnCodeHash: Boolean

    init {
        if (codeHash != null) {
            this.codeHash = codeHash.replace("0x", "").lowercase()
            this.warnCodeHash = false
        } else {
            // codeHash will be set in SecretNetworkClient before invoking toProto() & toAmino()
            this.codeHash = null
            this.warnCodeHash = true
            Logger.w { getMissingCodeHashWarning("MsgInstantiateContract") }
        }
    }

    override suspend fun toProto(utils: EncryptionUtils): ProtoMsg<MsgInstantiateContractProto> {
        if (warnCodeHash) {
            Logger.w { getMissingCodeHashWarning("MsgInstantiateContract") }
        }

        if (initMsgEncrypted == null) {
            // The encryption uses a random nonce
            // toProto() & toAmino() are called multiple times during signing
            // so to keep the msg consistant across calls we encrypt the msg only once
            initMsgEncrypted = utils.encrypt(codeHash!!, Json.parseToJsonElement(initMsg).jsonObject)
        }

        val msgContent = MsgInstantiateContractProto(
            sender = addressToBytes(sender),
            codeId = codeId,
            label = label,
            initMsg = initMsgEncrypted!!.toByteArray(),
            initFunds = initFunds.map { it.toProto() },
            // callbackSig & callbackCodeHash are internal stuff that doesn't matter here
            callbackSig = null,
            callbackCodeHash = null,
        )

        return ProtoMsg(
            typeUrl = "/secret.compute.v1beta1.MsgInstantiateContract",
            value = msgContent
        )
    }

    override suspend fun toAmino(utils: EncryptionUtils): MsgAmino {
        TODO("Not yet implemented")
    }
}

