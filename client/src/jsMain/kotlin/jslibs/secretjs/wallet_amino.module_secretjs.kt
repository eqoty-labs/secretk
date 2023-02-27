@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsModule("secretjs")
@file:JsNonModule

package jslibs.secretjs

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

external interface WalletOptions {
    var hdAccountIndex: Number?
        get() = definedExternally
        set(value) = definedExternally
    var coinType: Number?
        get() = definedExternally
        set(value) = definedExternally
    var bech32Prefix: String?
        get() = definedExternally
        set(value) = definedExternally
}

open external class AminoWallet(mnemonic: String = definedExternally, options: WalletOptions = definedExternally) {
    open var mnemonic: String
    open var hdAccountIndex: Number
    open var coinType: Number
    open var privateKey: Uint8Array
    open var publicKey: Uint8Array
    open var address: String
    open var bech32Prefix: Any
    open fun getAccounts(): Promise<Array<AccountData>>
    open fun signAmino(signerAddress: String, signDoc: StdSignDoc): Promise<AminoSignResponse>
}

external fun pubkeyToAddress(pubkey: Uint8Array, prefix: String = definedExternally): String

external fun base64PubkeyToAddress(pubkey: String, prefix: String = definedExternally): String


external interface AminoSignResponse {
    var signed: StdSignDoc
    var signature: StdSignature
}

external interface StdSignDoc {
    var chain_id: String
    var account_number: String
    var sequence: String
    var fee: StdFee
    var msgs: Array<AminoMsg>
    var memo: String
}

external interface StdFee {
    var amount: Array<Coin>
    var gas: String
    var granter: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface StdSignature {
    var pub_key: Pubkey
    var signature: String
}

external interface Pubkey {
    var type: String
    var value: Any
}

external interface AccountData {
    var address: String
    var algo: String /* "secp256k1" | "ed25519" | "sr25519" */
    var pubkey: Uint8Array
}

external interface DirectSigner {
    var getAccounts: () -> Promise<Array<AccountData>>
    var signDirect: (signerAddress: String, signDoc: Any) -> Promise<DirectSignResponse>
}

external interface DirectSignResponse {
    var signed: Any
    var signature: StdSignature
}

external interface AminoSigner {
    var getSignMode: (() -> Promise<Any>)?
        get() = definedExternally
        set(value) = definedExternally
    var getAccounts: () -> Promise<Array<AccountData>>
    var signAmino: (signerAddress: String, signDoc: StdSignDoc) -> Promise<AminoSignResponse>
}

external interface AminoEip191Signer {
    var getAccounts: () -> Promise<Array<AccountData>>
    var signAminoEip191: (signerAddress: String, signDoc: StdSignDoc) -> Promise<AminoSignResponse>
}