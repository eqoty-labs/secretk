@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package events.global.NodeJS

external interface EventEmitter {
    fun addListener(eventName: String, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun addListener(eventName: Any, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun on(eventName: String, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun on(eventName: Any, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun once(eventName: String, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun once(eventName: Any, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun removeListener(eventName: String, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun removeListener(eventName: Any, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun off(eventName: String, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun off(eventName: Any, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun removeAllListeners(event: String = definedExternally): EventEmitter /* this */
    fun removeAllListeners(): EventEmitter /* this */
    fun removeAllListeners(event: Any = definedExternally): EventEmitter /* this */
    fun setMaxListeners(n: Number): EventEmitter /* this */
    fun getMaxListeners(): Number
    fun listeners(eventName: String): Array<Function<*>>
    fun listeners(eventName: Any): Array<Function<*>>
    fun rawListeners(eventName: String): Array<Function<*>>
    fun rawListeners(eventName: Any): Array<Function<*>>
    fun emit(eventName: String, vararg args: Any): Boolean
    fun emit(eventName: Any, vararg args: Any): Boolean
    fun listenerCount(eventName: String): Number
    fun listenerCount(eventName: Any): Number
    fun prependListener(eventName: String, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun prependListener(eventName: Any, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun prependOnceListener(eventName: String, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun prependOnceListener(eventName: Any, listener: (args: Any) -> Unit): EventEmitter /* this */
    fun eventNames(): Array<dynamic /* String | Any */>
}