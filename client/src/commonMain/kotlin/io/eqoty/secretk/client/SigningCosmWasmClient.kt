package io.eqoty.secretk.client

import com.ionspin.kotlin.bignum.integer.toBigInteger
import io.eqoty.cosmwasm.std.types.Coin
import io.eqoty.secret.std.types.PubKey
import io.eqoty.secret.std.types.PubKeyMultisigThreshold
import io.eqoty.secret.std.types.PubKeySecp256k1
import io.eqoty.secretk.BroadcastMode
import io.eqoty.secretk.types.*
import io.eqoty.secretk.types.proto.*
import io.eqoty.secretk.types.response.GasInfo
import io.eqoty.secretk.types.response.TxResponseData
import io.eqoty.secretk.utils.*
import io.eqoty.secretk.wallet.AccountData
import io.eqoty.secretk.wallet.DirectSigningWallet
import io.eqoty.secretk.wallet.Wallet
import io.eqoty.secretk.wallet.encodeSecp256k1Pubkey
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.decodeHex
import kotlin.math.ceil

/***
 * A Secret Network Client that can sign transactions.
 * Note: libsodium must be initialized before instantiating the client.
 * use [SigningCosmWasmClient.init] to handle initializing libsodium automatically.
 * Or call ensureSodiumInitialized() before creating [SigningCosmWasmClient]
 */
class SigningCosmWasmClient(
    val apiUrl: String,
    var wallet: Wallet?,
    encryptionUtils: EncryptionUtils = EnigmaUtils(apiUrl, EnigmaUtils.GenerateNewSeed()),
    broadcastMode: BroadcastMode = BroadcastMode.Block,
    chainId: String? = null
) : CosmWasmClient(apiUrl, encryptionUtils, broadcastMode, chainId) {

    init {
        if (chainId.isNullOrBlank()) {
            logger.w(
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

            is MsgMigrateContractProto -> {
                msg.msg.toUByteArray().copyOfRange(0, 32)
            }

            else -> null
        }
    }

    private fun getSender(msgs: List<Msg<*>>): String {
        val senders = msgs.map { it.sender }.toSet()
        if (senders.size > 1) {
            throw IllegalArgumentException("The same sender must be used for all messages.")
        }
        return senders.first()
    }

    suspend fun simulate(
        msgs: List<Msg<*>>,
        txOptions: TxOptions = TxOptions(),
    ): GasInfo {
        val sender = getSender(msgs)
        val txRawProto = prepareAndSign(sender, msgs, txOptions)
        val txRawBytes = ProtoBuf.encodeToByteArray(txRawProto).toUByteArray()
        val simulateTxResponse = try {
            postSimulateTx(txRawBytes)
        } catch (t: Throwable) {
            val nonces = msgs.map { msg ->
                if (msg is EncryptedMsg) msg.populateCodeHash()
                msg.toProto(this.restClient.enigmautils).value
            }.map { anyProto ->
                extractMessageNonceIfNeeded(anyProto)
            }
            throw nonces[0]?.let { nonce ->
                restClient.decrypt(t, nonce)
            } ?: t

        }
        return simulateTxResponse.gasInfo!!
    }

    suspend fun execute(
        msgs: List<Msg<*>>,
        txOptions: TxOptions = TxOptions(),
    ): TxResponseData {
        val sender = getSender(msgs)
        val txRawProto = prepareAndSign(sender, msgs, txOptions)
        val txRawBytes = ProtoBuf.encodeToByteArray(txRawProto).toUByteArray()
        val txResponse = try {
            postTx(txRawBytes)
        } catch (t: Throwable) {
            val nonces = msgs.map { msg ->
                if (msg is EncryptedMsg) msg.populateCodeHash()
                msg.toProto(this.restClient.enigmautils).value
            }.map { anyProto ->
                extractMessageNonceIfNeeded(anyProto)
            }
            throw nonces[0]?.let { nonce ->
                restClient.decrypt(t, nonce)
            } ?: t
        }

        txResponse.data = if (this.restClient.broadcastMode == BroadcastMode.Block) {
            // inject tx here to standardize decoding tx responses. Since txsQuery responses (not implemented yet)
            // will actually have a tx value populated.
            txResponse.tx = AnyProto(value = txRawBytes.toByteArray())
            decodeTxResponses(txResponse)
        } else {
            emptyList()
        }
        msgs.filterIsInstance<MsgMigrateContract>().forEach { restClient.addressToCodeHashCache.remove(it.contractAddress) }

        return txResponse
    }

    private suspend fun prepareAndSign(
        sender: String,
        messages: List<Msg<*>>,
        txOptions: TxOptions
    ): TxRawProto {
        val accountFromWallet =
            wallet?.getAccount(sender) ?: throw Error("Failed to retrieve account $sender from wallet")
        val nonceResult = getNonce(accountFromWallet.address)
        if (chainId == null) {
            chainId = getChainId()
        }
        val signerData = txOptions.explicitSignerData
            ?: SignerData(nonceResult.accountNumber, nonceResult.sequence, chainId!!)
        val fee = StdFee(
            gas = txOptions.gasLimit,
            amount = listOf(
                Coin(
                    gasToFee(txOptions.gasLimit, txOptions.gasPriceInFeeDenom),
                    txOptions.feeDenom
                )
            ),
            granter = txOptions.feeGranter
        )

        return when (wallet) {
            is DirectSigningWallet -> {
                signDirect(
                    wallet as DirectSigningWallet,
                    accountFromWallet,
                    messages,
                    fee,
                    txOptions.memo,
                    signerData
                )
            }

            is Wallet -> {
                signAmino(wallet!!, accountFromWallet, messages, fee, txOptions.memo, signerData)
            }

            else -> throw Error("Wallet not set")
        }
    }

    private suspend fun signDirect(
        wallet: DirectSigningWallet,
        account: AccountData,
        msgs: List<Msg<*>>,
        fee: StdFee,
        memo: String,
        signerData: SignerData,
    ): TxRawProto {
        val txBody = TxBody(
            value = TxBodyValue(
                messages = msgs
                    .map { msg ->
                        if (msg is EncryptedMsg) msg.populateCodeHash()
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
            account.address,
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
        wallet: Wallet,
        account: AccountData,
        messages: List<Msg<*>>,
        fee: StdFee,
        memo: String,
        signerData: SignerData,
    ): TxRawProto {
        val signMode = wallet.getSignMode() ?: SignMode.SIGN_MODE_LEGACY_AMINO_JSON
        val msgs = messages.map { msg ->
            if (msg is EncryptedMsg) msg.populateCodeHash()
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
                        if (msg is EncryptedMsg) msg.populateCodeHash()
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

    private suspend fun EncryptedMsg<*>.populateCodeHash() {
        when (this) {
            is MsgExecuteContract -> {
                if (codeHash.isNullOrBlank()) {
                    codeHash = restClient.getCodeHashByContractAddr(contractAddress)
                }
            }

            is MsgInstantiateContract -> {
                if (codeHash.isNullOrBlank()) {
                    codeHash = restClient.getCodeInfoByCodeId(codeId).codeHash
                }
            }

            is MsgMigrateContract -> {
                if (codeHash.isNullOrBlank()) {
                    codeHash = restClient.getCodeInfoByCodeId(codeId).codeHash
                }
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

                    is MsgSendProto -> {
                        ProtoBuf.encodeToByteArray(message.value)
                    }

                    is MsgMigrateContractProto -> {
                        ProtoBuf.encodeToByteArray(message.value)
                    }

                    is MsgClearAdminProto -> {
                        ProtoBuf.encodeToByteArray(message.value)
                    }

                    is MsgUpdateAdminProto -> {
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

        /**
         * Helper to initialize libsodium and then create the client.
         */
        suspend fun init(
            apiUrl: String,
            wallet: Wallet?,
            enigmaUtils: EncryptionUtils? = null,
            broadcastMode: BroadcastMode = BroadcastMode.Block,
            chainId: String? = null
        ): SigningCosmWasmClient {
            ensureLibsodiumInitialized()
            return SigningCosmWasmClient(
                apiUrl,
                wallet,
                enigmaUtils ?: EnigmaUtils(apiUrl, EnigmaUtils.GenerateNewSeed()),
                broadcastMode,
                chainId
            )
        }
    }

}