@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslibs.cosmjs.amino

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

external interface AccountData {
    var address: String
    var algo: String /* "secp256k1" | "ed25519" | "sr25519" */
    var pubkey: Uint8Array
}

//external interface AminoSignResponse {
//    var signed: StdSignDoc
//    var signature: StdSignature
//}
//
//external interface OfflineAminoSigner {
//    var getAccounts: () -> Promise<Array<AccountData>>
//    var signAmino: (signerAddress: String, signDoc: StdSignDoc) -> Promise<AminoSignResponse>
//}