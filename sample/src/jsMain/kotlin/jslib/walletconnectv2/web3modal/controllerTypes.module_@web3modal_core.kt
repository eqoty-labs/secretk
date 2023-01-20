package jslib.walletconnectv2.web3modal

import jslib.es5.Record

external interface `T$131` {
    var universal: String
    var native: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MobileWallet {
    var id: String
    var name: String
    var links: `T$131`
}

external interface `T$132` {
    var native: String
    var universal: String
}

external interface DesktopWallet {
    var id: String
    var name: String
    var links: `T$132`
}

external interface ConfigCtrlState {
    var projectId: String?
        get() = definedExternally
        set(value) = definedExternally
    var themeMode: String? /* "dark" | "light" */
        get() = definedExternally
        set(value) = definedExternally
    var themeColor: String? /* "blackWhite" | "blue" | "default" | "green" | "magenta" | "orange" | "purple" | "teal" */
        get() = definedExternally
        set(value) = definedExternally
    var themeBackground: String? /* "gradient" | "themeColor" */
        get() = definedExternally
        set(value) = definedExternally
    var themeZIndex: Number?
        get() = definedExternally
        set(value) = definedExternally
    var standaloneChains: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var defaultChain: Any?
        get() = definedExternally
        set(value) = definedExternally
    var mobileWallets: Array<MobileWallet>?
        get() = definedExternally
        set(value) = definedExternally
    var desktopWallets: Array<DesktopWallet>?
        get() = definedExternally
        set(value) = definedExternally
    var walletImages: Record<String, String>?
        get() = definedExternally
        set(value) = definedExternally
    var chainImages: Record<String, String>?
        get() = definedExternally
        set(value) = definedExternally
    var tokenImages: Record<String, String>?
        get() = definedExternally
        set(value) = definedExternally
    var enableStandaloneMode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var enableNetworkView: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var explorerAllowList: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var explorerDenyList: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var termsOfServiceUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    var privacyPolicyUrl: String?
        get() = definedExternally
        set(value) = definedExternally
}