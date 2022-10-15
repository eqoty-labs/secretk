package io.eqoty.secretk.client

import co.touchlab.kermit.Logger
import com.ionspin.kotlin.bignum.integer.toBigInteger
import io.eqoty.secretk.BroadcastMode
import io.eqoty.secretk.types.*
import io.eqoty.secretk.types.proto.*
import io.eqoty.secretk.types.response.*
import io.eqoty.secretk.utils.EncryptionUtils
import io.eqoty.secretk.utils.EnigmaUtils
import io.eqoty.secretk.utils.decodeToString
import io.eqoty.secretk.utils.ensureLibsodiumInitialized
import io.eqoty.secretk.wallet.*
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.decodeHex
import kotlin.math.ceil

class SigningCosmWasmClient
private constructor(
    val apiUrl: String,
    var senderAddress: String,
    val wallet: Wallet,
    encryptionUtils: EncryptionUtils,
    broadcastMode: BroadcastMode = BroadcastMode.Block,
    chainId: String? = null
) : CosmWasmClient(apiUrl, encryptionUtils, broadcastMode, chainId) {

    init {
        Logger.setTag("secretk")
        if (chainId.isNullOrBlank()) {
            Logger.w(
                "SigningCosmWasmClient was created without the \"chainId\" parameter. This is discouraged " +
                        "and will result in slower execution times for your app."
            )
        }
    }

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

    private fun extractMessageNonceIfNeeded(msg: MsgProto): UByteArray? {
        return when (msg) {
            is MsgInstantiateContractProto -> {
                msg.initMsg.toUByteArray().copyOfRange(0, 32)
            }

            is MsgExecuteContractProto -> {
                msg.msg.toUByteArray().copyOfRange(0, 32)
            }

            else -> null
        }
    }

    suspend fun simulate(
        msgs: List<Msg<*>>,
        txOptions: TxOptions = TxOptions(),
    ): GasInfo {
        val txRawProto = prepareAndSign(msgs, txOptions)
        val txRawBytes = ProtoBuf.encodeToByteArray(txRawProto).toUByteArray()
        val simulateTxResponse = try {
            postSimulateTx(txRawBytes)
        } catch (t: Throwable) {
            throw t
        }
        return simulateTxResponse.gasInfo
    }

    suspend fun execute(
        msgs: List<Msg<*>>,
        txOptions: TxOptions = TxOptions(),
    ): TxResponseData {
        val txRawProto = prepareAndSign(msgs, txOptions)
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
        txResponse.data = if (this.restClient.broadcastMode == BroadcastMode.Block) {
            // inject tx here to standardize decoding tx responses. Since txsQuery responses (not implemented yet)
            // will actually have a tx value populated.
            txResponse.tx = AnyProto(value = txRawBytes.toByteArray())
            decodeTxResponses(txResponse)
        } else {
            emptyList()
        }

        return txResponse
    }

    private suspend fun prepareAndSign(
        messages: List<Msg<*>>,
        txOptions: TxOptions
    ): TxRawProto {
        val accountFromSigner = wallet.getAccounts().find { account ->
            account.address == senderAddress
        } ?: throw Error("Failed to retrieve account from signer")
        val nonceResult = getNonce(senderAddress)
        val signerData = txOptions.explicitSignerData
            ?: SignerData(nonceResult.accountNumber, nonceResult.sequence, getChainId())
        val fee = StdFee(
            gas = txOptions.gasLimit,
            amount = listOf(
                Coin(
                    txOptions.feeDenom,
                    gasToFee(txOptions.gasLimit, txOptions.gasPriceInFeeDenom)
                )
            ),
            granter = txOptions.feeGranter
        )

        return when (wallet) {
            is DirectSigningWallet -> {
                signDirect(accountFromSigner, messages, fee, txOptions.memo, signerData)
            }

            else -> {
                signAmino(accountFromSigner, messages, fee, txOptions.memo, signerData)
            }
        }

    }

    private suspend fun signDirect(
        account: AccountData,
        msgs: List<Msg<*>>,
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
        val gasLimit = fee.gas.toInt()


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
            senderAddress,
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
        messages: List<Msg<*>>,
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
        val signedGasLimit = signResponse.signed.fee.gas.toInt()
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
            if (codeHash.isNullOrBlank()) {
                codeHash = restClient.getCodeHashByContractAddr(contractAddress)
            }
        } else if (this is MsgInstantiateContract) {
            if (codeHash.isNullOrBlank()) {
                codeHash = restClient.getCodeInfoByCodeId(codeId.toString()).codeHash
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

                    is MsgStoreCodeProto -> {
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

    private suspend fun decodeTxResponses(postTxResult: TxResponseData): List<String> {
        val nonces = mutableMapOf<Int, UByteArray?>()
        val txRaw: TxRawProto = ProtoBuf.decodeFromByteArray(postTxResult.tx!!.value)
        val txBody: TxBodyProto = ProtoBuf.decodeFromByteArray(txRaw.bodyBytes)

        val msgs: List<MsgProto> = txBody.messages.map { it.toMsg() }
        msgs.forEachIndexed { i, anyProto ->
            nonces[i] = extractMessageNonceIfNeeded(anyProto)
        }
        val txMsgData: TxMsgDataProto = ProtoBuf.decodeFromByteArray(postTxResult.rawData.decodeHex().toByteArray())
        val dataFields = txMsgData.data
        val data = dataFields.mapIndexed { i, msgDataProto ->
            val msgTyped: MsgProto = msgDataProto.toMsgResponseType()
            restClient.decryptDataField(msgTyped, nonces[i])
        }

        this.restClient.decryptLogs(
            postTxResult.logs,
            nonces.values.toList()
        )

        return data.map { it.decodeToString() }
    }

    fun gasToFee(gasLimit: Int, gasPrice: Double): Int {
        return ceil(gasLimit.toDouble() * gasPrice).toInt()
    }

    companion object {

        @OptIn(ExperimentalUnsignedTypes::class)
        suspend fun init(
            apiUrl: String,
            senderAddress: String,
            wallet: Wallet,
            seed: UByteArray? = null,
            broadcastMode: BroadcastMode = BroadcastMode.Block,
            chainId: String? = null
        ): SigningCosmWasmClient {
            ensureLibsodiumInitialized()
            return SigningCosmWasmClient(
                apiUrl,
                senderAddress,
                wallet,
                EnigmaUtils(apiUrl, seed ?: EnigmaUtils.GenerateNewSeed()),
                broadcastMode,
                chainId
            )
        }

        suspend fun init(
            apiUrl: String,
            senderAddress: String,
            wallet: Wallet,
            enigmaUtils: EncryptionUtils,
            broadcastMode: BroadcastMode = BroadcastMode.Block,
            chainId: String? = null
        ): SigningCosmWasmClient {
            ensureLibsodiumInitialized()
            return SigningCosmWasmClient(
                apiUrl,
                senderAddress,
                wallet,
                enigmaUtils,
                broadcastMode,
                chainId
            )
        }
    }


}