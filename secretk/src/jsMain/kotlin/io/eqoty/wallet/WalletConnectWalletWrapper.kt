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

class WalletConnectWalletWrapper(
    val provider: dynamic,
    val chainId: String,
) : Wallet {

    override suspend fun getSignMode(): SignMode? = null

    override suspend fun getAccounts(): List<AccountData> {
        console.log("getAccounts")
        val accountDatas : Array<jslibs.secretjs.AccountData> = provider.session.namespaces["cosmos"].accounts
        console.log(accountDatas)
        return accountDatas.map { it.toCommonType() }
    }

    override suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse {
        TODO()
//        val result = wallet.signAmino(signerAddress, JSON.parse(Json.encodeToString(signDoc))).await()
//        return Json.decodeFromString(JSON.stringify(result))
    }

}
