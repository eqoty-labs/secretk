import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.wallet.MetaMaskWalletWrapper
import io.eqoty.wallet.OfflineSignerOnlyAminoWalletWrapper
import jslib.walletconnect.*
import jslib.walletconnect.IQRCodeModal
import jslibs.secretjs.MetaMaskWallet
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.skiko.wasm.onWasmReady
import org.khronos.webgl.Uint8Array
import org.w3c.dom.get
import web3.Web3
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.js.Promise

fun main() {
    application {
//        val client = getClientWithMetamaskWallet(Chain.Pulsar2)
//        val client = setupEthWalletConnectAndGetWallet(Chain.Pulsar2)
//        val client = getClientWithKeplrWallet(Chain.Pulsar2)
        val client = setupCosmosWalletConnectAndGetWallet(Chain.Secret4, WalletConnectModal.Cosmostation)

        console.log(client)
        onWasmReady {
            Window("secretk demo") {
                Column(modifier = Modifier.fillMaxSize()) {
                    SampleApp(client)
                }
            }
        }
    }
}

enum class Chain(val id: String, val grpcGatewayEndpoint: String, val rpcEndpoint: String) {
    Pulsar2("pulsar-2", "https://pulsar-2.api.trivium.network:1317", "https://pulsar-2.api.trivium.network:26657"),
    Secret4("secret-4", "https://secret-4.api.trivium.network:1317", "https://secret-4.api.trivium.network:26657")
}

fun application(block: suspend () -> Unit) {
    MainScope().launch {
        block()
    }
}

suspend fun getClientWithKeplrWallet(
    chain: Chain,
    keplr: dynamic = null,
    suggestChain: Boolean = true
): SigningCosmWasmClient {
    @Suppress("NAME_SHADOWING")
    val keplr = if (keplr == null) {
        while (
            window.asDynamic().keplr == null ||
            window.asDynamic().getOfflineSignerOnlyAmino == null ||
            window.asDynamic().getEnigmaUtils == null
        ) {
            delay(10)
        }
        window.asDynamic().keplr
    } else {
        keplr
    }
    if (suggestChain) {
        val chainId = chain.id
        val chainName = "Local Testnet"  //Anything you want
        val lcdUrl = chain.grpcGatewayEndpoint
        val rpcUrl = chain.rpcEndpoint
        val denom = "SCRT"
        val minimalDenom = "uscrt"
        val suggestion: dynamic = JSON.parse(
            """{
            "chainId": "$chainId",
            "chainName": "$chainName",
            "rpc": "$rpcUrl",
            "rest": "$lcdUrl",
            "bip44": { "coinType": 529 },
            "coinType": 529,
            "stakeCurrency": { "coinDenom": "$denom",
                             "coinMinimalDenom": "$minimalDenom",
                             "coinDecimals": 6
                             },
            "bech32Config": {
                "bech32PrefixAccAddr": "secret",
                "bech32PrefixAccPub": "secretpub",
                "bech32PrefixValAddr": "secretvaloper",
                "bech32PrefixValPub": "secretvaloperpub",
                "bech32PrefixConsAddr": "secretvalcons",
                "bech32PrefixConsPub": "secretvalconspub"
            },
            "currencies": [
                { "coinDenom": "$denom",
                  "coinMinimalDenom": "$minimalDenom",
                  "coinDecimals": 6
                }
            ],
            "feeCurrencies": [
                { "coinDenom": "$denom",
                  "coinMinimalDenom": "$minimalDenom",
                  "coinDecimals": 6,
                  "gasPriceStep": { 
                        "low": 0.1,
                        "average": 0.25,
                        "high": 0.4
                   }
                }
            ],
            "features": ["secretwasm"]
        }"""
        )
        console.log(suggestion)
        val suggestChainPromise: Promise<dynamic> =
            keplr.experimentalSuggestChain(suggestion) as Promise<dynamic>
        suggestChainPromise.await()
    }
    val enablePromise: Promise<dynamic> = keplr.enable(chain.id) as Promise<dynamic>
    enablePromise.await()
    val wallet = OfflineSignerOnlyAminoWalletWrapper(keplr, chain.id)
    val accAddress = wallet.getAccounts()[0].address
    println(accAddress)
    return SigningCosmWasmClient.init(
        chain.grpcGatewayEndpoint,
        accAddress,
        wallet
    )
}


suspend fun getClientWithMetamaskWallet(chain: Chain): SigningCosmWasmClient {
    val provider = window["ethereum"]
    val web3 = Web3(provider).apply {
        eth.handleRevert = true
    }
    val account = web3.eth.requestAccounts().await().firstOrNull()!!
    val wallet = MetaMaskWalletWrapper(MetaMaskWallet.create(provider, account).await())
    val accAddress = wallet.getAccounts()[0].address
    println(accAddress)
    return SigningCosmWasmClient.init(
        chain.grpcGatewayEndpoint,
        accAddress,
        wallet
    )
}

enum class WalletConnectModal(val signingMethods: Array<String>, val qrcodeModal: IQRCodeModal){
    Keplr(
        signingMethods = arrayOf(
            "keplr_enable_wallet_connect_v1",
            "keplr_sign_amino_wallet_connect_v1",
        ),
        qrcodeModal = KeplrQRCodeModalV1()
    ),
    Cosmostation(
        signingMethods = arrayOf(
//            "cosmostation_enable_wallet_connect_v1",
//            "cosmostation_sign_amino_wallet_connect_v1",
            "cosmostation_wc_accounts_v1",
            "cosmostation_wc_sign_tx_v1",
        ),
        qrcodeModal = CosmostationWCModal()
    )
}

suspend fun setupCosmosWalletConnectAndGetWallet(chain: Chain, wcModal: WalletConnectModal): SigningCosmWasmClient {
    val connector = WalletConnect(
        IWalletConnectOptionsInstance(
            bridge = "https://bridge.walletconnect.org", // Required
            signingMethods = wcModal.signingMethods,
            qrcodeModal = wcModal.qrcodeModal,
        )
    )
    val keplr = if (!connector.connected) {
        connector.createSession().await()
        suspendCoroutine<KeplrWalletConnectV1> { continuation ->
            connector.on("connect") { error, payload ->
                if (error != null) {
                    continuation.resumeWithException(error)
                } else {
                    val keplr = KeplrWalletConnectV1(connector,
                        KeplrWalletConnectV1OptionsInstance(null) { a, b, c ->
                            console.log("SEND TX CALLED")
                            Promise.resolve(Uint8Array(1))
                        }
                    )
                    continuation.resume(keplr)

                }
            }
        }
    } else {
        KeplrWalletConnectV1(connector,
            KeplrWalletConnectV1OptionsInstance(null) { a, b, c ->
                console.log("SEND TX CALLED")
                Promise.resolve(Uint8Array(1))
            }
        )
    }
    // experimentalSuggestChain not implemented yet on WalletConnect
    // https://github.com/chainapsis/keplr-wallet/blob/682c8402ccd09b35cecf9f028d97635b6a5cd015/packages/wc-client/src/index.ts#L275
    return getClientWithKeplrWallet(chain, keplr, false)
}

suspend fun setupEthWalletConnectAndGetWallet(chain: Chain): SigningCosmWasmClient {
    val provider = WalletConnectProvider(
        IWalletConnectProviderOptionsInstance(
            infuraId = "YOUR_ID",
        )
    )
    try {
        (provider as WalletConnectProvider).enable().await()
    } catch (t: Throwable) {
        println("WalletConnectProvider.enable() returned error ${t.message}")
    }
    val web3 = Web3(provider).apply {
        eth.handleRevert = true
    }
    val account = web3.eth.getAccounts().await().firstOrNull()!!
    val wallet = MetaMaskWalletWrapper(MetaMaskWallet.create(provider, account).await())
    val accAddress = wallet.getAccounts()[0].address
    println(accAddress)
    return SigningCosmWasmClient.init(
        chain.grpcGatewayEndpoint,
        accAddress,
        wallet
    )
}