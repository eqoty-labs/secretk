package io.eqoty

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import io.eqoty.client.SigningCosmWasmClient
import io.eqoty.types.StdSignature
import io.eqoty.utils.EnigmaUtils
import io.eqoty.wallet.Secp256k1Pen
import io.ktor.util.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

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
        val httpUrl = "http://eqoty.duckdns.org:1337"
        val mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
        // A pen is the most basic tool you can think of for signing.
        // This wraps a single keypair and allows for signing.
        val signingPen = Secp256k1Pen.fromMnemonic(mnemonic)
/*
60,-48,-29,-10,-70,-106,-11,-12,-33,-97,-45,21,-91,21,100,-99,-41,95,-17,112,58,-93,-24,-64,-66,-37,52,-17,0,-112,66,-59,-103,-8,-10,4,68,-24,63,32,73,-111,-99,61,6,70,95,-25,74,47,-58,52,121,86,25,58,-18,-115,-106,6,-105,-104,-89,-119
 */
//        val client = SigningCosmWasmClient(
//            httpUrl,
//            accAddress,
//            { StdSignature() },
//            txEncryptionSeed,
//            null
//        )
//        val contractInfoQuery = json.parseToJsonElement("""{"contract_info": {}}""").jsonObject
//        val contractInfo = client.queryContractSmart(contractAddress, contractInfoQuery)
//        println("My nft contract info: $contractInfo")
//
//        assertEquals("""{"contract_info":{"name":"lucasfirstsnip721","symbol":"luca721"}}""", contractInfo.toString())
    }


}