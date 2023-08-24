package io.eqoty.dapp.secret.utils

import io.eqoty.dapp.secret.utils.Constants.GITPOD_ID_ENV_NAME
import io.eqoty.dapp.secret.utils.Constants.NODE_TYPE_ENV_NAME
import io.getenv
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okio.Path
import okio.Path.Companion.toPath

@Serializable
sealed interface NodeInfo {
    val type: String
    val chainId: String
    val grpcGatewayEndpoint: String
    val faucetAddressEndpoint: String?
    fun createFaucetAddressGetEndpoint(address: String) = faucetAddressEndpoint + address
}

@Serializable
@SerialName("LocalSecret")
data class LocalSecret(
    override val type: String,
    override val chainId: String,
    override val grpcGatewayEndpoint: String,
    override val faucetAddressEndpoint: String,
) : NodeInfo

@Serializable
@SerialName("Pulsar2")
@Deprecated("Use Pulsar3 instead")
data class Pulsar2(
    override val type: String,
    override val chainId: String,
    override val grpcGatewayEndpoint: String,
    override val faucetAddressEndpoint: String,
) : NodeInfo

@Serializable
@SerialName("Pulsar3")
data class Pulsar3(
    override val type: String,
    override val chainId: String,
    override val grpcGatewayEndpoint: String,
    override val faucetAddressEndpoint: String,
) : NodeInfo

data class Gitpod(
    val gitpodId: String,
) : NodeInfo {
    override val type: String = "Gitpod"
    override val chainId = "secretdev-1"
    override val grpcGatewayEndpoint: String = "https://1317-$gitpodId.gitpod.io"
    override val faucetAddressEndpoint: String =
        "https://5000-$gitpodId.gitpod.io/faucet?address=".replace("\$gitpodId", gitpodId)
}

@Serializable
@SerialName("Secret4")
data class Secret4(
    override val type: String,
    override val chainId: String,
    override val grpcGatewayEndpoint: String,
    override val faucetAddressEndpoint: String? = null,
) : NodeInfo

@Serializable
@SerialName("Custom")
data class Custom(
    override val type: String,
    override val chainId: String,
    override val grpcGatewayEndpoint: String,
    override val faucetAddressEndpoint: String,
) : NodeInfo

@Serializable
data class ConfigNodes(val nodes: List<NodeInfo>)

fun getNode(nodesJsonPath: String): NodeInfo {
    val nodes: Path = nodesJsonPath.toPath()
    val jsonString = fileSystem.read(nodes) {
        readUtf8()
    }
    val config: ConfigNodes = Json.decodeFromString(jsonString)
    val nodeType = getenv(NODE_TYPE_ENV_NAME)
    return if (nodeType == "Gitpod") {
        val gitpodId = try {
            getenv(GITPOD_ID_ENV_NAME)!!
        } catch (t: Throwable) {
            throw RuntimeException(
                "GITPOD_ID environment variable not found. GITPOD_ID Should be set " +
                        "in local.properties or directly as an environment variable."
            )
        }
        Gitpod(gitpodId)
    } else {
        config.nodes.first { it.type == nodeType }
    }
}
