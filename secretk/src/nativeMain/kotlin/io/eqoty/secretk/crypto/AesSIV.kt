package io.eqoty.secretk.crypto

import kotlinx.cinterop.*
import libaes_siv.AES_SIV_CTX_free
import libaes_siv.AES_SIV_CTX_new
import libaes_siv.AES_SIV_Decrypt
import libaes_siv.AES_SIV_Encrypt

actual class AesSIV actual constructor() {
    actual suspend fun encrypt(
        txEncryptionKey: UByteArray,
        plaintext: UByteArray,
        associatedData: UByteArray
    ): UByteArray = memScoped {
        val ctx = AES_SIV_CTX_new()
        val outputLength = txEncryptionKey.size / 2 + plaintext.size
        val ciphertext = UByteArray(outputLength)
        val ciphertextPtr = ciphertext.refTo(0)
        val outputLengthPtr = cValue<ULongVar>().ptr
        outputLengthPtr.pointed.value = outputLength.toULong()
        val success = AES_SIV_Encrypt(
            ctx,
            ciphertextPtr, outputLengthPtr,
            txEncryptionKey.toCValues(), txEncryptionKey.size.convert(),
            null, 0,
            plaintext.toCValues(), plaintext.size.convert(),
            associatedData.toCValues(), associatedData.size.convert(),
        )
        if (success == 0) {
            throw Error("AES_SIV_Encrypt failed")
        }
        require(outputLengthPtr.pointed.value.toInt() == outputLength) {
            "outputLength set by AES_SIV_Encrypt doesn't match input outputLength"
        }
        AES_SIV_CTX_free(ctx)
        return@memScoped ciphertext
    }


    actual suspend fun decrypt(
        txEncryptionKey: UByteArray,
        ciphertext: UByteArray,
        associatedData: UByteArray
    ): UByteArray = memScoped {
        val ctx = AES_SIV_CTX_new()
        val outputLength = ciphertext.size - txEncryptionKey.size / 2
        val plaintext = UByteArray(outputLength)
        val plaintextPtr = plaintext.refTo(0)
        val outputLengthPtr = cValue<ULongVar>().ptr
        outputLengthPtr.pointed.value = outputLength.toULong()
        val success = AES_SIV_Decrypt(
            ctx,
            plaintextPtr, outputLengthPtr,
            txEncryptionKey.toCValues(), txEncryptionKey.size.convert(),
            null, 0,
            ciphertext.toCValues(), ciphertext.size.convert(),
            associatedData.toCValues(), associatedData.size.convert(),
        )
        if (success == 0) {
            throw Error("AES_SIV_Decrypt failed")
        }
        require(outputLengthPtr.pointed.value.toInt() == outputLength) {
            "outputLength set by AES_SIV_Encrypt doesn't match input outputLength"
        }
        AES_SIV_CTX_free(ctx)
        return@memScoped plaintext
    }

}