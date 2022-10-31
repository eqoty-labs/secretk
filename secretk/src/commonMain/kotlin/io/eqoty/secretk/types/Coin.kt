package io.eqoty.secretk.types

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.secretk.types.proto.CoinProto

@kotlinx.serialization.Serializable
data class Coin(
    val amount: String,
    val denom: String
) {
    constructor(denom: String, amount: Int) : this(amount.toString(), denom)
    constructor(denom: String, amount: BigInteger) : this(amount.toString(), denom)

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

    operator fun div(increment: Coin): Coin {
        return if (increment.denom == denom) {
            this.copy(
                amount = (BigInteger.parseString(amount, 10) / BigInteger.parseString(
                    increment.amount,
                    10
                )).toString()
            )
        } else {
            this
        }
    }

}