package jslib.walletconnectv2

external interface UniversalProviderOpts {
    var projectId: String?
        get() = definedExternally
        set(value) = definedExternally
    var metadata: Metadata?
        get() = definedExternally
        set(value) = definedExternally
    var logger: String?
        get() = definedExternally
        set(value) = definedExternally
    var client: Any?
        get() = definedExternally
        set(value) = definedExternally
    var relayUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    var storageOptions: KeyValueStorageOptions?
        get() = definedExternally
        set(value) = definedExternally
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RpcProvidersMap {
    @nativeGetter
    operator fun get(provider: String): JsonRpcProvider?

    @nativeSetter
    operator fun set(provider: String, value: JsonRpcProvider)
}

external interface EthereumRpcMap {
    @nativeGetter
    operator fun get(chainId: String): String?

    @nativeSetter
    operator fun set(chainId: String, value: String)
}

external interface NamespacesMap {
    @nativeGetter
    operator fun get(chainId: String): Namespace?

    @nativeSetter
    operator fun set(chainId: String, value: Namespace)
}

external interface RpcProviderMap {
    @nativeGetter
    operator fun get(chainId: String): IProvider?

    @nativeSetter
    operator fun set(chainId: String, value: IProvider)
}

external interface Namespace : BaseRequiredNamespace {
    override var chains: Array<String>
    var rpcMap: EthereumRpcMap?
        get() = definedExternally
        set(value) = definedExternally
}

external interface NamespaceConfig {}

@Suppress("NOTHING_TO_INLINE")
inline operator fun NamespaceConfig.get(namespace: String): Namespace? = asDynamic()[namespace]

@Suppress("NOTHING_TO_INLINE")
inline operator fun NamespaceConfig.set(namespace: String, value: Namespace) {
    asDynamic()[namespace] = value
}

external interface SessionNamespace : Namespace {
    var accounts: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ConnectParams {
    var namespaces: NamespaceConfig
    var pairingTopic: String?
        get() = definedExternally
        set(value) = definedExternally
    var skipPairing: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubProviderOpts {
    var client: Any
    var namespace: Namespace
    var events: Any
}

external interface RequestParams {
    var topic: String
    var request: RequestArguments<Any>
    var chainId: String
}