package io.eqoty.secretk.extensions.accesscontrol

import io.eqoty.secretk.types.*
import io.eqoty.secretk.types.extensions.Permission
import io.eqoty.secretk.types.extensions.Permit
import io.eqoty.secretk.wallet.DirectSigningWallet
import io.eqoty.secretk.wallet.Wallet

object PermitFactory {

    private fun newSignDoc(
        chainId: String,
        permitName: String,
        allowedTokens: List<String>,
        permissions: List<Permission>,
    ) =
        StdSignDoc(
            chainId = chainId,
            accountNumber = "0", // Must be 0
            sequence = "0", // Must be 0
            fee = StdFee(
                amount = listOf(Coin(amount = "0", denom = "uscrt")), // Must be 0 uscrt
                gas = "1", // Must be 1
            ),
            msgs = listOf(
                MsgQueryPermitAmino(
                    MsgQueryPermitAminoData(
                        allowedTokens,
                        permissions,
                        permitName,
                    )
                ),
            ),
            memo = "", // Must be empty
        )

    suspend fun newPermit(
        wallet: Wallet,
        owner: String,
        chainId: String,
        permitName: String,
        allowedTokens: List<String>,
        permissions: List<Permission>,
    ): Permit {
        val signature = when (wallet) {
            is DirectSigningWallet -> {
                wallet.signAmino(
                    owner,
                    newSignDoc(chainId, permitName, allowedTokens, permissions),
                ).signature
            }

            else -> TODO()
        }

        return Permit(
            params = Permit.Params(
                chainId = chainId,
                permitName = permitName,
                allowedTokens = allowedTokens,
                permissions = permissions,
            ),
            signature = signature,
        )
    }
}