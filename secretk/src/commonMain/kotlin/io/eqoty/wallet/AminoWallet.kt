package io.eqoty.wallet

import io.eqoty.tx.proto.SignMode
import io.eqoty.types.StdSignDoc
import io.eqoty.types.StdSignature
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
    override fun getSignMode(): SignMode? = null

}