package io.eqoty.response

import kotlinx.serialization.Serializable

@Serializable
class WasmResponse<T>(
    val height: String,
    val result: T)

@Serializable
class SmartQueryResponse(val smart: String)
