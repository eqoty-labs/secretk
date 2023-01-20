@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package jslib.walletconnectv2

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

typealias ProviderRpcError = Error

external interface ProviderMessage {
    var type: String
    var data: Any
}

external interface ProviderInfo {
    var chainId: String
}

typealias ProviderChainId = String

typealias ProviderAccounts = Array<String>

external interface SimpleEventEmitter {
    fun on(event: String, listener: Any)
    fun once(event: String, listener: Any)
    fun removeListener(event: String, listener: Any)
    fun off(event: String, listener: Any)
}

external interface EIP1193Provider : SimpleEventEmitter {
    fun on(event: String /* "connect" */, listener: (info: ProviderInfo) -> Unit)
    override fun on(event: String, listener: Any)
    fun on(event: String /* "disconnect" */, listener: (error: ProviderRpcError) -> Unit)
    fun on(event: String /* "message" */, listener: (message: ProviderMessage) -> Unit)
    fun on(event: String /* "chainChanged" */, listener: (chainId: ProviderChainId) -> Unit)
    fun on(event: String /* "accountsChanged" */, listener: (accounts: ProviderAccounts) -> Unit)
    fun request(args: RequestArguments<dynamic>): Promise<Any>
}

external interface IEthereumProvider : EIP1193Provider {
    fun enable(): Promise<ProviderAccounts>
}