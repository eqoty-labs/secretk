package io.eqoty.result;

import io.eqoty.logs.Log
import kotlinx.serialization.json.JsonElement

data class ExecuteResult (
  val logs: List<Log>,
  /** Transaction hash (might be used as transaction ID). Guaranteed to be non-empty upper-case hex */
  val transactionHash: String,
  val data: JsonElement
)