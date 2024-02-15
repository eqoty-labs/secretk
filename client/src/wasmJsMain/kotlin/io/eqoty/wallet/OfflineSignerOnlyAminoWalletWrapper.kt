package io.eqoty.wallet

import io.eqoty.secretk.types.StdSignDoc
import io.eqoty.secretk.types.proto.SignMode
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import jslibs.keplrwallet.types.Keplr
import jslibs.secretjs.AminoWallet
import kotlinx.coroutines.await
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class OfflineSignerOnlyAminoWalletWrapper(
    val keplr: Keplr, val chainId: String, val wallet: AminoWallet = keplr.getOfflineSignerOnlyAmino(chainId)
) : Wallet {

    override suspend fun getAccounts(): List<AccountData> {
        val walletAccounts: JsArray<jslibs.secretjs.AccountData> = wallet.getAccounts().await()
        val accounts = Array(walletAccounts.length) { walletAccounts[it]!!.toCommonType() }.toList()
        return accounts
    }

    override suspend fun getSignMode(): SignMode? = null

    override suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse {
        val result: jslibs.cosmjs.amino.AminoSignResponse =
            wallet.signAmino(signerAddress, parseStdSignDocJsonToJsStdSignDoc(Json.encodeToString(signDoc))).await()
        return Json.decodeFromString(stringify(result))
    }

}