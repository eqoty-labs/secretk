package io.eqoty.crypto

import org.cryptomator.siv.SivMode

actual class SIV {
    private val aesSIV = SivMode()
    actual fun encrypt(txEncryptionKey: UByteArray, plaintext: String, associatedData: String): UByteArray {
        val ctrKey = ByteArray(txEncryptionKey.size/2){ i -> txEncryptionKey[i].toByte() }
        val macKey = ByteArray(txEncryptionKey.size/2){ i -> txEncryptionKey[txEncryptionKey.size / 2 + i].toByte() }
        val safeAssociatedData = if (associatedData.isEmpty()){
            ByteArray(0)
        } else {
            associatedData.toByteArray()
        }
        return aesSIV.encrypt(ctrKey,macKey,plaintext.encodeToByteArray(), safeAssociatedData).toUByteArray()
    }
}