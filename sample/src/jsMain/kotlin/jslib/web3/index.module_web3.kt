
package web3


@JsModule("web3")
@JsNonModule
open external class Web3(provider: String)  {

    val utils: Utils = definedExternally
    val eth: Eth = definedExternally

    companion object {
        var utils: Utils = definedExternally
    }

    //    constructor()
    constructor(provider: dynamic)
//    constructor(provider: HttpProvider?)
//    constructor(provider: IpcProvider?)
//    constructor(provider: WebsocketProvider?)
//    constructor(provider: AbstractProvider?)
//    constructor(provider: String?)

//    open var givenProvider: Any
//    open var defaultAccount: String?
//    open var defaultBlock: dynamic /* String | Number */
//    open var currentProvider: dynamic /* HttpProvider? | IpcProvider? | WebsocketProvider? | AbstractProvider? | String? */
//    open fun setProvider(provider: HttpProvider?): Boolean
//    open fun setProvider(provider: IpcProvider?): Boolean
//    open fun setProvider(provider: WebsocketProvider?): Boolean
//    open fun setProvider(provider: AbstractProvider?): Boolean
//    open fun setProvider(provider: String?): Boolean
//    open var BatchRequest: Any
//    open var utils: Utils
//    open var eth: Eth
//    open var shh: Shh
//    open var bzz: Bzz
//    open var version: String
//    open fun extend(extension: Extension): Any
//
//    companion object {
//        var modules: Modules
//        var givenProvider: Any
//        var providers: Providers
//        var version: String
//        var utils: Utils
//    }

}

