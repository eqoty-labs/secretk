package io.eqoty.secretk.types.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class BlockResponse(
    val blockId: BlockId,
    val block: Block
)

@Serializable
data class BlockId(
    val hash: String,
    val partSetHeader: PartSetHeader
)

@Serializable
data class PartSetHeader(
    val total: Int,
    val hash: String
)

@Serializable
data class Block(
    val header: Header,
    val data: Data,
//    val evidence: Evidence,
    val lastCommit: LastCommit
)

@Serializable
data class Header(
    val version: Version,
    val chainId: String,
    val height: String,
    val time: String,
    val lastBlockId: BlockId,
    val lastCommitHash: String,
    val dataHash: String,
    val validatorsHash: String,
    val nextValidatorsHash: String,
    val consensusHash: String,
    val appHash: String,
    val lastResultsHash: String,
    val evidenceHash: String,
    val proposerAddress: String,
    val encryptedRandom: EncryptedRandom
)

@Serializable
data class Version(
    val block: String,
    val app: String
)

@Serializable
data class EncryptedRandom(
    val random: String,
    val proof: String
)

@Serializable
data class Data(
    val txs: List<String>
)

//@Serializable
//data class Evidence(
//    val evidence: List<Any>
//)

@Serializable
data class LastCommit(
    val height: String,
    val round: Int,
    val blockId: BlockId,
    val signatures: List<Signature>
)

@Serializable
data class Signature(
    val blockIdFlag: String,
    val validatorAddress: String?,
    val timestamp: String,
    val signature: String?,
)
