package io.eqoty.tx

import co.touchlab.kermit.Logger
import io.eqoty.tx.proto.MsgExecuteContractProto
import io.eqoty.types.MsgAmino
import io.eqoty.utils.EncryptionUtils
import io.eqoty.utils.getMissingCodeHashWarning

class MsgInstantiateContract(
    val sender: String,

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
    codeHash: String?
) : EncryptedMsg<MsgExecuteContractProto> {
    private var msgEncrypted: UByteArray? = null

    var codeHash: String? = null
    private val warnCodeHash: Boolean

    init {
        if (codeHash != null) {
            this.codeHash = codeHash.replace("0x", "").lowercase()
            this.warnCodeHash = false
        } else {
            // codeHash will be set in SecretNetworkClient before invoking toProto() & toAimno()
            this.codeHash = null
            this.warnCodeHash = true
            Logger.w { getMissingCodeHashWarning("MsgExecuteContract") }
        }
    }

    override suspend fun toProto(utils: EncryptionUtils): ProtoMsg<MsgExecuteContractProto> {
        TODO("Not yet implemented")
    }

    override suspend fun toAmino(utils: EncryptionUtils): MsgAmino {
        TODO("Not yet implemented")
    }
}

