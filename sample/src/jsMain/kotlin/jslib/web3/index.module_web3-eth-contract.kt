package web3.eth


import web3.*
import kotlin.js.Json
import kotlin.js.Promise

@JsModule("web3-eth-contract")
@JsNonModule
open external class Contract<M : Method>(
    jsonInterface: Array<AbiItem>, address: String = definedExternally, options: ContractOptions = definedExternally
) {
    open var _address: String
    open var _jsonInterface: Array<AbiItem>
    open var defaultAccount: String?
    open var defaultBlock: dynamic /* String | Number | BN | BigNumber | "latest" | "pending" | "earliest" | "genesis" */
    open var defaultCommon: Common
    open var defaultHardfork: String /* "chainstart" | "homestead" | "dao" | "tangerineWhistle" | "spuriousDragon" | "byzantium" | "constantinople" | "petersburg" | "istanbul" */
    open var defaultChain: String /* "mainnet" | "goerli" | "kovan" | "rinkeby" | "ropsten" */
    open var transactionPollingTimeout: Number
    open var transactionConfirmationBlocks: Number
    open var transactionBlockTimeout: Number
    open var handleRevert: Boolean
    open var options: Options
    open fun clone(): Contract<M>
    open fun <T> deploy(options: DeployOptions): ContractSendMethod<T>
    open var methods: M
    open fun once(event: String, callback: (error: Error?, event: EventData) -> Unit)
    open fun once(event: String, options: EventOptions, callback: (error: Error?, event: EventData) -> Unit)
    open var events: Any
    open fun getPastEvents(event: String): Promise<Array<EventData>>
    open fun getPastEvents(
        event: String, options: PastEventOptions, callback: (error: Error?, event: EventData) -> Unit
    ): Promise<Array<EventData>>

    open fun getPastEvents(event: String, options: PastEventOptions): Promise<Array<EventData>>
    open fun getPastEvents(
        event: String, callback: (error: Error?, event: EventData) -> Unit
    ): Promise<Array<EventData>>

    companion object {
        fun setProvider(provider: HttpProvider?, accounts: Accounts = definedExternally)

        //        fun setProvider(provider: IpcProvider?, accounts: Accounts = definedExternally)
        fun setProvider(provider: WebsocketProvider?, accounts: Accounts = definedExternally)
        fun setProvider(provider: AbstractProvider?, accounts: Accounts = definedExternally)
        fun setProvider(provider: String?, accounts: Accounts = definedExternally)

    }
}


external interface Options : ContractOptions {
    var address: String
    var jsonInterface: Array<AbiItem>
}

external interface DeployOptions {
    var data: String
    var arguments: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
}


external interface ContractSendMethod<T> {
    fun send(options: Any /*SendOptions as Json*//*, callback: (err: Error, transactionHash: String) -> Unit*/): Promise<T>
    fun call(): Promise<T>
    fun estimateGas(
        options: EstimateGasOptions, callback: (err: Error, gas: Number) -> Unit = definedExternally
    ): Promise<Number>

    fun estimateGas(options: EstimateGasOptions): Promise<Number>
    fun estimateGas(callback: (err: Error, gas: Number) -> Unit): Promise<Number>
    fun estimateGas(): Promise<Number>
    fun encodeABI(): String
}

external interface CallOptions {
    var from: String?
    var gasPrice: String?
    var gas: Number?
}

external interface SendOptions {
    var from: String

    //    var gasPrice: String?
//    var gas: Number?
    var value: String? /* Number? | String? | BN? */
//    var nonce: Number?
}

external interface EstimateGasOptions {
    var from: String?
        get() = definedExternally
        set(value) = definedExternally
    var gas: Number?
        get() = definedExternally
        set(value) = definedExternally
    var value: dynamic /* Number? | String? | BN? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface ContractOptions {
    var from: String?
    var gasPrice: String?
    var gas: Number?
    var data: String?
}

external interface PastEventOptions : PastLogsOptions {
    var filter: Filter?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EventOptions : LogsOptions {
    var filter: Filter?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Filter {

}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Filter.get(key: String): dynamic /* Number? | String? | Array<String>? | Array<Number>? */ =
    asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun Filter.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Filter.set(key: String, value: String) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Filter.set(key: String, value: Array<String>) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Filter.set(key: String, value: Array<Number>) {
    asDynamic()[key] = value
}

external interface `T$27` {
    var data: String
    var topics: Array<String>
}

external interface EventData {
    var returnValues: Json
    var raw: `T$27`
    var event: String
    var signature: String
    var logIndex: Number
    var transactionIndex: Number
    var transactionHash: String
    var blockHash: String
    var blockNumber: Number
    var address: String
}


external interface Method {
    fun name(): ContractSendMethod<String>
    var call: String
    var params: Number?
    var inputFormatter: Array<(() -> Unit)?>?
    var outputFormatter: (() -> Unit)?
    var transformPayload: (() -> Unit)?
    var extraFormatters: Any?
    var defaultBlock: String?
    var defaultAccount: String?
    var abiCoder: Any?
    var handleRevert: Boolean?
}


external interface AbiItem {
    var anonymous: Boolean?
    var constant: Boolean?
    var inputs: Array<AbiInput>?
    var name: String?
    var outputs: Array<AbiOutput>?
    var payable: Boolean?
    var stateMutability: String?
    var type: String /* "function" | "constructor" | "event" | "fallback" */
    var gas: Double?
}


external interface AbiInput {
    var name: String
    var type: String
    var indexed: Boolean?

    //    var components: Array<AbiInput>?
    var internalType: String?
}


external interface AbiOutput {
    var name: String
    var type: String

    //    var components: Array<AbiOutput>?
    var internalType: String?
}


