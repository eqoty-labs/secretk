package io.eqoty.secretk.types

import io.eqoty.secretk.BroadcastMode

data class TxOptions(
    /** Defaults to `25_000`. */
    val gasLimit: Int = 25_000,
    /** E.g. gasPriceInFeeDenom=0.1 & feeDenom="uscrt" => Total fee for tx is `0.1 * gasLimit`uscrt. Defaults to `0.1`. */
    val gasPriceInFeeDenom: Double = 0.1,
    val feeDenom: String = "uscrt",
    /** Address of the fee granter from which to charge gas fees. */
    val feeGranter: String? = null,
    val memo: String = "",
    /** If `false` returns immediately with only the `transactionHash` field set. Defaults to `true`. */
    val waitForCommit: Boolean = true,
    /**
     * How much time (in milliseconds) to wait for tx to commit on-chain.
     *
     * Defaults to `60_000`. Ignored if `waitForCommit = false`.
     */
    val broadcastTimeoutMs: Int? = 60_000,
    /**
     * When waiting for the tx to commit on-chain, how much time (in milliseconds) to wait between checks.
     *
     * Smaller intervals will cause more load on your node provider. Keep in mind that blocks on Secret Network take about 6 seconds to finalize.
     *
     * Defaults to `6_000`. Ignored if `waitForCommit = false`.
     */
    val broadcastCheckIntervalMs: Int? = 6_000,
    /**
     * If `BroadcastMode.Sync` - Broadcast transaction to mempool and wait for CheckTx response.
     *
     * @see https://docs.tendermint.com/master/rpc/#/Tx/broadcast_tx_sync
     *
     * If `BroadcastMode.Async` Broadcast transaction to mempool and do not wait for CheckTx response.
     *
     * @see https://docs.tendermint.com/master/rpc/#/Tx/broadcast_tx_async
     */
    val broadcastMode: BroadcastMode = BroadcastMode.Block,
    /**
     * explicitSignerData can be used to override `chainId`, `accountNumber` & `accountSequence`.
     * This is useful when using {@link BroadcastMode.Async} or when you don't want secretjs
     * to query for `accountNumber` & `accountSequence` from the chain. (smoother in UIs, less load on your node provider).
     */
    val explicitSignerData: SignerData? = null,
)