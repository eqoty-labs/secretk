@file:JsModule("miscreant")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslibs.miscreant

import org.khronos.webgl.Uint8Array

@JsName("default")
open external class Block {
    open var data: Uint8Array

    open fun clear()
    open fun clone(): Block = definedExternally

    companion object {
        var SIZE: Number = definedExternally
        var R: Number = definedExternally
    }
}