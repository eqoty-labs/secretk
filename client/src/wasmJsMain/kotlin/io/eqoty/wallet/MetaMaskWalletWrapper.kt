package io.eqoty.wallet

import io.eqoty.secretk.types.StdSignDoc
import io.eqoty.secretk.types.proto.SignMode
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import jslibs.secretjs.MetaMaskWallet
import kotlinx.coroutines.await
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// todo: Remove secret.js dependency and just implement it ourselves
class MetaMaskWalletWrapper(
    val wallet: MetaMaskWallet,
) : Wallet {

    override suspend fun getAccounts(): List<AccountData> {
        val accounts: JsArray<jslibs.secretjs.AccountData> = wallet.getAccounts().await()
        val commonAccounts = Array(accounts.length) { accounts[it]!!.toCommonType() }
        return commonAccounts.asList()
    }

    override suspend fun getSignMode(): SignMode? {
        val signMode: Int = wallet.getSignMode().await()
        return SignMode.getByValue(signMode)
    }

    override suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse {
        TODO()
//        val result = wallet.signAmino(signerAddress, JSON.parse(Json.encodeToString(signDoc))).await()
//        return Json.decodeFromString(JSON.stringify(result))
    }

}
