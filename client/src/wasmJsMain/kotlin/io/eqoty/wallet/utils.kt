package io.eqoty.wallet

import io.eqoty.kryptools.utils.toUByteArray
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.Algo

fun jslibs.secretjs.AccountData.toCommonType(): AccountData =
    AccountData(
        address = address,
        algo = Algo.valueOf(algo),
        pubkey = pubkey.toUByteArray()
    )

//language=JavaScript
internal fun stringify(any: JsAny): String = js("JSON.stringify(any)")

internal fun parse(json: String): JsAny =
    js("JSON.parse(json)")

//language=JavaScript
internal fun parseStdSignDocJsonToJsStdSignDoc(signDocJson: String): jslibs.cosmjs.amino.StdSignDoc =
    js("JSON.parse(signDocJson)")

