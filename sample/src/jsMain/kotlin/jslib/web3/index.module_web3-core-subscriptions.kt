@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package web3

import kotlin.js.Promise

open external class Subscription<T>(options: SubscriptionOptions) {
    open var id: String
    open var options: SubscriptionOptions
    open var callback: () -> Unit
    open var arguments: Any
    open var lastBlock: Number
    open fun subscribe(callback: (error: Error?, result: T) -> Unit = definedExternally): Subscription<T>
    open fun unsubscribe(callback: (error: Error?, result: Boolean) -> Unit = definedExternally): Promise<Boolean?>
    open fun on(type: String /* "data" | "changed" */, handler: (data: T) -> Unit): Subscription<T>
    open fun on(type: String /* "connected" */, handler: (subscriptionId: String) -> Unit): Subscription<T>
    open fun on(type: String /* "error" */, handler: (data: Error) -> Unit): Subscription<T>
}

external interface SubscriptionOptions {
    var subscription: String
    var type: String
    var requestManager: Any
}