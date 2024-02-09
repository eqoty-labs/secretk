package jslibs.keplrwallet.types

import kotlinx.serialization.Serializable

@Serializable
class KeplrSignOptionsImpl(
    var preferNoSetFee: Boolean? = null,
    var preferNoSetMemo: Boolean? = null,
    var disableBalanceCheck: Boolean? = null
)