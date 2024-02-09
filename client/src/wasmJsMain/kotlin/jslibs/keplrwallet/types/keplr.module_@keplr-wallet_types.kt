//@file:JsModule("@keplr-wallet/types")
//
package jslibs.keplrwallet.types

import jslibs.cosmjs.amino.AminoSignResponse
import jslibs.cosmjs.amino.StdSignDoc
import jslibs.secretjs.AminoWallet
import kotlin.js.Promise

//
//import jslibs.cosmjs.amino.AminoSignResponse
//import jslibs.cosmjs.amino.StdSignDoc
//import jslibs.cosmjs.amino.StdSignature
//import org.khronos.webgl.Uint8Array
//import kotlin.js.Promise


external interface KeplrSignOptions {
    val preferNoSetFee: Boolean?
    val preferNoSetMemo: Boolean?
    val disableBalanceCheck: Boolean?
}

external interface Keplr {
    fun getOfflineSignerOnlyAmino(chainId: String): AminoWallet

    fun signAmino(
        chainId: String,
        signer: String,
        signDoc: StdSignDoc,
        signOptions: KeplrSignOptions?
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
}