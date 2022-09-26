package io.eqoty.crypto

import ext.libsodium.com.ionspin.kotlin.crypto.toUByteArray
import ext.libsodium.com.ionspin.kotlin.crypto.toUInt8Array
import jslibs.happydom.GlobalRegistrator
import jslibs.miscreant.SIV
import kotlinx.browser.window
import kotlinx.coroutines.await


actual class AesSIV {

    val needsWindow get() = !js("typeof window !== 'undefined'") as Boolean
    val initiallyHadNoWindow = needsWindow

    fun setupFakeWindow(){
        GlobalRegistrator.register()
        val crypto = js("""require('@peculiar/webcrypto');""")
        window.asDynamic().crypto = js("""new crypto.Crypto();""")
    }

    fun destroyFakeWindow(){
        // TODO: unregister https://github.com/capricorn86/happy-dom/pull/584
        // globalRegistrator?.unregister()
    }

    actual suspend fun encrypt(
        txEncryptionKey: UByteArray,
        plaintext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        if (needsWindow) {
            setupFakeWindow()
        }
        val key = SIV.importKey(txEncryptionKey.toUInt8Array(), "AES-SIV").await()
        val ciphertext =
            key.seal(plaintext.toUInt8Array(), arrayOf(associatedData.toUInt8Array())).await().toUByteArray()
        if (initiallyHadNoWindow) {
            destroyFakeWindow()
        }
        return ciphertext
    }

    actual suspend fun decrypt(
        txEncryptionKey: UByteArray,
        ciphertext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        if (needsWindow) {
            setupFakeWindow()
        }
        val key = SIV.importKey(txEncryptionKey.toUInt8Array(), "AES-SIV").await()
        val plaintext =
            key.open(ciphertext.toUInt8Array(), arrayOf(associatedData.toUInt8Array())).await().toUByteArray()
        if (initiallyHadNoWindow) {
            destroyFakeWindow()
        }
        return plaintext
    }
}