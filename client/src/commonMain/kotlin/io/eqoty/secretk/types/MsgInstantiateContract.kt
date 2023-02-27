package io.eqoty.secretk.types

import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.kryptools.bech32.addressToBytes
import io.eqoty.secretk.types.proto.MsgInstantiateContractProto
import io.eqoty.secretk.types.proto.ProtoMsg
import io.eqoty.secretk.types.proto.toProto
import io.eqoty.secretk.utils.EncryptionUtils
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

class MsgInstantiateContract(
    var sender: String,
    /** The id of the contract's WASM code */
    var codeId: Int?,
    /** A unique label across all contracts */
    var label: String,
    /** The input message to the contract's constructor */
    val initMsg: String,
    /** Funds to send to the contract */
    var initFunds: List<Coin> = emptyList(),
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
    var codeHash: String? = codeHash
        set(value) {
            if (!value.isNullOrBlank()) {
                field = value.replace("0x", "").lowercase()
            } else {
                field = null
            }
        }

    init {
        // set isn't triggered otherwise
        this.codeHash = codeHash
    }

    override suspend fun toProto(utils: EncryptionUtils): ProtoMsg<MsgInstantiateContractProto> {
        if (codeHash.isNullOrBlank()) {
            throw RuntimeException(getMissingParameterWarning("MsgInstantiateContract", "codeHash"))
        }
        if (codeId == null) {
            throw RuntimeException(getMissingParameterWarning("MsgInstantiateContract", "codeId"))
        }

        if (initMsgEncrypted == null) {
            // The encryption uses a random nonce
            // toProto() & toAmino() are called multiple times during signing
            // so to keep the msg consistant across calls we encrypt the msg only once
            initMsgEncrypted = utils.encrypt(codeHash!!, Json.parseToJsonElement(initMsg).jsonObject)
        }

        val msgContent = MsgInstantiateContractProto(
            sender = addressToBytes(sender),
            codeId = codeId!!,
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

