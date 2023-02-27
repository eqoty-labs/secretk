package io.eqoty.secretk

enum class BroadcastMode(val mode: String) {
    /** Return after tx commit */
    Block("BROADCAST_MODE_BLOCK"),

    /** Return afrer CheckTx */
    Sync("BROADCAST_MODE_SYNC"),

    /** Return right away */
    Async("BROADCAST_MODE_ASYNC"),
}