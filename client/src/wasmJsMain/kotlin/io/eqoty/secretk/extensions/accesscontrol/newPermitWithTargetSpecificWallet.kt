package io.eqoty.secretk.extensions.accesscontrol


import io.eqoty.secret.std.types.Permission
import io.eqoty.secret.std.types.StdSignature
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import io.eqoty.wallet.OfflineSignerOnlyAminoWalletWrapper
import io.eqoty.wallet.parseStdSignDocJsonToJsStdSignDoc
import io.eqoty.wallet.stringify
import jslibs.keplrwallet.types.KeplrSignOptions
import jslibs.keplrwallet.types.KeplrSignOptionsImpl
import kotlinx.coroutines.await
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal actual suspend fun PermitFactory.newPermitWithTargetSpecificWallet(
    wallet: Wallet,
    owner: String,
    chainId: String,
    permitName: String,
    allowedTokens: List<String>,
    permissions: List<Permission>
): StdSignature? {
    return if (wallet is OfflineSignerOnlyAminoWalletWrapper) {
        val jsAminoSignResponse: jslibs.cosmjs.amino.AminoSignResponse = (wallet.keplr.signAmino(
            chainId, owner, parseStdSignDocJsonToJsStdSignDoc(
                Json.encodeToString(
                    newSignDoc(
                        chainId, permitName, allowedTokens, permissions
                    )
                )
            ),
            // not sure why I can't just directly use KeplrSignOptionsImpl here 🙃
            signOptions = signDocJsonToJsKeplrSignOptions(
                Json.encodeToString(
                    KeplrSignOptionsImpl(
                        preferNoSetFee = true, // Fee must be 0, so hide it from the user
                        preferNoSetMemo = true, // Memo must be empty, so hide it from the user
                        disableBalanceCheck = true
                    )
                )
            )
        )).await()
        val aminoSignResponse: AminoSignResponse = Json.decodeFromString(stringify(jsAminoSignResponse))
        aminoSignResponse.signature
    } else {
        null
    }
}

//language=JavaScript
internal fun signDocJsonToJsKeplrSignOptions(signDocJson: String): KeplrSignOptions = js("JSON.parse(signDocJson)")

