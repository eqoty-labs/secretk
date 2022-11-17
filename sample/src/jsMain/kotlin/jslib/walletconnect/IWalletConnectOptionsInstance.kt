package jslib.walletconnect

class IWalletConnectOptionsInstance(
    override var bridge: String?,
    override var signingMethods: Array<String>?,
    override var qrcodeModal: IQRCodeModal?
) : IWalletConnectOptions
