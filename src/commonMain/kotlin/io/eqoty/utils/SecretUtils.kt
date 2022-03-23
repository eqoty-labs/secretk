package io.eqoty.utils

import kotlinx.coroutines.Deferred
import kotlinx.serialization.json.JsonObject

interface SecretUtils {
  suspend fun getPubkey() : Deferred<UByteArray>
  suspend fun decrypt(ciphertext: UByteArray, nonce: UByteArray): Deferred<UByteArray>
  suspend fun encrypt(contractCodeHash: String, message: JsonObject): UByteArray
  suspend fun getTxEncryptionKey(nonce: UByteArray): UByteArray
}