import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.secretk.types.MsgExecuteContract
import io.eqoty.secretk.types.TxOptions
import io.eqoty.secretk.wallet.DirectSigningWallet
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

val contractAddress = "secret1lz4m46vpdn8f2aj8yhtnexus40663udv7hhprm"

@Composable
fun SampleApp(client: SigningCosmWasmClient) {
    val coroutineScope = rememberCoroutineScope()
    var contractInfoQueryResponse: String? by remember { mutableStateOf(null) }
    var viewingKeyTxResponse: String? by remember { mutableStateOf(null) }
    var numTokensQueryResponse: String? by remember { mutableStateOf(null) }
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Sample") }
                    )
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row {
                        Button({
                            coroutineScope.launch {
                                val contractInfoQuery = """{"contract_info": {}}"""
                                contractInfoQueryResponse = try {
                                    client.queryContractSmart(contractAddress, contractInfoQuery)
                                } catch (t: Throwable) {
                                    t.message
                                }
                            }
                        }) {
                            Text("Query Contract Info")
                        }
                        contractInfoQueryResponse?.let {
                            Text("query response: $contractInfoQueryResponse")
                        }
                    }
                    Row {
                        Button({
                            coroutineScope.launch {
                                val entropy = "Another really random thing??"
                                val handleMsg = """{ "create_viewing_key": {"entropy": "$entropy"} }"""
                                viewingKeyTxResponse = try {
                                    val msgs = listOf(
                                        MsgExecuteContract(
                                            sender = client.senderAddress,
                                            contractAddress = contractAddress,
                                            msg = handleMsg,
                                        )
                                    )
                                    val simulate = client.simulate(msgs)
                                    val gasLimit = (simulate.gasUsed.toDouble() * 1.1).toInt()

                                    val response = client.execute(
                                        msgs,
                                        txOptions = TxOptions(gasLimit = gasLimit)
                                    )
                                    response.data[0]
                                } catch (t: Throwable) {
                                    t.printStackTrace()
                                    t.message
                                }
                            }
                        }) {
                            Text("Create Viewing Key")
                        }
                        viewingKeyTxResponse?.let {
                            Text("tx response: $viewingKeyTxResponse")
                        }
                    }
                    viewingKeyTxResponse?.let { viewingKeyTxResponse ->
                        Row {
                            Button({
                                coroutineScope.launch {
                                    val viewingKey = Json.parseToJsonElement(viewingKeyTxResponse)
                                        .jsonObject["viewing_key"]!!
                                        .jsonObject["key"]!!.jsonPrimitive.content
                                    val numTokensQuery =
                                        """
                                        {
                                            "num_tokens": {
                                                "viewer": {
                                                    "address": "${client.senderAddress}",
                                                    "viewing_key": "$viewingKey"
                                                }
                                            }
                                        }
                                        """
                                    numTokensQueryResponse = try {
                                        client.queryContractSmart(contractAddress, numTokensQuery)
                                    } catch (t: Throwable) {
                                        t.message
                                    }
                                }
                            }) {
                                Text("Get number of tokens")
                            }
                            numTokensQueryResponse?.let {
                                Text("query response using viewing key: $numTokensQueryResponse")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun setupAndStartApp() {
    val coroutineScope = rememberCoroutineScope()
    var client: SigningCosmWasmClient? by remember { mutableStateOf(null) }
    if (client == null) {
        coroutineScope.launch {
            client = clientWithDirectSigningWallet()
        }
    }
    client?.let {
        SampleApp(it)
    }
}


suspend fun clientWithDirectSigningWallet(): SigningCosmWasmClient {
    val grpcGatewayEndpoint = "https://api.pulsar.scrttestnet.com"
    val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
    val wallet = DirectSigningWallet(mnemonic)
    val accAddress = wallet.accounts[0].address
    return SigningCosmWasmClient.init(
        grpcGatewayEndpoint,
        accAddress,
        wallet
    )
}