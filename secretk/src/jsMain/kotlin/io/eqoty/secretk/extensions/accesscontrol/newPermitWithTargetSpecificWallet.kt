package io.eqoty.secretk.extensions.accesscontrol

import io.eqoty.secretk.types.StdSignature
import io.eqoty.secretk.types.extensions.Permission
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import io.eqoty.wallet.OfflineSignerOnlyAminoWalletWrapper
import jslibs.keplrwallet.types.Keplr
import jslibs.keplrwallet.types.KeplrSignOptionsImpl
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.get

internal actual suspend fun PermitFactory.newPermitWithTargetSpecificWallet(
    wallet: Wallet,
    owner: String,
    chainId: String,
    permitName: String,
    allowedTokens: List<String>,
    permissions: List<Permission>
): StdSignature? {
    return if (wallet is OfflineSignerOnlyAminoWalletWrapper) {
        val jsAminoSignResponse = (window["keplr"] as Keplr).signAmino(
            chainId,
            owner,
            JSON.parse(Json.encodeToString(newSignDoc(chainId, permitName, allowedTokens, permissions))),
            // not sure why I can't just directly use KeplrSignOptionsImpl here 🙃
            signOptions = JSON.parse(
                Json.encodeToString(
                    KeplrSignOptionsImpl(
                        preferNoSetFee = true, // Fee must be 0, so hide it from the user
                        preferNoSetMemo = true, // Memo must be empty, so hide it from the user
                        disableBalanceCheck = true
                    )
                )
            )
        ).await()
        val aminoSignResponse: AminoSignResponse = Json.decodeFromString(JSON.stringify(jsAminoSignResponse))
        aminoSignResponse.signature
    } else {
        null
    }
}