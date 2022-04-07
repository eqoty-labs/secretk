package io.eqoty.client

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.eqoty.BroadcastMode
import io.eqoty.encoding.makeSignBytes
import io.eqoty.result.ExecuteResult
import io.eqoty.types.*
import io.eqoty.utils.SecretUtils
import io.eqoty.utils.toByteString
import io.eqoty.wallet.SigningCallback
import kotlinx.serialization.json.JsonObject
import okio.ByteString.Companion.decodeBase64

class SigningCosmWasmClient : CosmWasmClient {

    val apiUrl: String
    val senderAddress: String
    val signer: SigningCallback
    val fees: FeeTable

    constructor(
        apiUrl: String,
        senderAddress: String,
        signer: SigningCallback, //| OfflineSigner
        seed: UByteArray,
        customFees: FeeTable?,
        broadcastMode: BroadcastMode = BroadcastMode.Block
    ) : super(apiUrl, seed, broadcastMode) {
        this.apiUrl = apiUrl
        this.senderAddress = senderAddress
        this.anyValidAddress = senderAddress
        this.signer = signer
        this.fees = FeeTable.Default.overwrite(customFees)
    }

    constructor(
        apiUrl: String,
        senderAddress: String,
        signer:  SigningCallback, // | OfflineSigner
        enigmaUtils: SecretUtils,
        customFees: FeeTable,
        broadcastMode: BroadcastMode = BroadcastMode.Block
    ) : super(apiUrl, null, broadcastMode) {
        this.apiUrl = apiUrl
        this.senderAddress = senderAddress
        this.anyValidAddress = senderAddress
        this.signer = signer
        this.restClient.enigmautils = enigmaUtils;
        this.fees = FeeTable.Default.overwrite(customFees)
    }

    suspend fun <T: MsgValue>signAdapter(
        msgs: List<Msg<T>>,
        fee: StdFee,
        chainId: String,
        memo: String,
        accountNumber: BigInteger,
        sequence: BigInteger,
    ): StdTx<T> {
//        // offline signer interface
//        if ("sign" in this.signer) {
//            val signResponse = this.signer.sign(this.senderAddress, {
//                chain_id: chainId,
//                account_number: String(accountNumber),
//                sequence: String(sequence),
//                fee: fee,
//                msgs: msgs,
//                memo: memo,
//            });
//
//            return {
//                msg: msgs,
//                fee: signResponse.signed.fee,
//                memo: signResponse.signed.memo,
//                signatures: [signResponse.signature],
//            };
//        } else {

        // legacy interface
        val signBytes = makeSignBytes(msgs, fee, chainId, memo, accountNumber, sequence);
        val signature = signer(signBytes);
        return StdTx(
            msg = msgs,
            fee = fee,
            memo = memo,
            signatures = listOf(signature),
        )
    }

    suspend fun execute(
        contractAddress: String,
        handleMsg: JsonObject,
        memo : String = "",
        transferAmount: List<Coin>?,
        fee: StdFee = fees.exec!!,
        _contractCodeHash: String?,
    ): ExecuteResult {
        val contractCodeHash = if (_contractCodeHash == null) {
            this.restClient.getCodeHashByContractAddr(contractAddress)
        } else {
            this.restClient.codeHashCache[contractAddress] = _contractCodeHash
            _contractCodeHash
        }



        val executeMsg = MsgExecuteContract(
            MsgExecuteContractValue(
                sender= this.senderAddress,
                contract= contractAddress,
                msg= this.restClient.enigmautils.encrypt(contractCodeHash, handleMsg).toByteString().base64(),
                sent_funds= transferAmount ?: emptyList()
            )
        )

        val nonceResult =  this.getNonce(senderAddress)
        val accountNumber = nonceResult.accountNumber
        val sequence = nonceResult.sequence

        val chainId = getChainId();
        val signedTx = signAdapter(listOf(executeMsg), fee, chainId, memo, accountNumber, sequence);

        val encryptionNonce = executeMsg.value.msg.decodeBase64()!!.toByteArray().sliceArray(IntRange(0, 31)).toUByteArray()


        val result = try {
            postTx(signedTx);
        } catch (err: Throwable) {
//            try {
//                const errorMessageRgx = /failed to execute message; message index: 0: encrypted: (.+?): (?:instantiate|execute|query) contract failed/g;
//                // console.log(`Got error message: ${err.message}`);
//
//                const rgxMatches = errorMessageRgx.exec(err.message);
//                if (rgxMatches == null || rgxMatches.length != 2) {
//                    throw err;
//                }
//
//                const errorCipherB64 = rgxMatches[1];
//
//                // console.log(`Got error message: ${errorCipherB64}`);
//
//                const errorCipherBz = Encoding.fromBase64(errorCipherB64);
//
//                const errorPlainBz = await this.restClient.enigmautils.decrypt(errorCipherBz, encryptionNonce);
//
//                err.message = err.message.replace(errorCipherB64, Encoding.fromUtf8(errorPlainBz));
//            } catch (decryptionError) {
//                throw new Error(
//                        `Failed to decrypt the following error message: ${err.message}. Decryption error of the error message: ${decryptionError.message}`,
//                );
//            }

            throw err
        }
//        let data = Uint8Array.from([]);
//        if (this.restClient.broadcastMode == BroadcastMode.Block) {
//            const dataFields: MsgData[] = decodeTxData(Encoding.fromHex(result.data));
//
//            if (dataFields[0].data) {
//                // decryptedData =
//                // dataFields[0].data = JSON.parse(decryptedData.toString());
//                // @ts-ignore
//                data = await this.restClient.decryptDataField(
//                    Encoding.toHex(Encoding.fromBase64(dataFields[0].data)),
//                    [encryptionNonce],
//                );
//            }
//        }
//
//        const logs =
//        this.restClient.broadcastMode == BroadcastMode.Block
//        ? await this.restClient.decryptLogs(result.logs, [encryptionNonce])
//        : [];
//
//        return {
//                logs,
//                transactionHash: result.transactionHash,
//                // @ts-ignore
//                data,
//        };
        return TODO()
    }


}