@file:JsModule("@walletconnect/jsonrpc-provider")
@file:JsNonModule

package jslib.walletconnectv2

import jslib.events.EventEmitter
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
external open class JsonRpcProvider(connection: IJsonRpcConnection) : IJsonRpcProvider {
    override var events: EventEmitter
    override var connection: IJsonRpcConnection
    open var hasRegisteredEventListeners: Any
    override fun connect(connection: String): Promise<Unit>
    override fun connect(): Promise<Unit>
    override fun connect(connection: IJsonRpcConnection): Promise<Unit>
    override fun disconnect(): Promise<Unit>
    override fun on(event: String, listener: Any)
    override fun once(event: String, listener: Any)
    override fun off(event: String, listener: Any)
    override fun removeListener(event: String, listener: Any)
    override fun <Result, Params> request(request: RequestArguments<Params>, context: Any): Promise<Result>
    override fun <Result, Params> requestStrict(request: JsonRpcRequest<Params>, context: Any): Promise<Result>
    override fun setConnection(connection: IJsonRpcConnection): IJsonRpcConnection
    override fun onPayload(payload: JsonRpcRequest<Any>)
    override fun onPayload(payload: JsonRpcResult<Any>)
    override fun onPayload(payload: JsonRpcError)
    override fun open(connection: String): Promise<Unit>
    override fun open(): Promise<Unit>
    override fun open(connection: IJsonRpcConnection): Promise<Unit>
    override fun close(): Promise<Unit>
    open var registerEventListeners: Any
}