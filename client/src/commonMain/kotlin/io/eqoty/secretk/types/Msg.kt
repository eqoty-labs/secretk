package io.eqoty.secretk.types

import io.eqoty.secretk.types.proto.MsgProto
import io.eqoty.secretk.types.proto.ProtoMsg
import io.eqoty.secretk.utils.EncryptionUtils
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

    fun getMissingParameterWarning(method: String, parameter: String): String =
        """${method} was used without the "codeHash" parameter. 
            |This is discouraged and will result in much slower execution times for your app.""".trimMargin()

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