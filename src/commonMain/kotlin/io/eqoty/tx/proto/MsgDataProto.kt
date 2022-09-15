package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
@kotlinx.serialization.Serializable
class MsgDataProto(
    @ProtoNumber(1) val msgType: String = "",
    @ProtoNumber(2) val data: ByteArray = byteArrayOf(),
) : MsgProto()