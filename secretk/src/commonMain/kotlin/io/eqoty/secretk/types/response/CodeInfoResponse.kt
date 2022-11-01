package io.eqoty.secretk.types.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CodeInfoResponse(
    @SerialName("code_info")
    val codeInfo: CodeInfo,
) {
    @Serializable
    data class CodeInfo(
        @SerialName("code_id")
        val codeId: String,
        val creator: String,
        @SerialName("code_hash")
        val codeHash: String,
        val source: String,
        val builder: String,
    )
}
