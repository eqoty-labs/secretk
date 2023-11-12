package io.eqoty.secretk.client

import com.ionspin.kotlin.bignum.serialization.kotlinx.biginteger.bigIntegerhumanReadableSerializerModule
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy

val Json: Json = Json {
    ignoreUnknownKeys = true
    serializersModule = bigIntegerhumanReadableSerializerModule
    namingStrategy = JsonNamingStrategy.SnakeCase
}