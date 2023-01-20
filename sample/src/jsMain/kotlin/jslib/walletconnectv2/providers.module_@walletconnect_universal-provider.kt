@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslib.walletconnectv2

import kotlin.js.Promise

external interface IProvider {
    var namespace: SessionNamespace
    var httpProviders: RpcProvidersMap
    var client: Any
    var request: (args: RequestParams) -> Promise<Any>
    var updateNamespace: (args: Namespace) -> Unit
    var setDefaultChain: (chainId: String, rpcUrl: String?) -> Unit
    var requestAccounts: () -> Array<String>
}

external interface IUniversalProvider : IEthereumProvider {
    var client: Any?
        get() = definedExternally
        set(value) = definedExternally
    var namespaces: NamespaceConfig?
        get() = definedExternally
        set(value) = definedExternally
    var rpcProviders: RpcProviderMap
    var session: Struct
    var uri: String?
    var request: (args: RequestArguments<dynamic>, chain: String) -> Promise<Any>
    var sendAsync: (args: RequestArguments<dynamic>, callback: (error: Error?, response: Any) -> Unit, chain: String) -> Unit
    var pair: (pairingTopic: String?) -> Promise<Struct>
    var connect: (opts: ConnectParams) -> Promise<Struct?>
    var disconnect: () -> Unit
    var cleanupPendingPairings: () -> Promise<Unit>
}