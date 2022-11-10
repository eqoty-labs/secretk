package io.eqoty.secretk.utils

import io.eqoty.kryptools.bech32.Bech32
import io.eqoty.secretk.types.response.PubKey
import io.eqoty.secretk.types.response.PubKeyEd25519
import io.eqoty.secretk.types.response.PubKeySecp256k1
import io.eqoty.secretk.types.response.PubKeySr25519
import okio.ByteString.Companion.decodeBase64
import org.komputing.khash.ripemd160.extensions.digestRipemd160

object Address {
    fun rawSecp256k1PubkeyToAddress(pubkeyRaw: UByteArray, prefix: String): String {
        if (pubkeyRaw.size != 33) {
            throw Error("Invalid Secp256k1 pubkey length (compressed): ${pubkeyRaw.size}")
        }
        val hash1 = pubkeyRaw.toByteString().sha256().toByteArray()
        val hash2 = hash1.digestRipemd160()
        return Bech32.encode(Bech32.Encoding.BECH32, prefix, hash2)
    }

    // See https://github.com/tendermint/tendermint/blob/f2ada0a604b4c0763bda2f64fac53d506d3beca7/docs/spec/blockchain/encoding.md#public-key-cryptography
// This assumes we already have a cosmos-compressed pubkey
    fun pubkeyToAddress(pubkey: PubKey, prefix: String): String {
        val pubkeyBytes = pubkey.value.decodeBase64()!!.toUByteArray()
        when (pubkey) {
            is PubKeySecp256k1 -> {
                return rawSecp256k1PubkeyToAddress(pubkeyBytes, prefix)
            }

            is PubKeyEd25519 -> {
                if (pubkeyBytes.size != 32) {
                    throw Error("Invalid Ed25519 pubkey length: ${pubkeyBytes.size}")
                }
                val hash = pubkeyBytes.toByteString().sha256().toByteArray()
                return Bech32.encode(Bech32.Encoding.BECH32, prefix, hash.slice(IntRange(0, 19)).toByteArray())
            }

            is PubKeySr25519 -> {
                if (pubkeyBytes.size != 32) {
                    throw Error("Invalid Sr25519 pubkey length: ${pubkeyBytes.size}")
                }
                val hash = pubkeyBytes.toByteString().sha256().toByteArray()
                return Bech32.encode(Bech32.Encoding.BECH32, prefix, hash.slice(IntRange(0, 19)).toByteArray())
            }

            else ->
                throw Error("Unrecognized public key algorithm")
        }
    }

}