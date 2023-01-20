@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslib.walletconnectv2

import jslib.events.EventEmitter

external open class IEvents {
    open var events: EventEmitter
    open fun on(event: String, listener: Any)
    open fun once(event: String, listener: Any)
    open fun off(event: String, listener: Any)
    open fun removeListener(event: String, listener: Any)
}