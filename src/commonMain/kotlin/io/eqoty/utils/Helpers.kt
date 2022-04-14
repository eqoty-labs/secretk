package io.eqoty.utils

fun getMissingCodeHashWarning(method: String): String {
    return "WARNING: ${method} was used without the \"codeHash\" parameter. This is discouraged and will result in much slower execution times for your app."
}

fun addressToBytes(address: String): ByteArray {
    return Bech32.decode(address).data
}

fun addressToUBytes(address: String): UByteArray {
    return Bech32.decode(address).data.toUByteArray()
}