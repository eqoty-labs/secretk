package io.eqoty.dapp.secret.utils

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.cosmwasm.std.types.ContractInfo
import io.eqoty.secret.std.contract.msg.Snip20Msgs
import io.eqoty.secret.std.types.Permission
import io.eqoty.secret.std.types.Permit
import io.eqoty.secretk.client.Json
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.secretk.extensions.accesscontrol.PermitFactory
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString

object BalanceUtils {

    private val snip20ToAddressPermit = mutableMapOf<ContractInfo, MutableMap<String, Permit>>()

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
        client: SigningCosmWasmClient, senderAddress: String, contract: ContractInfo
    ): BigInteger? {
        val permit = snip20ToAddressPermit.getOrPut(contract) { mutableMapOf() }.getOrPut(senderAddress) {
            PermitFactory.newPermit(
                client.wallet!!,
                senderAddress,
                client.chainId!!,
                "balanceUtilsPermit",
                listOf(contract.address),
                listOf(Permission.Balance)
            )
        }
        val query = Json.encodeToString(
            Snip20Msgs.Query(
                withPermit = Snip20Msgs.Query.WithPermit(
                    permit = permit, query = Snip20Msgs.QueryWithPermit(balance = Snip20Msgs.QueryWithPermit.Balance())
                )
            )
        )
        val response = client.queryContractSmart(
            contract.address, query, contract.codeHash
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
}