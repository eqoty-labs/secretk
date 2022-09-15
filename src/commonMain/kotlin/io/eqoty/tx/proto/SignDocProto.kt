package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
@kotlinx.serialization.Serializable
class SignDocProto(
    @ProtoNumber(1) val bodyBytes: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val authInfoBytes: ByteArray = byteArrayOf(),
    @ProtoNumber(3) val chainId: String = "",
    @ProtoNumber(4) val accountNumber: Int? = null,
    ) : MsgProto()