@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsModule("secretjs")
@file:JsNonModule

package jslibs.secretjs

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

external interface MsgInstantiateContractParams : MsgParams {
    var sender: String
    var codeId: Number
    var label: String
    var initMsg: Any
    var initFunds: Array<Coin>?
        get() = definedExternally
        set(value) = definedExternally
    var codeHash: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun getMissingCodeHashWarning(method: String): String

open external class MsgInstantiateContract(__0: MsgInstantiateContractParams) : Msg {
    open var sender: String
    open var codeId: String
    open var label: String
    open var initMsg: Any?
    open var initMsgEncrypted: Any
    open var initFunds: Array<Coin>
    open var codeHash: String
    open var warnCodeHash: Any
    override fun toProto(utils: EncryptionUtils): Promise<ProtoMsg>
    override fun toAmino(utils: EncryptionUtils): Promise<AminoMsg>
}

external interface MsgExecuteContractParams<T> : MsgParams {
    var sender: String
    var contractAddress: String
    var msg: T
    var sentFunds: Array<Coin>?
        get() = definedExternally
        set(value) = definedExternally
    var codeHash: String?
        get() = definedExternally
        set(value) = definedExternally
}

open external class MsgExecuteContract<T : Any>(__0: MsgExecuteContractParams<T>) : Msg {
    open var sender: String
    open var contractAddress: String
    open var msg: T
    open var msgEncrypted: String
    var sentFunds: Array<Coin>
    open var codeHash: String
    open var warnCodeHash: String
    override fun toProto(utils: EncryptionUtils): Promise<ProtoMsg>
    override fun toAmino(utils: EncryptionUtils): Promise<AminoMsg>
}

external interface MsgStoreCodeParams : MsgParams {
    var sender: String
    var wasmByteCode: Uint8Array
    var source: String
    var builder: String
}

/*
external open class MsgStoreCode(__0: MsgStoreCodeParams) : Msg {
    open var sender: String
    open var wasmByteCode: Uint8Array
    open var source: String
    open var builder: String
    open var gzipWasm: Any
    open fun toProto(): Promise<ProtoMsg>
    open fun toAmino(): Promise<AminoMsg>
}
*/

external interface MsgParams

external interface Msg {
    fun toProto(utils: EncryptionUtils): Promise<ProtoMsg>
    fun toAmino(utils: EncryptionUtils): Promise<AminoMsg>
}

external interface ProtoMsg {
    var typeUrl: String
    var value: Any
    fun encode(): Promise<Uint8Array>
}

external interface AminoMsg {
    var type: String
    var value: Any
}