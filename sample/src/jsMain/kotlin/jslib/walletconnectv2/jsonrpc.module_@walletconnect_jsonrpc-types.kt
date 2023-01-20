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

external interface RequestArguments<T> {
    var method: String
    var params: T?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RequestArguments__0 : RequestArguments<Any>

external interface JsonRpcRequest<T> {
    var id: Number
    var jsonrpc: String
}

external interface JsonRpcRequest__0 : JsonRpcRequest<Any>

external interface JsonRpcResult<T> {
    var id: Number
    var jsonrpc: String
    var result: T
}

external interface JsonRpcResult__0 : JsonRpcResult<Any>

external interface JsonRpcError {
    var id: Number
    var jsonrpc: String
    var error: ErrorResponse
}

external interface ErrorResponse {
    var code: Number
    var message: String
    var data: String?
        get() = definedExternally
        set(value) = definedExternally
}