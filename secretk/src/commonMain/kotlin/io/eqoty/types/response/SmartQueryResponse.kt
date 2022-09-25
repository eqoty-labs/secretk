package io.eqoty.types.response

import kotlinx.serialization.Serializable

@Serializable
class SmartQueryResponse(
    val data: String? = null,
    val code: Int? = null,
    val message: String? = null
)
