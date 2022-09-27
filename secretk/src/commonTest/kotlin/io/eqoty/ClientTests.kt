package io.eqoty

import co.touchlab.kermit.Logger
import io.eqoty.client.SigningCosmWasmClient
import io.eqoty.types.MsgExecuteContract
import io.eqoty.types.MsgInstantiateContract
import io.eqoty.types.MsgStoreCode
import io.eqoty.types.TxOptions
import io.eqoty.wallet.DirectSigningWallet
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okio.FileSystem
import okio.Path
import kotlin.math.ceil
import kotlin.random.Random
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

expect val fileSystem: FileSystem
expect val snip721ReferenceImplWasmGz: Path

class ClientTests {
    val json: Json = Json
    val grpcGatewayEndpoint = "https://api.pulsar.scrttestnet.com"
    val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
    var wallet = DirectSigningWallet(mnemonic)

    @BeforeTest
    fun beforeEach() {
    }

    @Test
    fun testPubKeyToAddress() = runTest {
        val accAddress = "secret1fdkdmflnrysrvg3nc4ym7zdsn2rm5atszn9q2y"
        assertEquals(accAddress, wallet.getAccounts()[0].address)
    }


    @Test
    fun testCreateViewingKeyAndUseToQuery() = runTest {
        val contractAddress = "secret1lz4m46vpdn8f2aj8yhtnexus40663udv7hhprm"
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            accAddress,
            wallet
        )
        println("Querying nft contract info")
        val contractInfoQuery = """{"contract_info": {}}"""
        val contractInfo = client.queryContractSmart(contractAddress, contractInfoQuery)
        println("nft contract info response: $contractInfo")

        assertEquals("""{"contract_info":{"name":"lucasfirstsnip721","symbol":"luca721"}}""", contractInfo)
        // Entropy: Secure implementation is left to the client, but it is recommended to use base-64 encoded random bytes and not predictable inputs.
        val entropy = "Another really random thing??"
        val handleMsg = """{ "create_viewing_key": {"entropy": "$entropy"} }"""
        println("Creating viewing key")
        val response = client.execute(
            listOf(
                MsgExecuteContract(
                    sender = accAddress,
                    contractAddress = contractAddress,
                    msg = handleMsg,
//                codeHash = "b3b9ecf43f21f5d41f55b1da1f50ccd68eee86cf951d6cb4490998005af28269"
                )
            )
//            contractCodeHash = "b3b9ecf43f21f5d41f55b1da1f50ccd68eee86cf951d6cb4490998005af28269"
        )
        println("viewing key response: ${response.data}")
        val viewingKey = json.parseToJsonElement(response.data[0])
            .jsonObject["viewing_key"]!!
            .jsonObject["key"]!!.jsonPrimitive.content
        println("Querying Num Tokens")
        val numTokensQuery =
            """
            {
                "num_tokens": {
                    "viewer": {
                        "address": "$accAddress",
                        "viewing_key": "$viewingKey"
                    }
                }
            }
            """

        val numTokens = client.queryContractSmart(contractAddress, numTokensQuery)
        println("Num Tokens Response: $numTokens")
    }

    @Test
    fun testStoreCode() = runTest {
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            accAddress,
            wallet
        )
        val wasmBytes =
            fileSystem.read(snip721ReferenceImplWasmGz) {
                readByteArray()
            }
        val response = client.execute(
            listOf(
                MsgStoreCode(
                    sender = accAddress,
                    wasmByteCode = wasmBytes.toUByteArray(),
                )
            ),
            txOptions = TxOptions(gasLimit = 5_000_000)
        )

        val codeId = response.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "code_id" }?.value!!
        Logger.i("codeId:  $codeId")


        // contract hash, useful for contract composition
        val codeInfo = client.restClient.getCodeInfoByCodeId(codeId)
        Logger.i("code hash: ${codeInfo.codeHash}")

        assertEquals("5b64d22c7774b11cbc3aac55168d11f624a51921679b005df7d59487d254c892", codeInfo.codeHash)
    }

    @Test
    fun testInstantiateContract() = runTest {
        val codeId = 13526
        val codeHash = "5b64d22c7774b11cbc3aac55168d11f624a51921679b005df7d59487d254c892"
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            accAddress,
            wallet
        )
        val initMsg =
            """
            {
                "name": "lucasfirstsnip721",
                "symbol": "luca721",
                "entropy": "sadfsadfasdfvabadfb",
                "config": {
                    "public_token_supply": false,
                    "public_owner": true
                }
            }
            """

        val instantiateResponse = client.execute(
            listOf(
                MsgInstantiateContract(
                    codeId = codeId,
                    sender = accAddress,
                    codeHash = codeHash,
                    initMsg = initMsg,
                    label = "My Snip721" + ceil(Random.nextDouble() * 10000),
                )
            ),
            txOptions = TxOptions(gasLimit = 500_000)
        )
        val contractAddress = instantiateResponse.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "contract_address" }?.value!!
        Logger.i("contract address:  $contractAddress")
        assertContains(contractAddress, "secret1")
    }

}