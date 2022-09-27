package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
@kotlinx.serialization.Serializable
class TxBodyProto(
    @ProtoNumber(1) val messages: List<AnyProto> = emptyList(),
    @ProtoNumber(2) val memo: String = "",
    @ProtoNumber(3) val timeoutHeight: String = "0",
    @ProtoNumber(1023) val extensionOptions: List<AnyProto> = emptyList(),
    @ProtoNumber(2047) val nonCriticalExtensionOptions: List<AnyProto> = emptyList(),
) : MsgProto()