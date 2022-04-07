package io.eqoty.response;

import kotlinx.serialization.Serializable


@Serializable
data class AuthAccountsResult(
        override val type: String = "cosmos-sdk/Account",
        override val value: CosmosSdkAccount
): TypeValue<CosmosSdkAccount>()