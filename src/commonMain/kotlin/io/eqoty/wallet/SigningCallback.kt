package io.eqoty.wallet

import io.eqoty.types.StdSignature

typealias SigningCallback = (UByteArray) -> StdSignature

interface OfflineSigner {
//  /**
//   * Get AccountData array from wallet. Rejects if not enabled.
//   */
//  readonly getAccounts: () => Promise<readonly AccountData[]>;
//
//  /**
//   * Request signature from whichever key corresponds to provided bech32-encoded address. Rejects if not enabled.
//   */
//  readonly sign: (signerAddress: string, signDoc: StdSignDoc) => Promise<SignResponse>;
}