package io.eqoty.types

@kotlinx.serialization.Serializable
sealed class Msg<T: MsgValue> (
    val type: String,
    val value: T
)

/** A Cosmos SDK token transfer message */
class MsgSend(value: MsgSendValue) : Msg<MsgSendValue> ("cosmos-sdk/MsgSend", value)

/**
 * Uploads Wam code to the chain
 *
 * @see https://github.com/cosmwasm/wasmd/blob/9842678d89/x/wasm/internal/types/msg.go#L17
 */
class MsgStoreCode(value: MsgStoreCodeValue) : Msg<MsgStoreCodeValue> ("wasm/MsgStoreCode", value)

/**
 * Creates an instance of contract that was uploaded before.
 *
 * @see https://github.com/cosmwasm/wasmd/blob/9842678d89/x/wasm/internal/types/msg.go#L73
 */
class MsgInstantiateContract(value: MsgInstantiateContractValue) : Msg<MsgInstantiateContractValue> ("wasm/MsgInstantiateContract", value)

/**
 * Creates an instance of contract that was uploaded before.
 *
 * @see https://github.com/cosmwasm/wasmd/blob/9842678d89/x/wasm/internal/types/msg.go#L103
 */
class MsgExecuteContract(value: MsgExecuteContractValue) : Msg<MsgExecuteContractValue> ("wasm/MsgExecuteContract", value)

sealed interface MsgValue

data class MsgSendValue(
    /** Bech32 account address */
    val from_address: String,
    /** Bech32 account address */
    val to_address: String,
    val amount: Array<Coin>
): MsgValue

data class MsgStoreCodeValue(
    /** Bech32 account address */
    val sender: String,
    /** Base64 encoded Wasm */
    val wasm_byte_code: String,
    /** A valid URI reference to the contract's source code. Can be empty. */
    val source: String?,
    /** A docker tag. Can be empty. */
    val builder: String?
): MsgValue

data class MsgInstantiateContractValue(
    /** Bech32 account address */
    val sender: String,
    /** ID of the Wasm code that was uploaded before */
    val code_id: String,
    /** Human-readable label for this contract */
    val label: String,
    /** Init message as JavaScript object */
    val init_msg: Any,
    val init_funds: List<Coin>
): MsgValue

data class MsgExecuteContractValue(
    /** Bech32 account address */
    val sender: String,
    /** Bech32 account address */
    val contract: String,
    // /** callback_code_hash should always be an empty String when coming from the user */
    // val callback_code_hash: String;
    /** Handle message as JavaScript object */
    val msg: String,
    val sent_funds: List<Coin>,
    // val callback_sig: Any;
): MsgValue

