package io.eqoty.wallet

import cash.z.ecc.android.bip39.Mnemonics
import cash.z.ecc.android.bip39.toSeed
import io.eqoty.crypto.Secp256k1
import io.eqoty.crypto.Slip10
import io.eqoty.crypto.Slip10Curve
import io.eqoty.crypto.Slip10RawIndex
import io.eqoty.types.StdSignDoc
import io.eqoty.types.StdSignature
import io.eqoty.types.proto.SignDocProto
import io.eqoty.types.proto.SignMode
import io.eqoty.utils.Address.pubkeyToAddress
import io.eqoty.utils.getPadded
import io.eqoty.utils.toByteString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


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

enum class PrehashType(val type: String) {
    SHA256("sha256"),
    SHA512("sha512")
}

interface Wallet {
    suspend fun getSignMode(): SignMode?
    suspend fun getAccounts(): List<AccountData>
    suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse
}

sealed class BaseWallet(
    mnemonic: String,
    hdPath: Array<Slip10RawIndex> = makeSecretNetworkPath(0.toUInt()),
    bech32Prefix: String = "secret"
) : Wallet {

    private val privkey: UByteArray
    private val pubkey: UByteArray
    protected var address: String

    init {
        val seed = Mnemonics.MnemonicCode(mnemonic).toSeed().toUByteArray()
        val result = Slip10.derivePath(Slip10Curve.Secp256k1, seed, hdPath)
        privkey = result.privkey
        val uncompressed = Secp256k1.makeKeypair(privkey).pubkey
        pubkey = Secp256k1.compressPubkey(uncompressed)
        address = pubkeyToAddress(encodeSecp256k1Pubkey(pubkey), bech32Prefix)
    }

    /**
     * Get AccountData array from wallet. Rejects if not enabled.
     */
    override suspend fun getAccounts(): List<AccountData> = listOf(
        AccountData(
            address,
            Algo.secp256k1,
            pubkey
        )
    )

    val accounts: List<AccountData> = listOf(
        AccountData(
            address,
            Algo.secp256k1,
            pubkey
        )
    )

    private fun prehash(bytes: UByteArray, type: PrehashType?): UByteArray {
        return when (type) {
            null -> bytes
            PrehashType.SHA256 -> bytes.toByteString().sha256().toByteArray().toUByteArray()
            PrehashType.SHA512 -> bytes.toByteString().sha512().toByteArray().toUByteArray()
        }
    }


    /**
     * Creates and returns a signature
     */
    fun sign(signBytes: UByteArray, prehashType: PrehashType = PrehashType.SHA256): StdSignature {
        val messageHash = prehash(signBytes, prehashType)
        val signature = Secp256k1.createSignature(messageHash, this.privkey)
        val fixedLengthSignature = signature.r.getPadded(32) + signature.s.getPadded(32)
        return encodeSecp256k1Signature(this.pubkey, fixedLengthSignature)
    }

    override suspend fun signAmino(signerAddress: String, signDoc: StdSignDoc): AminoSignResponse {
        if (signerAddress != this.address) {
            throw Error("Address $signerAddress not found in wallet")
        }

        val signBytes = Json.encodeToString(signDoc).encodeToByteArray().toUByteArray()
        return AminoSignResponse(
            signed = signDoc,
            signature = sign(signBytes)
        )
    }
}


data class SignResponse(
    /**
     * The sign doc that was signed.
     * This may be different from the input signDoc when the signer modifies it as part of the signing process.
     */
    val signed: SignDocProto,
    val signature: StdSignature
)