@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package jslib.events

import kotlin.js.*

external interface EventEmitterOptions {
    var captureRejections: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface NodeEventTarget {
    fun once(eventName: String, listener: (args: Any) -> Unit): NodeEventTarget /* this */
    fun once(eventName: Any, listener: (args: Any) -> Unit): NodeEventTarget /* this */
}

external interface `T$8` {
    var once: Boolean
}

external interface DOMEventTarget {
    fun addEventListener(eventName: String, listener: (args: Any) -> Unit, opts: `T$8` = definedExternally): Any
}

external interface StaticEventEmitterOptions {
//    var signal: AbortSignal?
//        get() = definedExternally
//        set(value) = definedExternally
}

@JsModule("events")
external open class EventEmitter(options: EventEmitterOptions = definedExternally) : events.global.NodeJS.EventEmitter {
    override fun addListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun addListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun on(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun on(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun once(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun once(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun removeListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun removeListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun off(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun off(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun removeAllListeners(event: String): dynamic /* EventEmitter */
    override fun removeAllListeners(): dynamic /* EventEmitter */
    override fun removeAllListeners(event: Any): dynamic /* EventEmitter */
    override fun setMaxListeners(n: Number): EventEmitter /* this */
    override fun getMaxListeners(): Number
    override fun listeners(eventName: String): Array<Function<*>>
    override fun listeners(eventName: Any): Array<Function<*>>
    override fun rawListeners(eventName: String): Array<Function<*>>
    override fun rawListeners(eventName: Any): Array<Function<*>>
    override fun emit(eventName: String, vararg args: Any): Boolean
    override fun emit(eventName: Any, vararg args: Any): Boolean
    override fun listenerCount(eventName: String): Number
    override fun listenerCount(eventName: Any): Number
    override fun prependListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun prependListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun prependOnceListener(eventName: String, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun prependOnceListener(eventName: Any, listener: (args: Any) -> Unit): dynamic /* EventEmitter */
    override fun eventNames(): Array<dynamic /* String | Any */>
//    interface Abortable {
//        var signal: AbortSignal?
//            get() = definedExternally
//            set(value) = definedExternally
//    }

    companion object {
        fun once(emitter: NodeEventTarget, eventName: String, options: StaticEventEmitterOptions = definedExternally): Promise<Array<Any>>
        fun once(emitter: NodeEventTarget, eventName: Any, options: StaticEventEmitterOptions = definedExternally): Promise<Array<Any>>
        fun once(emitter: DOMEventTarget, eventName: String, options: StaticEventEmitterOptions = definedExternally): Promise<Array<Any>>
//        fun on(emitter: events.global.NodeJS.EventEmitter, eventName: String, options: StaticEventEmitterOptions = definedExternally): AsyncIterableIterator<Any>
        fun listenerCount(emitter: events.global.NodeJS.EventEmitter, eventName: String): Number
        fun listenerCount(emitter: events.global.NodeJS.EventEmitter, eventName: Any): Number
        fun getEventListeners(emitter: DOMEventTarget, name: String): Array<Function<*>>
        fun getEventListeners(emitter: DOMEventTarget, name: Any): Array<Function<*>>
        fun getEventListeners(emitter: events.global.NodeJS.EventEmitter, name: String): Array<Function<*>>
        fun getEventListeners(emitter: events.global.NodeJS.EventEmitter, name: Any): Array<Function<*>>
        fun setMaxListeners(n: Number = definedExternally, vararg eventTargets: Any /* DOMEventTarget | NodeJS.EventEmitter */)
        var errorMonitor: Any
        var captureRejectionSymbol: Any
        var captureRejections: Boolean
        var defaultMaxListeners: Number
    }
}