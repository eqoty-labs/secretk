@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package web3

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


external open class WebsocketProviderBase(host: String, options: WebsocketProviderOptions = definedExternally) {
    open fun isConnecting(): Boolean
    open var requestQueue: Map<String, RequestItem>
    open var responseQueue: Map<String, RequestItem>
    open var connected: Boolean
    open var connection: Any
    open fun supportsSubscriptions(): Boolean
    open fun send(payload: JsonRpcPayload, callback: (error: Error?, result: JsonRpcResponse) -> Unit)
    open fun on(type: String, callback: () -> Unit)
    open fun once(type: String, callback: () -> Unit)
    open fun removeListener(type: String, callback: () -> Unit)
    open fun removeAllListeners(type: String)
    open fun reset()
    open fun disconnect(code: Number, reason: String)
    open fun connect()
    open fun reconnect()
}

//external open class IpcProviderBase(path: String, net: Server) {
//    open var responseCallbacks: Any
//    open var notificationCallbacks: Any
//    open var connected: Boolean
//    open var connection: Any
//    open fun addDefaultEvents()
//    open fun supportsSubscriptions(): Boolean
//    open fun send(payload: JsonRpcPayload, callback: (error: Error?, result: JsonRpcResponse) -> Unit)
//    open fun on(type: String, callback: () -> Unit)
//    open fun once(type: String, callback: () -> Unit)
//    open fun removeListener(type: String, callback: () -> Unit)
//    open fun removeAllListeners(type: String)
//    open fun reset()
//    open fun reconnect()
//}

external open class HttpProviderBase(host: String, options: HttpProviderOptions = definedExternally) {
    open var host: String
    open var connected: Boolean
    open fun supportsSubscriptions(): Boolean
    open fun send(payload: JsonRpcPayload, callback: (error: Error?, result: JsonRpcResponse) -> Unit)
    open fun disconnect(): Boolean
}

external interface HttpProviderOptions {
    var keepAlive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var headers: Array<HttpHeader>?
        get() = definedExternally
        set(value) = definedExternally
    var withCredentials: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var agent: HttpAgent?
        get() = definedExternally
        set(value) = definedExternally
}

external interface HttpAgent {
    var http: Any?
        get() = definedExternally
        set(value) = definedExternally
    var https: Any?
        get() = definedExternally
        set(value) = definedExternally
    var baseUrl: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface HttpHeader {
    var name: String
    var value: String
}

external interface WebsocketProviderOptions {
    var host: String?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var reconnectDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var headers: Any?
        get() = definedExternally
        set(value) = definedExternally
    var protocol: String?
        get() = definedExternally
        set(value) = definedExternally
    var clientConfig: Any?
        get() = definedExternally
        set(value) = definedExternally
    var requestOptions: Any?
        get() = definedExternally
        set(value) = definedExternally
    var origin: String?
        get() = definedExternally
        set(value) = definedExternally
    var reconnect: ReconnectOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReconnectOptions {
    var auto: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var delay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var maxAttempts: Number?
        get() = definedExternally
        set(value) = definedExternally
    var onTimeout: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RequestItem {
    var payload: JsonRpcPayload
    var callback: (error: Any, result: Any) -> Unit
}

external interface JsonRpcPayload {
    var jsonrpc: String
    var method: String
    var params: Array<Any>
    var id: dynamic /* String? | Number? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface JsonRpcResponse {
    var jsonrpc: String
    var id: Number
    var result: Any?
        get() = definedExternally
        set(value) = definedExternally
    var error: String?
        get() = definedExternally
        set(value) = definedExternally
}

typealias TransactionRevertInstructionError = Error