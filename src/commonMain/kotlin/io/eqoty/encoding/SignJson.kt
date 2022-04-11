package io.eqoty.encoding

import io.eqoty.response.MsgValue
import io.eqoty.response.TypeValue
import io.eqoty.types.StdFee

@kotlinx.serialization.Serializable
data class SignJson <T: MsgValue> (
        val account_number: String,
        val chain_id: String,
        val fee: StdFee,
        val memo: String,
        val msgs: List<TypeValue<T>>,
        val sequence: String
)
