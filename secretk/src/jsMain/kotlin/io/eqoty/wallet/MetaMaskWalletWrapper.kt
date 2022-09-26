package io.eqoty.wallet

import io.eqoty.types.StdSignDoc
import io.eqoty.types.proto.SignMode
import jslibs.secretjs.MetaMaskWallet
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
