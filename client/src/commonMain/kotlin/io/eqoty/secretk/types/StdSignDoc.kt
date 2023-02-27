package io.eqoty.secretk.types

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class StdSignDoc(
    @SerialName("account_number")
    val accountNumber: String,
    @SerialName("chain_id")
    val chainId: String,
    val fee: StdFee,
    val memo: String,
    val msgs: List<MsgAmino>,
    val sequence: String,
)