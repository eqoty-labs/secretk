@file:JsModule("@walletconnect/core")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslib.walletconnect

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

@JsName("default")
external abstract class Connector(opts: IConnectorOpts) : IConnector {
    open var protocol: Any = definedExternally
    open var version: Any = definedExternally
    open var _bridge: Any
    open var _key: Any
    open var _clientId: Any
    open var _clientMeta: Any
    open var _peerId: Any
    open var _peerMeta: Any
    open var _handshakeId: Any
    open var _handshakeTopic: Any
    open var _connected: Any
    open var _accounts: Any
    open var _chainId: Any
    open var _networkId: Any
    open var _rpcUrl: Any
    open var _cryptoLib: Any
    open var _transport: Any
    open var _eventManager: Any
    open var _sessionStorage: Any
    open var _qrcodeModal: Any
    open var _qrcodeModalOptions: Any
    open var _signingMethods: Any
    override fun on(event: String, callback: (error: Error?, payload: Any?) -> Unit)
    open fun off(event: String)
    open fun createInstantRequest(instantRequest: Any): Promise<Unit>
    override fun connect(opts: ICreateSessionOptions): Promise<ISessionStatus>
    override fun createSession(opts: ICreateSessionOptions): Promise<Unit>
    override fun approveSession(sessionStatus: ISessionStatus)
    override fun rejectSession(sessionError: ISessionError)
    override fun updateSession(sessionStatus: ISessionStatus)
    override fun killSession(sessionError: ISessionError): Promise<Unit>
    override fun sendTransaction(tx: ITxData): Promise<Any>
    override fun signTransaction(tx: ITxData): Promise<Any>
    override fun signMessage(params: Array<Any>): Promise<Any>
    override fun signPersonalMessage(params: Array<Any>): Promise<Any>
    override fun signTypedData(params: Array<Any>): Promise<Any>
    override fun updateChain(chainParams: IUpdateChainParams): Promise<Any>
    override fun unsafeSend(
        request: IJsonRpcRequest,
        options: IRequestOptions
    ): Promise<dynamic /* IJsonRpcResponseSuccess | IJsonRpcResponseError */>

    open fun sendCustomRequest(request: Any, options: IRequestOptions = definedExternally): Promise<Any>
    override fun sendCustomRequest(request: IJsonRpcRequestPartial, options: IRequestOptions): Promise<Any>
    open fun approveRequest(response: Any)
    override fun approveRequest(response: IJsonRpcResponseSuccessPartial)
    open fun rejectRequest(response: Any)
    override fun rejectRequest(response: IJsonRpcResponseErrorPartial)
    open fun transportClose()
    open fun _sendRequest(request: Any, options: Any = definedExternally): Promise<Unit>
    open fun _sendResponse(response: IJsonRpcResponseSuccess): Promise<Unit>
    open fun _sendResponse(response: IJsonRpcResponseError): Promise<Unit>
    open fun _sendSessionRequest(
        request: IJsonRpcRequest,
        errorMsg: String,
        options: IInternalRequestOptions = definedExternally
    ): Promise<Unit>

    open fun _sendCallRequest(request: IJsonRpcRequest, options: IRequestOptions = definedExternally): Promise<Any>
    open fun _formatRequest(request: Any): IJsonRpcRequest

    //    open fun _formatResponse(response: Partial<Any /* IJsonRpcResponseSuccess | IJsonRpcResponseError */>): dynamic /* IJsonRpcResponseSuccess | IJsonRpcResponseError */
    open var _handleSessionDisconnect: Any
    open var _handleSessionResponse: Any
    open var _handleIncomingMessages: Any
    open var _subscribeToSessionRequest: Any
    open var _subscribeToResponse: Any
    open var _subscribeToSessionResponse: Any
    open var _subscribeToCallResponse: Any
    open var _subscribeToInternalEvents: Any
    open var _initTransport: Any
    open var _formatUri: Any
    open var _parseUri: Any
    open var _generateKey: Any
    open var _encrypt: Any
    open var _decrypt: Any
    open var _getStorageSession: Any
    open var _setStorageSession: Any
    open var _removeStorageSession: Any
    open var _manageStorageSession: Any
    open var _registerPushServer: Any
}