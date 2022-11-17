package jslib.walletconnect

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

class KeplrWalletConnectV1OptionsInstance(
    override var kvStore: dynamic,
    override var sendTx: (chainId: String, tx: Uint8Array, mode: dynamic) -> Promise<Uint8Array>
) : KeplrWalletConnectV1Options
