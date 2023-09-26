@file:JsModule("@keplr-wallet/wc-client")
@file:JsNonModule

package jslib.walletconnect

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise

external class KeplrWalletConnectV1(
    walletConnect: WalletConnect,
    options: KeplrWalletConnectV1Options
)

external interface KeplrWalletConnectV1Options {
    var kvStore: dynamic
    var sendTx: (chainId: String, tx: Uint8Array, mode: dynamic) -> Promise<Uint8Array>
}
