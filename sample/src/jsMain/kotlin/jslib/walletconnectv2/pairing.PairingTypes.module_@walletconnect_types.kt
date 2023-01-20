package jslib.walletconnectv2

external interface Struct {
    var topic: String
    var expiry: Number
    var relay: ProtocolOptions
    var active: Boolean
    var peerMetadata: Metadata?
        get() = definedExternally
        set(value) = definedExternally
}