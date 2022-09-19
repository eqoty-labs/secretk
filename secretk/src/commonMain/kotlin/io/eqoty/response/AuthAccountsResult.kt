package io.eqoty.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@SerialName("cosmos-sdk/BaseAccount")
data class AuthAccountsResult(
    override val value: CosmosSdkAccount
) : TypeValue<CosmosSdkAccount>()