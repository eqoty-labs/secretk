package io.eqoty.types.result

import io.eqoty.types.response.logs.Log

data class ExecuteResult(
    val logs: List<Log>,
    /** Transaction hash (might be used as transaction ID). Guaranteed to be non-empty upper-case hex */
    val transactionHash: String,
    val data: List<String>
)