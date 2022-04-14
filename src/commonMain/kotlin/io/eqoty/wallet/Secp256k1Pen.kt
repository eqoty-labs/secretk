package io.eqoty.wallet;

import cash.z.ecc.android.bip39.Mnemonics
import cash.z.ecc.android.bip39.toSeed
import io.eqoty.crypto.Secp256k1
import io.eqoty.crypto.Slip10
import io.eqoty.crypto.Slip10Curve
import io.eqoty.crypto.Slip10RawIndex
import io.eqoty.tx.proto.SignDocProto
import io.eqoty.types.StdSignature
import io.eqoty.utils.getPadded
import io.eqoty.utils.toByteString
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import okio.ByteString.Companion.toByteString


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

enum class PrehashType(val type: String){
  SHA256("sha256"),
  SHA512("sha512")
}

class Secp256k1Pen private constructor(private val privkey: UByteArray, val pubkey: UByteArray) {

  private fun prehash(bytes: UByteArray, type: PrehashType?): UByteArray {
    return when (type) {
      null -> bytes
      PrehashType.SHA256 -> bytes.toByteString().sha256().toByteArray().toUByteArray()
      PrehashType.SHA512 -> bytes.toByteString().sha512().toByteArray().toUByteArray()
    }
  }


  companion object {
    suspend fun fromMnemonic(
      mnemonic: String,
      hdPath:  Array<Slip10RawIndex> = makeSecretNetworkPath(0.toUInt()),
    ): Secp256k1Pen {
      val seed = Mnemonics.MnemonicCode(mnemonic).toSeed().toUByteArray()
      val result = Slip10.derivePath(Slip10Curve.Secp256k1, seed, hdPath)
      val privkey = result.privkey
      val uncompressed = Secp256k1.makeKeypair(privkey).pubkey
      return Secp256k1Pen(privkey, Secp256k1.compressPubkey(uncompressed));
    }
  }


  /**
   * Creates and returns a signature
   */
  fun sign(signBytes: UByteArray, prehashType: PrehashType = PrehashType.SHA256): StdSignature {
    val message = prehash(signBytes, prehashType)
    val signature = Secp256k1.createSignature(message, this.privkey)
    val fixedLengthSignature =  signature.r.getPadded(32) + signature.s.getPadded(32)
    return encodeSecp256k1Signature(this.pubkey, fixedLengthSignature);
  }

  fun signDirect(senderAddress: String, signDoc: SignDocProto): StdSignature {
    val messageHash = ProtoBuf.encodeToByteArray(signDoc).toUByteArray()
    return sign(messageHash)
  }


}
