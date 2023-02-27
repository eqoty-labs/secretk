package io.eqoty.secret.std.types

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContractInfo(
    val address: String,
    @SerialName("code_hash")
    val codeHash: String
)