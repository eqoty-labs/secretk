@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package web3

import events.global.NodeJS.EventEmitter
import web3.eth.Method
import kotlin.js.Promise


external interface SignedTransaction {
    var messageHash: String?
        get() = definedExternally
        set(value) = definedExternally
    var r: String
    var s: String
    var v: String
    var rawTransaction: String?
        get() = definedExternally
        set(value) = definedExternally
    var transactionHash: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Extension {
    var property: String?
        get() = definedExternally
        set(value) = definedExternally
    var methods: Array<Method>
}

external interface Providers {
    var HttpProvider: Any
    var WebsocketProvider: Any
    var IpcProvider: Any
}

external interface PromiEvent<T> : Promise<T> {
    fun once(type: String /* "sending" | "sent" | "error" | "confirmation" | "receipt" | "transactionHash" | "sent" | "sending" */, handler: (payload: Any? /* Error? | TransactionReceipt? | String? | Any? */) -> Unit): PromiEvent<T>
    fun once(type: String /* "transactionHash" */, handler: (transactionHash: String) -> Unit): PromiEvent<T>
    fun once(type: String /* "receipt" */, handler: (receipt: TransactionReceipt) -> Unit): PromiEvent<T>
    fun once(type: String /* "confirmation" */, handler: (confirmationNumber: Number, receipt: TransactionReceipt, latestBlockHash: String) -> Unit): PromiEvent<T>
    fun once(type: String /* "error" */, handler: (error: Error) -> Unit): PromiEvent<T>
    fun on(type: String /* "sending" | "sent" | "error" | "confirmation" | "receipt" | "transactionHash" | "sent" | "sending" */, handler: (payload: Any? /* Error? | TransactionReceipt? | String? | Any? */) -> Unit): PromiEvent<T>
    fun on(type: String /* "transactionHash" */, handler: (receipt: String) -> Unit): PromiEvent<T>
    fun on(type: String /* "receipt" */, handler: (receipt: TransactionReceipt) -> Unit): PromiEvent<T>
    fun on(type: String /* "confirmation" */, handler: (confNumber: Number, receipt: TransactionReceipt, latestBlockHash: String) -> Unit): PromiEvent<T>
    fun on(type: String /* "error" */, handler: (error: Error) -> Unit): PromiEvent<T>
}

external interface Transaction {
    var hash: String
    var nonce: Number
    var blockHash: String?
    var blockNumber: Number?
    var transactionIndex: Number?
    var from: String
    var to: String?
    var value: String
    var gasPrice: String
    var maxPriorityFeePerGas: dynamic /* Number? | String? | BN? */
        get() = definedExternally
        set(value) = definedExternally
    var maxFeePerGas: dynamic /* Number? | String? | BN? */
        get() = definedExternally
        set(value) = definedExternally
    var gas: Number
    var input: String
}

external interface TransactionConfig {
    var from: dynamic /* String? | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var to: String?
        get() = definedExternally
        set(value) = definedExternally
    var value: dynamic /* Number? | String? | BN? */
        get() = definedExternally
        set(value) = definedExternally
    var gas: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var gasPrice: dynamic /* Number? | String? | BN? */
        get() = definedExternally
        set(value) = definedExternally
    var maxPriorityFeePerGas: dynamic /* Number? | String? | BN? */
        get() = definedExternally
        set(value) = definedExternally
    var maxFeePerGas: dynamic /* Number? | String? | BN? */
        get() = definedExternally
        set(value) = definedExternally
    var data: String?
        get() = definedExternally
        set(value) = definedExternally
    var nonce: Number?
        get() = definedExternally
        set(value) = definedExternally
    var chainId: Number?
        get() = definedExternally
        set(value) = definedExternally
    var common: Common?
        get() = definedExternally
        set(value) = definedExternally
    var chain: String?
        get() = definedExternally
        set(value) = definedExternally
    var hardfork: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Common {
    var customChain: CustomChainParams
    var baseChain: String? /* "mainnet" | "goerli" | "kovan" | "rinkeby" | "ropsten" */
        get() = definedExternally
        set(value) = definedExternally
    var hardfork: String? /* "chainstart" | "homestead" | "dao" | "tangerineWhistle" | "spuriousDragon" | "byzantium" | "constantinople" | "petersburg" | "istanbul" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface CustomChainParams {
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var networkId: Number
    var chainId: Number
}

external interface `T$12` {
    var nonce: String
    var gasPrice: String
    var gas: String
    var to: String
    var value: String
    var input: String
    var r: String
    var s: String
    var v: String
    var hash: String
}

external interface RLPEncodedTransaction {
    var raw: String
    var tx: `T$12`
}

external interface `T$13` {
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$13`.get(eventName: String): EventLog? = asDynamic()[eventName]

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$13`.set(eventName: String, value: EventLog) {
    asDynamic()[eventName] = value
}

external interface TransactionReceipt {
    var status: Boolean
    var transactionHash: String
    var transactionIndex: Number
    var blockHash: String
    var blockNumber: Number
    var from: String
    var to: String
    var contractAddress: String?
        get() = definedExternally
        set(value) = definedExternally
    var cumulativeGasUsed: Number
    var gasUsed: Number
    var effectiveGasPrice: Number
    var logs: Array<Log>
    var logsBloom: String
    var events: `T$13`?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$14` {
    var data: String
    var topics: Array<Any>
}

external interface EventLog {
    var event: String
    var address: String
    var returnValues: Any
    var logIndex: Number
    var transactionIndex: Number
    var transactionHash: String
    var blockHash: String
    var blockNumber: Number
    var raw: `T$14`?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Log {
    var address: String
    var data: String
    var topics: Array<String>
    var logIndex: Number
    var transactionIndex: Number
    var transactionHash: String
    var blockHash: String
    var blockNumber: Number
}

open external class NetworkBase {
    constructor()
    constructor(provider: HttpProvider?)
//    constructor(provider: IpcProvider?)
    constructor(provider: WebsocketProvider?)
    constructor(provider: AbstractProvider?)
    constructor(provider: String?)

    open var givenProvider: Any
    open var currentProvider: dynamic /* HttpProvider? | IpcProvider? | WebsocketProvider? | AbstractProvider? | String? */
    open var BatchRequest: Any
    open fun setProvider(provider: HttpProvider?): Boolean
//    open fun setProvider(provider: IpcProvider?): Boolean
    open fun setProvider(provider: WebsocketProvider?): Boolean
    open fun setProvider(provider: AbstractProvider?): Boolean
    open fun setProvider(provider: String?): Boolean
    open fun extend(extension: Extension): Any
    open fun getNetworkType(callback: (error: Error?, returnValue: String) -> Unit = definedExternally): Promise<String>
    open fun getId(callback: (error: Error?, id: Number) -> Unit = definedExternally): Promise<Number>
    open fun isListening(callback: (error: Error?, listening: Boolean) -> Unit = definedExternally): Promise<Boolean>
    open fun getPeerCount(callback: (error: Error?, peerCount: Number) -> Unit = definedExternally): Promise<Number>

    companion object {
        var givenProvider: Any
        var providers: Providers
    }
}

open external class AccountsBase {
    constructor()
    constructor(provider: HttpProvider?)
//    constructor(provider: IpcProvider?)
    constructor(provider: WebsocketProvider?)
    constructor(provider: AbstractProvider?)
    constructor(provider: String?)

    open var givenProvider: Any
    open var currentProvider: dynamic /* HttpProvider? | IpcProvider? | WebsocketProvider? | AbstractProvider? | String? */
    open fun setProvider(provider: HttpProvider?): Boolean
//    open fun setProvider(provider: IpcProvider?): Boolean
    open fun setProvider(provider: WebsocketProvider?): Boolean
    open fun setProvider(provider: AbstractProvider?): Boolean
    open fun setProvider(provider: String?): Boolean
    open fun create(entropy: String = definedExternally): Account
    open fun privateKeyToAccount(privateKey: String, ignoreLength: Boolean = definedExternally): Account
    open fun signTransaction(transactionConfig: TransactionConfig, privateKey: String, callback: (error: Error?, signedTransaction: SignedTransaction) -> Unit = definedExternally): Promise<SignedTransaction>
    open fun recoverTransaction(signature: String): String
    open fun hashMessage(message: String): String
    open fun sign(data: String, privateKey: String): Sign
    open fun recover(signatureObject: SignatureObject): String
    open fun recover(message: String, signature: String, preFixed: Boolean = definedExternally): String
    open fun recover(message: String, signature: String): String
    open fun recover(message: String, v: String, r: String, s: String, preFixed: Boolean = definedExternally): String
    open fun recover(message: String, v: String, r: String, s: String): String
    open fun encrypt(privateKey: String, password: String): EncryptedKeystoreV3Json
    open fun decrypt(keystoreJsonV3: EncryptedKeystoreV3Json, password: String): Account
    open var wallet: WalletBase
}

open external class WalletBase(accounts: AccountsBase) {
    open var length: Number
    open var defaultKeyName: String
    open fun create(numberOfAccounts: Number, entropy: String = definedExternally): WalletBase
    open fun add(account: String): AddedAccount
    open fun add(account: AddAccount): AddedAccount
    open fun remove(account: String): Boolean
    open fun remove(account: Number): Boolean
    open fun clear(): WalletBase
    open fun encrypt(password: String): Array<EncryptedKeystoreV3Json>
    open fun decrypt(keystoreArray: Array<EncryptedKeystoreV3Json>, password: String): WalletBase
    open fun save(password: String, keyName: String = definedExternally): Boolean
    open fun load(password: String, keyName: String = definedExternally): WalletBase
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun WalletBase.get(key: Number): Account? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun WalletBase.set(key: Number, value: Account) {
    asDynamic()[key] = value
}

external interface AddAccount {
    var address: String
    var privateKey: String
}

external interface AddedAccount : Account {
    var index: Number
}

external interface Account {
    var address: String
    var privateKey: String
    var signTransaction: (transactionConfig: TransactionConfig, callback: (signTransaction: SignedTransaction) -> Unit) -> Promise<SignedTransaction>
    var sign: (data: String) -> Sign
    var encrypt: (password: String) -> EncryptedKeystoreV3Json
}

external interface `T$15` {
    var iv: String
}

external interface `T$16` {
    var dklen: Number
    var salt: String
    var n: Number
    var r: Number
    var p: Number
}

external interface `T$17` {
    var ciphertext: String
    var cipherparams: `T$15`
    var cipher: String
    var kdf: String
    var kdfparams: `T$16`
    var mac: String
}

external interface EncryptedKeystoreV3Json {
    var version: Number
    var id: String
    var address: String
    var crypto: `T$17`
}

external interface Sign : SignedTransaction {
    var message: String
    var signature: String
}

external interface SignatureObject {
    var messageHash: String
    var r: String
    var s: String
    var v: String
}

open external class BatchRequest {
    open fun add(method: Method)
    open fun execute()
}

open external class HttpProvider(host: String, options: HttpProviderOptions = definedExternally) : HttpProviderBase

//external open class IpcProvider(path: String, net: Server) : IpcProviderBase

open external class WebsocketProvider(host: String, options: WebsocketProviderOptions = definedExternally) : WebsocketProviderBase

external interface PastLogsOptions : LogsOptions {
    var toBlock: dynamic /* String? | Number? | BN? | BigNumber? | "latest" | "pending" | "earliest" | "genesis" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface LogsOptions {
    var fromBlock: dynamic /* String? | Number? | BN? | BigNumber? | "latest" | "pending" | "earliest" | "genesis" */
        get() = definedExternally
        set(value) = definedExternally
    var address: dynamic /* String? | Array<String>? */
        get() = definedExternally
        set(value) = definedExternally
    var topics: Array<dynamic /* String? | Array<String>? */>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RequestArguments {
    var method: String
    var params: Any?
        get() = definedExternally
        set(value) = definedExternally
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun RequestArguments.get(key: String): Any? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun RequestArguments.set(key: String, value: Any) {
    asDynamic()[key] = value
}

external interface AbstractProvider : EventEmitter {
    fun sendAsync(payload: JsonRpcPayload, callback: (error: Error?, result: JsonRpcResponse) -> Unit)
    val send: ((payload: JsonRpcPayload, callback: (error: Error?, result: JsonRpcResponse) -> Unit) -> Unit)?
    val request: ((args: RequestArguments) -> Promise<Any>)?
    var connected: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}