package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber
import kotlinx.serialization.Serializable

@Serializable
class ModeInfoProto(
    @ProtoNumber(1) val single: ModeInfoProtoSingle? = null,
    @ProtoNumber(2) val multi: ModeInfoProtoMulti? = null
): MsgProto()

@Serializable
data class ModeInfoProtoSingle(
    @ProtoNumber(1) val mode: Int = SignMode.UNRECOGNIZED.value
): MsgProto()

@Serializable
data class ModeInfoProtoMulti(
    /*@ProtoNumber(1) val bitarray: CompactBitArray,*/
    @ProtoNumber(2) val modeInfos: String? = null
): MsgProto()

