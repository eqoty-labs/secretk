package io.eqoty.response

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator


@Serializable
@JsonClassDiscriminator("@type")
sealed class V1BetaType




@Serializable
@SerialName("/cosmos.auth.v1beta1.BaseAccount")
data class Account(
    val address: String,
    val pub_key: Secp256k1PubKey?,
    @Contextual val account_number: BigInteger?,
    @Contextual val sequence: BigInteger?
): V1BetaType()


@Serializable
@SerialName("/cosmos.crypto.secp256k1.PubKey")
data class Secp256k1PubKey(val key: String): V1BetaType()