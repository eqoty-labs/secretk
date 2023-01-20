//@file:JsModule("@walletconnect/web3-provider")
//@file:JsNonModule
//@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
//
//package jslib.walletconnect
//
//import kotlin.js.Promise
//
//external interface ProviderEngine: Any
//
//external interface `T$14` {
//    var open: (uri: String, cb: Any, qrcodeModalOptions: IQRCodeModalOptions?) -> Unit
//    var close: () -> Unit
//}
//
//external interface `T$15` {
//    var id: Any
//    var jsonrpc: Any
//    var result: Any
//}
//
//external interface `T$16` {
//    var disableSessionCreation: Boolean?
//        get() = definedExternally
//        set(value) = definedExternally
//}
//
//@JsName("default")
//open external class WalletConnectProvider(opts: IWalletConnectProviderOptions) : ProviderEngine {
//    open var bridge: String
//    open var qrcode: Boolean
//    open var qrcodeModal: `T$14`
//    open var qrcodeModalOptions: IQRCodeModalOptions?
//    open var rpc: IRPCMap?
//    open var infuraId: String
//    open var http: Any?
//    open var wc: IConnector
//    open var isConnecting: Boolean
//    open var connected: Boolean
//    open var connectCallbacks: Array<Any>
//    open var accounts: Array<String>
//    open var chainId: Number
//    open var rpcUrl: String
//    open var enable: () -> Promise<Array<String>>
//    open var request: (payload: Any) -> Promise<Any>
//    open var send: (payload: Any, callback: Any) -> Promise<Any>
//    open var onConnect: (callback: Any) -> Unit
//    open var triggerConnect: (result: Any) -> Unit
//    open fun disconnect(): Promise<Unit>
//    open fun close(): Promise<Unit>
//    open fun handleRequest(payload: Any): Promise<Any>
//    open fun handleOtherRequests(payload: Any): Promise<IJsonRpcResponseSuccess>
//    open fun handleReadRequests(payload: Any): Promise<IJsonRpcResponseSuccess>
//    open fun formatResponse(payload: Any, result: Any): `T$15`
//    open fun getWalletConnector(opts: `T$16` = definedExternally): Promise<IConnector>
//    open fun subscribeWalletConnector(): Promise<Unit>
//    open fun onDisconnect(): Promise<Unit>
//    open fun updateState(sessionParams: Any): Promise<Unit>
//    open fun updateRpcUrl(chainId: Number, rpcUrl: String? = definedExternally)
//    open fun updateHttpConnection()
//    open fun sendAsyncPromise(method: String, params: Any): Promise<Any>
//    open var initialize: Any
//    open var configWallet: Any
//}