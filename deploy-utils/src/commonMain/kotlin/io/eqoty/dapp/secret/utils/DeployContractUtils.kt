import co.touchlab.kermit.Logger
import io.eqoty.cosmwasm.std.types.CodeInfo
import io.eqoty.dapp.secret.types.ContractInfo
import io.eqoty.dapp.secret.utils.fileSystem
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.secretk.types.MsgInstantiateContract
import io.eqoty.secretk.types.MsgStoreCode
import io.eqoty.secretk.types.TxOptions
import okio.Path

object DeployContractUtils {

    private val storedCode = mutableMapOf<Int, CodeInfo>()

    suspend fun getOrStoreCode(
        client: SigningCosmWasmClient,
        contractCodePath: Path
    ): CodeInfo {
        val wasmBytes =
            fileSystem.read(contractCodePath) {
                readByteArray()
            }

        return storedCode.getOrPut(wasmBytes.contentHashCode()) {
            storeCode(client, wasmBytes)
        }
    }

    suspend fun storeCode(
        client: SigningCosmWasmClient,
        contractCodePath: Path
    ): CodeInfo {
        val wasmBytes =
            fileSystem.read(contractCodePath) {
                readByteArray()
            }
        return storeCode(client, wasmBytes)
    }

    private suspend fun storeCode(
        client: SigningCosmWasmClient,
        wasmBytes: ByteArray
    ): CodeInfo {
        val msgs0 = listOf(
            MsgStoreCode(
                sender = client.senderAddress,
                wasmByteCode = wasmBytes.toUByteArray(),
            )
        )
        val simulate = client.simulate(msgs0)
        val gasLimit = (simulate.gasUsed.toDouble() * 1.1).toInt()
        val response = client.execute(
            msgs0,
            txOptions = TxOptions(gasLimit = gasLimit)
        )

        val codeId = response.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "code_id" }?.value!!
        Logger.i("codeId:  $codeId")

        return client.getCodeInfoByCodeId(codeId)
    }

    suspend fun instantiateCode(
        client: SigningCosmWasmClient,
        codeInfo: CodeInfo,
        instantiateMsgs: List<MsgInstantiateContract>,
    ): ContractInfo {
        instantiateMsgs.forEach {
            it.codeId = codeInfo.codeId.toInt()
            it.codeHash = codeInfo.codeHash
        }
        val simulate = client.simulate(instantiateMsgs)
        val gasLimit = (simulate.gasUsed.toDouble() * 1.1).toInt()
        val instantiateResponse = client.execute(
            instantiateMsgs,
            txOptions = TxOptions(gasLimit = gasLimit)
        )
        val contractAddress = instantiateResponse.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "contract_address" }?.value!!
        Logger.i("contract address:  $contractAddress")
        return ContractInfo(codeInfo, contractAddress)
    }

    suspend fun getOrStoreCodeAndInstantiate(
        client: SigningCosmWasmClient,
        codePath: Path,
        instantiateMsgs: List<MsgInstantiateContract>,
    ): ContractInfo {
        val codeInfo = getOrStoreCode(client, codePath)
        return instantiateCode(client, codeInfo, instantiateMsgs)
    }

}
