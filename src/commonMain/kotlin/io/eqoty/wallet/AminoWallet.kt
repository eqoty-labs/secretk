package io.eqoty.wallet

import io.eqoty.tx.proto.SignDocProto
import io.eqoty.tx.proto.SignMode
import io.eqoty.types.StdSignature
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

data class AminoSignResponse(
    /**
     * The sign doc that was signed.
     * This may be different from the input signDoc when the signer modifies it as part of the signing process.
     */
    val signed: SignDocProto,
    val signature: StdSignature
)

class AminoWallet(
    mnemonic: String,
) : SigningWallet(mnemonic) {
    override suspend fun getSignMode(): SignMode? = null

    fun signAmino(address: String, signDoc: SignDocProto): AminoSignResponse {
        if (address != this.address) {
            throw Error("Address $address not found in wallet")
        }

        val signBytes = Json.encodeToString(signDoc).encodeToByteArray().toUByteArray()
        return AminoSignResponse(
            signed = signDoc,
            signature = sign(signBytes)
        )
    }

}