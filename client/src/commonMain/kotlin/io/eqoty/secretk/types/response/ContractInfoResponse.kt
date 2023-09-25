package io.eqoty.secretk.types.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContractInfoResponse(
    @SerialName("contract_address")
    val contractAddress: String,

    @SerialName("contract_info")
    val contractInfo: ContractInfo
) {

    @Serializable
    data class ContractInfo(
        @SerialName("code_id")
        val codeId: Int,

        val creator: String,

        val label: String,

        val created: CreationInfo,

        @SerialName("ibc_port_id")
        val ibcPortId: String,

        val admin: String,

        @SerialName("admin_proof")
        val adminProof: String
    )

    @Serializable
    data class CreationInfo(
        @SerialName("block_height")
        val blockHeight: String,

        @SerialName("tx_index")
        val txIndex: String
    )
}