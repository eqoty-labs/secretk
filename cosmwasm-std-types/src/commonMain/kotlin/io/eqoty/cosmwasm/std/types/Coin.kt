package io.eqoty.cosmwasm.std.types

import com.ionspin.kotlin.bignum.integer.BigInteger

@kotlinx.serialization.Serializable
data class Coin(
    val amount: String,
    val denom: String
) {
    constructor(amount: Int, denom: String) : this(amount.toString(), denom)
    constructor(amount: BigInteger, denom: String) : this(amount.toString(), denom)

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

    operator fun plus(increment: BigInteger): Coin {
        return this.copy(
            amount = (BigInteger.parseString(amount, 10) + increment).toString()
        )
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

    operator fun minus(increment: BigInteger): Coin {
        return this.copy(
            amount = (BigInteger.parseString(amount, 10) - increment).toString()
        )
    }

    operator fun times(other: Coin): Coin {
        return if (other.denom == denom) {
            this.copy(
                amount = (BigInteger.parseString(amount, 10) * BigInteger.parseString(
                    other.amount,
                    10
                )).toString()
            )
        } else {
            this
        }
    }

    operator fun times(other: BigInteger): Coin {
        return this.copy(
            amount = (BigInteger.parseString(amount, 10) * other).toString()
        )
    }

    operator fun div(other: Coin): Coin {
        return if (other.denom == denom) {
            this.copy(
                amount = (BigInteger.parseString(amount, 10) / BigInteger.parseString(
                    other.amount,
                    10
                )).toString()
            )
        } else {
            this
        }
    }

    operator fun div(other: BigInteger): Coin {
        return this.copy(
            amount = (BigInteger.parseString(amount, 10) / other).toString()
        )
    }

    operator fun rem(other: Coin): Coin {
        return if (other.denom == denom) {
            this.copy(
                amount = (BigInteger.parseString(amount, 10) % BigInteger.parseString(
                    other.amount,
                    10
                )).toString()
            )
        } else {
            this
        }
    }

    operator fun rem(other: BigInteger): Coin {
        return this.copy(
            amount = (BigInteger.parseString(amount, 10) % other).toString()
        )
    }
}