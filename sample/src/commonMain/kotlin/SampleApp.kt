import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import io.eqoty.secret.std.types.Permission
import io.eqoty.secret.std.types.Permit
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.secretk.extensions.accesscontrol.PermitFactory
import io.eqoty.secretk.types.MsgExecuteContract
import io.eqoty.secretk.types.TxOptions
import io.eqoty.secretk.wallet.DirectSigningWallet
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

// a `secret-4` nft contract`
//val contractAddress = "secret1d96jn9azwqw40paqyd5g02kz0ye0udhhqlue7j"
// a `pulsar-3` nft contract
val contractAddress = "secret13wgwunerja49j68eehvn6ynnfnzceg42uqut5x"

@Composable
fun SampleApp(
    client: SigningCosmWasmClient,
    senderAddress: String,
    platformSpecificItems: @Composable ColumnScope.() -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    var permit: Permit? by remember { mutableStateOf(null) }
    var contractInfoQueryResponse: String? by remember { mutableStateOf(null) }
    var numTokensQueryWithPermitResponse: String? by remember { mutableStateOf(null) }
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
                    platformSpecificItems()
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
                    if (permit == null) {
                        coroutineScope.launch {
                            permit = PermitFactory.newPermit(
                                client.wallet!!,
                                senderAddress,
                                client.getChainId(),
                                "Test",
                                listOf(contractAddress),
                                listOf(Permission.Owner),
                            )
                        }
                    } else {
                        Row {
                            Button({
                                coroutineScope.launch {
                                    val numTokensQuery =
                                        """
                                            {
                                                "with_permit": {
                                                    "permit": ${Json.encodeToString(permit)},
                                                    "query": { "num_tokens": {} }
                                                }
                                            }
                                        """
                                    numTokensQueryWithPermitResponse = try {
                                        client.queryContractSmart(contractAddress, numTokensQuery)
                                    } catch (t: Throwable) {
                                        t.message
                                    }
                                }
                            }) {
                                Text("Get number of tokens with permit")
                            }
                            numTokensQueryWithPermitResponse?.let {
                                Text("query response: $numTokensQueryWithPermitResponse")
                            }
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
                                            sender = senderAddress,
                                            contractAddress = contractAddress,
                                            msg = handleMsg,
                                        )
                                    )
//                                    val simulate = client.simulate(msgs)
                                    val gasLimit = 50_000//(simulate.gasUsed.toDouble() * 1.1).toInt()

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
                                                    "address": "${senderAddress}",
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
        val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
        val wallet = DirectSigningWallet(mnemonic)
        val accAddress = wallet.accounts[0].address
        client!!.wallet = wallet
        SampleApp(it, accAddress)
    }
}

enum class Chain(val id: String, val grpcGatewayEndpoint: String, val rpcEndpoint: String) {
    Pulsar3("pulsar-3", "https://api.pulsar.scrttestnet.com", "https://rpc.pulsar.scrttestnet.com"),
    Secret4("secret-4", "https://secret-4.api.trivium.network:1317", "https://secret-4.api.trivium.network:26657")
}

suspend fun clientWithDirectSigningWallet(): SigningCosmWasmClient {
    return SigningCosmWasmClient.init(
        Chain.Pulsar3.grpcGatewayEndpoint,
        null
    )
}