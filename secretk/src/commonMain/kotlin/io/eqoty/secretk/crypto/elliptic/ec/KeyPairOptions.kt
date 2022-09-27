package io.eqoty.secretk.crypto.elliptic.ec

data class KeyPairOptions(
    val priv: UByteArray? = null,
    val pub: UByteArray? = null,
    val privEnc: String? = null,
    val pubEnc: String? = null
)
