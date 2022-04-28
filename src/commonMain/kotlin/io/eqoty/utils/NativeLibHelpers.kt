package io.eqoty.utils

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

fun JsonElement.toObjectString() = jsonObject.toString()
fun JsonElement.toArrayString() = jsonArray.toString()

fun toString(json: JsonElement) = json.toString()
