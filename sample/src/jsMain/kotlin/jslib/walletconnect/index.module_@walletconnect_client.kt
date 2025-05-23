@file:JsModule("@walletconnect/client")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslib.walletconnect

@JsName("default")
external class WalletConnect(
    connectorOpts: IWalletConnectOptions,
    pushServerOpts: IPushServerOptions = definedExternally
) : Connector {
    override var bridge: String = definedExternally
    override var key: String = definedExternally
    override var clientId: String = definedExternally
    override var peerId: String = definedExternally
    override var clientMeta: IClientMeta? = definedExternally
    override var peerMeta: IClientMeta? = definedExternally
    override var handshakeTopic: String = definedExternally
    override var handshakeId: Number = definedExternally
    override var uri: String = definedExternally
    override var chainId: Number = definedExternally
    override var networkId: Number = definedExternally
    override var accounts: Array<String> = definedExternally
    override var rpcUrl: String = definedExternally
    override var connected: Boolean = definedExternally
    override var pending: Boolean = definedExternally
    override var session: IWalletConnectSession = definedExternally
}