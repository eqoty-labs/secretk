# secretk

A Kotlin multiplatform Encryption and REST client for Secret Network utilizing gRPC gateway endpoints.

Based on the work of:

[secret.js](https://github.com/scrtlabs/SecretNetwork/tree/f01dda32b12e02c6cc2326ea58f8b13bf6e3ff8f/cosmwasm-js/packages/sdk) (
old) + [secret.js](https://github.com/scrtlabs/secret.js)

### Supported Features:

* Contract Queries
* Simulate Contract Execution To Estimate Gas
* Contract Execution (MsgExecuteContract)
* Contract Code Upload (MsgStoreCode)
* Contract Instantiate (MsgInstantiateContract)
* Web: Delegate signing transactions to Kepler or Metamask browser wallets

### Supported Targets:

* JVM
* js
* iOS
* macOS
* TODO: linux

### Build Requirements

* Xcode 13.2.1
    * Note: Xcode 13.3 [build issue](https://github.com/leetal/ios-cmake/issues/141)

## Setup

### Gradle

```gradle
repositories {
    mavenCentral()
    // And the following repository to workaround this issue: 
    // https://youtrack.jetbrains.com/issue/KT-52240/Dependencies-of-a-dependency-are-not-resolved
    maven {
        name = "luca992/KHash GitHub Packages"
        url = uri("https://maven.pkg.github.com/luca992/KHash")
        credentials {
            username = "token"
            // see: https://github.community/t/download-from-github-package-registry-without-authentication/14407/44
            password = "\u0067\u0068\u0070\u005f\u0072\u0067\u0070\u0054\u0069\u006c\u004c\u0042\u0038\u006c\u0066\u0057\u0045\u0056\u0031\u0053\u004a\u006d\u0061\u006b\u004a\u004c\u005a\u0063\u0038\u004d\u0074\u0038\u0045\u0066\u0031\u0059\u0053\u0058\u0039\u0055"
        }
    }
}

dependencies {
    implementation("io.eqoty.secretk:client:$latest")
}
```

### Swift Package Manager

you need to declare your dependency in your `Package.swift`:

```swift
.package(url: "https://github.com/eqoty-labs/secretk.git", from: "latest"),
```

## Samples

- [Secret Contract Template](https://github.com/eqoty-labs/secret-template) using secretk for Integration Testing
- Compose UI [sample project](/sample)
- Swift [sample project](/sampleSwift)

## Useage

### Kotlin

#### Create SigningCosmWasmClient

```kotlin
val grpcGatewayEndpoint = "http://secretnetworkendpoint.com:1337"
val mnemonic = ""
val wallet = DirectSigningWallet(mnemonic)
val accAddress = wallet.getAccounts()[0].address
val client = SigningCosmWasmClient.init(
    grpcGatewayEndpoint,
    accAddress,
    wallet
)
```

#### Query Contract

```kotlin
val contractAddress = "secret1lz4m46vpdn8f2aj8yhtnexus40663udv7hhprm"
val contractInfoQuery = """{"contract_info": {}}"""
val contractInfo = client.queryContractSmart(contractAddress, contractInfoQuery)
println("nft contract info response: $contractInfo")
```

#### Simulate Execute + Execute + Query Contract(Generate and use viewing key for query)

```kotlin
// Entropy: Secure implementation is left to the client, but it is recommended to use base-64 encoded random bytes and not predictable inputs.
val entropy = "Another really random thing??"
val handleMsg = """{ "create_viewing_key": {"entropy": "$entropy"} }"""
println("Creating viewing key")
val msgs = listOf(
    MsgExecuteContract(
        sender = accAddress,
        contractAddress = contractAddress,
        msg = handleMsg,
        codeHash = "" // optional but faster if you include
    )
)
val simulate = client.simulate(msgs)
val gasLimit = (simulate.gasUsed.toDouble() * 1.1).toInt()
val response = client.execute(
    msgs,
    txOptions = TxOptions(gasLimit = gasLimit)
)
println("viewing key response: ${response.data}")
val viewingKey = json.parseToJsonElement(response.data[0])
    .jsonObject["viewing_key"]!!
    .jsonObject["key"]!!.jsonPrimitive.content
println("Querying Num Tokens")
val numTokensQuery =
    """
    {
        "num_tokens": {
            "viewer": {
                "address": "$accAddress",
                "viewing_key": "$viewingKey"
            }
        }
    }
    """

val numTokens = client.queryContractSmart(contractAddress, numTokensQuery)
println("Num Tokens Response: $numTokens")
```

### Swift

#### Create SigningCosmWasmClient

```swift
let wallet = DirectSigningWallet(mnemonic: mnemonic)
let accAddress = (try! await wallet.getAccounts())[0].address
let SigningCosmWasmClientCompanion = SigningCosmWasmClient.Companion()
let client = try! await SigningCosmWasmClient.Companion.doInit(SigningCosmWasmClientCompanion)(
    apiUrl: grpcGatewayEndpoint,
    senderAddress: accAddress,
    signer: wallet,
    seed: nil,
    broadcastMode: BroadcastMode.block
)
```

#### Query Contract

```swift
let contractAddress = "secret1lz4m46vpdn8f2aj8yhtnexus40663udv7hhprm"
let contractInfoQuery = #"{"contract_info": {}}"#
let contractInfo = try! await client.queryContractSmart(
    contractAddress: contractAddress,
    queryMsg: contractInfoQuery,
    contractCodeHash: nil)
print("nft contract info response: \(contractInfo)")
```

#### Simulate Execute + Execute + Query Contract(Generate and use viewing key for query)

```swift
// Entropy: Secure implementation is left to the client, but it is recommended to use base-64 encoded random bytes and not predictable inputs.
let msgs = [
    MsgExecuteContract(
        sender: accAddress,
        contractAddress: contractAddress,
        msg: handleMsg,
        sentFunds: [],
        codeHash: nil  // optional but faster if you include
    )
]
let simulate = try! await client.simulate(msgs: msgs, txOptions: TxOptions())
let gasLimit = Int32(Double(simulate.gasUsed)! * 1.1)
let response = try! await client.execute(
    msgs: msgs,
    txOptions: TxOptions(customGasLimit: gasLimit)
)
print("viewing key response: \(response.data)")

let decoder = JSONDecoder()
struct ViewingKey: Codable {
    var viewing_key: ViewingKeyValue
    struct ViewingKeyValue: Codable{
        var key: String
    }
}
let viewingKey = try! decoder.decode(ViewingKey.self, from: response.data[0].data(using: .utf8)!)

print("Querying Num Tokens")
let numTokensQuery = #"""
    {
        "num_tokens": {
            "viewer": {
                "address": "\#(accAddress)",
                "viewing_key": "\#(viewingKey.viewing_key.key)"
            }
        }
    }
    """#
let numTokens = try! await client.queryContractSmart(
    contractAddress: contractAddress,
    queryMsg: numTokensQuery,
    contractCodeHash: nil)
print("Num Tokens Response: \(numTokens)")
```
