package io.eqoty

import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.secret.std.types.Permission
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.secretk.extensions.accesscontrol.PermitFactory
import io.eqoty.secretk.types.*
import io.eqoty.secretk.utils.logger
import io.eqoty.secretk.wallet.DirectSigningWallet
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okio.FileSystem
import okio.Path
import kotlin.math.ceil
import kotlin.random.Random
import kotlin.test.*
import kotlin.time.Duration.Companion.seconds

expect val fileSystem: FileSystem
expect val snip721MigratableWasmGz: Path

class ClientTests {
    val json: Json = Json
    val grpcGatewayEndpoint = "https://api.pulsar3.scrttestnet.com"
    val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
    var wallet = DirectSigningWallet(mnemonic)

    @BeforeTest
    fun beforeEach() = runTest {
        platformBeforeEach()
    }


    @Test
    fun walletsUnique() = runTest(timeout = 20.seconds) {
        val mnemonics = mutableSetOf<String>()
        (0..1000).forEach { idx ->
            val randWallet = DirectSigningWallet()
            assertTrue(mnemonics.add(randWallet.accounts[0].address), "account already generated")
            if (idx % 500 == 0) logger.i(idx.toString())
        }
    }

    @Test
    fun testPubKeyToAddress() = runTest {
        val accAddress = "secret1fdkdmflnrysrvg3nc4ym7zdsn2rm5atszn9q2y"
        assertEquals(accAddress, wallet.getAccounts()[0].address)
    }

    @Test
    fun testCorrectlyGeneratesAddressFromPrivKey() = runTest {
        val privKey = wallet.addressToAccountSigningData[wallet.accountAddresses.first()]!!.privkey
        val walletFromPrivKey = DirectSigningWallet(privKey)
        assertEquals(walletFromPrivKey.getAccounts()[0].address, wallet.getAccounts()[0].address)
    }

    @Test
    fun testCreateViewingKeyAndUseToQuery() = runTest {
        val contractAddress = "secret1yk7cd95nanxfcac7kfkkdh2dcm2m0v2eu7umz8"
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
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
        val msgs = listOf(
            MsgExecuteContract(
                sender = accAddress,
                contractAddress = contractAddress,
                msg = handleMsg,
            )
        )
        val gasLimit = if (client.chainId != "secret-dev1") {
            // public testnet doesn't support simulate: for large txs?
            50_000
        } else {
            val simulate = client.simulate(msgs)
            (simulate.gasUsed.toDouble() * 1.1).toInt()
        }
        val response = client.execute(
            msgs,
            txOptions = TxOptions(gasLimit = gasLimit)
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
    fun testQueryWithPermit() = runTest {
        val contractAddress = "secret1yk7cd95nanxfcac7kfkkdh2dcm2m0v2eu7umz8"
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        println("Querying nft contract info")
        val contractInfoQuery = """{"contract_info": {}}"""
        val contractInfo = client.queryContractSmart(contractAddress, contractInfoQuery)
        println("nft contract info response: $contractInfo")

        assertEquals("""{"contract_info":{"name":"lucasfirstsnip721","symbol":"luca721"}}""", contractInfo)

        println("Querying Num Tokens")
        val permit = PermitFactory.newPermit(
            wallet,
            accAddress,
            client.getChainId(),
            "Test",
            listOf(contractAddress),
            listOf(Permission.Owner),
        )
        val numTokensQuery =
            """
                {
                    "with_permit": {
                        "permit": ${Json.encodeToString(permit)},
                        "query": { "num_tokens": {} }
                    }
                }
            """

        val numTokens = client.queryContractSmart(contractAddress, numTokensQuery)
        println("Num Tokens Response: $numTokens")
    }

    suspend fun storeCode(client: SigningCosmWasmClient, sender: String): Int {
        val wasmBytes =
            fileSystem.read(snip721MigratableWasmGz) {
                readByteArray()
            }
        val msgs = listOf(
            MsgStoreCode(
                sender = sender,
                wasmByteCode = wasmBytes.toUByteArray(),
            )
        )
        val simulate = client.simulate(msgs)
        val gasLimit = (simulate.gasUsed.toDouble() * 1.1).toInt()
        val response = client.execute(
            msgs,
            txOptions = TxOptions(gasLimit = gasLimit)
        )

        val codeId = response.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "code_id" }?.value!!
        logger.i("codeId:  $codeId")
        return codeId.toInt()
    }

    @Test
    fun testStoreCode() = runTest(timeout = 20.seconds) {
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        val codeId = storeCode(client, accAddress)

        // contract hash, useful for contract composition
        val codeInfo = client.getCodeInfoByCodeId(codeId)
        logger.i("code hash: ${codeInfo.codeHash}")

        assertEquals("203e69ab1cd265aa8d1f61cf8510c53fa8210cfd4bab7891616bae9e94547b26", codeInfo.codeHash)
    }


    @Test
    fun testInstantiateContractWithCodeHash() = runTest {
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        testInstantiateContract(
            client,
            accAddress,
            "5b64d22c7774b11cbc3aac55168d11f624a51921679b005df7d59487d254c892",
            accAddress
        )
    }

    @Test
    fun testInstantiateContractWithNullCodeHash() = runTest {
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        testInstantiateContract(client, accAddress, null, accAddress)
    }

    @Test
    fun testInstantiateContractWithEmptyStringCodeHash() = runTest {
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        testInstantiateContract(client, accAddress, "", accAddress)
    }

    @Test
    fun testInstantiateContractWithBlankStringCodeHash() = runTest {
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        testInstantiateContract(client, accAddress, "  ", accAddress)
    }

    @Test
    fun testMigrateContract() = runTest(timeout = 30.seconds) {
        val senderAddr = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        val contractAddr = testInstantiateContract(client, senderAddr, null, senderAddr)
        val newCodeId = storeCode(client, senderAddr)
        assertNotEquals(newCodeId, client.getContractInfoByAddress(contractAddr).contractInfo.codeId)
        val msgs = listOf(
            MsgMigrateContract(
                sender = senderAddr,
                contractAddress = contractAddr,
                codeId = newCodeId,
                msg = "{}"
            )
        )
        val gasLimit = (1_000_000.toDouble() * 1.1).toInt()
        client.execute(
            msgs,
            txOptions = TxOptions(gasLimit = gasLimit)
        )
        assertEquals(newCodeId, client.getContractInfoByAddress(contractAddr).contractInfo.codeId)
    }

    suspend fun testInstantiateContract(
        client: SigningCosmWasmClient,
        sender: String,
        codeHash: String?,
        admin: String? = null
    ): String {
        val codeId = 1331
        val initMsg =
            """
            { 
                "instantiate": {
                    "name": "lucasfirstsnip721",
                    "symbol": "luca721",
                    "entropy": "sadfsadfasdfvabadfb",
                    "config": {
                        "public_token_supply": false,
                        "public_owner": true
                    }
                },
                "max_migration_complete_event_subscribers": 0
            }
            """
        val msgs = listOf(
            MsgInstantiateContract(
                codeId = codeId,
                sender = sender,
                codeHash = codeHash,
                initMsg = initMsg,
                label = "My Snip721" + ceil(Random.nextDouble() * 10000),
                admin = admin
            )
        )
        val gasLimit = if (client.chainId != "secret-dev1") {
            // public testnet doesn't support simulate: for large txs?
            50_000
        } else {
            val simulate = client.simulate(msgs)
            (simulate.gasUsed.toDouble() * 1.1).toInt()
        }
        val instantiateResponse = client.execute(
            msgs,
            txOptions = TxOptions(gasLimit = gasLimit)
        )
        val contractAddress = instantiateResponse.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "contract_address" }?.value!!
        logger.i("contract address:  $contractAddress")
        assertContains(contractAddress, "secret1")
        return contractAddress
    }

    @Test
    fun testSendCoin() = runTest {
        val accAddress = wallet.getAccounts()[0].address
        val client = SigningCosmWasmClient.init(
            grpcGatewayEndpoint,
            wallet
        )
        val toAccount = wallet.addAccount()
        val amountToSend = listOf(Coin(10, "uscrt"))
        val msgs = listOf(
            MsgSend(
                fromAddress = accAddress,
                toAddress = toAccount.publicData.address,
                amount = amountToSend
            )
        )
        val simulate = client.simulate(msgs)
        val gasLimit = (simulate.gasUsed.toDouble() * 1.1).toInt()
        client.execute(
            msgs,
            txOptions = TxOptions(gasLimit = gasLimit)
        )
        val recipientBalance = client.getBalance(toAccount.publicData.address).balances
        assertEquals(recipientBalance, amountToSend)
    }

}