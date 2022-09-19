package io.eqoty.crypto

import SIV
import ext.libsodium.com.ionspin.kotlin.crypto.toUByteArray
import ext.libsodium.com.ionspin.kotlin.crypto.toUInt8Array
import kotlinx.coroutines.await


actual class AesSIV {


    actual suspend fun encrypt(
        txEncryptionKey: UByteArray,
        plaintext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        val key = SIV.importKey(txEncryptionKey.toUInt8Array(), "AES-SIV").await()
        return key.seal(plaintext.toUInt8Array(), arrayOf(associatedData.toUInt8Array())).await().toUByteArray()
    }

    actual suspend fun decrypt(
        txEncryptionKey: UByteArray,
        ciphertext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        val key = SIV.importKey(txEncryptionKey.toUInt8Array(), "AES-SIV").await()
        return key.open(ciphertext.toUInt8Array(), arrayOf(associatedData.toUInt8Array())).await().toUByteArray()
    }
}