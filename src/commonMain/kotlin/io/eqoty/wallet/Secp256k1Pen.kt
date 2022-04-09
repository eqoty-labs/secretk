package io.eqoty.wallet;

import cash.z.ecc.android.bip39.Mnemonics
import cash.z.ecc.android.bip39.toSeed
import io.eqoty.crypto.Slip10
import io.eqoty.crypto.Slip10Curve
import io.eqoty.crypto.Slip10RawIndex
import io.eqoty.types.StdSignature


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

expect object Secp256k1 {
  fun pubkeyCreate(privkey: UByteArray): UByteArray
  fun pubKeyCompress(pubkey: UByteArray): UByteArray
}

class Secp256k1Pen private constructor(private val privkey: UByteArray, val pubkey: UByteArray) {


  companion object {
    suspend fun fromMnemonic(
      mnemonic: String,
      hdPath:  Array<Slip10RawIndex> = makeSecretNetworkPath(0.toUInt()),
    ): Secp256k1Pen {
      val seed = Mnemonics.MnemonicCode(mnemonic).toSeed().toUByteArray()
      val result = Slip10.derivePath(Slip10Curve.Secp256k1, seed, hdPath)
      val privkey = result.privkey
      val uncompressed = Secp256k1.pubkeyCreate(privkey)
      return Secp256k1Pen(privkey, Secp256k1.pubKeyCompress(uncompressed));
    }
  }


  /**
   * Creates and returns a signature
   */
  fun sign(signBytes: UByteArray, prehashType: Any = Unit /*PrehashType = "sha256"*/): StdSignature {
    TODO()
//    val message = prehash(signBytes, prehashType);
//    val signature = await Secp256k1.createSignature(message, this.privkey);
//    val fixedLengthSignature = new Uint8Array([...signature.r(32), ...signature.s(32)]);
//    return encodeSecp256k1Signature(this.pubkey, fixedLengthSignature);
  }
}
