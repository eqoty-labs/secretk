@file:JsModule("@web3modal/standalone")
@file:JsNonModule

package jslib.walletconnectv2.web3modal

import jslib.es5.Pick
import kotlin.js.Promise

open external class Web3Modal(config: Web3ModalConfig) {
    open var initUi: Any
    open var openModal: (options: Any?) -> Promise<Unit>
    open var closeModal: () -> Unit
    open var subscribeModal: (callback: (newState: Any) -> Unit) -> () -> Unit
    open var setTheme: (theme: Pick<ConfigCtrlState, String /* "themeMode" | "themeColor" | "themeBackground" */>) -> Unit
}