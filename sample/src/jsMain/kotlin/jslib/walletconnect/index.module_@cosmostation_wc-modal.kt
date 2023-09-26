@file:JsModule("@cosmostation/wc-modal")
@file:JsNonModule

package jslib.walletconnect

external class CosmostationWCModal() : IQRCodeModal {
    override fun open(uri: String, cb: Any, opts: Any) = definedExternally
    override fun close()
}