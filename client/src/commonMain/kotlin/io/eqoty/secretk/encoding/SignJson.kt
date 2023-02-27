package io.eqoty.secretk.encoding

import io.eqoty.secret.std.types.TypeValue
import io.eqoty.secretk.types.StdFee

@kotlinx.serialization.Serializable
data class SignJson<T>(
    val account_number: String,
    val chain_id: String,
    val fee: StdFee,
    val memo: String,
    val msgs: List<TypeValue<T>>,
    val sequence: String
)
