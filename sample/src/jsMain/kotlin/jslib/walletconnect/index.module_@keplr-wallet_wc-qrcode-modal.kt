@file:JsModule("@keplr-wallet/wc-qrcode-modal")
@file:JsNonModule

package jslib.walletconnect

external class KeplrQRCodeModalV1() : IQRCodeModal {
    override fun open(uri: String, cb: Any, opts: Any) = definedExternally
    override fun close() = definedExternally
}