package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber
/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
@kotlinx.serialization.Serializable
class SignerInfoProto(
    @ProtoNumber(1) val publicKey: AnyProto? = null,
    @ProtoNumber(2) val modeInfo: ModeInfoProto? = null,
    @ProtoNumber(3) val sequence: Int? = null,
    ) : MsgProto()