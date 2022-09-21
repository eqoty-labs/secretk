@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS"
)

package web3

external class Accounts : AccountsBase {
    constructor()
    constructor(provider: HttpProvider?)

    //    constructor(provider: IpcProvider?)
    constructor(provider: WebsocketProvider?)
    constructor(provider: AbstractProvider?)
    constructor(provider: String?)
//    constructor(provider: HttpProvider?, net: Socket)
//    constructor(provider: IpcProvider?, net: Socket)
//    constructor(provider: WebsocketProvider?, net: Socket)
//    constructor(provider: AbstractProvider?, net: Socket)
//    constructor(provider: String?, net: Socket)
}