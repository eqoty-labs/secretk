package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
@kotlinx.serialization.Serializable
class MsgStoreCodeProto(
    // sender is the canonical address of the sender
    @ProtoNumber(1) val sender: ByteArray,
    // WASMByteCode can be raw or gzip compressed
    @ProtoNumber(2) val wasmByteCode: ByteArray,
    // Source is a valid absolute HTTPS URI to the contract's source code, optional
    @ProtoNumber(3) val source: String? = null,
    // Builder is a valid docker image name with tag, optional
    @ProtoNumber(4) val builder: String? = null
) : MsgProto()