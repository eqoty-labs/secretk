@file:JsModule("@keplr-wallet/wc-client")
@file:JsNonModule

package jslib.walletconnect

import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import kotlin.js.*

external class KeplrWalletConnectV1(
    walletConnect: WalletConnect,
    options: KeplrWalletConnectV1Options
)

external interface KeplrWalletConnectV1Options {
    var kvStore: dynamic
    var sendTx: (chainId: String, tx: Uint8Array, mode: dynamic) -> Promise<Uint8Array>
}
