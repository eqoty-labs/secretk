@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslibs.cosmjs.amino

external interface Pubkey {
    var type: String
    var value: dynamic
}

external interface Ed25519Pubkey : SinglePubkey {
    override var type: String /* "tendermint/PubKeyEd25519" */
    override var value: String
}

external fun isEd25519Pubkey(pubkey: Pubkey): Boolean

external interface Secp256k1Pubkey : SinglePubkey {
    override var type: String /* "tendermint/PubKeySecp256k1" */
    override var value: String
}

external fun isSecp256k1Pubkey(pubkey: Pubkey): Boolean

external interface SinglePubkey : Pubkey {
    override var type: String
    override var value: String
}

external fun isSinglePubkey(pubkey: Pubkey): Boolean

external interface MultisigThresholdPubkeyValue {
    var threshold: String
    var pubkeys: Array<SinglePubkey>
}

external interface MultisigThresholdPubkey : Pubkey {
    override var type: String /* "tendermint/PubKeyMultisigThreshold" */
    override var value: MultisigThresholdPubkeyValue
}

external fun isMultisigThresholdPubkey(pubkey: Pubkey): Boolean