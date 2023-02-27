package io.eqoty.secretk.wallet

import io.eqoty.secret.std.types.StdSignature
import io.eqoty.secretk.utils.toByteString


fun encodeSecp256k1Signature(pubkey: UByteArray, signature: UByteArray): StdSignature {
    if (signature.size != 64) {
        throw Error(
            "Signature must be 64 bytes long. Cosmos SDK uses a 2x32 byte fixed length encoding for the secp256k1 signature integers r and s.",
        )
    }

    return StdSignature(
        // eslint-disable-next-line @typescript-eslint/camelcase
        pubKey = encodeSecp256k1Pubkey(pubkey),
        signature = signature.toByteString().base64()
    )
}
