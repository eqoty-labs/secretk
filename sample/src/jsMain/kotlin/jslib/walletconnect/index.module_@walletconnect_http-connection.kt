@file:JsModule("@walletconnect/http-connection")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package jslib.walletconnect

external interface `T$18` {
    var message: String
    var code: Number
}

external interface `T$19` {
    var error: `T$18`
    var id: Any
    var jsonrpc: Any
}

//@JsName("default")
//external open class HTTPConnection(url: String) : EventEmitter {
//    open var url: String
//    open fun formatError(payload: Any, message: String, code: Number = definedExternally): `T$19`
//    open fun send(payload: Any, internal: Any = definedExternally): Promise<Any>
//}