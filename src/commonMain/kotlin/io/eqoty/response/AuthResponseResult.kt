package io.eqoty.response;

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable


@Serializable
data class AuthResponseResult(
        val address: String,
        val public_key: PubKey,
        @Contextual val account_number: BigInteger?,
        @Contextual val sequence: BigInteger?
)