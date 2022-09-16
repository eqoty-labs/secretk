package io.eqoty.response

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
sealed class PubKey : TypeValue<String>()

@kotlinx.serialization.Serializable
@SerialName("tendermint/PubKeySecp256k1")
class PubKeySecp256k1(
    // Value field is base64-encoded in all cases
    // Note: if type is Secp256k1, this must contain a COMPRESSED pubkey - to encode from bcp/keycontrol land, you must compress it first
    override val value: String
) : PubKey()

@kotlinx.serialization.Serializable
@SerialName("tendermint/PubKeyMultisigThreshold")
class PubKeyMultisigThreshold(
    // Value field is base64-encoded in all cases
    // Note: if type is Secp256k1, this must contain a COMPRESSED pubkey - to encode from bcp/keycontrol land, you must compress it first
    override val value: String
) : PubKey()


@kotlinx.serialization.Serializable
@SerialName("tendermint/PubKeyEd25519")
class PubKeyEd25519(
    // Value field is base64-encoded in all cases
    // Note: if type is Secp256k1, this must contain a COMPRESSED pubkey - to encode from bcp/keycontrol land, you must compress it first
    override val value: String
) : PubKey()

@kotlinx.serialization.Serializable
@SerialName("tendermint/PubKeySr25519")
class PubKeySr25519(
    // Value field is base64-encoded in all cases
    // Note: if type is Secp256k1, this must contain a COMPRESSED pubkey - to encode from bcp/keycontrol land, you must compress it first
    override val value: String
) : PubKey()

