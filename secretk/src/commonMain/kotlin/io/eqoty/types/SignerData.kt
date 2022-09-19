package io.eqoty.types;

import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Signing information for a single signer that is not included in the transaction.
 *
 * @see https://github.com/cosmos/cosmos-sdk/blob/v0.42.2/x/auth/signing/sign_mode_handler.go#L23-L37
 */
data class SignerData(
    val accountNumber: BigInteger,
    val sequence: BigInteger,
    val chainId: String
)
