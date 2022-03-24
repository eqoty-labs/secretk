package io.eqoty.crypto


actual class SIV {
    actual fun encrypt(
        txEncryptionKey: UByteArray,
        plaintext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        TODO("Not yet implemented")
    }

    actual fun decrypt(
        txEncryptionKey: UByteArray,
        ciphertext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        TODO("Not yet implemented")
    }
}