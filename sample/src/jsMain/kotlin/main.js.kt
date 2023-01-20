import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.wallet.MetaMaskWalletWrapper
import io.eqoty.wallet.OfflineSignerOnlyAminoWalletWrapper
import io.eqoty.wallet.WalletConnectWalletWrapper
import jslib.walletconnect.*
import jslib.walletconnectv2.*
import jslib.walletconnectv2.web3modal.Web3Modal
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

enum class WalletConnectModal(val signingMethods: Array<String>, val qrcodeModal: IQRCodeModal) {
    Keplr(
        signingMethods = arrayOf(
            "keplr_enable_wallet_connect_v1",
            "keplr_sign_amino_wallet_connect_v1",
        ),
        qrcodeModal = KeplrQRCodeModalV1()
    ),
    Cosmostation(
        signingMethods = arrayOf(
            "cosmos_signDirect", "cosmos_signAmino"
        ),
        qrcodeModal = CosmostationWCModal()
    )
}

suspend fun setupCosmosWalletConnectAndGetWallet(chain: Chain, wcModal: WalletConnectModal): SigningCosmWasmClient {
    val projectId = "yourProjectId"
    val provider = UniversalProvider.init(
        UniversalProviderOptsInit(
            projectId = projectId,
        )
    ).await()
    val web3ModalConfig: dynamic = Unit
    web3ModalConfig.projectId = projectId
    web3ModalConfig.standaloneChains = arrayOf("cosmos:${chain.id}")

    val web3Modal = Web3Modal(web3ModalConfig as Any)
    //  Create WalletConnect Provider
    val namespaces = provider.namespaces
    namespaces?.set(
        "cosmos", NamespaceInit(
            methods = wcModal.signingMethods,
            chains = arrayOf("cosmos:${chain.id}"),
            events = arrayOf("chainChanged", "accountsChanged")
        )
    )
    console.log(namespaces)
    provider.on("display_uri") { uri: String?, error: Error? ->
        console.log("display_uri called")
        console.log(error)
        console.log(uri)
        if (error != null) {
            console.log(error)
        } else {
            console.log("openModal uri:$uri")
            val openModalOptions: dynamic = Unit
            openModalOptions.uri = uri
            web3Modal.openModal(openModalOptions).then {
                console.log("openModal then $it")
            }.catch { t ->
                console.log("openModal error")
                console.log(t)
            }.finally {
                console.log("openModal finally")
            }
        }
    }

    val session = provider.connect(ConnectParamsInstance(namespaces = namespaces!!)).await()
    console.log("Connected")
    console.log(session)
    web3Modal.closeModal()

    val enablePromise: Promise<dynamic> = provider.enable() as Promise<dynamic>
    enablePromise.await()
    val wallet = CosmosWCWalletWrapper(provider)
    val accAddress = wallet.getAccounts()[0].address
    return SigningCosmWasmClient.init(
        chain.grpcGatewayEndpoint,
        accAddress,
        wallet
    )
}

suspend fun setupEthWalletConnectAndGetWallet(chain: Chain): SigningCosmWasmClient {
//    val provider = WalletConnectProvider(
//        IWalletConnectProviderOptionsInstance(
//            infuraId = "YOUR_ID",
//        )
//    )
//    try {
//        (provider as WalletConnectProvider).enable().await()
//    } catch (t: Throwable) {
//        println("WalletConnectProvider.enable() returned error ${t.message}")
//    }
    val provider = TODO()
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