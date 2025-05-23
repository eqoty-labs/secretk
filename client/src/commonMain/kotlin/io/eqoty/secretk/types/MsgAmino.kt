package io.eqoty.secretk.types

import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.secret.std.types.Permission
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface MsgAmino

@Serializable
@SerialName("wasm/MsgMigrateContract")
class MsgMigrateContractAmino(
    val value: MsgMigrateContractAminoData,
) : MsgAmino

@Serializable
class MsgMigrateContractAminoData(
    val sender: String,
    val contract: String,
    val msg: String,
    @SerialName("code_id")
    val codeId: Int,
)

@Serializable
@SerialName("wasm/MsgUpdateAdmin")
class MsgUpdateAdminAmino(
    val value: MsgUpdateAdminAminoData,
) : MsgAmino

@Serializable
class MsgUpdateAdminAminoData(
    val sender: String,
    @SerialName("new_admin")
    val newAdmin: String,
    val contract: String,
)

@Serializable
@SerialName("wasm/MsgClearAdmin")
class MsgClearAdminAmino(
    val value: MsgClearAdminAminoData,
) : MsgAmino

@Serializable
class MsgClearAdminAminoData(
    val sender: String,
    val contract: String,
)

@Serializable
@SerialName("wasm/MsgExecuteContract")
class MsgExecuteContractAmino(
    val value: MsgExecuteContractAminoData,
) : MsgAmino

@Serializable
class MsgExecuteContractAminoData(
    val sender: String,
    val contract: String,
    val msg: String,
    @SerialName("sent_funds")
    val sentFunds: List<Coin>,
)

@Serializable
@SerialName("wasm/MsgStoreCode")
class MsgStoreCodeAmino(
    val value: MsgStoreCodeAminoData,
) : MsgAmino

@Serializable
class MsgStoreCodeAminoData(
    val sender: String,
    @SerialName("wasm_byte_code")
    val wasmByteCode: String,
    val source: String? = null,
    val builder: String? = null,
)

@Serializable
@SerialName("cosmos-sdk/MsgSend")
class MsgSendAmino(
    val value: MsgSendAminoData,
) : MsgAmino

@Serializable
class MsgSendAminoData(
    @SerialName("from_address")
    val fromAddress: String,
    @SerialName("to_address")
    val toAddress: String,
    val amount: List<Coin>,
)


@Serializable
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
