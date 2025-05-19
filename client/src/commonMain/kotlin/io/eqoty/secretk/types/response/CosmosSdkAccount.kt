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
    val txIndex: String,
    val rpcAddress: String,
)

@Serializable
data class NodeInfo(
    val protocolVersion: ProtocolVersion,
    val defaultNodeId: String,
    val listenAddr: String,
    val network: String,
    val version: String,
    val channels: String,
    val moniker: String,
    val other: NodeInfoOther
)

@Serializable
data class ApplicationVersion(
    val name: String,
    val appName: String,
    val version: String,
    val gitCommit: String,
    val buildTags: String,
    val goVersion: String,
)