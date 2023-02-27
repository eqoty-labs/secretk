package io.eqoty.secretk.utils

import com.ionspin.kotlin.crypto.LibsodiumInitializer

suspend fun ensureLibsodiumInitialized() {
    if (!LibsodiumInitializer.isInitialized()) LibsodiumInitializer.initialize()
}