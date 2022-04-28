package io.eqoty.client

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import io.eqoty.BroadcastMode
import io.eqoty.response.PubKey
import io.eqoty.response.PubKeyMultisigThreshold
import io.eqoty.response.PubKeySecp256k1
import io.eqoty.result.ExecuteResult
import io.eqoty.tx.MsgExecuteContract
import io.eqoty.tx.ProtoMsg
import io.eqoty.tx.proto.*
import io.eqoty.types.*
import io.eqoty.utils.EncryptionUtils
import io.eqoty.utils.EnigmaUtils
import io.eqoty.utils.decodeToString
import io.eqoty.utils.ensureLibsodiumInitialized
import io.eqoty.wallet.Secp256k1Pen
import io.eqoty.wallet.encodeSecp256k1Pubkey
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.decodeHex

class SigningCosmWasmClient//| OfflineSigner
private constructor(
    val apiUrl: String,
    val senderAddress: String,
    signer: Secp256k1Pen,
    encryptionUtils: EncryptionUtils,
    customFees: FeeTable?,
    broadcastMode: BroadcastMode = BroadcastMode.Block
) : CosmWasmClient(apiUrl, encryptionUtils, broadcastMode) {

    val pen: Secp256k1Pen = signer
    val fees: FeeTable

    init {
        this.fees = FeeTable.Default.overwrite(customFees)
    }



//    inline fun <reified T: MsgValue> signAdapter(
//        msgs: List<TypeValue<T>>,
//        fee: StdFee,
//        chainId: String,
//        memo: String,
//        accountNumber: BigInteger,
//        sequence: BigInteger,
//    ): StdTx<T> {
////        // offline signer interface
////        if ("sign" in this.signer) {
////            val signResponse = this.signer.sign(this.senderAddress, {
////                chain_id: chainId,
////                account_number: String(accountNumber),
////                sequence: String(sequence),
////                fee: fee,
////                msgs: msgs,
////                memo: memo,
////            });
////
////            return {
////                msg: msgs,
////                fee: signResponse.signed.fee,
////                memo: signResponse.signed.memo,
////                signatures: [signResponse.signature],
////            };
////        } else {
//
//        // legacy interface
//        val signBytes = makeSignBytes(msgs, fee, chainId, memo, accountNumber, sequence)
//        val signature = signer(signBytes)
//        return StdTx(
//            msg = msgs.toList(),
//            fee = fee,
//            memo = memo,
//            signatures = listOf(signature),
//        )
//    }

    private fun encodePubkey(
    pubkey: PubKey,
    ): AnyProto {
        when (pubkey) {
            is PubKeySecp256k1 -> {
                val pubkeyProto = KeyProto(
                    key =  (pubkey as PubKeySecp256k1).value.decodeBase64()!!.toByteArray(),
                )
                return AnyProto(
                    typeUrl = "/cosmos.crypto.secp256k1.PubKey",
                    value = ProtoBuf.encodeToByteArray(pubkeyProto),
                )
            }
            is PubKeyMultisigThreshold -> {
                TODO()
    //            const { LegacyAminoPubKey } = await import(
    //                    "./protobuf_stuff/cosmos/crypto/multisig/keys"
    //                    )
    //
    //            const pubkeyProto = LegacyAminoPubKey.fromPartial({
    //                threshold: Number(pubkey.value.threshold),
    //                publicKeys: pubkey.value.pubkeys.map(encodePubkey),
    //            })
    //            return Any.fromPartial({
    //                typeUrl: "/cosmos.crypto.multisig.LegacyAminoPubKey",
    //                value: Uint8Array.from(LegacyAminoPubKey.encode(pubkeyProto).finish()),
    //            })
            }
            else -> TODO()
        }
    }


    private fun <M: MsgProto>extractNonce(msg: ProtoMsg<M>): UByteArray {
        if (msg.typeUrl === "/secret.compute.v1beta1.MsgInstantiateContract") {
            return (msg.value as MsgInstantiateContractProto).initMsg.toUByteArray().copyOfRange(0, 32)
        }
        if (msg.typeUrl === "/secret.compute.v1beta1.MsgExecuteContract") {
            return (msg.value as MsgExecuteContractProto).msg.toUByteArray().copyOfRange(0, 32)
        }
        return ubyteArrayOf()
    }

    suspend fun execute(
        contractAddress: String,
        msg: MsgExecuteContract,
        memo : String = "",
        transferAmount: List<Coin>? = null,
        fee: StdFee? = null,
        contractCodeHash: String? = null,
    ): ExecuteResult {
        @Suppress("NAME_SHADOWING")
        val fee = fee ?: fees.exec!!
        @Suppress("NAME_SHADOWING")
        val contractCodeHash = if (contractCodeHash == null) {
            this.restClient.getCodeHashByContractAddr(contractAddress)
        } else {
            this.restClient.codeHashCache[contractAddress] = contractCodeHash
            contractCodeHash
        }

        val encryptionNonces= mutableListOf<UByteArray>()
        val txBody = TxBody(
            value = TxBodyValue(
                messages = listOf(msg)
                    .map{
                        it.codeHash = contractCodeHash
                        val asProto = it.toProto(this.restClient.enigmautils)
                        encryptionNonces.add(extractNonce(asProto))
                        asProto
                    },
                memo = memo
            )
        )

        val txBodyBytes = encodeTx(txBody)
        val pubkey = encodePubkey(encodeSecp256k1Pubkey(this.pen.pubkey))
        val gasLimit = fee.gas
        val nonceResult =  this.getNonce(senderAddress)
        val sequence = nonceResult.sequence
        val accountNumber = nonceResult.accountNumber
        val chainId = getChainId()

        val authInfoBytes = makeAuthInfoBytes(
            listOf(Signer(pubkey, sequence)),
            fee.amount,
            gasLimit,
            SignMode.SIGN_MODE_DIRECT
        )

        val signDoc = SignDocProto(
            txBodyBytes,
            authInfoBytes,
            chainId,
            accountNumber.intValue(),
        )

        val signature = this.pen.signDirect(
            this.senderAddress,
            signDoc,
        )
        val txRawProto = TxRawProto(
            bodyBytes = signDoc.bodyBytes,
            authInfoBytes = signDoc.authInfoBytes,
            signatures = listOf(signature.signature.decodeBase64()!!.toByteArray()),
        )
        val txRawBytes = ProtoBuf.encodeToByteArray(txRawProto).toUByteArray()

        val result = try {
            postTx(txRawBytes)
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
        var data : UByteArray = ubyteArrayOf()
        if (this.restClient.broadcastMode == BroadcastMode.Block) {
            val txMsgData: TxMsgDataProto = ProtoBuf.decodeFromByteArray(result.data.decodeHex().toByteArray());
            val dataFields = txMsgData.data
            if (dataFields[0].data.isNotEmpty()) {
                data = this.restClient.decryptDataField(dataFields[0].data.toUByteArray(), encryptionNonces)
            }
        }

        if (this.restClient.broadcastMode == BroadcastMode.Block) this.restClient.decryptLogs(result.logs, encryptionNonces)


        return ExecuteResult(
            logs = result.logs,
            transactionHash = result.transactionHash,
            data = data.decodeToString()
        )
    }



    /**
     * Creates and serializes an AuthInfo document.
     *
     * This implementation does not support different signing modes for the different signers.
     */
    private fun makeAuthInfoBytes(signers: List<Signer>, amount: List<Coin>, gasLimit: Int, signMode: SignMode): ByteArray {
        val authInfo = AuthInfoProto(
            signerInfos = makeSignerInfos(signers, signMode),
            fee = FeeProto(
                amount = amount.map { it.toProto() },
                gasLimit = gasLimit
            )
        )
        return ProtoBuf.encodeToByteArray(authInfo)
    }

    /**
     * Create signer infos from the provided signers.
     *
     * This implementation does not support different signing modes for the different signers.
     */
    private fun  makeSignerInfos(
    signers: List<Signer>,
    signMode: SignMode
    ): List<SignerInfoProto> {
        return signers.map{ signer->
            SignerInfoProto(
                publicKey = signer.pubkey,
                modeInfo= ModeInfoProto(single =ModeInfoProtoSingle(signMode.value)),
                sequence= signer.sequence.intValue()
            )
        }
    }
    

    private fun encodeTx(txBody: TxBody<MsgExecuteContractProto>): ByteArray {
        val wrappedMessages = txBody.value.messages
            .map { message ->
                AnyProto(
                    typeUrl = message.typeUrl,
                    value = ProtoBuf.encodeToByteArray(message.value),
                )

            }
        val txBodyEncoded = TxBodyProto(
            messages = wrappedMessages,
            memo = txBody.value.memo
        )
        return ProtoBuf.encodeToByteArray(txBodyEncoded)
    }


    companion object {
        suspend fun init(
            apiUrl: String,
            senderAddress: String,
            signer: Secp256k1Pen, //| OfflineSigner
            seed: UByteArray? = null,
            customFees: FeeTable? = null,
            broadcastMode: BroadcastMode = BroadcastMode.Block
        ): SigningCosmWasmClient {
            ensureLibsodiumInitialized()
            return SigningCosmWasmClient(
                apiUrl,
                senderAddress,
                signer,
                EnigmaUtils(apiUrl, seed ?: EnigmaUtils.GenerateNewSeed()),
                customFees,
                broadcastMode
            )
        }

        suspend fun init(
            apiUrl: String,
            senderAddress: String,
            pen:  Secp256k1Pen, // | OfflineSigner
            enigmaUtils: EncryptionUtils,
            customFees: FeeTable? = null,
            broadcastMode: BroadcastMode = BroadcastMode.Block
        ): SigningCosmWasmClient {
            ensureLibsodiumInitialized()
            return SigningCosmWasmClient(
                apiUrl,
                senderAddress,
                pen,
                enigmaUtils,
                customFees,
                broadcastMode
            )
        }
    }


}