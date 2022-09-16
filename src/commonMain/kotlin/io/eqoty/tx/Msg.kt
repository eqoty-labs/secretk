package io.eqoty.tx

import io.eqoty.tx.proto.MsgProto
import io.eqoty.utils.EncryptionUtils

interface Msg<M : MsgProto> {
    suspend fun toProto(utils: EncryptionUtils): ProtoMsg<M>
}

