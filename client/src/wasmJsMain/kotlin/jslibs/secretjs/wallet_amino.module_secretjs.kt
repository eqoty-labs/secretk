@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsModule("secretjs")

package jslibs.secretjs

import jslibs.cosmjs.amino.AminoSignResponse
import jslibs.cosmjs.amino.StdSignDoc
import org.khronos.webgl.Uint8Array
import kotlin.js.Promise


external interface WalletOptions {
    var hdAccountIndex: JsNumber?
    var coinType: JsNumber?
    var bech32Prefix: String?
}

open external class AminoWallet(mnemonic: String = definedExternally, options: WalletOptions = definedExternally) {
    open var mnemonic: String
    open var hdAccountIndex: JsNumber
    open var coinType: JsNumber
    open var privateKey: Uint8Array
    open var publicKey: Uint8Array
    open var address: String
    open var bech32Prefix: JsAny
    open fun getAccounts(): Promise<JsArray<AccountData>>
    open fun signAmino(signerAddress: String, signDoc: StdSignDoc): Promise<AminoSignResponse>
}

//
//external fun pubkeyToAddress(pubkey: Uint8Array, prefix: String = definedExternally): String
//
//external fun base64PubkeyToAddress(pubkey: String, prefix: String = definedExternally): String
//
//

external interface AccountData : JsAny {
    var address: String
    var algo: String /* "secp256k1" | "ed25519" | "sr25519" */
    var pubkey: Uint8Array
}
//
//external interface DirectSigner {
//    var getAccounts: () -> Promise<Array<AccountData>>
//    var signDirect: (signerAddress: String, signDoc: Any) -> Promise<DirectSignResponse>
//}
//
//external interface DirectSignResponse {
//    var signed: Any
//    var signature: StdSignature
//}
//
//external interface AminoSigner {
//    var getSignMode: (() -> Promise<Any>)?
//        get() = definedExternally
//        set(value) = definedExternally
//    var getAccounts: () -> Promise<Array<AccountData>>
//    var signAmino: (signerAddress: String, signDoc: StdSignDoc) -> Promise<AminoSignResponse>
//}
//
//external interface AminoEip191Signer {
//    var getAccounts: () -> Promise<Array<AccountData>>
//    var signAminoEip191: (signerAddress: String, signDoc: StdSignDoc) -> Promise<AminoSignResponse>
//}