package io.eqoty.utils

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

fun JsonElement.toObjectString(): String {
    val jsonObj = jsonObject
    return jsonObj.toString()
}
fun JsonElement.toArrayString(): String {
    val jsonArray = jsonArray
    return jsonArray.toString()
}
fun JsonElement.toString(): String {
    return toString()
}

fun toString(json: JsonElement) = json.toString()
