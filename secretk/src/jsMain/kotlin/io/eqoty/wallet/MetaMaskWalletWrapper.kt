package io.eqoty.wallet

import io.eqoty.secretk.types.StdSignDoc
import io.eqoty.secretk.types.proto.SignMode
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import jslibs.secretjs.MetaMaskWallet
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// todo: Remove secret.js dependency and just implement it ourselves
class MetaMaskWalletWrapper(
    val wallet: MetaMaskWallet,
) : Wallet {

    override suspend fun getSignMode(): SignMode? =
        SignMode.getByValue(wallet.getSignMode().await() as Int)


    override suspend fun getAccounts(): List<AccountData> {
        return wallet.getAccounts().await().map { it.toCommonType() }
    }

    override suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse {
        val result = wallet.signAmino(signerAddress, JSON.parse(Json.encodeToString(signDoc))).await()
        return Json.decodeFromString(JSON.stringify(result))
    }

}
