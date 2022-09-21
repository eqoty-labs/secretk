package io.eqoty.client

import com.ionspin.kotlin.bignum.integer.toBigInteger
import io.eqoty.BroadcastMode
import io.eqoty.response.PubKey
import io.eqoty.response.PubKeyMultisigThreshold
import io.eqoty.response.PubKeySecp256k1
import io.eqoty.response.TxsResponseData
import io.eqoty.result.ExecuteResult
import io.eqoty.tx.Msg
import io.eqoty.tx.MsgExecuteContract
import io.eqoty.tx.MsgInstantiateContract
import io.eqoty.tx.proto.*
import io.eqoty.types.*
import io.eqoty.utils.EncryptionUtils
import io.eqoty.utils.EnigmaUtils
import io.eqoty.utils.decodeToString
import io.eqoty.utils.ensureLibsodiumInitialized
import io.eqoty.wallet.*
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.decodeHex

class SigningCosmWasmClient//| OfflineSigner
private constructor(
    val apiUrl: String,
    val senderAddress: String,
    val wallet: Wallet,
    encryptionUtils: EncryptionUtils,
    customFees: FeeTable?,
    broadcastMode: BroadcastMode = BroadcastMode.Block
) : CosmWasmClient(apiUrl, encryptionUtils, broadcastMode) {

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
                    key = pubkey.value.decodeBase64()!!.toByteArray(),
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

    private fun extractMessageNonce(msg: MsgProto): UByteArray {
        return when (msg) {
            is MsgInstantiateContractProto -> {
                msg.initMsg.toUByteArray().copyOfRange(0, 32)
            }

            is MsgExecuteContractProto -> {
                msg.msg.toUByteArray().copyOfRange(0, 32)
            }

            else -> throw UnsupportedOperationException("Extracting nonce from a:${msg::class} is not supported")
        }
    }


    suspend fun execute(
        msgs: Array<Msg<*>>,
        memo: String = "",
        fee: StdFee? = null,
        contractCodeHash: String? = null,
    ): ExecuteResult {
        @Suppress("NAME_SHADOWING")
        val fee = fee ?: fees.exec!!

        val txRawProto = sign(fee, memo, msgs)
        val txRawBytes = ProtoBuf.encodeToByteArray(txRawProto).toUByteArray()
        val txResponse = try {
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
        val data: List<String> = if (this.restClient.broadcastMode == BroadcastMode.Block) {
            // inject tx here to standardize decoding tx responses. Since txsQuery responses (not implemented yet)
            // will actually have a tx value populated.
            txResponse.tx = AnyProto(value = txRawBytes.toByteArray())
            decodeTxResponses(txResponse)
        } else {
            emptyList()
        }


        return ExecuteResult(
            logs = txResponse.logs,
            transactionHash = txResponse.txhash,
            data = data
        )
    }

    private suspend fun sign(
        fee: StdFee,
        memo: String,
        messages: Array<Msg<*>>,
    ): TxRawProto {
        val accountFromSigner = wallet.getAccounts().find { account ->
            account.address == this.senderAddress
        } ?: throw Error("Failed to retrieve account from signer")
        val nonceResult = this.getNonce(senderAddress)
        val signerData = SignerData(
            nonceResult.accountNumber,
            nonceResult.sequence,
            getChainId()
        )

        return when (wallet) {
            is DirectSigningWallet -> {
                signDirect(accountFromSigner, messages, fee, memo, signerData)
            }

            else -> {
                signAmino(accountFromSigner, messages, fee, memo, signerData)
            }
        }

    }


    private suspend fun signDirect(
        account: AccountData,
        msgs: Array<Msg<*>>,
        fee: StdFee,
        memo: String,
        signerData: SignerData,
    ): TxRawProto {
        val wallet: DirectSigningWallet = wallet as DirectSigningWallet
        val txBody = TxBody(
            value = TxBodyValue(
                messages = msgs
                    .map { msg ->
                        msg.populateCodeHash()
                        msg.toProto(this.restClient.enigmautils)
                    },
                memo = memo
            )
        )

        val txBodyBytes = encodeTx(txBody)
        val pubkey = encodePubkey(encodeSecp256k1Pubkey(account.pubkey))
        val gasLimit = fee.gas


        val authInfoBytes = makeAuthInfoBytes(
            listOf(Signer(pubkey, signerData.sequence)),
            fee.amount,
            gasLimit,
            SignMode.SIGN_MODE_DIRECT
        )

        val signDoc = SignDocProto(
            txBodyBytes,
            authInfoBytes,
            signerData.chainId,
            signerData.accountNumber.intValue(),
        )

        val signResponse = wallet.signDirect(
            this.senderAddress,
            signDoc,
        )
        val signature = signResponse.signature
        return TxRawProto(
            bodyBytes = signDoc.bodyBytes,
            authInfoBytes = signDoc.authInfoBytes,
            signatures = listOf(signature.signature.decodeBase64()!!.toByteArray()),
        )
    }

    private suspend fun signAmino(
        account: AccountData,
        messages: Array<Msg<*>>,
        fee: StdFee,
        memo: String,
        signerData: SignerData,
    ): TxRawProto {
        val signMode = wallet.getSignMode() ?: SignMode.SIGN_MODE_LEGACY_AMINO_JSON
        val msgs = messages.map { msg ->
            msg.populateCodeHash()
            msg.toAmino(this.restClient.enigmautils)
        }

        val signDoc = StdSignDoc(
            msgs = msgs,
            fee = fee,
            chainId = signerData.chainId,
            memo = memo,
            accountNumber = signerData.accountNumber.toString(10),
            sequence = signerData.sequence.toString(10),
        )
        val signResponse = wallet.signAmino(
            account.address,
            signDoc,
        )

        val txBody = TxBody(
            value = TxBodyValue(
                messages = messages
                    .map { msg ->
                        msg.populateCodeHash()
                        msg.toProto(this.restClient.enigmautils)
                    },
                memo = memo
            )
        )

        val txBodyBytes = encodeTx(txBody)
        val signedFeeAmount = signResponse.signed.fee.amount
        val signedGasLimit = signResponse.signed.fee.gas
        val signedSequence = signResponse.signed.sequence.toBigInteger(10)
        val pubkey = encodePubkey(encodeSecp256k1Pubkey(account.pubkey))
        val signedAuthInfoBytes = makeAuthInfoBytes(
            listOf(Signer(pubkey, signedSequence)),
            signedFeeAmount,
            signedGasLimit,
            signMode
        )
        val signature = signResponse.signature
        return TxRawProto(
            bodyBytes = txBodyBytes,
            authInfoBytes = signedAuthInfoBytes,
            signatures = listOf(signature.signature.decodeBase64()!!.toByteArray()),
        )
    }

    private suspend fun Msg<*>.populateCodeHash() {
        if (this is MsgExecuteContract) {
            if (codeHash == null) {
                codeHash = restClient.getCodeHashByContractAddr(contractAddress)
            }
        } else if (this is MsgInstantiateContract) {
            if (codeHash == null) {
                TODO()
//                msg.codeHash = await this.query.compute.codeHash(Number(msg.codeId));
            }
        }
    }

    /**
     * Creates and serializes an AuthInfo document.
     *
     * This implementation does not support different signing modes for the different signers.
     */
    private fun makeAuthInfoBytes(
        signers: List<Signer>,
        amount: List<Coin>,
        gasLimit: Int,
        signMode: SignMode
    ): ByteArray {
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
    private fun makeSignerInfos(
        signers: List<Signer>,
        signMode: SignMode
    ): List<SignerInfoProto> {
        return signers.map { signer ->
            SignerInfoProto(
                publicKey = signer.pubkey,
                modeInfo = ModeInfoProto(single = ModeInfoProtoSingle(signMode.value)),
                sequence = signer.sequence.intValue()
            )
        }
    }


    private fun encodeTx(txBody: TxBody<out MsgProto>): ByteArray {
        val wrappedMessages = txBody.value.messages
            .map { message ->
                val anyValue = when (message.value) {
                    is MsgInstantiateContractProto -> {
                        ProtoBuf.encodeToByteArray(message.value)
                    }

                    is MsgExecuteContractProto -> {
                        ProtoBuf.encodeToByteArray(message.value)
                    }

                    else -> TODO()
                }
                AnyProto(
                    typeUrl = message.typeUrl,
                    value = anyValue
                )
            }
        val txBodyEncoded = TxBodyProto(
            messages = wrappedMessages,
            memo = txBody.value.memo
        )
        return ProtoBuf.encodeToByteArray(txBodyEncoded)
    }

    private suspend fun decodeTxResponses(postTxResult: TxsResponseData): List<String> {
        val nonces = mutableMapOf<Int, UByteArray>()
        val txRaw: TxRawProto = ProtoBuf.decodeFromByteArray(postTxResult.tx!!.value)
        val txBody: TxBodyProto = ProtoBuf.decodeFromByteArray(txRaw.bodyBytes)

        val msgs: List<MsgProto> = txBody.messages.map { it.toMsg() }
        msgs.forEachIndexed { i, anyProto ->
            nonces[i] = extractMessageNonce(anyProto)
        }

        val txMsgData: TxMsgDataProto = ProtoBuf.decodeFromByteArray(postTxResult.data.decodeHex().toByteArray())
        val dataFields = txMsgData.data
        val data = dataFields.mapIndexed { i, msgDataProto ->
            val msgExecuteContractResponse: MsgExecuteContractResponseProto =
                ProtoBuf.decodeFromByteArray(msgDataProto.data)
            restClient.decryptDataField(msgExecuteContractResponse.data.toUByteArray(), nonces[i]!!)
        }

        this.restClient.decryptLogs(
            postTxResult.logs,
            nonces.values.toList()
        )

        return data.map { it.decodeToString() }
    }


    companion object {
        suspend fun init(
            apiUrl: String,
            senderAddress: String,
            signer: Wallet, //| OfflineSigner
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
            pen: BaseWallet, // | OfflineSigner
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