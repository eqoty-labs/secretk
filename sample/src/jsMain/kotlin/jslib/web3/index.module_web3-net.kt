@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package web3

open external class Network : NetworkBase {
    constructor()
    constructor(provider: HttpProvider?)
    constructor(provider: WebsocketProvider?)
    constructor(provider: AbstractProvider?)
    constructor(provider: String?)

}