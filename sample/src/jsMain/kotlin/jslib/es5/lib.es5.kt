package jslib.es5

import jslib.es2017.SharedArrayBuffer
import jslib.globals.CallSite
import org.khronos.webgl.*
import org.w3c.dom.url.URL
import kotlin.js.Date
import kotlin.js.Promise
import kotlin.js.RegExp

external interface Symbol {
    var description: String?
    override fun toString(): String
    fun valueOf(): Any
}

external interface PropertyDescriptor {
    var configurable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var enumerable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
    var writable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val get: (() -> Any)?
    val set: ((v: Any) -> Unit)?
}

external interface PropertyDescriptorMap {
    @nativeGetter
    operator fun get(s: String): PropertyDescriptor?

    @nativeSetter
    operator fun set(s: String, value: PropertyDescriptor)
}

external interface Object {
    var constructor: Function<*>
    override fun toString(): String
    fun toLocaleString(): String
    fun valueOf(): Any
    fun hasOwnProperty(v: String): Boolean
    fun hasOwnProperty(v: Number): Boolean
    fun hasOwnProperty(v: Any): Boolean
    fun isPrototypeOf(v: Any): Boolean
    fun propertyIsEnumerable(v: String): Boolean
    fun propertyIsEnumerable(v: Number): Boolean
    fun propertyIsEnumerable(v: Any): Boolean
}

external interface `T$4`<T> {
    @nativeGetter
    operator fun get(k: String): T?

    @nativeSetter
    operator fun set(k: String, value: T)
}

external interface ObjectConstructor {
    fun <T> fromEntries(entries: Iterable<Any /* JsTuple<Any, T> */>): `T$4`<T>
    fun fromEntries(entries: Iterable<Array<Any>>): Any
    fun <T> values(o: `T$4`<T>): Array<T>
    fun <T> values(o: ArrayLike<T>): Array<T>
    fun values(o: Any): Array<Any>
    fun <T> entries(o: `T$4`<T>): Array<dynamic /* JsTuple<String, T> */>
    fun <T> entries(o: ArrayLike<T>): Array<dynamic /* JsTuple<String, T> */>
    fun entries(o: Any): Array<dynamic /* JsTuple<String, Any> */>
    fun <T> getOwnPropertyDescriptors(o: T): Any /* Any & `T$5` */
    fun <T, U> assign(target: T, source: U): T /* T & U */
    fun <T, U, V> assign(target: T, source1: U, source2: V): T /* T & U & V */
    fun <T, U, V, W> assign(target: T, source1: U, source2: V, source3: W): T /* T & U & V & W */
    fun assign(target: Any?, vararg sources: Any): Any
    fun getOwnPropertySymbols(o: Any): Array<Any>
    fun keys(o: Any): Array<String>
    fun `is`(value1: Any, value2: Any): Boolean
    fun setPrototypeOf(o: Any, proto: Any?): Any

    @nativeInvoke
    operator fun invoke(): Any

    @nativeInvoke
    operator fun invoke(value: Any): Any
    var prototype: Any
    fun getPrototypeOf(o: Any): Any
    fun getOwnPropertyDescriptor(o: Any, p: String): PropertyDescriptor?
    fun getOwnPropertyDescriptor(o: Any, p: Number): PropertyDescriptor?
    fun getOwnPropertyDescriptor(o: Any, p: Any): PropertyDescriptor?
    fun getOwnPropertyNames(o: Any): Array<String>
    fun create(o: Any?): Any
    fun create(o: Any?, properties: PropertyDescriptorMap /* PropertyDescriptorMap & ThisType<Any> */): Any
    fun defineProperty(o: Any, p: String, attributes: PropertyDescriptor /* PropertyDescriptor & ThisType<Any> */): Any
    fun defineProperty(o: Any, p: Number, attributes: PropertyDescriptor /* PropertyDescriptor & ThisType<Any> */): Any
    fun defineProperty(o: Any, p: Any, attributes: PropertyDescriptor /* PropertyDescriptor & ThisType<Any> */): Any
    fun defineProperties(o: Any, properties: PropertyDescriptorMap /* PropertyDescriptorMap & ThisType<Any> */): Any
    fun <T> seal(o: T): T
    fun <T> freeze(a: Array<T>): Array<T>
    fun <T : Function<*>> freeze(f: T): dynamic
    fun <T> preventExtensions(o: T): T
    fun isSealed(o: Any): Boolean
    fun isFrozen(o: Any): Boolean
    fun isExtensible(o: Any): Boolean
    fun keys(o: Any?): Array<String>
}

external interface FunctionConstructor {
    @nativeInvoke
    operator fun invoke(vararg args: String): Function<*>
    var prototype: Function<*>
}

external interface IArguments {
    @nativeGetter
    operator fun get(index: Number): Any?

    @nativeSetter
    operator fun set(index: Number, value: Any)
    var length: Number
    var callee: Function<*>
}

external interface StringConstructor {
    fun fromCodePoint(vararg codePoints: Number): String
    fun raw(template: Array<String>, vararg substitutions: Any): String

    @nativeInvoke
    operator fun invoke(value: Any = definedExternally): String
    var prototype: String
    fun fromCharCode(vararg codes: Number): String
}

external interface BooleanConstructor {
    @nativeInvoke
    operator fun <T> invoke(value: T = definedExternally): Boolean
    var prototype: Boolean
}

external interface NumberConstructor {
    var EPSILON: Number
    fun isFinite(number: Any): Boolean
    fun isInteger(number: Any): Boolean
    fun isNaN(number: Any): Boolean
    fun isSafeInteger(number: Any): Boolean
    var MAX_SAFE_INTEGER: Number
    var MIN_SAFE_INTEGER: Number
    fun parseFloat(string: String): Number
    fun parseInt(string: String, radix: Number = definedExternally): Number

    @nativeInvoke
    operator fun invoke(value: Any = definedExternally): Number
    var prototype: Number
    var MAX_VALUE: Number
    var MIN_VALUE: Number
    var NaN: Number
    var NEGATIVE_INFINITY: Number
    var POSITIVE_INFINITY: Number
}

typealias TemplateStringsArray = Array<String>

external interface `L$0` {
    @nativeInvoke
    operator fun invoke(specified: String, parent: String = definedExternally): Promise<String>

    @nativeInvoke
    operator fun invoke(specified: String): Promise<String>

    @nativeInvoke
    operator fun invoke(specified: String, parent: URL = definedExternally): Promise<String>
}

external interface ImportMeta {
    var url: String
    val resolve: `L$0`?
        get() = definedExternally
}

external interface DateConstructor {
    @nativeInvoke
    operator fun invoke(): String
    var prototype: Date
    fun parse(s: String): Number
    fun UTC(
        year: Number,
        month: Number,
        date: Number = definedExternally,
        hours: Number = definedExternally,
        minutes: Number = definedExternally,
        seconds: Number = definedExternally,
        ms: Number = definedExternally
    ): Number

    fun now(): Number
}

external interface `T$6` {
    @nativeGetter
    operator fun get(key: String): String?

    @nativeSetter
    operator fun set(key: String, value: String)
}

typealias RegExpMatchArray = Array<String>

typealias RegExpExecArray = Array<String>

external interface RegExpConstructor {
    @nativeInvoke
    operator fun invoke(pattern: RegExp, flags: String = definedExternally): RegExp

    @nativeInvoke
    operator fun invoke(pattern: RegExp): RegExp

    @nativeInvoke
    operator fun invoke(pattern: String, flags: String = definedExternally): RegExp

    @nativeInvoke
    operator fun invoke(pattern: String): RegExp
    var prototype: RegExp
    var `$1`: String
    var `$2`: String
    var `$3`: String
    var `$4`: String
    var `$5`: String
    var `$6`: String
    var `$7`: String
    var `$8`: String
    var `$9`: String
    var lastMatch: String
}

external interface ErrorConstructor {
    fun captureStackTrace(targetObject: Any?, constructorOpt: Function<*> = definedExternally)
    var prepareStackTrace: ((err: Error, stackTraces: Array<CallSite>) -> Any)?
        get() = definedExternally
        set(value) = definedExternally
    var stackTraceLimit: Number

    @nativeInvoke
    operator fun invoke(message: String = definedExternally): Error
    var prototype: Error
}

typealias SyntaxError = Error

external interface SyntaxErrorConstructor : ErrorConstructor {
    @nativeInvoke
    override operator fun invoke(message: String): SyntaxError
    override var prototype: SyntaxError
}

external interface ConcatArray<T> {
    var length: Number

    @nativeGetter
    operator fun get(n: Number): T?

    @nativeSetter
    operator fun set(n: Number, value: T)
    fun join(separator: String = definedExternally): String
    fun slice(start: Number = definedExternally, end: Number = definedExternally): Array<T>
}

external interface ArrayConstructor {
    fun <T> from(iterable: Iterable<T>): Array<T>
    fun <T> from(iterable: ArrayLike<T>): Array<T>
    fun <T, U> from(iterable: Iterable<T>, mapfn: (v: T, k: Number) -> U, thisArg: Any = definedExternally): Array<U>
    fun <T, U> from(iterable: Iterable<T>, mapfn: (v: T, k: Number) -> U): Array<U>
    fun <T, U> from(iterable: ArrayLike<T>, mapfn: (v: T, k: Number) -> U, thisArg: Any = definedExternally): Array<U>
    fun <T, U> from(iterable: ArrayLike<T>, mapfn: (v: T, k: Number) -> U): Array<U>
    fun <T> of(vararg items: T): Array<T>

    @nativeInvoke
    operator fun invoke(arrayLength: Number = definedExternally): Array<Any>

    @nativeInvoke
    operator fun invoke(): Array<Any>

    @nativeInvoke
    operator fun <T> invoke(arrayLength: Number): Array<T>

    @nativeInvoke
    operator fun <T> invoke(vararg items: T): Array<T>
    fun isArray(arg: Any): Boolean
    var prototype: Array<Any>
}

external interface TypedPropertyDescriptor<T> {
    var enumerable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var configurable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var writable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var value: T?
        get() = definedExternally
        set(value) = definedExternally
    var get: (() -> T)?
        get() = definedExternally
        set(value) = definedExternally
    var set: ((value: T) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PromiseLike<T> {
    fun then(
        onfulfilled: ((value: T) -> Any?)? = definedExternally,
        onrejected: ((reason: Any) -> Any?)? = definedExternally
    ): PromiseLike<dynamic /* TResult1 | TResult2 */>
}

external interface ArrayLike<T> {
    var length: Number

    @nativeGetter
    operator fun get(n: Number): T?

    @nativeSetter
    operator fun set(n: Number, value: T)
}

typealias Partial<T> = Any

typealias Required<T> = Any

typealias Readonly<T> = Any

typealias Pick<T, K> = Any

typealias Record<K, T> = Any

typealias Exclude<T, U> = Any

typealias Omit<T, K> = Any

typealias InstanceType<T> = Any

external interface ThisType<T>

external interface ArrayBufferTypes {
    var SharedArrayBuffer: SharedArrayBuffer
    var ArrayBuffer: ArrayBuffer
}

external interface ArrayBufferConstructor {
    var prototype: ArrayBuffer
    fun isView(arg: Any): Boolean
}

external interface DataViewConstructor

external interface Int8ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Int8Array

    fun from(arrayLike: Iterable<Number>): Int8Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Int8Array
    var prototype: Int8Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Int8Array
    fun from(arrayLike: ArrayLike<Number>): Int8Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Int8Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Int8Array
}

external interface Uint8ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Uint8Array

    fun from(arrayLike: Iterable<Number>): Uint8Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Uint8Array
    var prototype: Uint8Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Uint8Array
    fun from(arrayLike: ArrayLike<Number>): Uint8Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Uint8Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Uint8Array
}

external interface Uint8ClampedArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Uint8ClampedArray

    fun from(arrayLike: Iterable<Number>): Uint8ClampedArray
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally
    ): Uint8ClampedArray

    var prototype: Uint8ClampedArray
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Uint8ClampedArray
    fun from(arrayLike: ArrayLike<Number>): Uint8ClampedArray
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Uint8ClampedArray

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Uint8ClampedArray
}

external interface Int16ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Int16Array

    fun from(arrayLike: Iterable<Number>): Int16Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Int16Array
    var prototype: Int16Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Int16Array
    fun from(arrayLike: ArrayLike<Number>): Int16Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Int16Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Int16Array
}

external interface Uint16ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Uint16Array

    fun from(arrayLike: Iterable<Number>): Uint16Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Uint16Array
    var prototype: Uint16Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Uint16Array
    fun from(arrayLike: ArrayLike<Number>): Uint16Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Uint16Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Uint16Array
}

external interface Int32ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Int32Array

    fun from(arrayLike: Iterable<Number>): Int32Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Int32Array
    var prototype: Int32Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Int32Array
    fun from(arrayLike: ArrayLike<Number>): Int32Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Int32Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Int32Array
}

external interface Uint32ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Uint32Array

    fun from(arrayLike: Iterable<Number>): Uint32Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Uint32Array
    var prototype: Uint32Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Uint32Array
    fun from(arrayLike: ArrayLike<Number>): Uint32Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Uint32Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Uint32Array
}

external interface Float32ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Float32Array

    fun from(arrayLike: Iterable<Number>): Float32Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Float32Array
    var prototype: Float32Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Float32Array
    fun from(arrayLike: ArrayLike<Number>): Float32Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Float32Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Float32Array
}

external interface Float64ArrayConstructor {
    fun from(
        arrayLike: Iterable<Number>,
        mapfn: (v: Number, k: Number) -> Number = definedExternally,
        thisArg: Any = definedExternally
    ): Float64Array

    fun from(arrayLike: Iterable<Number>): Float64Array
    fun from(arrayLike: Iterable<Number>, mapfn: (v: Number, k: Number) -> Number = definedExternally): Float64Array
    var prototype: Float64Array
    var BYTES_PER_ELEMENT: Number
    fun of(vararg items: Number): Float64Array
    fun from(arrayLike: ArrayLike<Number>): Float64Array
    fun <T> from(
        arrayLike: ArrayLike<T>,
        mapfn: (v: T, k: Number) -> Number,
        thisArg: Any = definedExternally
    ): Float64Array

    fun <T> from(arrayLike: ArrayLike<T>, mapfn: (v: T, k: Number) -> Number): Float64Array
}