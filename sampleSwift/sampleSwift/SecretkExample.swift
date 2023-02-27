//
//  main.swift
//  sampleIos
//
//  Created by Luca Spinazzola on 9/21/22.
//

import Foundation
import client



@main
struct SecretkExample {
    static func main() async {
        let mnemonic = "sand check forward humble between movie language siege where social crumble mouse"
        let grpcGatewayEndpoint = "https://api.pulsar.scrttestnet.com"
        let wallet = DirectSigningWallet(mnemonic: mnemonic)
        let accAddress = (try! await wallet.getAccounts())[0].address
        let SigningCosmWasmClientCompanion = SigningCosmWasmClient.Companion()
        let client = try! await SigningCosmWasmClient.Companion.doInit(SigningCosmWasmClientCompanion)(
            apiUrl: grpcGatewayEndpoint,
            senderAddress: accAddress,
            wallet: wallet,
            seed: nil,
            broadcastMode: BroadcastMode.block,
            chainId: nil
        )

        let contractAddress = "secret1lz4m46vpdn8f2aj8yhtnexus40663udv7hhprm"
        let contractInfoQuery = #"{"contract_info": {}}"#
        let contractInfo = try! await client.queryContractSmart(
            contractAddress: contractAddress,
            queryMsg: contractInfoQuery,
            contractCodeHash: nil)
        print("nft contract info response: \(contractInfo)")
        
        // Entropy: Secure implementation is left to the client, but it is recommended to use base-64 encoded random bytes and not predictable inputs.
        let entropy = "Another really random thing??"
        let handleMsg = #"{ "create_viewing_key": {"entropy": "\#(entropy)"} }"#
        print("Creating viewing key");
        let msgs = [
            MsgExecuteContract(
                sender: accAddress,
                contractAddress: contractAddress,
                msg: handleMsg,
                sentFunds: [],
                codeHash: nil
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
    }
    
}

