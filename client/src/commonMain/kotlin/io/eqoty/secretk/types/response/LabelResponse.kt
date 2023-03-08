package io.eqoty.secretk.types.response

import kotlinx.serialization.Serializable

@Serializable
data class LabelResponse(
    val label: String,
)