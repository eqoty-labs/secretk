@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package jslib.walletconnect

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

external interface IConnector {
    var bridge: String
    var key: String
    var clientId: String
    var peerId: String
    var clientMeta: IClientMeta?
    var peerMeta: IClientMeta?
    var handshakeTopic: String
    var handshakeId: Number
    var uri: String
    var chainId: Number
    var networkId: Number
    var accounts: Array<String>
    var rpcUrl: String
    var connected: Boolean
    var pending: Boolean
    var session: IWalletConnectSession
    fun on(event: String, callback: (error: Error?, payload: Any?) -> Unit)
    fun connect(opts: ICreateSessionOptions = definedExternally): Promise<ISessionStatus>
    fun createSession(opts: ICreateSessionOptions = definedExternally): Promise<Unit>
    fun approveSession(sessionStatus: ISessionStatus)
    fun rejectSession(sessionError: ISessionError = definedExternally)
    fun updateSession(sessionStatus: ISessionStatus)
    fun killSession(sessionError: ISessionError = definedExternally): Promise<Unit>
    fun sendTransaction(tx: ITxData): Promise<Any>
    fun signTransaction(tx: ITxData): Promise<Any>
    fun signMessage(params: Array<Any>): Promise<Any>
    fun signPersonalMessage(params: Array<Any>): Promise<Any>
    fun signTypedData(params: Array<Any>): Promise<Any>
    fun updateChain(chainParams: IUpdateChainParams): Promise<Any>
    fun sendCustomRequest(request: IJsonRpcRequestPartial, options: IRequestOptions = definedExternally): Promise<Any>
    fun unsafeSend(request: IJsonRpcRequest, options: IRequestOptions = definedExternally): Promise<dynamic /* IJsonRpcResponseSuccess | IJsonRpcResponseError */>
    fun approveRequest(response: IJsonRpcResponseSuccessPartial)
    fun rejectRequest(response: IJsonRpcResponseErrorPartial)
}

external interface ISessionStatus {
    var chainId: Number
    var accounts: Array<String>
    var networkId: Number?
        get() = definedExternally
        set(value) = definedExternally
    var rpcUrl: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ISessionError {
    var message: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ICallTxData {
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
    var to: String?
        get() = definedExternally
        set(value) = definedExternally
    var value: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var gas: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var gasLimit: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var gasPrice: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var nonce: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var data: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ITxData : ICallTxData {
    var from: String
}

external interface IJsonRpcResponseSuccess {
    var id: Number
    var jsonrpc: String
    var result: Any
}

external interface IJsonRpcResponseSuccessPartial {
    var id: Number?
        get() = definedExternally
        set(value) = definedExternally
    var jsonrpc: String?
        get() = definedExternally
        set(value) = definedExternally
    var result: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IJsonRpcErrorMessage {
    var code: Number?
        get() = definedExternally
        set(value) = definedExternally
    var message: String
    var data: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IJsonRpcResponseError {
    var id: Number
    var jsonrpc: String
    var error: IJsonRpcErrorMessage
}

external interface IJsonRpcResponseErrorPartial {
    var id: Number?
        get() = definedExternally
        set(value) = definedExternally
    var jsonrpc: String?
        get() = definedExternally
        set(value) = definedExternally
    var error: IJsonRpcErrorMessage?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IJsonRpcRequest {
    var id: Number
    var jsonrpc: String
    var method: String
    var params: Array<Any>
}

external interface IJsonRpcRequestPartial {
    var id: Number?
        get() = definedExternally
        set(value) = definedExternally
    var jsonrpc: String?
        get() = definedExternally
        set(value) = definedExternally
    var method: String?
        get() = definedExternally
        set(value) = definedExternally
    var params: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IClientMeta {
    var description: String
    var url: String
    var icons: Array<String>
    var name: String
}

external interface IWalletConnectSession {
    var connected: Boolean
    var accounts: Array<String>
    var chainId: Number
    var bridge: String
    var key: String
    var clientId: String
    var clientMeta: IClientMeta?
    var peerId: String
    var peerMeta: IClientMeta?
    var handshakeId: Number
    var handshakeTopic: String
}

external interface `T$17` {
    var name: String
    var symbol: String
}

external interface IUpdateChainParams {
    var chainId: Number
    var networkId: Number
    var rpcUrl: String
    var nativeCurrency: `T$17`
}

external interface IRPCMap {
    @nativeGetter
    operator fun get(chainId: Number): String?
    @nativeSetter
    operator fun set(chainId: Number, value: String)
}

external interface IWCRpcConnectionOptions {
    var connector: IConnector?
        get() = definedExternally
        set(value) = definedExternally
    var bridge: String?
        get() = definedExternally
        set(value) = definedExternally
    var qrcode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var chainId: Number?
        get() = definedExternally
        set(value) = definedExternally
    var storageId: String?
        get() = definedExternally
        set(value) = definedExternally
    var signingMethods: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var qrcodeModalOptions: IQRCodeModalOptions?
        get() = definedExternally
        set(value) = definedExternally
    var clientMeta: IClientMeta?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IWCEthRpcConnectionOptions : IWCRpcConnectionOptions {
    var rpc: IRPCMap?
        get() = definedExternally
        set(value) = definedExternally
    var infuraId: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IWalletConnectProviderOptions : IWCEthRpcConnectionOptions {
    var pollingInterval: Number?
        get() = definedExternally
        set(value) = definedExternally
    var qrcodeModal: IQRCodeModal?
        get() = definedExternally
        set(value) = definedExternally
}

class IWalletConnectProviderOptionsInstance(override var infuraId: String?): IWalletConnectProviderOptions

external interface IRequestOptions {
    var forcePushNotification: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ICreateSessionOptions {
    var chainId: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IQRCodeModal {
    fun open(uri: String, cb: Any, opts: Any = definedExternally)
    fun close()
}

external interface IQRCodeModalOptions {
    var registryUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    var mobileLinks: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var desktopLinks: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}