import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.wallet.MetaMaskWalletWrapper
import io.eqoty.wallet.OfflineSignerOnlyAminoWalletWrapper
import jslibs.secretjs.AminoWallet
import jslibs.secretjs.MetaMaskWallet
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.get
import web3.Web3
import kotlin.js.Promise

fun main() {
    application {
        val wallet = setupMetamaskAndGetWallet()
//        val wallet = setupKeplerAndGetWallet()
        val grpcGatewayEndpoint = "https://api.pulsar.scrttestnet.com"
        // A pen is the most basic tool you can think of for signing.
        // This wraps a single keypair and allows for signing.
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            accAddress,
            wallet
        )

        onWasmReady {
            Window("secretk demo") {
                Column(modifier = Modifier.fillMaxSize()) {
                    SampleApp(client)
                }
            }
        }
    }
}

fun application(block: suspend () -> Unit) {
    MainScope().launch {
        block()
    }
}

suspend fun setupKeplerAndGetWallet(): OfflineSignerOnlyAminoWalletWrapper {
    while (
        window.asDynamic().keplr == null ||
        window.asDynamic().getOfflineSignerOnlyAmino == null ||
        window.asDynamic().getEnigmaUtils == null
    ) {
        delay(10)
    }
    val CHAIN_NAME = "Local Testnet"  //Anything you want
    val GRPCWEB_URL = "https://grpc.pulsar.scrttestnet.com"
    val LCD_URL = "https://api.pulsar.scrttestnet.com"
    val RPC_URL = "https://rpc.pulsar.scrttestnet.com"
    val CHAIN_ID = "pulsar-2"
    val DENOM = "SCRT"
    val MINIMAL_DENOM = "uscrt"
    val suggestion: dynamic = JSON.parse(
        """{
            "chainId": "$CHAIN_ID",
            "chainName": "$CHAIN_NAME",
            "rpc": "$RPC_URL",
            "rest": "$LCD_URL",
            "bip44": { "coinType": 529 },
            "coinType": 529,
            "stakeCurrency": { "coinDenom": "$DENOM",
                             "coinMinimalDenom": "$MINIMAL_DENOM",
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
                { "coinDenom": "$DENOM",
                  "coinMinimalDenom": "$MINIMAL_DENOM",
                  "coinDecimals": 6
                }
            ],
            "feeCurrencies": [
                { "coinDenom": "$DENOM",
                  "coinMinimalDenom": "$MINIMAL_DENOM",
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
    val promise: Promise<dynamic> = window.asDynamic().keplr.experimentalSuggestChain(suggestion) as Promise<dynamic>
    val enablePromise: Promise<dynamic> = window.asDynamic().keplr.enable(CHAIN_ID) as Promise<dynamic>
    val wallet: AminoWallet = window.asDynamic().getOfflineSignerOnlyAmino(CHAIN_ID)
    return OfflineSignerOnlyAminoWalletWrapper(wallet)
}


suspend fun setupMetamaskAndGetWallet(): MetaMaskWalletWrapper {
    val provider = window["ethereum"]
    val web3 = Web3(provider).apply {
        eth.handleRevert = true
    }
    val account = web3.eth.requestAccounts().await().firstOrNull()!!
    return MetaMaskWalletWrapper(MetaMaskWallet.create(provider, account).await())
}