package io.eqoty.tx.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/compute/v1beta1/msg.ts
 */
@kotlinx.serialization.Serializable
class MsgExecuteContractProto(
    @ProtoNumber(1) val sender: ByteArray = byteArrayOf(),
    @ProtoNumber(2) val contract: ByteArray = byteArrayOf(),
    @ProtoNumber(3) val msg: ByteArray = byteArrayOf(),
    @ProtoNumber(4) val callbackCodeHash: String?,
    @ProtoNumber(5) val sentFunds: List<CoinProto> = emptyList(),
    /**
     * todo: figure out why adding callbackSig in with a empty byte array causes it to add two additional bytes after
     * encoding and causes verify transaction signature to fail
     *
     * PostTxResult(logs=[], rawLog=failed to execute message; message index: 0: Execution error:
     * Enclave: failed to verify transaction signature: execute contract failed,
     * data=, transactionHash=DD45DDD696CA1F75B9FB3EA3CEC50ED0ABBD247506D52A797479651D2B1737A7)
     */
//    @ProtoNumber(6) val callbackSig: ByteArray = byteArrayOf()
) : MsgProto()