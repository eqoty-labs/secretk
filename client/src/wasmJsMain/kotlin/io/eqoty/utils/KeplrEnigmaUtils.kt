//package io.eqoty.utils
//
//import io.eqoty.secretk.utils.EncryptionUtils
//import kotlinx.coroutines.await
//import kotlinx.serialization.encodeToString
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.json.JsonObject
//import org.khronos.webgl.ArrayBuffer
//import org.khronos.webgl.Int8Array
//import org.khronos.webgl.Uint8Array
//import kotlin.js.Promise
//
//class KeplrEnigmaUtils(
//    val keplr: dynamic,
//    val chainId: String,
//    val jsEnigmaUtils: dynamic = keplr.getEnigmaUtils(chainId)
//) : EncryptionUtils {
//
//    private fun UByteArray.toUInt8Array(): Uint8Array = Uint8Array(asByteArray().unsafeCast<Int8Array>().buffer)
//    private fun ArrayBuffer.asUByteArray(): UByteArray = Int8Array(this).unsafeCast<ByteArray>().asUByteArray()
//    override suspend fun getPubkey(): UByteArray {
//        return (jsEnigmaUtils.getPubkey() as Promise<ArrayBuffer>).await().asUByteArray()
//    }
//
//    override suspend fun decrypt(ciphertext: UByteArray, nonce: UByteArray): UByteArray {
//        return (jsEnigmaUtils.decrypt(
//            ciphertext.toUInt8Array(),
//            nonce.toUInt8Array()
//        ) as Promise<ArrayBuffer>).await().asUByteArray()
//    }
//
//    override suspend fun encrypt(contractCodeHash: String, message: JsonObject): UByteArray {
//        return (jsEnigmaUtils.encrypt(
//            contractCodeHash,
//            JSON.parse(Json.encodeToString(message))
//        ) as Promise<ArrayBuffer>).await().asUByteArray()
//    }
//
//    override suspend fun getTxEncryptionKey(nonce: UByteArray): UByteArray {
//        return (jsEnigmaUtils.getTxEncryptionKey(nonce.toUInt8Array()) as Promise<ArrayBuffer>).await().asUByteArray()
//    }
//
//}
