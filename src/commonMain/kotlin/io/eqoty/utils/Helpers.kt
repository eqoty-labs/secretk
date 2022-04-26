package io.eqoty.utils

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import io.eqoty.utils.bech32.Bech32

fun getMissingCodeHashWarning(method: String): String {
    return "${method} was used without the \"codeHash\" parameter. This is discouraged and will result in much slower execution times for your app."
}

fun addressToBytes(address: String): ByteArray {
    return Bech32.decode(address).data
}

fun addressToUBytes(address: String): UByteArray {
    return Bech32.decode(address).data.toUByteArray()
}

suspend fun ensureLibsodiumInitialized() {
    if (!LibsodiumInitializer.isInitialized()) LibsodiumInitializer.initialize()
}