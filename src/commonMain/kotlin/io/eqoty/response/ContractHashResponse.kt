package io.eqoty.response;

import kotlinx.serialization.Serializable

@Serializable
data class ContractHashResponse(
        val height: String,
        val result: String
)