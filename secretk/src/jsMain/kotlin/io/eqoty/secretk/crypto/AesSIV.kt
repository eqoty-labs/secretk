package io.eqoty.secretk.crypto

import ext.libsodium.com.ionspin.kotlin.crypto.toUByteArray
import ext.libsodium.com.ionspin.kotlin.crypto.toUInt8Array
import jslibs.miscreant.SIV
import kotlinx.coroutines.await
import kotlinx.coroutines.flow.*

val createWindowBroadcaster = MutableSharedFlow<Unit>()
val windowIsSetup = MutableStateFlow(!js("typeof window == 'undefined'") as Boolean)
val destroyWindowBroadcaster = MutableSharedFlow<Unit>()
val initiallyHadNoWindow = !windowIsSetup.value

actual class AesSIV {
    /**
     * This is a hacky workaround to make a window object only in our mocha tests.
     * (miscreant.SIV requires a window.crypto)
     * We create a window with happy-dom which we only want to include as a dev/test npm dependency.
     *
     * Note: For js tests I tried the logical method of setting up and destroying happy-dom using
     * @BeforeTest @AfterTest annotated functions but that does not work for some reason.
     * It causes the following error when an api call is made:
     *
     * TypeError: Cannot read properties of undefined (reading 'host_1')
     * at <global>.applyOrigin(/Users/lucaspinazzola/Projects/secretk/URLBuilder.kt:105)
     * at URLBuilder.build_1k0s4u(/Users/lucaspinazzola/Projects/secretk/URLBuilder.kt:88)
     * at <global>.Url(/Users/lucaspinazzola/Projects/secretk/URLUtils.kt:13)
     *
     */
    suspend fun awaitFakeWindow() {
        windowIsSetup.onSubscription {
            println("onSubscription")
            createWindowBroadcaster.emit(Unit)
        }.filter { it }.take(1).first()
    }

    suspend fun awaitDestroyFakeWindow() {
        windowIsSetup.onSubscription {
            println("onSubscription")
            destroyWindowBroadcaster.emit(Unit)
        }.filter { !it }.take(1).first()
    }

    actual suspend fun encrypt(
        txEncryptionKey: UByteArray,
        plaintext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        if (!windowIsSetup.value) {
            awaitFakeWindow()
        }
        val key = SIV.importKey(txEncryptionKey.toUInt8Array(), "AES-SIV").await()
        val ciphertext =
            key.seal(plaintext.toUInt8Array(), arrayOf(associatedData.toUInt8Array())).await().toUByteArray()
//        TODO: unregister https://github.com/capricorn86/happy-dom/pull/604
//        if (initiallyHadNoWindow) {
//            awaitDestroyFakeWindow()
//        }
        return ciphertext
    }

    actual suspend fun decrypt(
        txEncryptionKey: UByteArray,
        ciphertext: UByteArray,
        associatedData: UByteArray
    ): UByteArray {
        if (!windowIsSetup.value) {
            awaitFakeWindow()
        }
        val key = SIV.importKey(txEncryptionKey.toUInt8Array(), "AES-SIV").await()
        val plaintext =
            key.open(ciphertext.toUInt8Array(), arrayOf(associatedData.toUInt8Array())).await().toUByteArray()
//         TODO: unregister https://github.com/capricorn86/happy-dom/pull/604
//        if (initiallyHadNoWindow) {
//            awaitDestroyFakeWindow()
//        }
        return plaintext
    }
}