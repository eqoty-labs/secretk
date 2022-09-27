package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/registration/v1beta1/msg.ts
 */
@kotlinx.serialization.Serializable
class KeyProto(
    @ProtoNumber(1) val key: ByteArray? = null,
) : MsgProto()