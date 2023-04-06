package io.eqoty.secret.std.contract.msg

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object SnipMsgs {
    @Serializable
    data class Execute(
        @SerialName("create_viewing_key") val createViewingKey: CreateViewingKey? = null,
    ) {
        @Serializable
        data class CreateViewingKey(
            val entropy: String,
            val padding: String? = null,
        )
    }


    @Serializable
    data class ExecuteAnswer(
        @SerialName("viewing_key") val viewingKey0: ViewingKey? = null,
        @SerialName("create_viewing_key") val viewingKey1: ViewingKey? = null,
    ) {
        val viewingKey: ViewingKey? = viewingKey0 ?: viewingKey1

        enum class ResponseStatus {
            success, failure
        }

        @Serializable
        data class ViewingKey(val key: String)
    }
}