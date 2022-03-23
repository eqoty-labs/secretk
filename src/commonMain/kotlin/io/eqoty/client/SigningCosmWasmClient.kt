package io.eqoty.client

import io.eqoty.BroadcastMode
import io.eqoty.utils.SecretUtils

class SigningCosmWasmClient : CosmWasmClient {

    val apiUrl: String
    val senderAddress: String
    val anyValidAddress : String

    constructor(
        apiUrl: String,
        senderAddress: String,
        signer: Any, //SigningCallback | OfflineSigner,
        seed: UByteArray,
//    customFees: Partial<FeeTable>,
        broadcastMode: BroadcastMode = BroadcastMode.Block
    ) : super(apiUrl, seed, broadcastMode) {
        this.apiUrl = apiUrl
        this.senderAddress = senderAddress
        this.anyValidAddress = senderAddress
    }

    constructor(
        apiUrl: String,
        senderAddress: String,
        signer: Any, //SigningCallback | OfflineSigner,
        enigmaUtils: SecretUtils,
//    customFees: Partial<FeeTable>,
        broadcastMode: BroadcastMode = BroadcastMode.Block
    ) : super(apiUrl, null, broadcastMode) {
        this.apiUrl = apiUrl
        this.senderAddress = senderAddress
        this.anyValidAddress = senderAddress
        this.restClient.enigmautils = enigmaUtils;
    }



}