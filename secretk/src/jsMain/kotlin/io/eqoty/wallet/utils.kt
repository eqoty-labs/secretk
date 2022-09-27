package io.eqoty.wallet

import ext.libsodium.com.ionspin.kotlin.crypto.toUByteArray
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.Algo

fun jslibs.secretjs.AccountData.toCommonType(): AccountData =
    AccountData(
        address = address,
        algo = Algo.valueOf(algo),
        pubkey = pubkey.toUByteArray()
    )
