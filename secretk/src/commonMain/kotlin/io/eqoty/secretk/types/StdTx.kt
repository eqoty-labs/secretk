package io.eqoty.secretk.types

import io.eqoty.secretk.types.proto.MsgProto
import io.eqoty.secretk.types.response.TypeValue

/** An Amino/Cosmos SDK StdTx */
@kotlinx.serialization.Serializable
data class StdTx<T : MsgProto>(
    val msg: List<TypeValue<T>>,
    val fee: StdFee,
    val signatures: List<StdSignature>,
    val memo: String?
)
