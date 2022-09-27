package io.eqoty.secretk.types.response


@kotlinx.serialization.Serializable
sealed class TypeValue<V> {
    abstract val value: V
}
