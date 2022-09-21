@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslib.metamask

import kotlin.js.Promise

external interface EthereumProvider {
    var isMetaMask: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$0` {
    var mustBeMetaMask: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var silent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

@JsModule("@metamask/detect-provider")
@JsNonModule
external fun detectEthereumProvider(__0: `T$0` = definedExternally): Promise<Any?>