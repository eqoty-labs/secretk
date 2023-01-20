@file:OptIn(ExperimentalUnsignedTypes::class)

import io.eqoty.secretk.types.StdSignDoc
import io.eqoty.secretk.types.proto.SignMode
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.Algo
import io.eqoty.secretk.wallet.AminoSignResponse
import io.eqoty.secretk.wallet.Wallet
import jslib.walletconnectv2.UniversalProvider
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okio.ByteString.Companion.decodeBase64

class CosmosWCWalletWrapper(
    val provider: UniversalProvider,
) : Wallet {

    private var lastSeenKey: UByteArray = ubyteArrayOf()
    private var lastSeenAlgo: Algo = Algo.secp256k1
    override suspend fun getSignMode(): SignMode? = null

    override suspend fun getAccounts(): List<AccountData> {
        return provider.requestAccounts().await().map {
            AccountData(it, lastSeenAlgo, lastSeenKey)
        }
    }

    override suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse {
        // cosmos_signAmino params
        val params: dynamic = JSON.parse("{}")
        params.signerAddress = signerAddress
        params.signDoc = JSON.parse(Json.encodeToString(signDoc))

        val requestArgs: dynamic = JSON.parse("{}")
        requestArgs.method = "cosmos_signAmino"
        requestArgs.params = params
        val result = provider.request(requestArgs).await()
        val aminoSignResponse = AminoSignResponse(
            signed = signDoc,
            signature = Json.decodeFromString(JSON.stringify(result))
        )
        lastSeenAlgo = aminoSignResponse.signature.pubKey.algo
        lastSeenKey = aminoSignResponse.signature.pubKey.value.decodeBase64()!!.toByteArray().asUByteArray()
        return aminoSignResponse
    }

}
