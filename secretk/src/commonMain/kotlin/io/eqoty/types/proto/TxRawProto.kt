package io.eqoty.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
@kotlinx.serialization.Serializable
class TxRawProto(
    @ProtoNumber(1) val bodyBytes: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val authInfoBytes: ByteArray = byteArrayOf(),
    @ProtoNumber(3) val signatures: List<ByteArray> = emptyList(),
) : MsgProto()