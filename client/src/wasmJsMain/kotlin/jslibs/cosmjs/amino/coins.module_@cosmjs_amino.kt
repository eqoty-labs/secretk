@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jslibs.cosmjs.amino

external interface Coin {
    var denom: String
    var amount: String
}

//external fun coin(amount: Number, denom: String): Coin

external fun coin(amount: String, denom: String): Coin

//external fun coins(amount: Number, denom: String): Array<Coin>
//
//external fun coins(amount: String, denom: String): Array<Coin>
//
//external fun parseCoins(input: String): Array<Coin>

external fun addCoins(lhs: Coin, rhs: Coin): Coin