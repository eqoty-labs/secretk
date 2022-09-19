package io.eqoty.response

import kotlinx.serialization.Serializable

@Serializable
class NodeInfoResponse(
    val node_info: NodeInfo,
    val application_version: ApplicationVersion
)
