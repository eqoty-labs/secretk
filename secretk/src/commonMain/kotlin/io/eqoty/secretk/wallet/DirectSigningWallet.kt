package io.eqoty.secretk.wallet

import io.eqoty.secretk.types.proto.SignDocProto
import io.eqoty.secretk.types.proto.SignMode
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf


class DirectSigningWallet(
    mnemonic: String?,
) : BaseWallet(mnemonic) {

    // helper constructor for swift
    constructor() : this(null)

    override suspend fun getSignMode(): SignMode? = null

    fun signDirect(signerAddress: String, signDoc: SignDocProto): SignResponse {
        val signBytes = ProtoBuf.encodeToByteArray(signDoc).toUByteArray()
        return SignResponse(
            signed = signDoc,
            signature = sign(signerAddress, signBytes)
        )
    }

}