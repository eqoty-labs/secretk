# secretk
CosmWasm SDK + Encryption for the Secret Network

A Kotlin multiplatform REST client utilizing secret network's gRPC gateway endpoints.  

Based on: 
https://github.com/scrtlabs/SecretNetwork/tree/f01dda32b12e02c6cc2326ea58f8b13bf6e3ff8f/cosmwasm-js/packages/sdk



### Supported Features:
* Contract Queries
* Contract Execution (Secret Network >= v1.2.6)
* TODO: Contract Execution Gas Estimation
* TODO: Contract Uploading

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

```
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.eqoty.secretk:0.1.0")
}
```

### Swift Package Manager
you need to declare your dependency in your `Package.swift`:

```
.package(url: "https://github.com/eqoty-labs/secretk.git", from: "0.1.0"),
```


## Useage 

### Kotlin

* Create SigningCosmWasmClient
```
val grpcGatewayEndpoint = "http://secretnetworkendpoint.com:1337"
val mnemonic = ""
val signingPen = Secp256k1Pen.fromMnemonic(mnemonic)
val pubkey = encodeSecp256k1Pubkey(signingPen.pubkey)
val accAddress = pubkeyToAddress(pubkey, "secret")

val client = SigningCosmWasmClient.init(
    grpcGatewayEndpoint,
    accAddress,
    signingPen
)
```
* Query Contract
```
val contractAddress = "secret18vd8fpwxzck93qlwghaj6arh4p7c5n8978vsyg"
val contractInfoQuery = """{"contract_info": {}}"""
val contractInfo = client.queryContractSmart(contractAddress, contractInfoQuery)
println("nft contract info response: $contractInfo")
```
* Execute Contract + Query (Generate and use viewing key for query)
```
// Entropy: Secure implementation is left to the client, but it is recommended to use base-64 encoded random bytes and not predictable inputs.
val entropy = "Another really random thing??"
val handleMsg = """{ "create_viewing_key": {"entropy": "$entropy"} }"""
println("Creating viewing key");
val response = client.execute(
    contractAddress,
    MsgExecuteContract(
        sender = accAddress,
        contractAddress = contractAddress,
        msg = handleMsg,
        codeHash = "" // optional but faster if you include
    ),
    _contractCodeHash = "" // optional but faster if you include
)
println("viewing key response: ${response.data}")
val viewingKey = json.parseToJsonElement(response.data)
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

val numTokens = client.queryContractSmart(contractAddress, numTokensQuery);
println("Num Tokens Response: $numTokens")
```




### Swift

* Create SigningCosmWasmClient
```
let Secp256k1PenCompanion = Secp256k1Pen.Companion()
let signingPen = try await Secp256k1Pen.Companion.fromMnemonic(Secp256k1PenCompanion)(
    mnemonic: mnemonic, hdPath: Secp256k1PenKt.makeSecretNetworkPath(a: 0)
)

let pubkey = PubkeyKt.encodeSecp256k1Pubkey(pubkey: signingPen.pubkey)
let accAddress = Address().pubkeyToAddress(pubkey: pubkey, prefix: "secret")
let SigningCosmWasmClientCompanion = SigningCosmWasmClient.Companion()
let client = try await SigningCosmWasmClient.Companion.doInit(SigningCosmWasmClientCompanion)(
    apiUrl: grpcGatewayEndpoint,
    senderAddress: accAddress,
    signer: signingPen,
    seed: nil,
    customFees: nil,
    broadcastMode: BroadcastMode.block
)
```
* Query Contract
```
val contractAddress = "secret18vd8fpwxzck93qlwghaj6arh4p7c5n8978vsyg"
let contractInfoQuery = #"{"contract_info": {}}"#
let contractInfo = try await client.queryContractSmart(
    contractAddress: contractAddress,
    queryMsg: contractInfoQuery,
    contractCodeHash: nil)
print("nft contract info response: \(contractInfo)")
```
* Execute Contract + Query (Generate and use viewing key for query)
```
// Entropy: Secure implementation is left to the client, but it is recommended to use base-64 encoded random bytes and not predictable inputs.
let entropy = "Another really random thing??"
let handleMsg = #"{ "create_viewing_key": {"entropy": "\#(entropy)"} }"#
print("Creating viewing key");
let response = try await client.execute(
    contractAddress: contractAddress,
    msg: MsgExecuteContract(
        sender: accAddress,
        contractAddress: contractAddress,
        msg: handleMsg,
        sentFunds: [],
        codeHash: nil
        /*codeHash = "f7711ac771565a1cb0db516a63a63742e11651516b8dfcf19ecd08aaec1e0193"*/),
    memo: "",
    transferAmount: nil,
    fee: client.fees.exec!,
    contractCodeHash: nil
)
print("viewing key response: \(response.data)")
let viewingKeyObject = response.data.convertToDictionary()?["viewing_key"] as? [String : Any]
let viewingKey = viewingKeyObject?["key"] as! String

print(viewingKeyObject)
print(viewingKey)
print("Querying Num Tokens")
let numTokensQuery = #"""
    {
        "num_tokens": {
            "viewer": {
                "address": "\#(accAddress)",
                "viewing_key": "\#(viewingKey)"
            }
        }
    }
    """#
let numTokens = try await client.queryContractSmart(
    contractAddress: contractAddress,
    queryMsg: numTokensQuery,
    contractCodeHash: nil)
print("Num Tokens Response: \(numTokens)")
```
