package io.eqoty.secretk.types.response

import kotlinx.serialization.Serializable

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