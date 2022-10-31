@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslibs.cosmjs.amino

import org.khronos.webgl.Uint8Array

external interface AminoMsg {
    var type: String
    var value: Any
}

external interface StdFee {
    var amount: Array<Coin>
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
    var msgs: Array<AminoMsg>
    var memo: String
}

external fun makeSignDoc(
    msgs: Array<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: Number,
    sequence: Number
): StdSignDoc

external fun makeSignDoc(
    msgs: Array<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: Number,
    sequence: String
): StdSignDoc

external fun makeSignDoc(
    msgs: Array<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: String,
    sequence: Number
): StdSignDoc

external fun makeSignDoc(
    msgs: Array<AminoMsg>,
    fee: StdFee,
    chainId: String,
    memo: String?,
    accountNumber: String,
    sequence: String
): StdSignDoc

external fun serializeSignDoc(signDoc: StdSignDoc): Uint8Array