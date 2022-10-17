package io.eqoty.secretk.types

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.secretk.types.proto.CoinProto

@kotlinx.serialization.Serializable
data class Coin(
    val denom: String,
    val amount: String
) {
    constructor(denom: String, amount: Int) : this(denom, amount.toString())
    constructor(denom: String, amount: BigInteger) : this(denom, amount.toString())

    fun toProto() = CoinProto(denom, amount)

    operator fun plus(increment: Coin): Coin {
        return if (increment.denom == denom) {
            this.copy(
                amount = (BigInteger.parseString(amount, 10) + BigInteger.parseString(
                    increment.amount,
                    10
                )).toString()
            )
        } else {
            this
        }
    }

    operator fun minus(increment: Coin): Coin {
        return if (increment.denom == denom) {
            this.copy(
                amount = (BigInteger.parseString(amount, 10) - BigInteger.parseString(
                    increment.amount,
                    10
                )).toString()
            )
        } else {
            this
        }
    }

    operator fun times(increment: Coin): Coin {
        return if (increment.denom == denom) {
            this.copy(
                amount = (BigInteger.parseString(amount, 10) * BigInteger.parseString(
                    increment.amount,
                    10
                )).toString()
            )
        } else {
            this
        }
    }

}