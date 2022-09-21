@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package web3

import web3.eth.AbiItem
import web3.eth.Contract
import web3.eth.ContractOptions
import kotlin.js.*

typealias BN = Any
typealias BigNumber = Any


@JsModule("web3-eth")
@JsNonModule
external class Eth {
    constructor()
    constructor(provider: HttpProvider?)
//    constructor(provider: IpcProvider?)
    constructor(provider: WebsocketProvider?)
    constructor(provider: AbstractProvider?)
    constructor(provider: String?)
//    constructor(provider: HttpProvider?, net: Socket)
//    constructor(provider: IpcProvider?, net: Socket)
//    constructor(provider: WebsocketProvider?, net: Socket)
//    constructor(provider: AbstractProvider?, net: Socket)
//    constructor(provider: String?, net: Socket)
    val Contract: (Array<AbiItem>, String, ContractOptions?) -> Contract<*>
    open var Iban: Any
//    open var personal: Personal
//    open var accounts: Accounts
//    open var ens: Ens
//    open var abi: AbiCoder
    open var net: Network
    open var givenProvider: Any
    open var defaultAccount: String?
    open var defaultBlock: dynamic /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */
    open var defaultCommon: Common
    open var defaultHardfork: String /* "chainstart" | "homestead" | "dao" | "tangerineWhistle" | "spuriousDragon" | "byzantium" | "constantinople" | "petersburg" | "istanbul" */
    open var defaultChain: String /* "mainnet" | "goerli" | "kovan" | "rinkeby" | "ropsten" */
    open var transactionPollingTimeout: Number
    open var transactionConfirmationBlocks: Number
    open var transactionBlockTimeout: Number
    open var handleRevert: Boolean
    open var currentProvider: AbstractProvider /* HttpProvider? | IpcProvider? | WebsocketProvider? | AbstractProvider? | String? */
    open fun setProvider(provider: HttpProvider?): Boolean
//    open fun setProvider(provider: IpcProvider?): Boolean
    open fun setProvider(provider: WebsocketProvider?): Boolean
    open fun setProvider(provider: AbstractProvider?): Boolean
    open fun setProvider(provider: String?): Boolean
    open var BatchRequest: Any
    open fun extend(extension: Extension): Any
    open fun clearSubscriptions(callback: (error: Error?, result: Boolean) -> Unit)
    open fun subscribe(type: String /* "logs" */, options: LogsOptions, callback: (error: Error?, log: Log) -> Unit = definedExternally): Subscription<Log>
    open fun subscribe(type: String /* "logs" */, options: LogsOptions): Subscription<Log>
    open fun subscribe(type: String /* "syncing" */, callback: (error: Error?, result: Syncing) -> Unit = definedExternally): Subscription<Syncing>
    open fun subscribe(type: String /* "syncing" | "newBlockHeaders" | "pendingTransactions" */): dynamic /* Subscription */
    open fun subscribe(type: String /* "newBlockHeaders" */, callback: (error: Error?, blockHeader: BlockHeader) -> Unit = definedExternally): Subscription<BlockHeader>
    open fun subscribe(type: String /* "pendingTransactions" */, callback: (error: Error?, transactionHash: String) -> Unit = definedExternally): Subscription<String>
    open fun getProtocolVersion(callback: (error: Error?, protocolVersion: String) -> Unit = definedExternally): Promise<String>
    open fun isSyncing(callback: (error: Error?, syncing: Syncing) -> Unit = definedExternally): Promise<dynamic /* Syncing | Boolean */>
    open fun getCoinbase(callback: (error: Error?, coinbaseAddress: String) -> Unit = definedExternally): Promise<String>
    open fun isMining(callback: (error: Error?, mining: Boolean) -> Unit = definedExternally): Promise<Boolean>
    open fun getHashrate(callback: (error: Error?, hashes: Number) -> Unit = definedExternally): Promise<Number>
    open fun getNodeInfo(callback: (error: Error?, version: String) -> Unit = definedExternally): Promise<String>
    open fun getChainId(callback: (error: Error?, version: Number) -> Unit = definedExternally): Promise<Number>
    open fun getGasPrice(callback: (error: Error?, gasPrice: String) -> Unit = definedExternally): Promise<String>
//    open fun getFeeHistory(blockCount: Number, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>, callback: (error: Error?, feeHistory: FeeHistoryResult) -> Unit = definedExternally): Promise<FeeHistoryResult>
//    open fun getFeeHistory(blockCount: Number, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>): Promise<FeeHistoryResult>
//    open fun getFeeHistory(blockCount: BigNumber, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>, callback: (error: Error?, feeHistory: FeeHistoryResult) -> Unit = definedExternally): Promise<FeeHistoryResult>
//    open fun getFeeHistory(blockCount: BigNumber, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>): Promise<FeeHistoryResult>
//    open fun getFeeHistory(blockCount: BN, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>, callback: (error: Error?, feeHistory: FeeHistoryResult) -> Unit = definedExternally): Promise<FeeHistoryResult>
//    open fun getFeeHistory(blockCount: BN, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>): Promise<FeeHistoryResult>
//    open fun getFeeHistory(blockCount: String, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>, callback: (error: Error?, feeHistory: FeeHistoryResult) -> Unit = definedExternally): Promise<FeeHistoryResult>
//    open fun getFeeHistory(blockCount: String, lastBlock: Any /* Number | BigNumber | BN | String */, rewardPercentiles: Array<Number>): Promise<FeeHistoryResult>
    open fun getAccounts(callback: (error: Error?, accounts: Array<String>) -> Unit = definedExternally): Promise<Array<String>>
//    open fun getBlockNumber(callback: (error: Error?, blockNumber: Number) -> Unit = definedExternally): Promise<Number>
    open fun getBalance(address: String): Promise<String>
//    open fun getBalance(address: String, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" | "latest" | "pending" | "earliest" | "genesis" */): Promise<String>
//    open fun getBalance(address: String, defaultBlock: Number): Promise<String>
//    open fun getBalance(address: String, defaultBlock: BN): Promise<String>
//    open fun getBalance(address: String, defaultBlock: BigNumber): Promise<String>
    open fun getBalance(address: String, callback: (error: Error?, balance: String) -> Unit = definedExternally): Promise<String>
//    open fun getBalance(address: String, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, balance: String) -> Unit = definedExternally): Promise<String>
//    open fun getBalance(address: String, defaultBlock: Number, callback: (error: Error?, balance: String) -> Unit = definedExternally): Promise<String>
//    open fun getBalance(address: String, defaultBlock: BN, callback: (error: Error?, balance: String) -> Unit = definedExternally): Promise<String>
//    open fun getBalance(address: String, defaultBlock: BigNumber, callback: (error: Error?, balance: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: Number): Promise<String>
//    open fun getStorageAt(address: String, position: BigNumber): Promise<String>
//    open fun getStorageAt(address: String, position: BN): Promise<String>
//    open fun getStorageAt(address: String, position: String): Promise<String>
//    open fun getStorageAt(address: String, position: Number, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<String>
//    open fun getStorageAt(address: String, position: BigNumber, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<String>
//    open fun getStorageAt(address: String, position: BN, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<String>
//    open fun getStorageAt(address: String, position: String, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<String>
//    open fun getStorageAt(address: String, position: Number, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: BigNumber, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: BN, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: String, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: Number, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: BigNumber, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: BN, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getStorageAt(address: String, position: String, defaultBlock: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, storageAt: String) -> Unit = definedExternally): Promise<String>
//    open fun getCode(address: String): Promise<String>
//    open fun getCode(address: String, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" | "latest" | "pending" | "earliest" | "genesis" */): Promise<String>
//    open fun getCode(address: String, defaultBlock: Number): Promise<String>
//    open fun getCode(address: String, defaultBlock: BN): Promise<String>
//    open fun getCode(address: String, defaultBlock: BigNumber): Promise<String>
//    open fun getCode(address: String, callback: (error: Error?, code: String) -> Unit = definedExternally): Promise<String>
//    open fun getCode(address: String, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, code: String) -> Unit = definedExternally): Promise<String>
//    open fun getCode(address: String, defaultBlock: Number, callback: (error: Error?, code: String) -> Unit = definedExternally): Promise<String>
//    open fun getCode(address: String, defaultBlock: BN, callback: (error: Error?, code: String) -> Unit = definedExternally): Promise<String>
//    open fun getCode(address: String, defaultBlock: BigNumber, callback: (error: Error?, code: String) -> Unit = definedExternally): Promise<String>
//    open fun getBlock(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" | "latest" | "pending" | "earliest" | "genesis" */): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: Number): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: BN): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: BigNumber): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" | "latest" | "pending" | "earliest" | "genesis" */, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getBlock(blockHashOrBlockNumber: Number, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getBlock(blockHashOrBlockNumber: BN, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getBlock(blockHashOrBlockNumber: BigNumber, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getBlock(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, block: BlockTransactionString) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: Number, callback: (error: Error?, block: BlockTransactionString) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: BN, callback: (error: Error?, block: BlockTransactionString) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: BigNumber, callback: (error: Error?, block: BlockTransactionString) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getBlock(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, returnTransactionObjects: Boolean, callback: (error: Error?, block: BlockTransactionObject) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getBlock(blockHashOrBlockNumber: Number, returnTransactionObjects: Boolean, callback: (error: Error?, block: BlockTransactionObject) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getBlock(blockHashOrBlockNumber: BN, returnTransactionObjects: Boolean, callback: (error: Error?, block: BlockTransactionObject) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getBlock(blockHashOrBlockNumber: BigNumber, returnTransactionObjects: Boolean, callback: (error: Error?, block: BlockTransactionObject) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */): Promise<Number>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: Number, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: Number): Promise<Number>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: BN, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: BN): Promise<Number>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: BigNumber, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockTransactionCount(blockHashOrBlockNumber: BigNumber): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: Number, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: Number): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: BN, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: BN): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: BigNumber, callback: (error: Error?, numberOfTransactions: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getBlockUncleCount(blockHashOrBlockNumber: BigNumber): Promise<Number>
//    open fun getUncle(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" | "latest" | "pending" | "earliest" | "genesis" */, uncleIndex: Any /* Number | String | BN */): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: Number, uncleIndex: Any /* Number | String | BN */): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: BN, uncleIndex: Any /* Number | String | BN */): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: BigNumber, uncleIndex: Any /* Number | String | BN */): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" | "latest" | "pending" | "earliest" | "genesis" */, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getUncle(blockHashOrBlockNumber: Number, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getUncle(blockHashOrBlockNumber: BN, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getUncle(blockHashOrBlockNumber: BigNumber, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean): Promise<BlockTransactionObject>
//    open fun getUncle(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, uncleIndex: Any /* Number | String | BN */, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: Number, uncleIndex: Any /* Number | String | BN */, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: BN, uncleIndex: Any /* Number | String | BN */, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: BigNumber, uncleIndex: Any /* Number | String | BN */, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionString>
//    open fun getUncle(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getUncle(blockHashOrBlockNumber: Number, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getUncle(blockHashOrBlockNumber: BN, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getUncle(blockHashOrBlockNumber: BigNumber, uncleIndex: Any /* Number | String | BN */, returnTransactionObjects: Boolean, callback: (error: Error?, uncle: Any) -> Unit = definedExternally): Promise<BlockTransactionObject>
//    open fun getTransaction(transactionHash: String, callback: (error: Error?, transaction: Transaction) -> Unit = definedExternally): Promise<Transaction>
//    open fun getPendingTransactions(callback: (error: Error?, result: Array<Transaction>) -> Unit = definedExternally): Promise<Array<Transaction>>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, indexNumber: Any /* Number | String | BN */, callback: (error: Error?, transaction: Transaction) -> Unit = definedExternally): Promise<Transaction>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: String /* "latest" | "pending" | "earliest" | "genesis" */, indexNumber: Any /* Number | String | BN */): Promise<Transaction>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: Number, indexNumber: Any /* Number | String | BN */, callback: (error: Error?, transaction: Transaction) -> Unit = definedExternally): Promise<Transaction>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: Number, indexNumber: Any /* Number | String | BN */): Promise<Transaction>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: BN, indexNumber: Any /* Number | String | BN */, callback: (error: Error?, transaction: Transaction) -> Unit = definedExternally): Promise<Transaction>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: BN, indexNumber: Any /* Number | String | BN */): Promise<Transaction>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: BigNumber, indexNumber: Any /* Number | String | BN */, callback: (error: Error?, transaction: Transaction) -> Unit = definedExternally): Promise<Transaction>
//    open fun getTransactionFromBlock(blockHashOrBlockNumber: BigNumber, indexNumber: Any /* Number | String | BN */): Promise<Transaction>
//    open fun getTransactionReceipt(hash: String, callback: (error: Error?, transactionReceipt: TransactionReceipt) -> Unit = definedExternally): Promise<TransactionReceipt>
//    open fun getTransactionCount(address: String): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" | "latest" | "pending" | "earliest" | "genesis" */): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: Number): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: BN): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: BigNumber): Promise<Number>
//    open fun getTransactionCount(address: String, callback: (error: Error?, count: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, count: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: Number, callback: (error: Error?, count: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: BN, callback: (error: Error?, count: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getTransactionCount(address: String, defaultBlock: BigNumber, callback: (error: Error?, count: Number) -> Unit = definedExternally): Promise<Number>
//    open fun sendTransaction(transactionConfig: TransactionConfig, callback: (error: Error?, hash: String) -> Unit = definedExternally): PromiEvent<TransactionReceipt>
//    open fun sendSignedTransaction(signedTransactionData: String, callback: (error: Error?, hash: String) -> Unit = definedExternally): PromiEvent<TransactionReceipt>
//    open fun sign(dataToSign: String, address: String, callback: (error: Error?, signature: String) -> Unit = definedExternally): Promise<String>
//    open fun sign(dataToSign: String, address: String): Promise<String>
//    open fun sign(dataToSign: String, address: Number, callback: (error: Error?, signature: String) -> Unit = definedExternally): Promise<String>
//    open fun sign(dataToSign: String, address: Number): Promise<String>
//    open fun signTransaction(transactionConfig: TransactionConfig, callback: (error: Error?, signedTransaction: RLPEncodedTransaction) -> Unit = definedExternally): Promise<RLPEncodedTransaction>
//    open fun signTransaction(transactionConfig: TransactionConfig): Promise<RLPEncodedTransaction>
//    open fun signTransaction(transactionConfig: TransactionConfig, address: String): Promise<RLPEncodedTransaction>
//    open fun signTransaction(transactionConfig: TransactionConfig, address: String, callback: (error: Error?, signedTransaction: RLPEncodedTransaction) -> Unit): Promise<RLPEncodedTransaction>
//    open fun call(transactionConfig: TransactionConfig): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" */ = definedExternally): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: Number = definedExternally): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: BN = definedExternally): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: BigNumber = definedExternally): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, callback: (error: Error?, data: String) -> Unit = definedExternally): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: String /* "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, data: String) -> Unit): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: Number, callback: (error: Error?, data: String) -> Unit): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: BN, callback: (error: Error?, data: String) -> Unit): Promise<String>
//    open fun call(transactionConfig: TransactionConfig, defaultBlock: BigNumber, callback: (error: Error?, data: String) -> Unit): Promise<String>
//    open fun estimateGas(transactionConfig: TransactionConfig, callback: (error: Error?, gas: Number) -> Unit = definedExternally): Promise<Number>
//    open fun getPastLogs(options: PastLogsOptions, callback: (error: Error?, logs: Array<Log>) -> Unit = definedExternally): Promise<Array<Log>>
//    open fun getWork(callback: (error: Error?, result: Array<String>) -> Unit = definedExternally): Promise<Array<String>>
//    open fun submitWork(data: Any /* JsTuple<String, String, String> */, callback: (error: Error?, result: Boolean) -> Unit = definedExternally): Promise<Boolean>
//    open fun getProof(address: String, storageKey: Array<Number>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, result: GetProof) -> Unit = definedExternally): Promise<GetProof>
//    open fun getProof(address: String, storageKey: Array<Number>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<GetProof>
//    open fun getProof(address: String, storageKey: Array<BigNumber>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, result: GetProof) -> Unit = definedExternally): Promise<GetProof>
//    open fun getProof(address: String, storageKey: Array<BigNumber>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<GetProof>
//    open fun getProof(address: String, storageKey: Array<BN>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, result: GetProof) -> Unit = definedExternally): Promise<GetProof>
//    open fun getProof(address: String, storageKey: Array<BN>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<GetProof>
//    open fun getProof(address: String, storageKey: Array<String>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */, callback: (error: Error?, result: GetProof) -> Unit = definedExternally): Promise<GetProof>
//    open fun getProof(address: String, storageKey: Array<String>, blockNumber: Any /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */): Promise<GetProof>
    open fun requestAccounts(): Promise<Array<String>>
    open fun requestAccounts(callback: (error: Error?, result: Array<String>) -> Unit): Promise<Array<String>>



    companion object {
        var givenProvider: Any
        var providers: Providers
    }
}


external interface Syncing {
    var StartingBlock: Number
    var CurrentBlock: Number
    var HighestBlock: Number
    var KnownStates: Number
    var PulledStates: Number
}

external interface BlockHeader {
    var number: Number
    var hash: String
    var parentHash: String
    var nonce: String
    var sha3Uncles: String
    var logsBloom: String
    var transactionRoot: String
    var stateRoot: String
    var receiptsRoot: String
    var miner: String
    var extraData: String
    var gasLimit: Number
    var gasUsed: Number
    var timestamp: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var baseFeePerGas: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface BlockTransactionBase : BlockHeader {
    var size: Number
    var difficulty: Number
    var totalDifficulty: Number
    var uncles: Array<String>
}

external interface BlockTransactionObject : BlockTransactionBase {
    var transactions: Array<Transaction>
}

external interface BlockTransactionString : BlockTransactionBase {
    var transactions: Array<String>
}

external interface GetProof {
    var address: String
    var balance: String
    var codeHash: String
    var nonce: String
    var storageHash: String
    var accountProof: Array<String>
    var storageProof: Array<StorageProof>
}

external interface StorageProof {
    var key: String
    var value: String
    var proof: Array<String>
}

external interface FeeHistoryResult {
    var baseFeePerGas: Array<String>
    var gasUsedRatio: Array<Number>
    var oldestBlock: Number
    var reward: Array<Array<String>>
}