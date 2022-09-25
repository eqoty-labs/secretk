package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/CosmWasm/wasmd/blob/main/proto/cosmwasm/wasm/v1/tx.proto
 */
@kotlinx.serialization.Serializable
class MsgStoreCodeResponseProto(
    @ProtoNumber(1) val codeId: Int
) : MsgProto()