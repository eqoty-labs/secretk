package io.eqoty.types

import io.eqoty.tx.proto.CoinProto
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class MsgAmino(
    val type: String,
    val value: MsgExecuteContractAmino,
) {
    @kotlinx.serialization.Serializable
    class MsgExecuteContractAmino(
        val sender: String,
        val contract: String,
        val msg: String,
        @SerialName("sent_funds") val sentFunds: List<Coin>,
    )
}