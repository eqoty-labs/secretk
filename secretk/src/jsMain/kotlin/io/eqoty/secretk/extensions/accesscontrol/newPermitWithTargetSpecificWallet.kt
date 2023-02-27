package io.eqoty.secretk.extensions.accesscontrol

import io.eqoty.secret.std.types.Permission
import io.eqoty.secret.std.types.StdSignature
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import io.eqoty.wallet.OfflineSignerOnlyAminoWalletWrapper
import jslibs.keplrwallet.types.KeplrSignOptionsImpl
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.js.Promise

internal actual suspend fun PermitFactory.newPermitWithTargetSpecificWallet(
    wallet: Wallet,
    owner: String,
    chainId: String,
    permitName: String,
    allowedTokens: List<String>,
    permissions: List<Permission>
): StdSignature? {
    return if (wallet is OfflineSignerOnlyAminoWalletWrapper) {
        val jsAminoSignResponse = (wallet.keplr
            .signAmino(
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
            ) as Promise<dynamic>)
            .await()
        val aminoSignResponse: AminoSignResponse = Json.decodeFromString(JSON.stringify(jsAminoSignResponse))
        aminoSignResponse.signature
    } else {
        null
    }
}