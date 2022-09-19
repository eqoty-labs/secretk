package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/CosmWasm/wasmd/blob/main/proto/cosmwasm/wasm/v1/tx.proto
 */
@kotlinx.serialization.Serializable
class MsgInstantiateContractResponseProto(
    @ProtoNumber(1) val address: String,
    @ProtoNumber(2) val data: ByteArray
) : MsgProto()