package io.eqoty

enum class BroadcastMode(val mode: String) {
  /** Return after tx commit */
  Block("block"),
  /** Return afrer CheckTx */
  Sync("sync"),
  /** Return right away */
  Async("async"),
}