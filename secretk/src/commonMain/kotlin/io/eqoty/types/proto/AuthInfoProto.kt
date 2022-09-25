package io.eqoty.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
@kotlinx.serialization.Serializable
class AuthInfoProto(
    @ProtoNumber(1) val signerInfos: List<SignerInfoProto> = emptyList(),
    @ProtoNumber(2) val fee: FeeProto? = null,
) : MsgProto()