package io.eqoty.logs

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual

@kotlinx.serialization.Serializable
data class Log(
    @Contextual val msg_index: BigInteger,
    val log: String,
    val events: List<Event>
)