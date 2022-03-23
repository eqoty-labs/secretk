package io.eqoty.crypto

expect class SIV() {
    fun encrypt(
        txEncryptionKey: UByteArray,
        plaintext: String,
        associatedData: String
    ): UByteArray
}