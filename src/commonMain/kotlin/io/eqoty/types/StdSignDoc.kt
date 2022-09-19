package io.eqoty.types

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class StdSignDoc(
    @SerialName("chain_id")
    val chainId: String,
    @SerialName("account_number")
    val accountNumber: String,
    val sequence: String,
    val fee: StdFee,
    val msgs: List<MsgAmino>,
    val memo: String,
)