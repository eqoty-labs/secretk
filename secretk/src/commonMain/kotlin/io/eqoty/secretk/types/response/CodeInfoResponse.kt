package io.eqoty.secretk.types.response

import io.eqoty.cosmwasm.std.types.CodeInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CodeInfoResponse(
    @SerialName("code_info")
    val codeInfo: CodeInfo,
)