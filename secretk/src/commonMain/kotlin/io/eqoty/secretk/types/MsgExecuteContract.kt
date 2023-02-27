package io.eqoty.secretk.types

import co.touchlab.kermit.Logger
import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.kryptools.bech32.addressToBytes
import io.eqoty.secretk.types.proto.MsgExecuteContractProto
import io.eqoty.secretk.types.proto.ProtoMsg
import io.eqoty.secretk.types.proto.toProto
import io.eqoty.secretk.utils.EncryptionUtils
import io.ktor.util.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

class MsgExecuteContract(
    var sender: String,
    /** The contract's address */
    var contractAddress: String,
    /** The input message */
    val msg: String,
    /** Funds to send to the contract */
    var sentFunds: List<Coin> = emptyList(),
    /** The SHA256 hash value of the contract's WASM bytecode, represented as case-insensitive 64
     * character hex String.
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
    codeHash: String? = null
) : EncryptedMsg<MsgExecuteContractProto> {

    private var msgEncrypted: UByteArray? = null
    var codeHash: String? = codeHash
        set(value) {
            if (!value.isNullOrBlank()) {
                field = value.replace("0x", "").lowercase()
            } else {
                Logger.w { getMissingParameterWarning("MsgExecuteContract", "codeHash") }
                field = null
            }
        }

    init {
        // set isn't triggered otherwise
        this.codeHash = codeHash
    }

    override suspend fun toProto(utils: EncryptionUtils): ProtoMsg<MsgExecuteContractProto> {
        if (codeHash.isNullOrBlank()) {
            throw RuntimeException(getMissingParameterWarning("MsgExecuteContract", "codeHash"))
        }


        if (msgEncrypted == null) {
            // The encryption uses a random nonce
            // toProto() & toAmino() are called multiple times during signing
            // so to keep the msg consistant across calls we encrypt the msg only once
            msgEncrypted = utils.encrypt(codeHash!!, Json.parseToJsonElement(msg).jsonObject)
        }

        val msgContent = MsgExecuteContractProto(
            sender = addressToBytes(sender),
            contract = addressToBytes(contractAddress),
            msg = msgEncrypted!!.toByteArray(),
            sentFunds = sentFunds.map { it.toProto() },
            // callbackSig & callbackCodeHash are internal stuff that doesn't matter here
//            callbackSig = byteArrayOf(),
            callbackCodeHash = null,
        )

        return ProtoMsg(
            typeUrl = "/secret.compute.v1beta1.MsgExecuteContract",
            value = msgContent
        )
    }

    override suspend fun toAmino(utils: EncryptionUtils): MsgAmino {
        if (codeHash.isNullOrBlank()) {
            throw RuntimeException(getMissingParameterWarning("MsgExecuteContract", "codeHash"))
        }

        if (msgEncrypted == null) {
            // The encryption uses a random nonce
            // toProto() & toAmino() are called multiple times during signing
            // so to keep the msg consistant across calls we encrypt the msg only once
            msgEncrypted = utils.encrypt(codeHash!!, Json.parseToJsonElement(msg).jsonObject)
        }

        return MsgExecuteContractAmino(
            MsgExecuteContractAminoData(
                sender = sender,
                contract = contractAddress,
                msg = msgEncrypted!!.toByteArray().encodeBase64(),
                sentFunds = sentFunds,
            )
        )
    }
}

