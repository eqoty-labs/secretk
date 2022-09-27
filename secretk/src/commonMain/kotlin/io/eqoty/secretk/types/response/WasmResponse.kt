package io.eqoty.secretk.types.response

import kotlinx.serialization.Serializable

@Serializable
data class WasmResponse<R>(
    val height: String,
    val result: R
)