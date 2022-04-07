package io.eqoty.encoding

import io.eqoty.types.Msg
import io.eqoty.types.MsgValue
import io.eqoty.types.StdFee

class SignJson <T:MsgValue> (
        val account_number: String,
        val chain_id: String,
        val fee: StdFee,
        val memo: String,
        val msgs: List<Msg<T>>,
        val sequence: String
)
