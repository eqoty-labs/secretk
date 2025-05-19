package io.eqoty.secretk

enum class BroadcastMode(val mode: String) {
    /** Return afrer CheckTx */
    Sync("BROADCAST_MODE_SYNC"),

    /** Return right away */
    Async("BROADCAST_MODE_ASYNC"),
}