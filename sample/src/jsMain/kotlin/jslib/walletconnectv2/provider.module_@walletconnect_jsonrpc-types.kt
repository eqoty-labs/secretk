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

external open class IJsonRpcConnection(opts: Any = definedExternally) : IEvents {
    open var connected: Boolean
    open var connecting: Boolean
    open fun open(opts: Any = definedExternally): Promise<Unit>
    open fun close(): Promise<Unit>
    open fun send(payload: JsonRpcRequest<Any>, context: Any = definedExternally): Promise<Unit>
    open fun send(payload: JsonRpcRequest<Any>): Promise<Unit>
    open fun send(payload: JsonRpcResult<Any>, context: Any = definedExternally): Promise<Unit>
    open fun send(payload: JsonRpcResult<Any>): Promise<Unit>
    open fun send(payload: JsonRpcError, context: Any = definedExternally): Promise<Unit>
    open fun send(payload: JsonRpcError): Promise<Unit>
}

external open class IBaseJsonRpcProvider : IEvents {
    open fun connect(params: Any = definedExternally): Promise<Unit>
    open fun disconnect(): Promise<Unit>
    open fun <Result, Params> request(request: RequestArguments<Params>, context: Any = definedExternally): Promise<Result>
    open fun <Result, Params> requestStrict(request: JsonRpcRequest<Params>, context: Any = definedExternally): Promise<Result>
}

external open class IJsonRpcProvider : IBaseJsonRpcProvider {
    constructor(connection: String)
    constructor(connection: IJsonRpcConnection)
    open var connection: IJsonRpcConnection
    open fun connect(connection: String = definedExternally): Promise<Unit>
    override fun connect(params: Any): Promise<Unit>
    open fun connect(): Promise<Unit>
    open fun connect(connection: IJsonRpcConnection = definedExternally): Promise<Unit>
    open fun setConnection(connection: String = definedExternally): IJsonRpcConnection
    open fun setConnection(): IJsonRpcConnection
    open fun setConnection(connection: IJsonRpcConnection = definedExternally): IJsonRpcConnection
    open fun onPayload(payload: JsonRpcRequest<Any>)
    open fun onPayload(payload: JsonRpcResult<Any>)
    open fun onPayload(payload: JsonRpcError)
    open fun open(connection: String = definedExternally): Promise<Unit>
    open fun open(): Promise<Unit>
    open fun open(connection: IJsonRpcConnection = definedExternally): Promise<Unit>
    open fun close(): Promise<Unit>
}