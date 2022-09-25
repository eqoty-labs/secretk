package io.eqoty.types.response


@kotlinx.serialization.Serializable
sealed class TypeValue<V> {
    abstract val value: V
}
