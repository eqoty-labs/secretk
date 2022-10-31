package io.eqoty.secretk.extensions.accesscontrol

import io.eqoty.secretk.types.StdSignature
import io.eqoty.secretk.types.extensions.Permission
import io.eqoty.secretk.wallet.Wallet

internal actual suspend fun PermitFactory.newPermitWithTargetSpecificWallet(
    wallet: Wallet,
    owner: String,
    chainId: String,
    permitName: String,
    allowedTokens: List<String>,
    permissions: List<Permission>
): StdSignature? = null