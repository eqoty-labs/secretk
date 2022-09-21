@file:JsModule("@walletconnect/http-connection")
@file:JsNonModule
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