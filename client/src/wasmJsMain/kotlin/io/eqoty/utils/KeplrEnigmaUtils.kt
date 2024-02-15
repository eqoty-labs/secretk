package io.eqoty.utils

import io.eqoty.kryptools.utils.toUByteArray
import io.eqoty.kryptools.utils.toUInt8Array
import io.eqoty.secretk.utils.EncryptionUtils
import io.eqoty.wallet.parse
import jslibs.keplrwallet.types.Keplr
import kotlinx.coroutines.await
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.khronos.webgl.Uint8Array

class KeplrEnigmaUtils(
    val keplr: Keplr,
    val chainId: String,
    val jsEnigmaUtils: jslibs.secretjs.EncryptionUtils = keplr.getEnigmaUtils(chainId)
) : EncryptionUtils {
    override suspend fun getPubkey(): UByteArray {
        val pubkey: Uint8Array = jsEnigmaUtils.getPubkey().await()
        return pubkey.toUByteArray()
    }

    override suspend fun decrypt(ciphertext: UByteArray, nonce: UByteArray): UByteArray {
        val bytes: Uint8Array = jsEnigmaUtils.decrypt(
            ciphertext.toUInt8Array(),
            nonce.toUInt8Array()
        ).await()
        return bytes.toUByteArray()
    }

    override suspend fun encrypt(contractCodeHash: String, message: JsonObject): UByteArray {
        val bytes: Uint8Array = jsEnigmaUtils.encrypt(
            contractCodeHash,
            parse(Json.encodeToString(message))
        ).await()
        return bytes.toUByteArray()
    }

    override suspend fun getTxEncryptionKey(nonce: UByteArray): UByteArray {
        val bytes: Uint8Array = jsEnigmaUtils.getTxEncryptionKey(nonce.toUInt8Array()).await()
        return bytes.toUByteArray()
    }

}
