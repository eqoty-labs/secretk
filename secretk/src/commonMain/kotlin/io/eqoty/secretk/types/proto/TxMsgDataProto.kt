package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
@kotlinx.serialization.Serializable
class TxMsgDataProto(
    @ProtoNumber(1) val data: List<MsgDataProto> = emptyList()
) : MsgProto()