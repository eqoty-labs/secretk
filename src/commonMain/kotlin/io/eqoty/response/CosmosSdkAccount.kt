package io.eqoty.response

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.types.Coin
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("cosmos-sdk/BaseAccount")
data class CosmosSdkAccount(
    /** Bech32 account address */
    val address: String?,
    val coins: List<Coin>? = null,
    /** Bech32 encoded pubkey */
    val public_key: PubKeySecp256k1?,
    @Contextual val account_number: BigInteger?,
    @Contextual val sequence: BigInteger?,
)

@Serializable
data class ProtocolVersion(
    val p2p: String,
    val block: String,
    val app: String,
)

@Serializable
data class NodeInfoOther(
    val tx_index: String,
    val rpc_address: String,
)

@Serializable
data class NodeInfo(
    val protocol_version: ProtocolVersion,
    val id: String,
    val listen_addr: String,
    val network: String,
    val version: String,
    val channels: String,
    val moniker: String,
    val other: NodeInfoOther
)

@Serializable
data class ApplicationVersion(
    val name: String,
    val server_name: String,
    val version: String,
    val commit: String,
    val build_tags: String,
    val go: String,
)