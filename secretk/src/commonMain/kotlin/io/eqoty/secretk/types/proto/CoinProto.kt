package io.eqoty.secretk.types.proto

import kotlinx.serialization.protobuf.ProtoNumber

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 */
@kotlinx.serialization.Serializable
data class CoinProto(
    @ProtoNumber(1) val denom: String = "",
    @ProtoNumber(2) val amount: String = ""
)