package io.eqoty.cosmwasm.std.types

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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