//@file:JsModule("@keplr-wallet/types")
//
package jslibs.keplrwallet.types

import jslibs.cosmjs.amino.AminoSignResponse
import jslibs.cosmjs.amino.StdSignDoc
import jslibs.secretjs.AminoWallet
import jslibs.secretjs.EncryptionUtils
import kotlin.js.Promise

external interface KeplrSignOptions {
    val preferNoSetFee: Boolean?
    val preferNoSetMemo: Boolean?
    val disableBalanceCheck: Boolean?
}

external interface Keplr {
    fun getOfflineSignerOnlyAmino(chainId: String): AminoWallet

    fun signAmino(
        chainId: String, signer: String, signDoc: StdSignDoc, signOptions: KeplrSignOptions?
    ): Promise<AminoSignResponse>
//
//    fun signArbitrary(
//        chainId: String,
//        signer: String,
//        signDoc: String,
//    ): Promise<StdSignature>
//
//    fun signArbitrary(
//        chainId: String,
//        signer: String,
//        signDoc: Uint8Array,
//    ): Promise<StdSignature>

    fun getEnigmaUtils(chainId: String): EncryptionUtils
    fun experimentalSuggestChain(suggestion: JsAny): Promise<JsAny>
    fun enable(id: String): Promise<JsAny>
}