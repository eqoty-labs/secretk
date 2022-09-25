package io.eqoty

import io.eqoty.client.SigningCosmWasmClient
import io.eqoty.tx.MsgExecuteContract
import io.eqoty.wallet.DirectSigningWallet
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ClientTests {
    val json: Json = Json

    @BeforeTest
    fun beforeEach() {
    }

    @Test
    fun testPubKeyToAddress() = runTest {
        val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
        val accAddress = "secret1fdkdmflnrysrvg3nc4ym7zdsn2rm5atszn9q2y"
        val signingPen = DirectSigningWallet(mnemonic)
        assertEquals(accAddress, signingPen.getAccounts()[0].address)
    }


    @Test
    fun testCreateViewingKeyAndUseToQuery() = runTest {
        val contractAddress = "secret1lz4m46vpdn8f2aj8yhtnexus40663udv7hhprm"
        val grpcGatewayEndpoint = "https://api.pulsar.scrttestnet.com"
        val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
        val wallet = DirectSigningWallet(mnemonic)
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


}