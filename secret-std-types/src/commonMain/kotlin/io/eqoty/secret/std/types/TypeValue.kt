package io.eqoty.secret.std.types


@kotlinx.serialization.Serializable
sealed class TypeValue<V> {
    abstract val value: V
}
