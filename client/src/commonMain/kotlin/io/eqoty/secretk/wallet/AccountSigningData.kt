package io.eqoty.secretk.wallet

class AccountSigningData(
    address: String,
    algo: Algo,
    pubkey: UByteArray,
    val privkey: UByteArray,
    val mnemonic: List<CharArray>? = null,
) {
    val publicData = AccountData(address, algo, pubkey)
}
