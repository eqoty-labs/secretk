package io.eqoty.tx.proto

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/signing/v1beta1/signing.ts
 */
enum class SignMode(val value: Int) {
    // SIGN_MODE_UNSPECIFIED specifies an unknown signing mode and will be
    // rejected
    SIGN_MODE_UNSPECIFIED(0),

    // SIGN_MODE_DIRECT specifies a signing mode which uses SignDoc and is
    // verified with raw bytes from Tx
    SIGN_MODE_DIRECT(1),

    // SIGN_MODE_TEXTUAL is a future signing mode that will verify some
    // human-readable textual representation on top of the binary representation
    // from SIGN_MODE_DIRECT
    SIGN_MODE_TEXTUAL(2),

    // SIGN_MODE_LEGACY_AMINO_JSON is a backwards compatibility mode which uses
    // Amino JSON and will be removed in the future
    SIGN_MODE_LEGACY_AMINO_JSON(127),

    SIGN_MODE_EIP_191(191),
    UNRECOGNIZED(-1)
}