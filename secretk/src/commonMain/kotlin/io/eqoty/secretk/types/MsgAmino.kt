package io.eqoty.secretk.types

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
sealed interface MsgAmino

@kotlinx.serialization.Serializable
@SerialName("wasm/MsgExecuteContract")
class MsgExecuteContractAmino(
    val value: MsgExecuteContractAminoData,
) : MsgAmino


@kotlinx.serialization.Serializable
@SerialName("wasm/MsgStoreCode")
class MsgStoreCodeAmino(
    val value: MsgStoreCodeAminoData,
) : MsgAmino

@kotlinx.serialization.Serializable
class MsgExecuteContractAminoData(
    val sender: String,
    val contract: String,
    val msg: String,
    @SerialName("sent_funds")
    val sentFunds: List<Coin>,
)

@kotlinx.serialization.Serializable
class MsgStoreCodeAminoData(
    val sender: String,
    @SerialName("wasm_byte_code")
    val wasmByteCode: String,
    val source: String? = null,
    val builder: String? = null,
)
