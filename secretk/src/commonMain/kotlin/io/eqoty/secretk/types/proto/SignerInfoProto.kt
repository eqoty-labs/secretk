package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/cosmwasm/enclaves/execute/proto/cosmos/tx/v1beta1/tx.proto
 */
@kotlinx.serialization.Serializable
class SignerInfoProto(
    @ProtoNumber(1) val publicKey: AnyProto? = null,
    @ProtoNumber(2) val modeInfo: ModeInfoProto? = null,
    @ProtoNumber(3) val sequence: Int? = null,
) : MsgProto()