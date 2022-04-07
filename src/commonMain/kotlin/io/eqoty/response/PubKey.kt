package io.eqoty.response

@kotlinx.serialization.Serializable
class PubKey (
    // type is one of the strings defined in pubkeyTypes
    // I don't use a string literal union here as that makes trouble with json test data:
    // https://github.com/confio/cosmwasm-js/pull/44#pullrequestreview-353280504
    override val type: String,
    // Value field is base64-encoded in all cases
    // Note: if type is Secp256k1, this must contain a COMPRESSED pubkey - to encode from bcp/keycontrol land, you must compress it first
    override val value: String
) : TypeValue<String>()
