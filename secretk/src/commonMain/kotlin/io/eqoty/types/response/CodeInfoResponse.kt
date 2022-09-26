package io.eqoty.types.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CodeInfoResponse(
    @SerialName("code_info")
    val codeInfo: CodeInfo,
) {
    @Serializable
    class CodeInfo(
        @SerialName("code_id")
        val codeId: String,
        val creator: String,
        @SerialName("code_hash")
        val codeHash: String,
        val source: String,
        val builder: String,
    )
}
