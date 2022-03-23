package io.eqoty

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import io.eqoty.client.SigningCosmWasmClient
import io.eqoty.utils.EnigmaUtils
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlin.test.Test
import kotlin.test.assertTrue

class ClientTests {
    val json: Json = Json

    @Test
    fun testProxy() = runTest {
        LibsodiumInitializer.initialize()
        val txEncryptionSeed = EnigmaUtils.GenerateNewSeed();
        val accAddress = "secret16cdfll4e73p2jh47za80mn6rxtjc6234r6pdj0"
        val contractAddress ="secret1ujhudppmg0wverv0ygcxutefz6q0tczhes0av6"
        val httpUrl = "https://lcd.pulsar.griptapejs.com"

        val client = SigningCosmWasmClient(
            httpUrl,
            accAddress,
            Unit,
            txEncryptionSeed
        )
        val contractInfoQuery = json.parseToJsonElement("""{"contract_info": {}}""").jsonObject
        val contractInfo = client.queryContractSmart(contractAddress, contractInfoQuery);

        println("My nft contract info: $contractInfo")
    }
}