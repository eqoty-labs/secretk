package io.eqoty.tx

import io.eqoty.tx.proto.MsgStoreCodeProto
import io.eqoty.types.MsgAmino
import io.eqoty.types.MsgStoreCodeAmino
import io.eqoty.utils.addressToBytes
import io.ktor.util.*

class MsgStoreCode(
    val sender: String,
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
            wasmByteCode = this.wasmByteCode.toByteArray(),
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
        val msgContent = MsgStoreCodeAmino(
            sender = sender,
            wasmByteCode = wasmByteCode.toByteArray().encodeBase64(),
            source = source,
            builder = builder
        )

        return MsgAmino(
            type = "wasm/MsgStoreCode",
            value = msgContent
        )
    }
}

