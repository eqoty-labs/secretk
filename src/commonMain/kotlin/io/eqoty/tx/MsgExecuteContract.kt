package io.eqoty.tx

import co.touchlab.kermit.Logger
import io.eqoty.tx.proto.MsgExecuteContractProto
import io.eqoty.types.Coin
import io.eqoty.utils.EncryptionUtils
import io.eqoty.utils.addressToBytes
import io.eqoty.utils.getMissingCodeHashWarning
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.protobuf.ProtoNumber

class MsgExecuteContract(
    val sender: String,
    /** The contract's address */
    val contractAddress: String,
    /** The input message */
    val msg: JsonObject,
    /** Funds to send to the contract */
    val sentFunds: List<Coin> = emptyList(),
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
): Msg<MsgExecuteContractProto> {
    private var msgEncrypted: UByteArray? = null

    var codeHash: String? = codeHash
        set(value) {
            if (value!=null && !value.isNullOrBlank()) {
                warnCodeHash = false
            } else {
                Logger.w{ getMissingCodeHashWarning("MsgExecuteContract") }
            }
            field = value?.replace("0x", "")?.lowercase()
        }

    private var warnCodeHash: Boolean = true

    init {
        // set isn't triggered otherwise
        this.codeHash = codeHash
    }


    override suspend fun toProto(utils: EncryptionUtils): ProtoMsg<MsgExecuteContractProto> {
        if (warnCodeHash) {
            Logger.w{ getMissingCodeHashWarning("MsgExecuteContract") }
        }

        if (msgEncrypted == null) {
            // The encryption uses a random nonce
            // toProto() & toAmino() are called multiple times during signing
            // so to keep the msg consistant across calls we encrypt the msg only once
            msgEncrypted = utils.encrypt(codeHash!!, msg)
        }
        
        val msgContent = MsgExecuteContractProto(
            sender = addressToBytes(sender),
            contract = addressToBytes(contractAddress),
            msg = msgEncrypted!!.toByteArray() ,
            sentFunds = sentFunds.map { it.toProto() },
            // callbackSig & callbackCodeHash are internal stuff that doesn't matter here
            callbackSig = byteArrayOf(),
            callbackCodeHash = "",
        )

        return ProtoMsg(
            typeUrl = "/secret.compute.v1beta1.MsgExecuteContract",
            value = msgContent
        )
    }
}

