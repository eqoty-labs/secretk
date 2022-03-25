package io.eqoty.crypto

import org.cryptomator.siv.SivMode

actual class AesSIV {
    private val aesSIV = SivMode()
    actual suspend fun encrypt(txEncryptionKey: UByteArray, plaintext: UByteArray, associatedData: UByteArray): UByteArray {
        val macKey = ByteArray(txEncryptionKey.size/2){ i -> txEncryptionKey[i].toByte() }
        val ctrKey = ByteArray(txEncryptionKey.size/2){ i -> txEncryptionKey[txEncryptionKey.size / 2 + i].toByte() }
        return aesSIV.encrypt(ctrKey, macKey, plaintext.toByteArray(), associatedData.toByteArray()).toUByteArray()
    }

    actual suspend fun decrypt(txEncryptionKey: UByteArray, ciphertext: UByteArray, associatedData: UByteArray): UByteArray {
        val macKey = ByteArray(txEncryptionKey.size/2){ i -> txEncryptionKey[i].toByte() }
        val ctrKey = ByteArray(txEncryptionKey.size/2){ i -> txEncryptionKey[txEncryptionKey.size / 2 + i].toByte() }
        return aesSIV.decrypt(ctrKey, macKey, ciphertext.toByteArray(), associatedData.toByteArray()).toUByteArray()
    }
}