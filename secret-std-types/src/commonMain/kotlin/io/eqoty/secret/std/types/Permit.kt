package io.eqoty.secret.std.types

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Permit(
    val params: Params,
    val signature: StdSignature
) {
    @Serializable
    data class Params(
        @SerialName("permit_name")
        val permitName: String,
        @SerialName("allowed_tokens")
        val allowedTokens: List<String>,
        @SerialName("chain_id")
        val chainId: String,
        val permissions: List<Permission>
    )
}

@Serializable
enum class Permission {
    @SerialName("owner")
    Owner,
    @SerialName("history")
    History,
    @SerialName("balance")
    Balance,
    @SerialName("allowance")
    Allowance,
}