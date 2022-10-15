package io.eqoty.secretk.wallet

class AccountSigningData(
    address: String,
    algo: Algo,
    pubkey: UByteArray,
    val privkey: UByteArray
){
    val publicData = AccountData(address, algo, pubkey)
}
