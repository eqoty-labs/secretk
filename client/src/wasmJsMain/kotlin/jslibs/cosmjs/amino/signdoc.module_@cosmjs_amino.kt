@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslibs.cosmjs.amino

import org.khronos.webgl.Uint8Array

external interface AminoMsg : JsAny {
    var type: String
    var value: JsAny
}

external interface StdFee {
    var amount: JsArray<Coin>
    var gas: String
    var granter: String?
        get() = definedExternally
        set(value) = definedExternally
    var payer: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface StdSignDoc {
    var chain_id: String
    var account_number: String
    var sequence: String
    var fee: StdFee
    var msgs: JsArray<AminoMsg>
    var memo: String
}

external fun makeSignDoc(
    msgs: JsArray<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: JsNumber,
    sequence: JsNumber
): StdSignDoc

external fun makeSignDoc(
    msgs: JsArray<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: JsNumber,
    sequence: String
): StdSignDoc

external fun makeSignDoc(
    msgs: JsArray<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: String,
    sequence: JsNumber
): StdSignDoc

external fun makeSignDoc(
    msgs: JsArray<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: String,
    sequence: String
): StdSignDoc

external fun serializeSignDoc(signDoc: StdSignDoc): Uint8Array