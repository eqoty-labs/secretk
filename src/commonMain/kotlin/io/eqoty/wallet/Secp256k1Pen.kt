package io.eqoty.wallet;

import cash.z.ecc.android.bip39.Mnemonics
import cash.z.ecc.android.bip39.toSeed
import io.eqoty.crypto.Slip10
import io.eqoty.crypto.Slip10Curve
import io.eqoty.crypto.Slip10RawIndex


/**
 * The Cosmoshub derivation path in the form `m/44'/118'/0'/0/a`
 * with 0-based account index `a`.
 * The Secret Network derivation path in the form `m/44'/529'/0'/0/a`
 * with 0-based account index `a`.
 */
fun makeSecretNetworkPath(a: UInt): Array<Slip10RawIndex> = arrayOf(
  Slip10RawIndex.hardened(44.toUInt()),
  Slip10RawIndex.hardened(529.toUInt()),
  Slip10RawIndex.hardened(0.toUInt()),
  Slip10RawIndex.normal(0.toUInt()),
  Slip10RawIndex.normal(a),
)


class Secp256k1Pen private constructor(private val privkey: UByteArray, val pubkey: UByteArray) {


  companion object {
    suspend fun fromMnemonic(
      mnemonic: String,
      hdPath:  Array<Slip10RawIndex> = makeSecretNetworkPath(0.toUInt()),
    ): Secp256k1Pen {
      val seed = Mnemonics.MnemonicCode(mnemonic).toSeed().toUByteArray()
      println(seed.toUByteArray().map { it.toInt() })
      val privkey = Slip10.derivePath(Slip10Curve.Secp256k1, seed, hdPath)
//      println(privkey.map { it.toInt() })

//      val uncompressed =(await Secp256k1 . makeKeypair (privkey)).pubkey;
//      return Secp256k1Pen(privkey, Secp256k1.compressPubkey(uncompressed));
      return TODO()
    }
  }

//
//  /**
//   * Creates and returns a signature
//   */
//  public async sign(signBytes: Uint8Array, prehashType: PrehashType = "sha256"): Promise<StdSignature> {
//    const message = prehash(signBytes, prehashType);
//    const signature = await Secp256k1.createSignature(message, this.privkey);
//    const fixedLengthSignature = new Uint8Array([...signature.r(32), ...signature.s(32)]);
//    return encodeSecp256k1Signature(this.pubkey, fixedLengthSignature);
//  }
}
