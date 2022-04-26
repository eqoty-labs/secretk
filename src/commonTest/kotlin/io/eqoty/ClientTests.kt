package io.eqoty

import io.eqoty.client.SigningCosmWasmClient
import io.eqoty.tx.MsgExecuteContract
import io.eqoty.utils.Address.pubkeyToAddress
import io.eqoty.utils.decodeToString
import io.eqoty.wallet.Secp256k1Pen
import io.eqoty.wallet.encodeSecp256k1Pubkey
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
    fun beforeEach(){
    }

    @Test
    fun testPubKeyToAddress() = runTest {
        val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
        val accAddress = "secret1fdkdmflnrysrvg3nc4ym7zdsn2rm5atszn9q2y"
        val signingPen = Secp256k1Pen.fromMnemonic(mnemonic)
        val pubkey = encodeSecp256k1Pubkey(signingPen.pubkey)
        val accAddressFromMnemonic = pubkeyToAddress(pubkey, "secret")
        assertEquals(accAddress, accAddressFromMnemonic)
    }
    /**
     * run test not working on darwin engine:
     * https://youtrack.jetbrains.com/issue/KTOR-3900/A-native-application-with-the-Darwin-engine-doesn't-make-a-reque
     */
    @Test
    fun testProxy() =  runTest {
        val contractAddress = "secret18vd8fpwxzck93qlwghaj6arh4p7c5n8978vsyg"
        val grpcGatewayEndpoint = "http://eqoty.duckdns.org:1337"
        val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
        // A pen is the most basic tool you can think of for signing.
        // This wraps a single keypair and allows for signing.
        val signingPen = Secp256k1Pen.fromMnemonic(mnemonic)
        val pubkey = encodeSecp256k1Pubkey(signingPen.pubkey)
        val accAddress = pubkeyToAddress(pubkey, "secret")

        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            accAddress,
            signingPen
        )
        println("Querying nft contract info")
        val contractInfoQuery = """{"contract_info": {}}"""
        val contractInfo = client.queryContractSmart(contractAddress, contractInfoQuery)
        println("nft contract info response: $contractInfo")

        assertEquals("""{"contract_info":{"name":"lucasfirstsnip721","symbol":"luca721"}}""", contractInfo.toString())
        // Entropy: Secure implementation is left to the client, but it is recommended to use base-64 encoded random bytes and not predictable inputs.
        val entropy = "Another really random thing??"
        val handleMsg = """{ "create_viewing_key": {"entropy": "$entropy"} }"""
        println("Creating viewing key");
        val response = client.execute(
            contractAddress,
            MsgExecuteContract(
                sender = accAddress,
                contractAddress = contractAddress,
                msg = handleMsg,
                //codeHash = "f7711ac771565a1cb0db516a63a63742e11651516b8dfcf19ecd08aaec1e0193"
            ),
            //_contractCodeHash = "f7711ac771565a1cb0db516a63a63742e11651516b8dfcf19ecd08aaec1e0193"
        )
        println("viewing key response: ${response.data.decodeToString()}")
        val viewingKey = json.parseToJsonElement(response.data.decodeToString())
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

        val numTokens = client.queryContractSmart(contractAddress, numTokensQuery);
        println("Num Tokens Response: $numTokens")
    }


}