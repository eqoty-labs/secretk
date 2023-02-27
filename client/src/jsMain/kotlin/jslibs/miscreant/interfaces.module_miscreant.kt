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

external interface IBlockCipher {
    fun clear(): IBlockCipher /* this */
    fun encryptBlock(block: Block): Promise<IBlockCipher /* this */>
}

external interface ICryptoProvider {
    fun importBlockCipherKey(keyData: Uint8Array): Promise<IBlockCipher>
    fun importCTRKey(keyData: Uint8Array): Promise<ICTRLike>
}

external interface ICTRLike {
    fun encryptCtr(iv: Uint8Array, plaintext: Uint8Array): Promise<Uint8Array>
    fun clear(): ICTRLike /* this */
}

external interface IMACLike {
    fun reset(): IMACLike /* this */
    fun clear()
    fun update(data: Uint8Array): Promise<IMACLike /* this */>
    fun finish(): Promise<Uint8Array>
}

external interface ISIVLike {
    fun seal(plaintext: Uint8Array, associatedData: Array<Uint8Array>): Promise<Uint8Array>
    fun open(ciphertext: Uint8Array, associatedData: Array<Uint8Array>): Promise<Uint8Array>
    fun clear(): ISIVLike /* this */
}
