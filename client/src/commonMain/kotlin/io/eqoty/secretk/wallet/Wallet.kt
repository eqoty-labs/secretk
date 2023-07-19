package io.eqoty.secretk.wallet

import io.eqoty.secretk.types.StdSignDoc
import io.eqoty.secretk.types.proto.SignMode

interface Wallet {

    suspend fun getAccount(address: String): AccountData? {
        return getAccounts().find { it.address == address }
    }

    suspend fun getAccounts(): List<AccountData>
    suspend fun getSignMode(): SignMode?

    suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse
}