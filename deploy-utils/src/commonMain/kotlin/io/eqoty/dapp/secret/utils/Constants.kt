package io.eqoty.dapp.secret.utils

import io.getenv
import okio.Path
import okio.Path.Companion.toPath

object Constants {
    const val NODE_TYPE_ENV_NAME = "NODE_TYPE"
    const val GITPOD_ID_ENV_NAME = "GITPOD_ID"
    const val CONTRACT_PATH_ENV_NAME = "CONTRACT_PATH"

    val releaseContractCodePath: Path = "${getenv(CONTRACT_PATH_ENV_NAME)}/eqoty_release.wasm.gz".toPath()
    val royaltyContractCodePath: Path = "${getenv(CONTRACT_PATH_ENV_NAME)}/eqoty_royalty.wasm.gz".toPath()
    val purchaseContractCodePath: Path = "${getenv(CONTRACT_PATH_ENV_NAME)}/eqoty_purchase.wasm.gz".toPath()
}