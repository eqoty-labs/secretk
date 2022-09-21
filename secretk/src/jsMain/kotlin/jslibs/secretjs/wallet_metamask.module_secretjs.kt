@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsModule("secretjs")
@file:JsNonModule

package jslibs.secretjs

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external open class MetaMaskWallet {
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