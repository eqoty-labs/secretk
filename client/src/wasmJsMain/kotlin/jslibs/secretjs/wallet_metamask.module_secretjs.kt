@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsModule("secretjs")

package jslibs.secretjs

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

open external class MetaMaskWallet : JsAny {
    open var ethProvider: JsAny
    open var ethAddress: String
    open var publicKey: Uint8Array
    open var address: String
    open fun getAccounts(): Promise<JsArray<AccountData>>
    open fun getSignMode(): Promise<JsAny>
    open fun signAmino(address: String, signDoc: StdSignDoc): Promise<AminoSignResponse>

    companion object {
        fun create(ethProvider: JsAny, ethAddress: String): Promise<MetaMaskWallet>
    }
}