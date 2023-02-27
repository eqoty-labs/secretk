package io.eqoty.secretk.types

import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.secret.std.types.Permission
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
sealed interface MsgAmino

@kotlinx.serialization.Serializable
@SerialName("wasm/MsgExecuteContract")
class MsgExecuteContractAmino(
    val value: MsgExecuteContractAminoData,
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
@SerialName("wasm/MsgStoreCode")
class MsgStoreCodeAmino(
    val value: MsgStoreCodeAminoData,
) : MsgAmino

@kotlinx.serialization.Serializable
class MsgStoreCodeAminoData(
    val sender: String,
    @SerialName("wasm_byte_code")
    val wasmByteCode: String,
    val source: String? = null,
    val builder: String? = null,
)

@kotlinx.serialization.Serializable
@SerialName("query_permit")
class MsgQueryPermitAmino(
    val value: MsgQueryPermitAminoData,
) : MsgAmino

@Serializable
data class MsgQueryPermitAminoData(
    @SerialName("allowed_tokens")
    val allowedTokens: List<String>,
    val permissions: List<Permission>,
    @SerialName("permit_name")
    val permitName: String,
)
