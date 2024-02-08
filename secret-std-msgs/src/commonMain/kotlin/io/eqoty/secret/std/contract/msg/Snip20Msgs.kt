package io.eqoty.secret.std.contract.msg

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.secret.std.contract.msg.SnipMsgs.ExecuteAnswer.ResponseStatus
import io.eqoty.secret.std.types.Permit
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
        @SerialName("token_info") val tokenInfo: TokenInfo? = null,
        @SerialName("with_permit") val withPermit: WithPermit? = null,
    ) {
        @Serializable
        data class Balance(
            val address: String,
            val key: String,
        )

        @Serializable
        class TokenInfo

        @Serializable
        data class WithPermit(
            val permit: Permit,
            val query: QueryWithPermit,
        )
    }

    @Serializable
    data class QueryWithPermit(
        val balance: Balance? = null,
    ) {
        @Serializable
        class Balance
    }


    @Serializable
    data class QueryAnswer(
        val balance: Balance? = null, @SerialName("token_info") val tokenInfo: TokenInfo? = null
    ) {
        @Serializable
        data class Balance(
            @Contextual val amount: BigInteger?,
        )

        @Serializable
        data class TokenInfo(
            val name: String,
            val symbol: String,
            val decimals: UByte,
            @Contextual val total_supply: BigInteger? = null,
        )

    }

    @Serializable
    data class Execute(
        val deposit: Deposit? = null,
        val send: Send? = null,
        val transfer: Transfer? = null,
    ) {
        @Serializable
        data class Deposit(
            val padding: String? = null
        )

        @Serializable
        data class Send(
            val recipient: String,
            @SerialName("recipient_code_hash") val recipientCodeHash: String? = null,
            @Contextual val amount: BigInteger,
            val msg: String? = null,
            val memo: String? = null,
            val decoys: List<String>? = null,
            val entropy: String? = null,
            val padding: String? = null,
        )

        @Serializable
        data class Transfer(
            val recipient: String,
            val amount: String,
            val memo: String? = null,
            val padding: String? = null,
        )
    }

    @Serializable
    data class ExecuteAnswer(
        val deposit: Deposit? = null,
        val send: Send? = null,
        val transfer: Transfer? = null,
    ) {

        @Serializable
        data class Deposit(
            val status: ResponseStatus,
        )

        @Serializable
        data class Send(
            val status: ResponseStatus,
        )

        @Serializable
        data class Transfer(
            val status: ResponseStatus,
        )
    }


    @Serializable
    data class InitConfig(
        @SerialName("public_total_supply") val publicTotalSupply: Boolean? = null,
        @SerialName("enable_deposit") val enableDeposit: Boolean? = null,
        @SerialName("enable_redeem") val enableRedeem: Boolean? = null,
        @SerialName("enable_mint") val enableMint: Boolean? = null,
        @SerialName("enable_burn") val enableBurn: Boolean? = null,
    )

}