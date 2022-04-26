# secretk
CosmWasm SDK + Encryption for the Secret Network

A Kotlin multiplatform port of https://github.com/scrtlabs/SecretNetwork/tree/f01dda32b12e02c6cc2326ea58f8b13bf6e3ff8f/cosmwasm-js/packages/sdk

##Build Requirements
* Xcode 13.2.1: https://github.com/leetal/ios-cmake/issues/141



## Useage
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
* Execute Contract (Secret Network >= v1.2.6)
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
println("viewing key response: ${response.data.decodeToString()}")
val viewingKey = json.parseToJsonElement(response.data.decodeToString())
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