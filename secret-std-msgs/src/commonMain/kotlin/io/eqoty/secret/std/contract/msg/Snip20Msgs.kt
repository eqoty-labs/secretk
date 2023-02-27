package io.eqoty.secret.std.contract.msg

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Snip20Msgs {
    @Serializable
    data class Instantiate(
        val name: String,
        val admin: String? = null,
        val symbol: String,
        val decimals: Byte,
        val initial_balances: List<InitialBalance>? = null,
        val prng_seed: String,
        val config: InitConfig? = null,
    ) {
        @Serializable
        data class InitialBalance(
            val address: String,
            val amount: Int,
        )
    }

    @Serializable
    data class Query(
        val balance: Balance? = null,
    ) {
        @Serializable
        data class Balance(
            val address: String,
            val key: String,
        )
    }

    @Serializable
    data class QueryAnswer(
        val balance: Balance? = null,
    ) {
        @Serializable
        data class Balance(
            @Contextual val amount: BigInteger?,
        )

    }

    @Serializable
    data class Execute(
        val deposit: Deposit? = null,
    ) {
        @Serializable
        data class Deposit(
            val padding: String? = null
        )
    }


    @Serializable
    data class InitConfig(
        @SerialName("public_total_supply")
        val publicTotalSupply: Boolean? = null,
        @SerialName("enable_deposit")
        val enableDeposit: Boolean? = null,
        @SerialName("enable_redeem")
        val enableRedeem: Boolean? = null,
        @SerialName("enable_mint")
        val enableMint: Boolean? = null,
        @SerialName("enable_burn")
        val enableBurn: Boolean? = null,
    )

}