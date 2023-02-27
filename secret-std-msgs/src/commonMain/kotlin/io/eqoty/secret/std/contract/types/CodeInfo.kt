package io.eqoty.secret.std.contract.types

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CodeInfo(
    @SerialName("code_id")
    val codeId: ULong,
    @SerialName("code_hash")
    val codeHash: String,
)