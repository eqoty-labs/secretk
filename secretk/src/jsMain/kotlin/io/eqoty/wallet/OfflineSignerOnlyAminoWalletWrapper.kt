package io.eqoty.wallet

import io.eqoty.secretk.types.StdSignDoc
import io.eqoty.secretk.types.proto.SignMode
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import jslibs.secretjs.AminoWallet
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class OfflineSignerOnlyAminoWalletWrapper(
    val keplr: dynamic,
    val chainId: String,
    val wallet: AminoWallet = keplr.getOfflineSignerOnlyAmino(chainId)
) : Wallet {

    override suspend fun getSignMode(): SignMode? = null

    override suspend fun getAccounts(): List<AccountData> {
        return wallet.getAccounts().await().map { it.toCommonType() }
    }

    override suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse {
        val result = wallet.signAmino(signerAddress, JSON.parse(Json.encodeToString(signDoc))).await()
        return Json.decodeFromString(JSON.stringify(result))
    }

}
