package io.eqoty.secretk.utils

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import io.eqoty.secretk.utils.bech32.Bech32

fun addressToBytes(address: String): ByteArray {
    return Bech32.decode(address).data
}

fun addressToUBytes(address: String): UByteArray {
    return Bech32.decode(address).data.toUByteArray()
}

suspend fun ensureLibsodiumInitialized() {
    if (!LibsodiumInitializer.isInitialized()) LibsodiumInitializer.initialize()
}