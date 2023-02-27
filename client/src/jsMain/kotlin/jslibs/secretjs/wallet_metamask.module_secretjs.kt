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

open external class MetaMaskWallet {
    open var ethProvider: Any
    open var ethAddress: String
    open var publicKey: Uint8Array
    open var address: String
    open fun getAccounts(): Promise<Array<AccountData>>
    open fun getSignMode(): Promise<Any>
    open fun signAmino(address: String, signDoc: StdSignDoc): Promise<AminoSignResponse>

    companion object {
        fun create(ethProvider: Any, ethAddress: String): Promise<MetaMaskWallet>
    }
}