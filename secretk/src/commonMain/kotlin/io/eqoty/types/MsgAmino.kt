package io.eqoty.types

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class MsgAmino(
    val type: String,
    val value: MsgAminoValue,
)

@kotlinx.serialization.Serializable
sealed interface MsgAminoValue

@kotlinx.serialization.Serializable
class MsgExecuteContractAmino(
    val sender: String,
    val contract: String,
    val msg: String,
    @SerialName("sent_funds")
    val sentFunds: List<Coin>,
) : MsgAminoValue

@kotlinx.serialization.Serializable
class MsgStoreCodeAmino(
    val sender: String,
    @SerialName("wasm_byte_code")
    val wasmByteCode: String,
    val source: String? = null,
    val builder: String? = null,
) : MsgAminoValue
