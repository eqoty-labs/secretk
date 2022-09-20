@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsModule("miscreant")
@file:JsNonModule

package jslibs.miscreant


import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

open external class SIV(mac: IMACLike, ctr: ICTRLike) : ISIVLike {

    open var _mac: IMACLike
    open var _ctr: ICTRLike
    open var _tmp1: Any
    open var _tmp2: Any
    override fun seal(plaintext: Uint8Array, associatedData: Array<Uint8Array>): Promise<Uint8Array> = definedExternally
    override fun open(sealed: Uint8Array, associatedData: Array<Uint8Array>): Promise<Uint8Array> = definedExternally
    override fun clear(): SIV /* this */ = definedExternally
    open fun _s2v(associated_data: Array<Uint8Array>, plaintext: Uint8Array): Promise<Uint8Array> = definedExternally

    companion object {
        fun importKey(keyData: Uint8Array, alg: String, provider: ICryptoProvider = definedExternally): Promise<SIV> =
            definedExternally
    }
}
