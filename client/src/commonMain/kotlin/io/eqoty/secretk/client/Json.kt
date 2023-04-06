package io.eqoty.secretk.client

import com.ionspin.kotlin.bignum.serialization.kotlinx.biginteger.bigIntegerhumanReadableSerializerModule
import kotlinx.serialization.json.Json

val Json: Json = Json {
    ignoreUnknownKeys = true
    serializersModule = bigIntegerhumanReadableSerializerModule
}