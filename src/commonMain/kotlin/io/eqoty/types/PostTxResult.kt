package io.eqoty.types

import io.eqoty.logs.Log

data class PostTxResult (
    val logs: List<Log>,
    val rawLog: String,
    val data: Any,
    /** Transaction hash (might be used as transaction ID). Guaranteed to be non-empty upper-case hex */
    val transactionHash: String
)