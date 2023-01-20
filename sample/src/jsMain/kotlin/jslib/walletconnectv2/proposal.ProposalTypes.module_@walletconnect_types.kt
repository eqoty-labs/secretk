package jslib.walletconnectv2

external interface BaseRequiredNamespace {
    var chains: Array<String>
    var methods: Array<String>
    var events: Array<String>
}

external interface RequiredNamespace : BaseRequiredNamespace {
    var extension: Array<BaseRequiredNamespace>?
        get() = definedExternally
        set(value) = definedExternally
}
