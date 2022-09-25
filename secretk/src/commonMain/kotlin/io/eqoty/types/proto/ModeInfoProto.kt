package io.eqoty.types.proto

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
@Serializable
class ModeInfoProto(
    @ProtoNumber(1) val single: ModeInfoProtoSingle? = null,
    @ProtoNumber(2) val multi: ModeInfoProtoMulti? = null
) : MsgProto()

@Serializable
data class ModeInfoProtoSingle(
    @ProtoNumber(1) val mode: Int = SignMode.UNRECOGNIZED.value
) : MsgProto()

@Serializable
data class ModeInfoProtoMulti(
    /*@ProtoNumber(1) val bitarray: CompactBitArray,*/
    @ProtoNumber(2) val modeInfos: String? = null
) : MsgProto()

