package io.eqoty.secretk.types

import io.eqoty.kryptools.bech32.addressToBytes
import io.eqoty.secretk.types.proto.MsgStoreCodeProto
import io.eqoty.secretk.types.proto.ProtoMsg
import io.ktor.util.*

class MsgStoreCode(
    override val sender: String,
    /** WASMByteCode can be raw or gzip compressed */
    val wasmByteCode: UByteArray,
    /** Source is a valid absolute HTTPS URI to the contract's source code, optional */
    val source: String? = null,
    /** Builder is a valid docker image name with tag, optional */
    val builder: String? = null
) : UnencryptedMsg<MsgStoreCodeProto> {


    override suspend fun toProto(): ProtoMsg<MsgStoreCodeProto> {
        // TODO: val wasmByteCode = gzipWasm()
        val msgContent = MsgStoreCodeProto(
            sender = addressToBytes(this.sender),
            wasmByteCode = this.wasmByteCode.asByteArray(),
            source = this.source,
            builder = this.builder,
        )
        return ProtoMsg(
            typeUrl = "/secret.compute.v1beta1.MsgStoreCode",
            value = msgContent
        )
    }

    override suspend fun toAmino(): MsgAmino {
        // TODO: val wasmByteCode = gzipWasm()

        return MsgStoreCodeAmino(
            MsgStoreCodeAminoData(
                sender = sender,
                wasmByteCode = wasmByteCode.asByteArray().encodeBase64(),
                source = source,
                builder = builder
            )
        )
    }
}

