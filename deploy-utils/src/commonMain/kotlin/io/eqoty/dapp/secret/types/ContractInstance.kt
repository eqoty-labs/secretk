package io.eqoty.dapp.secret.types

import io.eqoty.cosmwasm.std.types.CodeInfo
import kotlinx.serialization.Serializable

@Serializable
data class ContractInstance(val codeInfo: CodeInfo, val address: String)
