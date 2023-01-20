@file:JsModule("@walletconnect/universal-provider")
@file:JsNonModule

package jslib.walletconnectv2

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
import kotlin.js.*

open external class UniversalProvider(opts: UniversalProviderOpts) : IUniversalProvider {
    open var events: Any
    override var rpcProviders: RpcProviderMap
    override var session: Struct
    open var providerOpts: UniversalProviderOpts

    //    open var logger: Logger
    override var uri: String?
    override var request: (args: RequestArguments<dynamic>, chain: String) -> Promise<Any>
        get() = definedExternally
        set(value) = definedExternally
    override var sendAsync: (args: RequestArguments<dynamic>, callback: (error: Error?, response: Any) -> Unit, chain: String) -> Unit
        get() = definedExternally
        set(value) = definedExternally

    open fun <T> request(args: RequestArguments<dynamic>, chain: String? = definedExternally): Promise<T>
    open fun sendAsync(
        args: RequestArguments<dynamic>,
        callback: (error: Error?, response: Any) -> Unit,
        chain: String? = definedExternally
    )

    override fun enable(): Promise<ProviderAccounts>
    open fun disconnect(): Promise<Unit>
    override var connect: (opts: ConnectParams) -> Promise<Struct?>
    override var disconnect: () -> Unit
        get() = definedExternally
        set(value) = definedExternally

    open fun on(event: Any, listener: Any)
    override fun on(event: String /* "connect" */, listener: (info: ProviderInfo) -> Unit)
    override fun on(event: String /* "disconnect" */, listener: (error: ProviderRpcError) -> Unit)
    override fun on(event: String /* "message" */, listener: (message: ProviderMessage) -> Unit)
    override fun on(event: String /* "chainChanged" */, listener: (chainId: ProviderChainId) -> Unit)
    override fun on(event: String /* "accountsChanged" */, listener: (accounts: ProviderAccounts) -> Unit)
    override fun request(args: RequestArguments<dynamic>): Promise<Any> = definedExternally
    override fun on(event: String, listener: Any)
    override fun once(event: String, listener: Any)
    override fun removeListener(event: String, listener: Any)
    override fun off(event: String, listener: Any)
    override var pair: (pairingTopic: String?) -> Promise<Struct>
    open fun setDefaultChain(chain: String, rpcUrl: String? = definedExternally)
    override var cleanupPendingPairings: () -> Promise<Unit>
    open var checkStorage: Any
    open var initialize: Any
    open var createClient: Any
    open var createProviders: Any
    open var registerEventListeners: Any
    open fun getProvider(namespace: String): Any
    open var onSessionUpdate: Any
    open var setNamespaces: Any
    open var validateChain: Any
    fun requestAccounts(): Promise<Array<String>>

    companion object {
        fun init(opts: UniversalProviderOpts): Promise<UniversalProvider>
    }
}