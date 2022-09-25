package io.eqoty.types

import io.eqoty.types.proto.MsgProto
import io.eqoty.types.proto.ProtoMsg
import io.eqoty.utils.EncryptionUtils
import kotlin.jvm.JvmName

interface Msg<M : MsgProto> {

    // https://youtrack.jetbrains.com/issue/KT-31420
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("toProtoNullable")
    suspend fun toProto(utils: EncryptionUtils?): ProtoMsg<M>

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("toAminoNullable")
    suspend fun toAmino(utils: EncryptionUtils?): MsgAmino
}

interface EncryptedMsg<M : MsgProto> : Msg<M> {
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("toProtoNullable")
    override suspend fun toProto(utils: EncryptionUtils?): ProtoMsg<M> =
        toProto(utils!!)

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("toAminoNullable")
    override suspend fun toAmino(utils: EncryptionUtils?): MsgAmino =
        toAmino(utils!!)

    suspend fun toProto(utils: EncryptionUtils): ProtoMsg<M>
    suspend fun toAmino(utils: EncryptionUtils): MsgAmino
}

interface UnencryptedMsg<M : MsgProto> : Msg<M> {

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("toProtoNullable")
    override suspend fun toProto(utils: EncryptionUtils?): ProtoMsg<M> =
        toProto()

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("toAminoNullable")
    override suspend fun toAmino(utils: EncryptionUtils?): MsgAmino =
        toAmino()

    suspend fun toProto(): ProtoMsg<M>
    suspend fun toAmino(): MsgAmino
}
