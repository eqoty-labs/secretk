package io.eqoty.secretk.types.response

import kotlinx.serialization.Serializable

@Serializable
class NodeInfoResponse(
    val defaultNodeInfo: NodeInfo,
    val applicationVersion: ApplicationVersion
)
