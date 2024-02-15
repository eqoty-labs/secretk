@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS"
) @file:JsModule("secretjs")

package jslibs.secretjs

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

external interface EncryptionUtils {
    fun getPubkey(): Promise<Uint8Array>
    fun decrypt(ciphertext: Uint8Array, nonce: Uint8Array): Promise<Uint8Array>
    fun encrypt(contractCodeHash: String, msg: JsAny?): Promise<Uint8Array>
    fun getTxEncryptionKey(nonce: Uint8Array): Promise<Uint8Array>
}

//external interface `T$2` {
//    var privkey: Uint8Array
//    var pubkey: Uint8Array
//}
//
//open external class EncryptionUtilsImpl(
//    registrationQuerier: Any,
//    seed: Uint8Array = definedExternally,
//    chainId: String = definedExternally
//) : EncryptionUtils {
//    open var registrationQuerier: Any
//    open var seed: Any
//    open var privkey: Any
//    open var pubkey: Uint8Array
//    open var consensusIoPubKey: Any
//    open var getConsensusIoPubKey: Any
//    override var getTxEncryptionKey: (nonce: Uint8Array) -> Promise<Uint8Array>
//    override var encrypt: (contractCodeHash: String, msg: Any?) -> Promise<Uint8Array>
//    override var decrypt: (ciphertext: Uint8Array, nonce: Uint8Array) -> Promise<Uint8Array>
//    override var getPubkey: () -> Promise<Uint8Array>
//
//    companion object {
//        fun GenerateNewKeyPair(): `T$2`
//        fun GenerateNewSeed(): Uint8Array
//        fun GenerateNewKeyPairFromSeed(seed: Uint8Array): `T$2`
//    }
//}