package io.eqoty.secretk.types.result

import io.eqoty.secretk.types.response.logs.Log

data class ExecuteResult(
    val logs: List<Log>,
    /** Transaction hash (might be used as transaction ID). Guaranteed to be non-empty upper-case hex */
    val transactionHash: String,
    val data: List<String>
)