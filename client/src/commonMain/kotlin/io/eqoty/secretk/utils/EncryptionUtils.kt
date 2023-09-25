package io.eqoty.secretk.utils

import kotlinx.serialization.json.JsonObject

interface EncryptionUtils {
    suspend fun getPubkey(): UByteArray
    suspend fun decrypt(ciphertext: UByteArray, nonce: UByteArray): UByteArray
    suspend fun encrypt(contractCodeHash: String, message: JsonObject): UByteArray
    suspend fun getTxEncryptionKey(nonce: UByteArray): UByteArray
}