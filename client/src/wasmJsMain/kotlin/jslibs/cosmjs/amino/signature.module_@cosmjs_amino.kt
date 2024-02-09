@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslibs.cosmjs.amino

import org.khronos.webgl.Uint8Array

external interface StdSignature {
    var pub_key: Pubkey<*>
    var signature: String
}

external fun encodeSecp256k1Signature(pubkey: Uint8Array, signature: Uint8Array): StdSignature

external interface `T$1` {
    var pubkey: Uint8Array
    var signature: Uint8Array
}

external fun decodeSignature(signature: StdSignature): `T$1`