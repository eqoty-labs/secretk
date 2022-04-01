package io.eqoty

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import io.eqoty.client.SigningCosmWasmClient
import io.eqoty.utils.EnigmaUtils
import io.ktor.util.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlin.test.BeforeTest
import kotlin.test.Test

class ClientTests {
    val json: Json = Json

    @BeforeTest
    fun beforeEach(){
    }

    @Test
    fun testProxy() =  runTest {
        LibsodiumInitializer.initialize()
        val txEncryptionSeed = EnigmaUtils.GenerateNewSeed();
        val accAddress = "secret16cdfll4e73p2jh47za80mn6rxtjc6234r6pdj0"
        val contractAddress = "secret18vd8fpwxzck93qlwghaj6arh4p7c5n8978vsyg"
        val httpUrl = "http://api.localhost:1337"

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