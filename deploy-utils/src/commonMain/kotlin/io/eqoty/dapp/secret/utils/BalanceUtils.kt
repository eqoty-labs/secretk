package io.eqoty.dapp.secret.utils

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.cosmwasm.std.types.ContractInfo
import io.eqoty.secret.std.contract.msg.Snip20Msgs
import io.eqoty.secret.std.contract.msg.SnipMsgs
import io.eqoty.secretk.client.Json
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.secretk.types.MsgExecuteContract
import io.eqoty.secretk.types.TxOptions
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.encodeToString
import kotlin.random.Random

object BalanceUtils {

    private val snip20ToAddressViewingKey =
        mutableMapOf<ContractInfo, MutableMap<String, SnipMsgs.ExecuteAnswer.ViewingKey>>()

    private val httpClient = HttpClient {
        expectSuccess = true
    }

    private val zeroUscrt = Coin("0", "uscrt")

    suspend fun fillUpFromFaucet(
        nodeInfo: NodeInfo,
        client: SigningCosmWasmClient,
        targetBalance: Int,
        address: String,
    ) {
        var balance = try {
            getScrtBalance(client, address)
        } catch (t: Throwable) {
            logger.i(t.message ?: "getScrtBalance failed")
            logger.i("Attempting to fill address $address from faucet")
            zeroUscrt
        }
        while (balance.amount.toInt() < targetBalance) {
            try {
                getFromFaucet(nodeInfo, address)
            } catch (t: Throwable) {
                throw RuntimeException("failed to get tokens from faucet: $t")
            }
            var newBalance = balance
            val maxTries = 10
            var tries = 0
            while (balance == newBalance) {
                // the api doesn't update immediately. So retry until the balance changes
                newBalance = try {
                    getScrtBalance(client, address)
                } catch (t: Throwable) {
                    logger.i("getScrtBalance try ${++tries}/$maxTries failed with: ${t.message}")
                    zeroUscrt
                }
                if (tries >= maxTries) {
                    throw RuntimeException("getScrtBalance did not update after $maxTries trys")
                }
            }
            balance = newBalance
            logger.i("got tokens from faucet. New balance: $balance, target balance: $targetBalance")
        }
    }

    suspend fun getScrtBalance(client: SigningCosmWasmClient, address: String): Coin {
        val balance = client.getBalance(address).balances
        return balance.getOrNull(0) ?: zeroUscrt
    }

    suspend fun getSnip20Balance(
        client: SigningCosmWasmClient,
        senderAddress: String,
        contract: ContractInfo
    ): BigInteger? {
        val viewingKey =
            snip20ToAddressViewingKey[contract]?.get(senderAddress)
                ?: createViewingKey(client, senderAddress, contract).apply {
                    snip20ToAddressViewingKey[contract]?.set(senderAddress, this)
                }
        val query =
            Json.encodeToString(Snip20Msgs.Query(balance = Snip20Msgs.Query.Balance(senderAddress, viewingKey.key)))
        val response = client.queryContractSmart(
            contract.address,
            query,
            contract.codeHash
        )
        return Json.decodeFromString<Snip20Msgs.QueryAnswer>(response).balance!!.amount
    }

    private suspend fun getFromFaucet(
        nodeInfo: NodeInfo, address: String
    ): String {
        val response = when (nodeInfo) {
            is Pulsar2, is Pulsar3 -> {
                httpClient.post(nodeInfo.faucetAddressEndpoint!!) {
                    contentType(ContentType.Application.Json)
                    setBody(
                        """
                            {
                                "denom": "uscrt",
                                "address": "$address"
                            }
                        """
                    )
                }
            }

            else -> {
                httpClient.get(nodeInfo.createFaucetAddressGetEndpoint(address))
            }
        }
        return response.bodyAsText()
    }

    private suspend fun createViewingKey(
        client: SigningCosmWasmClient,
        senderAddress: String,
        contract: ContractInfo
    ): SnipMsgs.ExecuteAnswer.ViewingKey {
        val entropy = Random.nextBytes(40).encodeBase64()
        val msg = Json.encodeToString(SnipMsgs.Execute(createViewingKey = SnipMsgs.Execute.CreateViewingKey(entropy)))
        val msgs = listOf(
            MsgExecuteContract(
                sender = senderAddress,
                contractAddress = contract.address,
                codeHash = contract.codeHash,
                msg = msg,
            )
        )
        val simulate = client.simulate(msgs)
        val gasLimit = (simulate.gasUsed.toDouble() * 1.1).toInt()

        val response = client.execute(
            msgs,
            txOptions = TxOptions(gasLimit = gasLimit)
        )
        return Json.decodeFromString<SnipMsgs.ExecuteAnswer>(response.data[0]).viewingKey!!
    }


}