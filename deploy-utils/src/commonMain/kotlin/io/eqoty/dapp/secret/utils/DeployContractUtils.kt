import io.eqoty.cosmwasm.std.types.CodeInfo
import io.eqoty.dapp.secret.types.ContractInstance
import io.eqoty.dapp.secret.utils.fileSystem
import io.eqoty.dapp.secret.utils.logger
import io.eqoty.secretk.client.SigningCosmWasmClient
import io.eqoty.secretk.types.MsgInstantiateContract
import io.eqoty.secretk.types.MsgStoreCode
import io.eqoty.secretk.types.TxOptions
import okio.Path

object DeployContractUtils {

    private val storedCode = mutableMapOf<Int, CodeInfo>()

    suspend fun getOrStoreCode(
        client: SigningCosmWasmClient,
        senderAddress: String,
        contractCodePath: Path,
        gasLimit: Int?,
    ): CodeInfo {
        val wasmBytes =
            fileSystem.read(contractCodePath) {
                readByteArray()
            }

        return storedCode.getOrPut(wasmBytes.contentHashCode()) {
            storeCode(client, senderAddress, wasmBytes, gasLimit)
        }
    }

    suspend fun storeCode(
        client: SigningCosmWasmClient,
        senderAddress: String,
        contractCodePath: Path,
        gasLimit: Int?,
    ): CodeInfo {
        val wasmBytes =
            fileSystem.read(contractCodePath) {
                readByteArray()
            }
        return storeCode(client, senderAddress, wasmBytes, gasLimit)
    }

    private suspend fun storeCode(
        client: SigningCosmWasmClient,
        senderAddress: String,
        wasmBytes: ByteArray,
        gasLimit: Int?,
    ): CodeInfo {
        val msgs0 = listOf(
            MsgStoreCode(
                sender = senderAddress,
                wasmByteCode = wasmBytes.toUByteArray(),
            )
        )
        val limit = if (gasLimit == null) {
            val simulate = client.simulate(msgs0)
            (simulate.gasUsed.toDouble() * 1.1).toInt()
        } else {
            gasLimit
        }
        val response = client.execute(
            msgs0,
            txOptions = TxOptions(gasLimit = limit)
        )

        val codeId = response.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "code_id" }?.value!!
        logger.i("codeId:  $codeId")

        return client.getCodeInfoByCodeId(codeId)
    }

    suspend fun instantiateCode(
        client: SigningCosmWasmClient,
        codeInfo: CodeInfo,
        instantiateMsgs: List<MsgInstantiateContract>,
        gasLimit: Int?,
    ): ContractInstance {
        instantiateMsgs.forEach {
            it.codeId = codeInfo.codeId.toInt()
            it.codeHash = codeInfo.codeHash
        }
        val limit = if (gasLimit == null) {
            val simulate = client.simulate(instantiateMsgs)
            (simulate.gasUsed.toDouble() * 1.1).toInt()
        } else {
            gasLimit
        }
        val instantiateResponse = client.execute(
            instantiateMsgs,
            txOptions = TxOptions(gasLimit = limit)
        )
        val contractAddress = instantiateResponse.logs[0].events
            .find { it.type == "message" }
            ?.attributes
            ?.find { it.key == "contract_address" }?.value!!
        logger.i("contract address:  $contractAddress")
        return ContractInstance(codeInfo, contractAddress)
    }

    suspend fun getOrStoreCodeAndInstantiate(
        client: SigningCosmWasmClient,
        senderAddress: String,
        codePath: Path,
        instantiateMsgs: List<MsgInstantiateContract>,
        storeCodeGasLimit: Int?,
        instantiateGasLimit: Int?,
    ): ContractInstance {
        val codeInfo = getOrStoreCode(client, senderAddress, codePath, storeCodeGasLimit)
        return instantiateCode(client, codeInfo, instantiateMsgs, instantiateGasLimit)
    }

}
