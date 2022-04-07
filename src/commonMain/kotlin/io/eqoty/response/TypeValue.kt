package io.eqoty.response

@kotlinx.serialization.Serializable
sealed class TypeValue<V> {
    abstract val type: String
    abstract val value: V
}
