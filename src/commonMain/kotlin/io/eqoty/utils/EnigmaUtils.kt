package io.eqoty.utils

import com.ionspin.kotlin.crypto.generichash.GenericHash.genericHash
import io.eqoty.crypto.SIV
import io.eqoty.utils.AxlSign.generateKeyPair
import io.eqoty.utils.AxlSign.sharedKey
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.Deferred
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.random.Random
import kotlin.random.nextUBytes


@Serializable
data class Result(val TxKey: String)

@Serializable
data class TxKeyResponse(val height: Int, val result: Result)

data class KeyPair(val privKey: UByteArray, val pubKey: UByteArray)

class EnigmaUtils(val apiUrl: String, seed: UByteArray?) : SecretUtils {


    private val siv = SIV()
    private val seed: UByteArray
    private val privKey: UByteArray
    val pubKey: UByteArray

    init {
        if (seed == null) {
            this.seed = EnigmaUtils.GenerateNewSeed();
        } else {
            this.seed = seed;
        }
        val keyPair = GenerateNewKeyPairFromSeed(this.seed);
        this.privKey = keyPair.privKey;
        this.pubKey = keyPair.pubKey;
    }

    companion object {
        fun GenerateNewKeyPair(): KeyPair {
            return EnigmaUtils.GenerateNewKeyPairFromSeed(EnigmaUtils.GenerateNewSeed());
        }

        fun GenerateNewSeed(): UByteArray {
            return Random.nextUBytes(32);
        }

        fun GenerateNewKeyPairFromSeed(seed: UByteArray): KeyPair {
            val keys = generateKeyPair(seed.toIntArray())
            return KeyPair(
                keys.privateKey.toUByteArray(),
                keys.privateKey.toUByteArray()
            )
        }
    }

    private val client: HttpClient = HttpClient {
        install(DefaultRequest) {
            contentType(ContentType.Application.Json)
        }
        install(ContentNegotiation) {
            json(Json)
        }
    }

    private var consensusIoPubKey: UByteArray? = null // cache

    private suspend fun getConsensusIoPubKey(): UByteArray {
        if (this.consensusIoPubKey != null) {
            return this.consensusIoPubKey!!
        }

        val txKeyResponse: TxKeyResponse = client.get(this.apiUrl + "/reg/tx-key").body()
        val txKey = txKeyResponse.result.TxKey
        val test = txKey.decodeBase64Bytes()
        this.consensusIoPubKey = test.toUByteArray()
        return this.consensusIoPubKey!!
    }


    override suspend fun getPubkey(): Deferred<UByteArray> {
        TODO("Not yet implemented")
    }

    override suspend fun decrypt(ciphertext: UByteArray, nonce: UByteArray): Deferred<UByteArray> {
        TODO("Not yet implemented")
    }

    override suspend fun encrypt(contractCodeHash: String, message: JsonObject): UByteArray {
        // TODO: Use a secureRandom library?
        val nonce = Random.nextUBytes(32)


        val txEncryptionKey = getTxEncryptionKey(nonce);
        val plaintext = contractCodeHash + message.toString()

        val ciphertext = siv.encrypt(txEncryptionKey, plaintext, "")


        return nonce + this.pubKey + ciphertext
    }

    override suspend fun getTxEncryptionKey(nonce: UByteArray): UByteArray {
        val consensusIoPubKey = getConsensusIoPubKey();

        val txEncryptionIkm = sharedKey(this.privKey.toIntArray(), consensusIoPubKey.toIntArray()).toUByteArray()

        return genericHash(txEncryptionIkm + nonce)
    }


}
