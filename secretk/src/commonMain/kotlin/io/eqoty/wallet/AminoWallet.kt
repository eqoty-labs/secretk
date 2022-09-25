package io.eqoty.wallet

import io.eqoty.types.StdSignDoc
import io.eqoty.types.StdSignature
import io.eqoty.types.proto.SignMode
import kotlinx.serialization.Serializable

@Serializable
data class AminoSignResponse(
    /**
     * The sign doc that was signed.
     * This may be different from the input signDoc when the signer modifies it as part of the signing process.
     */
    val signed: StdSignDoc,
    val signature: StdSignature
)

class AminoWallet(
    mnemonic: String,
) : BaseWallet(mnemonic) {
    override suspend fun getSignMode(): SignMode? = null

}