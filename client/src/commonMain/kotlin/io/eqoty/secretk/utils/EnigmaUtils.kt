package io.eqoty.secretk.utils

import dev.whyoleg.cryptography.random.CryptographyRandom
import io.eqoty.kryptools.aessiv.AesSIV
import io.eqoty.kryptools.axlsign.AxlSignDouble
import io.eqoty.kryptools.deriveHKDFKey
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.random.nextUBytes


@Serializable
data class Result(val TxKey: String)

@Serializable
data class TxKeyResponse(val height: Int, val result: Result)

data class KeyPair(val privKey: UByteArray, val pubKey: UByteArray)

class EnigmaUtils(val apiUrl: String, val seed: UByteArray = GenerateNewSeed()) : EncryptionUtils {

    val hkdfSalt = ubyteArrayOf(
        0x00.toUByte(),
        0x00.toUByte(),
        0x00.toUByte(),
        0x00.toUByte(),
        0x00.toUByte(),
        0x00.toUByte(),
        0x00.toUByte(),
        0x00.toUByte(),
        0x00.toUByte(),
        0x02.toUByte(),
        0x4b.toUByte(),
        0xea.toUByte(),
        0xd8.toUByte(),
        0xdf.toUByte(),
        0x69.toUByte(),
        0x99.toUByte(),
        0x08.toUByte(),
        0x52.toUByte(),
        0xc2.toUByte(),
        0x02.toUByte(),
        0xdb.toUByte(),
        0x0e.toUByte(),
        0x00.toUByte(),
        0x97.toUByte(),
        0xc1.toUByte(),
        0xa1.toUByte(),
        0x2e.toUByte(),
        0xa6.toUByte(),
        0x37.toUByte(),
        0xd7.toUByte(),
        0xe9.toUByte(),
        0x6d.toUByte(),
    )


    private val siv = AesSIV()
    private val axlSign = AxlSignDouble()
    private val privKey: UByteArray
    val pubKey: UByteArray

    init {
        if (seed.size != 32) {
            throw Error("encryptionSeed must be a UByteArray of length 32")
        }
        val keyPair = GenerateNewKeyPairFromSeed(this.seed)
        this.privKey = keyPair.privKey
        this.pubKey = keyPair.pubKey
    }

    companion object {

        fun GenerateNewKeyPair(): KeyPair {
            return GenerateNewKeyPairFromSeed(GenerateNewSeed())
        }

        fun GenerateNewSeed(): UByteArray {
            return CryptographyRandom.nextUBytes(32)
        }

        fun GenerateNewKeyPairFromSeed(seed: UByteArray): KeyPair {
            val keys = AxlSignDouble().generateKeyPair(seed.toIntArray())
            return KeyPair(
                keys.privateKey.toUByteArray(),
                keys.publicKey.toUByteArray()
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
        val txKey = txKeyResponse.result.TxKey.decodeBase64Bytes()
        this.consensusIoPubKey = txKey.toUByteArray()
        return this.consensusIoPubKey!!
    }


    override suspend fun getPubkey(): UByteArray {
        TODO("Not yet implemented")
    }

    override suspend fun decrypt(ciphertext: UByteArray, nonce: UByteArray): UByteArray {
        if (ciphertext.isEmpty()) {
            return ubyteArrayOf()
        }

        val txEncryptionKey = getTxEncryptionKey(nonce)

        //console.log(`decrypt tx encryption key: ${Encoding.toHex(txEncryptionKey)}`);

        val plaintext = siv.decrypt(txEncryptionKey, ciphertext, ubyteArrayOf())
        return plaintext
    }

    override suspend fun encrypt(contractCodeHash: String, message: JsonObject): UByteArray {
        val nonce = CryptographyRandom.nextUBytes(32)

        val txEncryptionKey = getTxEncryptionKey(nonce)

        val plaintext = (contractCodeHash + message).encodeToByteArray().asUByteArray()

        val ciphertext = siv.encrypt(txEncryptionKey, plaintext, ubyteArrayOf())

        return nonce + this.pubKey + ciphertext
    }

    override suspend fun getTxEncryptionKey(nonce: UByteArray): UByteArray {
        val consensusIoPubKey = getConsensusIoPubKey()
        val txEncryptionIkm =
            axlSign.sharedKey(this.privKey.toIntArray(), consensusIoPubKey.toIntArray()).toUByteArray()
        return deriveHKDFKey(txEncryptionIkm + nonce, hkdfSalt, len = 32)
    }

}
