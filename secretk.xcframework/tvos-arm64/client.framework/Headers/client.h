#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class ClientAccount, ClientAccountCompanion, ClientAccountData, ClientAccountResponse, ClientAccountResponseCompanion, ClientAccountSigningData, ClientAddress, ClientAlgo, ClientAminoSignResponse, ClientAminoSignResponseCompanion, ClientAnyProto, ClientAnyProtoCompanion, ClientApplicationVersion, ClientApplicationVersionCompanion, ClientAttribute, ClientAttributeCompanion, ClientAuthInfoProtoCompanion, ClientBalanceResponse, ClientBalanceResponseCompanion, ClientBaseWallet, ClientBignumBigInteger, ClientBignumBigIntegerBigIntegerRange, ClientBignumBigIntegerCompanion, ClientBignumBigIntegerQuotientAndRemainder, ClientBignumBigIntegerSqareRootAndRemainder, ClientBignumModularBigInteger, ClientBignumModularBigIntegerCompanion, ClientBignumModularQuotientAndRemainder, ClientBignumSign, ClientBlock, ClientBlockCompanion, ClientBlockId, ClientBlockIdCompanion, ClientBlockResponse, ClientBlockResponseCompanion, ClientBroadcastMode, ClientCodeHashResponse, ClientCodeHashResponseCompanion, ClientCodeInfoResponse, ClientCodeInfoResponseCompanion, ClientCoinProto, ClientCoinProtoCompanion, ClientContractInfoResponse, ClientContractInfoResponseCompanion, ClientContractInfoResponseContractInfo, ClientContractInfoResponseContractInfoCompanion, ClientContractInfoResponseCreationInfo, ClientContractInfoResponseCreationInfoCompanion, ClientCosmWasmClient, ClientCosmwasm_std_typesCodeInfo, ClientCosmwasm_std_typesCodeInfoCompanion, ClientCosmwasm_std_typesCoin, ClientCosmwasm_std_typesCoinCompanion, ClientData, ClientDataCompanion, ClientEncryptedRandom, ClientEncryptedRandomCompanion, ClientEnigmaUtilsCompanion, ClientEvent, ClientEventCompanion, ClientFeeProto, ClientFeeProtoCompanion, ClientGasInfo, ClientGasInfoCompanion, ClientGetNonceResult, ClientHeader, ClientHeaderCompanion, ClientKeyPair, ClientKeyProtoCompanion, ClientKotlinArray<T>, ClientKotlinByteArray, ClientKotlinByteIterator, ClientKotlinCharArray, ClientKotlinCharIterator, ClientKotlinEnum<E>, ClientKotlinEnumCompanion, ClientKotlinException, ClientKotlinIllegalStateException, ClientKotlinIntArray, ClientKotlinIntIterator, ClientKotlinNothing, ClientKotlinPair<__covariant A, __covariant B>, ClientKotlinRuntimeException, ClientKotlinThrowable, ClientKotlinx_serialization_coreSerialKind, ClientKotlinx_serialization_coreSerializersModule, ClientKotlinx_serialization_jsonClassDiscriminatorMode, ClientKotlinx_serialization_jsonJson, ClientKotlinx_serialization_jsonJsonConfiguration, ClientKotlinx_serialization_jsonJsonContentPolymorphicSerializer<T>, ClientKotlinx_serialization_jsonJsonDefault, ClientKotlinx_serialization_jsonJsonElement, ClientKotlinx_serialization_jsonJsonElementCompanion, ClientLabelResponse, ClientLabelResponseCompanion, ClientLastCommit, ClientLastCommitCompanion, ClientLog, ClientLogCompanion, ClientModeInfoProto, ClientModeInfoProtoCompanion, ClientModeInfoProtoMulti, ClientModeInfoProtoMultiCompanion, ClientModeInfoProtoSingle, ClientModeInfoProtoSingleCompanion, ClientMsgAminoCompanion, ClientMsgClearAdminAminoCompanion, ClientMsgClearAdminAminoData, ClientMsgClearAdminAminoDataCompanion, ClientMsgClearAdminProto, ClientMsgClearAdminProtoCompanion, ClientMsgClearAdminResponseProtoCompanion, ClientMsgDataProtoCompanion, ClientMsgExecuteContractAminoCompanion, ClientMsgExecuteContractAminoData, ClientMsgExecuteContractAminoDataCompanion, ClientMsgExecuteContractProto, ClientMsgExecuteContractProtoCompanion, ClientMsgExecuteContractResponseProtoCompanion, ClientMsgInstantiateContractProto, ClientMsgInstantiateContractProtoCompanion, ClientMsgInstantiateContractResponseProtoCompanion, ClientMsgMigrateContractAminoCompanion, ClientMsgMigrateContractAminoData, ClientMsgMigrateContractAminoDataCompanion, ClientMsgMigrateContractProto, ClientMsgMigrateContractProtoCompanion, ClientMsgMigrateContractResponseProtoCompanion, ClientMsgProto, ClientMsgQueryPermitAminoCompanion, ClientMsgQueryPermitAminoData, ClientMsgQueryPermitAminoDataCompanion, ClientMsgSendAminoCompanion, ClientMsgSendAminoData, ClientMsgSendAminoDataCompanion, ClientMsgSendProto, ClientMsgSendProtoCompanion, ClientMsgSendResponseProtoCompanion, ClientMsgStoreCodeAminoCompanion, ClientMsgStoreCodeAminoData, ClientMsgStoreCodeAminoDataCompanion, ClientMsgStoreCodeProto, ClientMsgStoreCodeProtoCompanion, ClientMsgStoreCodeResponseProtoCompanion, ClientMsgUpdateAdminAminoCompanion, ClientMsgUpdateAdminAminoData, ClientMsgUpdateAdminAminoDataCompanion, ClientMsgUpdateAdminProto, ClientMsgUpdateAdminProtoCompanion, ClientMsgUpdateAdminResponseProtoCompanion, ClientNodeInfo, ClientNodeInfoCompanion, ClientNodeInfoOther, ClientNodeInfoOtherCompanion, ClientNodeInfoResponse, ClientNodeInfoResponseCompanion, ClientOkioByteString, ClientOkioByteStringCompanion, ClientPartSetHeader, ClientPartSetHeaderCompanion, ClientPermitFactory, ClientPrehashType, ClientProtoMsg<M>, ClientProtoMsgCompanion, ClientProtocolVersion, ClientProtocolVersionCompanion, ClientResult, ClientResultCompanion, ClientRipemd160DigestCompanion, ClientSecp256k1PubKey, ClientSecp256k1PubKeyCompanion, ClientSecret_std_typesPermission, ClientSecret_std_typesPermissionCompanion, ClientSecret_std_typesPermit, ClientSecret_std_typesPermitCompanion, ClientSecret_std_typesPermitParams, ClientSecret_std_typesPermitParamsCompanion, ClientSecret_std_typesPubKey, ClientSecret_std_typesPubKeyCompanion, ClientSecret_std_typesPubKeySecp256k1, ClientSecret_std_typesPubKeySecp256k1Companion, ClientSecret_std_typesStdSignature, ClientSecret_std_typesStdSignatureCompanion, ClientSecret_std_typesTypeValue<V>, ClientSecret_std_typesTypeValueCompanion, ClientSignDocProto, ClientSignDocProtoCompanion, ClientSignMode, ClientSignModeCompanion, ClientSignResponse, ClientSignature, ClientSignatureCompanion, ClientSigner, ClientSignerData, ClientSignerInfoProto, ClientSignerInfoProtoCompanion, ClientSimulateTxsResponse, ClientSimulateTxsResponseCompanion, ClientSimulateTxsResponseData, ClientSimulateTxsResponseDataCompanion, ClientSmartQueryResponseCompanion, ClientStdFee, ClientStdFeeCompanion, ClientStdSignDoc, ClientStdSignDocCompanion, ClientStdTx<T>, ClientStdTxCompanion, ClientTxBody<M>, ClientTxBodyCompanion, ClientTxBodyProtoCompanion, ClientTxBodyValue<M>, ClientTxBodyValueCompanion, ClientTxKeyResponse, ClientTxKeyResponseCompanion, ClientTxMsgDataProtoCompanion, ClientTxOptions, ClientTxRawProtoCompanion, ClientTxResponseCompanion, ClientTxResponseData, ClientTxResponseDataCompanion, ClientTxResponseError, ClientTxResponseErrorCompanion, ClientTxResponseSerializer, ClientTxResponseValid, ClientTxResponseValidCompanion, ClientV1BetaType, ClientV1BetaTypeCompanion, ClientVersion, ClientVersionCompanion, ClientWasmResponse<R>, ClientWasmResponseCompanion, NSData;

@protocol ClientBignumBigNumber, ClientBignumBigNumberCreator, ClientBignumBigNumberUtil, ClientBignumBitwiseCapable, ClientBignumByteArrayDeserializable, ClientBignumByteArraySerializable, ClientEncryptedMsg, ClientEncryptionUtils, ClientKotlinAnnotation, ClientKotlinClosedRange, ClientKotlinComparable, ClientKotlinIterable, ClientKotlinIterator, ClientKotlinKAnnotatedElement, ClientKotlinKClass, ClientKotlinKClassifier, ClientKotlinKDeclarationContainer, ClientKotlinx_serialization_coreCompositeDecoder, ClientKotlinx_serialization_coreCompositeEncoder, ClientKotlinx_serialization_coreDecoder, ClientKotlinx_serialization_coreDeserializationStrategy, ClientKotlinx_serialization_coreEncoder, ClientKotlinx_serialization_coreKSerializer, ClientKotlinx_serialization_coreSerialDescriptor, ClientKotlinx_serialization_coreSerialFormat, ClientKotlinx_serialization_coreSerializationStrategy, ClientKotlinx_serialization_coreSerializersModuleCollector, ClientKotlinx_serialization_coreStringFormat, ClientKotlinx_serialization_jsonJsonNamingStrategy, ClientMsg, ClientMsgAmino, ClientTxResponse, ClientUnencryptedMsg, ClientWallet;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface ClientBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface ClientBase (ClientBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface ClientMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface ClientMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorClientKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface ClientNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface ClientByte : ClientNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface ClientUByte : ClientNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface ClientShort : ClientNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface ClientUShort : ClientNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface ClientInt : ClientNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface ClientUInt : ClientNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface ClientLong : ClientNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface ClientULong : ClientNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface ClientFloat : ClientNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface ClientDouble : ClientNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface ClientBoolean : ClientNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((swift_name("KotlinComparable")))
@protocol ClientKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface ClientKotlinEnum<E> : ClientBase <ClientKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BroadcastMode")))
@interface ClientBroadcastMode : ClientKotlinEnum<ClientBroadcastMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClientBroadcastMode *sync __attribute__((swift_name("sync")));
@property (class, readonly) ClientBroadcastMode *async __attribute__((swift_name("async")));
+ (ClientKotlinArray<ClientBroadcastMode *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClientBroadcastMode *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *mode __attribute__((swift_name("mode")));
@end

__attribute__((swift_name("CosmWasmClient")))
@interface ClientCosmWasmClient : ClientBase

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (instancetype)initWithApiUrl:(NSString *)apiUrl encryptionUtils:(id<ClientEncryptionUtils>)encryptionUtils broadcastMode:(ClientBroadcastMode *)broadcastMode chainId:(NSString * _Nullable)chainId __attribute__((swift_name("init(apiUrl:encryptionUtils:broadcastMode:chainId:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getAccountAddress:(NSString *)address completionHandler:(void (^)(ClientAccount * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getAccount(address:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getBalanceAddress:(NSString *)address completionHandler:(void (^)(ClientBalanceResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getBalance(address:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getChainIdWithCompletionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getChainId(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getCodeHashByContractAddrAddr:(NSString *)addr completionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getCodeHashByContractAddr(addr:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getCodeInfoByCodeIdCodeId:(int32_t)codeId completionHandler:(void (^)(ClientCosmwasm_std_typesCodeInfo * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getCodeInfoByCodeId(codeId:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getContractInfoByAddressAddr:(NSString *)addr completionHandler:(void (^)(ClientContractInfoResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getContractInfoByAddress(addr:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getLabelByContractAddrAddr:(NSString *)addr completionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getLabelByContractAddr(addr:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getLatestBlockWithCompletionHandler:(void (^)(ClientBlockResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getLatestBlock(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getNonceAddress:(NSString *)address completionHandler:(void (^)(ClientGetNonceResult * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getNonce(address:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getTxHash:(NSString *)hash timeoutAfter:(int64_t)timeoutAfter completionHandler:(void (^)(ClientTxResponseData * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getTx(hash:timeoutAfter:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)nodeInfoWithCompletionHandler:(void (^)(ClientNodeInfoResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("nodeInfo(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)postSimulateTxTx:(id)tx completionHandler:(void (^)(ClientSimulateTxsResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("postSimulateTx(tx:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)postTxTx:(id)tx completionHandler:(void (^)(ClientTxResponseData * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("postTx(tx:completionHandler:)")));

/**
 * Makes a smart query on the contract, returns the parsed JSON document.
 *
 * Promise is rejected when contract does not exist.
 * Promise is rejected for invalid query format.
 * Promise is rejected for invalid response format.
 *
 * Note: addedParams allows for query string additions such as "&height=1234567"
 *
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)queryContractSmartContractAddress:(NSString *)contractAddress queryMsg:(NSString *)queryMsg contractCodeHash:(NSString * _Nullable)contractCodeHash completionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("queryContractSmart(contractAddress:queryMsg:contractCodeHash:completionHandler:)")));

/** Any address the chain considers valid (valid bech32 with proper prefix)
 *
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property NSString * _Nullable anyValidAddress __attribute__((swift_name("anyValidAddress")));
@property NSString * _Nullable chainId __attribute__((swift_name("chainId")));
@end


/***
 * A Secret Network Client that can sign transactions.
 * Note: libsodium must be initialized before instantiating the client.
 * use [SigningCosmWasmClient.init] to handle initializing libsodium automatically.
 * Or call ensureSodiumInitialized() before creating [SigningCosmWasmClient]
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SigningCosmWasmClient")))
@interface ClientSigningCosmWasmClient : ClientCosmWasmClient
- (instancetype)initWithApiUrl:(NSString *)apiUrl wallet:(id<ClientWallet> _Nullable)wallet encryptionUtils:(id<ClientEncryptionUtils>)encryptionUtils broadcastMode:(ClientBroadcastMode *)broadcastMode chainId:(NSString * _Nullable)chainId __attribute__((swift_name("init(apiUrl:wallet:encryptionUtils:broadcastMode:chainId:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (instancetype)initWithApiUrl:(NSString *)apiUrl encryptionUtils:(id<ClientEncryptionUtils>)encryptionUtils broadcastMode:(ClientBroadcastMode *)broadcastMode chainId:(NSString * _Nullable)chainId __attribute__((swift_name("init(apiUrl:encryptionUtils:broadcastMode:chainId:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeMsgs:(NSArray<id<ClientMsg>> *)msgs txOptions:(ClientTxOptions *)txOptions completionHandler:(void (^)(ClientTxResponseData * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("execute(msgs:txOptions:completionHandler:)")));
- (int32_t)gasToFeeGasLimit:(int32_t)gasLimit gasPrice:(double)gasPrice __attribute__((swift_name("gasToFee(gasLimit:gasPrice:)")));
- (void)setEncryptionUtilsEncryptionUtils:(id<ClientEncryptionUtils>)encryptionUtils __attribute__((swift_name("setEncryptionUtils(encryptionUtils:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)simulateMsgs:(NSArray<id<ClientMsg>> *)msgs txOptions:(ClientTxOptions *)txOptions completionHandler:(void (^)(ClientGasInfo * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("simulate(msgs:txOptions:completionHandler:)")));
@property (readonly) NSString *apiUrl __attribute__((swift_name("apiUrl")));
@property id<ClientWallet> _Nullable wallet __attribute__((swift_name("wallet")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PermitFactory")))
@interface ClientPermitFactory : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)permitFactory __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientPermitFactory *shared __attribute__((swift_name("shared")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)doNewPermitWallet:(id<ClientWallet>)wallet owner:(NSString *)owner chainId:(NSString *)chainId permitName:(NSString *)permitName allowedTokens:(NSArray<NSString *> *)allowedTokens permissions:(NSArray<ClientSecret_std_typesPermission *> *)permissions completionHandler:(void (^)(ClientSecret_std_typesPermit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("doNewPermit(wallet:owner:chainId:permitName:allowedTokens:permissions:completionHandler:)")));
@end

__attribute__((swift_name("Msg")))
@protocol ClientMsg
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoUtils:(id<ClientEncryptionUtils> _Nullable)utils completionHandler_:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(utils:completionHandler_:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoUtils:(id<ClientEncryptionUtils> _Nullable)utils completionHandler_:(void (^)(ClientProtoMsg<ClientMsgProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(utils:completionHandler_:)")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end

__attribute__((swift_name("EncryptedMsg")))
@protocol ClientEncryptedMsg <ClientMsg>
@required
- (NSString *)getMissingParameterWarningMethod:(NSString *)method parameter:(NSString *)parameter __attribute__((swift_name("getMissingParameterWarning(method:parameter:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(utils:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(ClientProtoMsg<ClientMsgProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(utils:completionHandler:)")));
@property NSString * _Nullable codeHash __attribute__((swift_name("codeHash")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((swift_name("MsgAmino")))
@protocol ClientMsgAmino
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgAminoCompanion")))
@interface ClientMsgAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end

__attribute__((swift_name("UnencryptedMsg")))
@protocol ClientUnencryptedMsg <ClientMsg>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoWithCompletionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoWithCompletionHandler:(void (^)(ClientProtoMsg<ClientMsgProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(completionHandler:)")));
@end


/***
 *  MsgSend represents a message to send coins from one account to another.
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdmin")))
@interface ClientMsgClearAdmin : ClientBase <ClientUnencryptedMsg>
- (instancetype)initWithSender:(NSString *)sender contractAddress:(NSString *)contractAddress __attribute__((swift_name("init(sender:contractAddress:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoWithCompletionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoWithCompletionHandler:(void (^)(ClientProtoMsg<ClientMsgClearAdminProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(completionHandler:)")));
@property (readonly) NSString *contractAddress __attribute__((swift_name("contractAddress")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="wasm/MsgClearAdmin")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminAmino")))
@interface ClientMsgClearAdminAmino : ClientBase <ClientMsgAmino>
- (instancetype)initWithValue:(ClientMsgClearAdminAminoData *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgClearAdminAminoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientMsgClearAdminAminoData *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminAmino.Companion")))
@interface ClientMsgClearAdminAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgClearAdminAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminAminoData")))
@interface ClientMsgClearAdminAminoData : ClientBase
- (instancetype)initWithSender:(NSString *)sender contract:(NSString *)contract __attribute__((swift_name("init(sender:contract:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgClearAdminAminoDataCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString *contract __attribute__((swift_name("contract")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminAminoData.Companion")))
@interface ClientMsgClearAdminAminoDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgClearAdminAminoDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContract")))
@interface ClientMsgExecuteContract : ClientBase <ClientEncryptedMsg>
- (instancetype)initWithSender:(NSString *)sender contractAddress:(NSString *)contractAddress msg:(NSString *)msg sentFunds:(NSArray<ClientCosmwasm_std_typesCoin *> *)sentFunds codeHash:(NSString * _Nullable)codeHash __attribute__((swift_name("init(sender:contractAddress:msg:sentFunds:codeHash:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(utils:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(ClientProtoMsg<ClientMsgExecuteContractProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(utils:completionHandler:)")));
@property NSString * _Nullable codeHash __attribute__((swift_name("codeHash")));

/** The contract's address */
@property (readonly) NSString *contractAddress __attribute__((swift_name("contractAddress")));

/** The input message */
@property (readonly) NSString *msg __attribute__((swift_name("msg")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));

/** Funds to send to the contract */
@property (readonly) NSArray<ClientCosmwasm_std_typesCoin *> *sentFunds __attribute__((swift_name("sentFunds")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="wasm/MsgExecuteContract")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractAmino")))
@interface ClientMsgExecuteContractAmino : ClientBase <ClientMsgAmino>
- (instancetype)initWithValue:(ClientMsgExecuteContractAminoData *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgExecuteContractAminoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientMsgExecuteContractAminoData *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractAmino.Companion")))
@interface ClientMsgExecuteContractAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgExecuteContractAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractAminoData")))
@interface ClientMsgExecuteContractAminoData : ClientBase
- (instancetype)initWithSender:(NSString *)sender contract:(NSString *)contract msg:(NSString *)msg sentFunds:(NSArray<ClientCosmwasm_std_typesCoin *> *)sentFunds __attribute__((swift_name("init(sender:contract:msg:sentFunds:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgExecuteContractAminoDataCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString *contract __attribute__((swift_name("contract")));
@property (readonly) NSString *msg __attribute__((swift_name("msg")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="sent_funds")
*/
@property (readonly) NSArray<ClientCosmwasm_std_typesCoin *> *sentFunds __attribute__((swift_name("sentFunds")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractAminoData.Companion")))
@interface ClientMsgExecuteContractAminoDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgExecuteContractAminoDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgInstantiateContract")))
@interface ClientMsgInstantiateContract : ClientBase <ClientEncryptedMsg>
- (instancetype)initWithSender:(NSString *)sender codeId:(int32_t)codeId label:(NSString *)label initMsg:(NSString *)initMsg initFunds:(NSArray<ClientCosmwasm_std_typesCoin *> *)initFunds codeHash:(NSString * _Nullable)codeHash admin:(NSString * _Nullable)admin __attribute__((swift_name("init(sender:codeId:label:initMsg:initFunds:codeHash:admin:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(utils:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(ClientProtoMsg<ClientMsgInstantiateContractProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(utils:completionHandler:)")));

/** The address of the admin account for enabling contract migration, if any */
@property (readonly) NSString * _Nullable admin __attribute__((swift_name("admin")));
@property NSString * _Nullable codeHash __attribute__((swift_name("codeHash")));

/** The id of the contract's WASM code */
@property int32_t codeId __attribute__((swift_name("codeId")));

/** Funds to send to the contract */
@property (readonly, getter=doInitFunds) NSArray<ClientCosmwasm_std_typesCoin *> *initFunds __attribute__((swift_name("initFunds")));

/** The input message to the contract's constructor */
@property (readonly, getter=doInitMsg) NSString *initMsg __attribute__((swift_name("initMsg")));

/** A unique label across all contracts */
@property (readonly) NSString *label __attribute__((swift_name("label")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContract")))
@interface ClientMsgMigrateContract : ClientBase <ClientEncryptedMsg>
- (instancetype)initWithSender:(NSString *)sender contractAddress:(NSString *)contractAddress msg:(NSString *)msg codeId:(int32_t)codeId codeHash:(NSString * _Nullable)codeHash __attribute__((swift_name("init(sender:contractAddress:msg:codeId:codeHash:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(utils:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoUtils:(id<ClientEncryptionUtils>)utils completionHandler:(void (^)(ClientProtoMsg<ClientMsgMigrateContractProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(utils:completionHandler:)")));
@property NSString * _Nullable codeHash __attribute__((swift_name("codeHash")));
@property int32_t codeId __attribute__((swift_name("codeId")));
@property (readonly) NSString *contractAddress __attribute__((swift_name("contractAddress")));
@property (readonly) NSString *msg __attribute__((swift_name("msg")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="wasm/MsgMigrateContract")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractAmino")))
@interface ClientMsgMigrateContractAmino : ClientBase <ClientMsgAmino>
- (instancetype)initWithValue:(ClientMsgMigrateContractAminoData *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgMigrateContractAminoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientMsgMigrateContractAminoData *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractAmino.Companion")))
@interface ClientMsgMigrateContractAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgMigrateContractAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractAminoData")))
@interface ClientMsgMigrateContractAminoData : ClientBase
- (instancetype)initWithSender:(NSString *)sender contract:(NSString *)contract msg:(NSString *)msg codeId:(int32_t)codeId __attribute__((swift_name("init(sender:contract:msg:codeId:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgMigrateContractAminoDataCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="code_id")
*/
@property (readonly) int32_t codeId __attribute__((swift_name("codeId")));
@property (readonly) NSString *contract __attribute__((swift_name("contract")));
@property (readonly) NSString *msg __attribute__((swift_name("msg")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractAminoData.Companion")))
@interface ClientMsgMigrateContractAminoDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgMigrateContractAminoDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="query_permit")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgQueryPermitAmino")))
@interface ClientMsgQueryPermitAmino : ClientBase <ClientMsgAmino>
- (instancetype)initWithValue:(ClientMsgQueryPermitAminoData *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgQueryPermitAminoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientMsgQueryPermitAminoData *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgQueryPermitAmino.Companion")))
@interface ClientMsgQueryPermitAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgQueryPermitAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgQueryPermitAminoData")))
@interface ClientMsgQueryPermitAminoData : ClientBase
- (instancetype)initWithAllowedTokens:(NSArray<NSString *> *)allowedTokens permissions:(NSArray<ClientSecret_std_typesPermission *> *)permissions permitName:(NSString *)permitName __attribute__((swift_name("init(allowedTokens:permissions:permitName:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgQueryPermitAminoDataCompanion *companion __attribute__((swift_name("companion")));
- (ClientMsgQueryPermitAminoData *)doCopyAllowedTokens:(NSArray<NSString *> *)allowedTokens permissions:(NSArray<ClientSecret_std_typesPermission *> *)permissions permitName:(NSString *)permitName __attribute__((swift_name("doCopy(allowedTokens:permissions:permitName:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="allowed_tokens")
*/
@property (readonly) NSArray<NSString *> *allowedTokens __attribute__((swift_name("allowedTokens")));
@property (readonly) NSArray<ClientSecret_std_typesPermission *> *permissions __attribute__((swift_name("permissions")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="permit_name")
*/
@property (readonly) NSString *permitName __attribute__((swift_name("permitName")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgQueryPermitAminoData.Companion")))
@interface ClientMsgQueryPermitAminoDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgQueryPermitAminoDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 *  MsgSend represents a message to send coins from one account to another.
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSend")))
@interface ClientMsgSend : ClientBase <ClientUnencryptedMsg>
- (instancetype)initWithFromAddress:(NSString *)fromAddress toAddress:(NSString *)toAddress amount:(NSArray<ClientCosmwasm_std_typesCoin *> *)amount __attribute__((swift_name("init(fromAddress:toAddress:amount:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoWithCompletionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoWithCompletionHandler:(void (^)(ClientProtoMsg<ClientMsgSendProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(completionHandler:)")));

/** Funds to send to the address */
@property (readonly) NSArray<ClientCosmwasm_std_typesCoin *> *amount __attribute__((swift_name("amount")));
@property (readonly) NSString *fromAddress __attribute__((swift_name("fromAddress")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@property (readonly) NSString *toAddress __attribute__((swift_name("toAddress")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="cosmos-sdk/MsgSend")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendAmino")))
@interface ClientMsgSendAmino : ClientBase <ClientMsgAmino>
- (instancetype)initWithValue:(ClientMsgSendAminoData *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgSendAminoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientMsgSendAminoData *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendAmino.Companion")))
@interface ClientMsgSendAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgSendAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendAminoData")))
@interface ClientMsgSendAminoData : ClientBase
- (instancetype)initWithFromAddress:(NSString *)fromAddress toAddress:(NSString *)toAddress amount:(NSArray<ClientCosmwasm_std_typesCoin *> *)amount __attribute__((swift_name("init(fromAddress:toAddress:amount:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgSendAminoDataCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSArray<ClientCosmwasm_std_typesCoin *> *amount __attribute__((swift_name("amount")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="from_address")
*/
@property (readonly) NSString *fromAddress __attribute__((swift_name("fromAddress")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="to_address")
*/
@property (readonly) NSString *toAddress __attribute__((swift_name("toAddress")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendAminoData.Companion")))
@interface ClientMsgSendAminoDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgSendAminoDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCode")))
@interface ClientMsgStoreCode : ClientBase <ClientUnencryptedMsg>
- (instancetype)initWithSender:(NSString *)sender wasmByteCode:(id)wasmByteCode source:(NSString * _Nullable)source builder:(NSString * _Nullable)builder __attribute__((swift_name("init(sender:wasmByteCode:source:builder:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoWithCompletionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoWithCompletionHandler:(void (^)(ClientProtoMsg<ClientMsgStoreCodeProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(completionHandler:)")));

/** Builder is a valid docker image name with tag, optional */
@property (readonly) NSString * _Nullable builder __attribute__((swift_name("builder")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));

/** Source is a valid absolute HTTPS URI to the contract's source code, optional */
@property (readonly) NSString * _Nullable source __attribute__((swift_name("source")));

/** WASMByteCode can be raw or gzip compressed */
@property (readonly) id wasmByteCode __attribute__((swift_name("wasmByteCode")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="wasm/MsgStoreCode")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeAmino")))
@interface ClientMsgStoreCodeAmino : ClientBase <ClientMsgAmino>
- (instancetype)initWithValue:(ClientMsgStoreCodeAminoData *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgStoreCodeAminoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientMsgStoreCodeAminoData *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeAmino.Companion")))
@interface ClientMsgStoreCodeAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgStoreCodeAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeAminoData")))
@interface ClientMsgStoreCodeAminoData : ClientBase
- (instancetype)initWithSender:(NSString *)sender wasmByteCode:(NSString *)wasmByteCode source:(NSString * _Nullable)source builder:(NSString * _Nullable)builder __attribute__((swift_name("init(sender:wasmByteCode:source:builder:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgStoreCodeAminoDataCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString * _Nullable builder __attribute__((swift_name("builder")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@property (readonly) NSString * _Nullable source __attribute__((swift_name("source")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="wasm_byte_code")
*/
@property (readonly) NSString *wasmByteCode __attribute__((swift_name("wasmByteCode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeAminoData.Companion")))
@interface ClientMsgStoreCodeAminoDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgStoreCodeAminoDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdmin")))
@interface ClientMsgUpdateAdmin : ClientBase <ClientUnencryptedMsg>
- (instancetype)initWithSender:(NSString *)sender newAdmin:(NSString *)newAdmin contractAddress:(NSString *)contractAddress __attribute__((swift_name("init(sender:newAdmin:contractAddress:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toAminoWithCompletionHandler:(void (^)(id<ClientMsgAmino> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toAmino(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)toProtoWithCompletionHandler:(void (^)(ClientProtoMsg<ClientMsgUpdateAdminProto *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("toProto(completionHandler:)")));
@property (readonly) NSString *contractAddress __attribute__((swift_name("contractAddress")));
@property (readonly, getter=doNewAdmin) NSString *newAdmin __attribute__((swift_name("newAdmin")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="wasm/MsgUpdateAdmin")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminAmino")))
@interface ClientMsgUpdateAdminAmino : ClientBase <ClientMsgAmino>
- (instancetype)initWithValue:(ClientMsgUpdateAdminAminoData *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgUpdateAdminAminoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientMsgUpdateAdminAminoData *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminAmino.Companion")))
@interface ClientMsgUpdateAdminAminoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgUpdateAdminAminoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminAminoData")))
@interface ClientMsgUpdateAdminAminoData : ClientBase
- (instancetype)initWithSender:(NSString *)sender newAdmin:(NSString *)newAdmin contract:(NSString *)contract __attribute__((swift_name("init(sender:newAdmin:contract:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgUpdateAdminAminoDataCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString *contract __attribute__((swift_name("contract")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="new_admin")
*/
@property (readonly, getter=doNewAdmin) NSString *newAdmin __attribute__((swift_name("newAdmin")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminAminoData.Companion")))
@interface ClientMsgUpdateAdminAminoDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgUpdateAdminAminoDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Signer")))
@interface ClientSigner : ClientBase
- (instancetype)initWithPubkey:(ClientAnyProto *)pubkey sequence:(ClientBignumBigInteger *)sequence __attribute__((swift_name("init(pubkey:sequence:)"))) __attribute__((objc_designated_initializer));
- (ClientSigner *)doCopyPubkey:(ClientAnyProto *)pubkey sequence:(ClientBignumBigInteger *)sequence __attribute__((swift_name("doCopy(pubkey:sequence:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientAnyProto *pubkey __attribute__((swift_name("pubkey")));
@property (readonly) ClientBignumBigInteger *sequence __attribute__((swift_name("sequence")));
@end


/**
 * Signing information for a single signer that is not included in the transaction.
 *
 * @see https://github.com/cosmos/cosmos-sdk/blob/v0.42.2/x/auth/signing/sign_mode_handler.go#L23-L37
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignerData")))
@interface ClientSignerData : ClientBase
- (instancetype)initWithAccountNumber:(ClientBignumBigInteger *)accountNumber sequence:(ClientBignumBigInteger *)sequence chainId:(NSString *)chainId __attribute__((swift_name("init(accountNumber:sequence:chainId:)"))) __attribute__((objc_designated_initializer));
- (ClientSignerData *)doCopyAccountNumber:(ClientBignumBigInteger *)accountNumber sequence:(ClientBignumBigInteger *)sequence chainId:(NSString *)chainId __attribute__((swift_name("doCopy(accountNumber:sequence:chainId:)")));

/**
 * Signing information for a single signer that is not included in the transaction.
 *
 * @see https://github.com/cosmos/cosmos-sdk/blob/v0.42.2/x/auth/signing/sign_mode_handler.go#L23-L37
 */
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));

/**
 * Signing information for a single signer that is not included in the transaction.
 *
 * @see https://github.com/cosmos/cosmos-sdk/blob/v0.42.2/x/auth/signing/sign_mode_handler.go#L23-L37
 */
- (NSUInteger)hash __attribute__((swift_name("hash()")));

/**
 * Signing information for a single signer that is not included in the transaction.
 *
 * @see https://github.com/cosmos/cosmos-sdk/blob/v0.42.2/x/auth/signing/sign_mode_handler.go#L23-L37
 */
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientBignumBigInteger *accountNumber __attribute__((swift_name("accountNumber")));
@property (readonly) NSString *chainId __attribute__((swift_name("chainId")));
@property (readonly) ClientBignumBigInteger *sequence __attribute__((swift_name("sequence")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StdFee")))
@interface ClientStdFee : ClientBase
- (instancetype)initWithAmount:(NSArray<ClientCosmwasm_std_typesCoin *> *)amount gas:(int32_t)gas granter:(NSString * _Nullable)granter __attribute__((swift_name("init(amount:gas:granter:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithAmount:(NSArray<ClientCosmwasm_std_typesCoin *> *)amount gas:(NSString *)gas granter_:(NSString * _Nullable)granter __attribute__((swift_name("init(amount:gas:granter_:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientStdFeeCompanion *companion __attribute__((swift_name("companion")));
- (ClientStdFee *)doCopyAmount:(NSArray<ClientCosmwasm_std_typesCoin *> *)amount gas:(NSString *)gas granter:(NSString * _Nullable)granter __attribute__((swift_name("doCopy(amount:gas:granter:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<ClientCosmwasm_std_typesCoin *> *amount __attribute__((swift_name("amount")));
@property (readonly) NSString *gas __attribute__((swift_name("gas")));
@property (readonly) NSString * _Nullable granter __attribute__((swift_name("granter")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StdFee.Companion")))
@interface ClientStdFeeCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientStdFeeCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StdSignDoc")))
@interface ClientStdSignDoc : ClientBase
- (instancetype)initWithAccountNumber:(NSString *)accountNumber chainId:(NSString *)chainId fee:(ClientStdFee *)fee memo:(NSString *)memo msgs:(NSArray<id<ClientMsgAmino>> *)msgs sequence:(NSString *)sequence __attribute__((swift_name("init(accountNumber:chainId:fee:memo:msgs:sequence:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientStdSignDocCompanion *companion __attribute__((swift_name("companion")));
- (ClientStdSignDoc *)doCopyAccountNumber:(NSString *)accountNumber chainId:(NSString *)chainId fee:(ClientStdFee *)fee memo:(NSString *)memo msgs:(NSArray<id<ClientMsgAmino>> *)msgs sequence:(NSString *)sequence __attribute__((swift_name("doCopy(accountNumber:chainId:fee:memo:msgs:sequence:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="account_number")
*/
@property (readonly) NSString *accountNumber __attribute__((swift_name("accountNumber")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="chain_id")
*/
@property (readonly) NSString *chainId __attribute__((swift_name("chainId")));
@property (readonly) ClientStdFee *fee __attribute__((swift_name("fee")));
@property (readonly) NSString *memo __attribute__((swift_name("memo")));
@property (readonly) NSArray<id<ClientMsgAmino>> *msgs __attribute__((swift_name("msgs")));
@property (readonly) NSString *sequence __attribute__((swift_name("sequence")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StdSignDoc.Companion")))
@interface ClientStdSignDocCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientStdSignDocCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/** An Amino/Cosmos SDK StdTx
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StdTx")))
@interface ClientStdTx<T> : ClientBase
- (instancetype)initWithMsg:(NSArray<ClientSecret_std_typesTypeValue<T> *> *)msg fee:(ClientStdFee *)fee signatures:(NSArray<ClientSecret_std_typesStdSignature *> *)signatures memo:(NSString * _Nullable)memo __attribute__((swift_name("init(msg:fee:signatures:memo:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientStdTxCompanion *companion __attribute__((swift_name("companion")));
- (ClientStdTx<T> *)doCopyMsg:(NSArray<ClientSecret_std_typesTypeValue<T> *> *)msg fee:(ClientStdFee *)fee signatures:(NSArray<ClientSecret_std_typesStdSignature *> *)signatures memo:(NSString * _Nullable)memo __attribute__((swift_name("doCopy(msg:fee:signatures:memo:)")));

/** An Amino/Cosmos SDK StdTx */
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));

/** An Amino/Cosmos SDK StdTx */
- (NSUInteger)hash __attribute__((swift_name("hash()")));

/** An Amino/Cosmos SDK StdTx */
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientStdFee *fee __attribute__((swift_name("fee")));
@property (readonly) NSString * _Nullable memo __attribute__((swift_name("memo")));
@property (readonly) NSArray<ClientSecret_std_typesTypeValue<T> *> *msg __attribute__((swift_name("msg")));
@property (readonly) NSArray<ClientSecret_std_typesStdSignature *> *signatures __attribute__((swift_name("signatures")));
@end


/** An Amino/Cosmos SDK StdTx */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StdTxCompanion")))
@interface ClientStdTxCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/** An Amino/Cosmos SDK StdTx */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientStdTxCompanion *shared __attribute__((swift_name("shared")));

/** An Amino/Cosmos SDK StdTx */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));

/** An Amino/Cosmos SDK StdTx */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeSerial0:(id<ClientKotlinx_serialization_coreKSerializer>)typeSerial0 __attribute__((swift_name("serializer(typeSerial0:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxBody")))
@interface ClientTxBody<M> : ClientBase
- (instancetype)initWithTypeUrl:(NSString *)typeUrl value:(ClientTxBodyValue<M> *)value __attribute__((swift_name("init(typeUrl:value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxBodyCompanion *companion __attribute__((swift_name("companion")));
- (ClientTxBody<M> *)doCopyTypeUrl:(NSString *)typeUrl value:(ClientTxBodyValue<M> *)value __attribute__((swift_name("doCopy(typeUrl:value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *typeUrl __attribute__((swift_name("typeUrl")));
@property (readonly) ClientTxBodyValue<M> *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxBodyCompanion")))
@interface ClientTxBodyCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxBodyCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeSerial0:(id<ClientKotlinx_serialization_coreKSerializer>)typeSerial0 __attribute__((swift_name("serializer(typeSerial0:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxBodyValue")))
@interface ClientTxBodyValue<M> : ClientBase
- (instancetype)initWithMessages:(NSArray<ClientProtoMsg<M> *> *)messages memo:(NSString *)memo __attribute__((swift_name("init(messages:memo:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxBodyValueCompanion *companion __attribute__((swift_name("companion")));
- (ClientTxBodyValue<M> *)doCopyMessages:(NSArray<ClientProtoMsg<M> *> *)messages memo:(NSString *)memo __attribute__((swift_name("doCopy(messages:memo:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *memo __attribute__((swift_name("memo")));
@property (readonly) NSArray<ClientProtoMsg<M> *> *messages __attribute__((swift_name("messages")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxBodyValueCompanion")))
@interface ClientTxBodyValueCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxBodyValueCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeSerial0:(id<ClientKotlinx_serialization_coreKSerializer>)typeSerial0 __attribute__((swift_name("serializer(typeSerial0:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxOptions")))
@interface ClientTxOptions : ClientBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithCustomGasLimit:(int32_t)customGasLimit __attribute__((swift_name("init(customGasLimit:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithGasLimit:(int32_t)gasLimit gasPriceInFeeDenom:(double)gasPriceInFeeDenom feeDenom:(NSString *)feeDenom feeGranter:(NSString * _Nullable)feeGranter memo:(NSString *)memo waitForCommit:(BOOL)waitForCommit broadcastTimeoutMs:(ClientInt * _Nullable)broadcastTimeoutMs broadcastCheckIntervalMs:(ClientInt * _Nullable)broadcastCheckIntervalMs broadcastMode:(ClientBroadcastMode *)broadcastMode explicitSignerData:(ClientSignerData * _Nullable)explicitSignerData __attribute__((swift_name("init(gasLimit:gasPriceInFeeDenom:feeDenom:feeGranter:memo:waitForCommit:broadcastTimeoutMs:broadcastCheckIntervalMs:broadcastMode:explicitSignerData:)"))) __attribute__((objc_designated_initializer));
- (ClientTxOptions *)doCopyGasLimit:(int32_t)gasLimit gasPriceInFeeDenom:(double)gasPriceInFeeDenom feeDenom:(NSString *)feeDenom feeGranter:(NSString * _Nullable)feeGranter memo:(NSString *)memo waitForCommit:(BOOL)waitForCommit broadcastTimeoutMs:(ClientInt * _Nullable)broadcastTimeoutMs broadcastCheckIntervalMs:(ClientInt * _Nullable)broadcastCheckIntervalMs broadcastMode:(ClientBroadcastMode *)broadcastMode explicitSignerData:(ClientSignerData * _Nullable)explicitSignerData __attribute__((swift_name("doCopy(gasLimit:gasPriceInFeeDenom:feeDenom:feeGranter:memo:waitForCommit:broadcastTimeoutMs:broadcastCheckIntervalMs:broadcastMode:explicitSignerData:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * When waiting for the tx to commit on-chain, how much time (in milliseconds) to wait between checks.
 *
 * Smaller intervals will cause more load on your node provider. Keep in mind that blocks on Secret Network take about 6 seconds to finalize.
 *
 * Defaults to `6_000`. Ignored if `waitForCommit = false`.
 */
@property (readonly) ClientInt * _Nullable broadcastCheckIntervalMs __attribute__((swift_name("broadcastCheckIntervalMs")));

/**
 * If `BroadcastMode.Sync` - Broadcast transaction to mempool and wait for CheckTx response.
 *
 * @see https://docs.tendermint.com/master/rpc/#/Tx/broadcast_tx_sync
 *
 * If `BroadcastMode.Async` Broadcast transaction to mempool and do not wait for CheckTx response.
 *
 * @see https://docs.tendermint.com/master/rpc/#/Tx/broadcast_tx_async
 */
@property (readonly) ClientBroadcastMode *broadcastMode __attribute__((swift_name("broadcastMode")));

/**
 * How much time (in milliseconds) to wait for tx to commit on-chain.
 *
 * Defaults to `60_000`. Ignored if `waitForCommit = false`.
 */
@property (readonly) ClientInt * _Nullable broadcastTimeoutMs __attribute__((swift_name("broadcastTimeoutMs")));

/**
 * explicitSignerData can be used to override `chainId`, `accountNumber` & `accountSequence`.
 * This is useful when using {@link BroadcastMode.Async} or when you don't want secretjs
 * to query for `accountNumber` & `accountSequence` from the chain. (smoother in UIs, less load on your node provider).
 */
@property (readonly) ClientSignerData * _Nullable explicitSignerData __attribute__((swift_name("explicitSignerData")));
@property (readonly) NSString *feeDenom __attribute__((swift_name("feeDenom")));

/** Address of the fee granter from which to charge gas fees. */
@property (readonly) NSString * _Nullable feeGranter __attribute__((swift_name("feeGranter")));

/** Defaults to `25_000`. */
@property (readonly) int32_t gasLimit __attribute__((swift_name("gasLimit")));

/** E.g. gasPriceInFeeDenom=0.1 & feeDenom="uscrt" => Total fee for tx is `0.1 * gasLimit`uscrt. Defaults to `0.1`. */
@property (readonly) double gasPriceInFeeDenom __attribute__((swift_name("gasPriceInFeeDenom")));
@property (readonly) NSString *memo __attribute__((swift_name("memo")));

/** If `false` returns immediately with only the `transactionHash` field set. Defaults to `true`. */
@property (readonly) BOOL waitForCommit __attribute__((swift_name("waitForCommit")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/google/protobuf/any.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AnyProto")))
@interface ClientAnyProto : ClientBase
- (instancetype)initWithTypeUrl:(NSString *)typeUrl value:(ClientKotlinByteArray *)value __attribute__((swift_name("init(typeUrl:value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientAnyProtoCompanion *companion __attribute__((swift_name("companion")));
- (ClientMsgProto *)toMsg __attribute__((swift_name("toMsg()")));
@property (readonly) NSString *typeUrl __attribute__((swift_name("typeUrl")));
@property (readonly) ClientKotlinByteArray *value __attribute__((swift_name("value")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/google/protobuf/any.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AnyProto.Companion")))
@interface ClientAnyProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/google/protobuf/any.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientAnyProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/google/protobuf/any.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("MsgProto")))
@interface ClientMsgProto : ClientBase
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthInfoProto")))
@interface ClientAuthInfoProto : ClientMsgProto
- (instancetype)initWithSignerInfos:(NSArray<ClientSignerInfoProto *> *)signerInfos fee:(ClientFeeProto * _Nullable)fee __attribute__((swift_name("init(signerInfos:fee:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientAuthInfoProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientFeeProto * _Nullable fee __attribute__((swift_name("fee")));
@property (readonly) NSArray<ClientSignerInfoProto *> *signerInfos __attribute__((swift_name("signerInfos")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthInfoProto.Companion")))
@interface ClientAuthInfoProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientAuthInfoProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CoinProto")))
@interface ClientCoinProto : ClientBase
- (instancetype)initWithDenom:(NSString *)denom amount:(NSString *)amount __attribute__((swift_name("init(denom:amount:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientCoinProtoCompanion *companion __attribute__((swift_name("companion")));
- (ClientCoinProto *)doCopyDenom:(NSString *)denom amount:(NSString *)amount __attribute__((swift_name("doCopy(denom:amount:)")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 */
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 */
- (NSUInteger)hash __attribute__((swift_name("hash()")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 */
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *amount __attribute__((swift_name("amount")));
@property (readonly) NSString *denom __attribute__((swift_name("denom")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CoinProto.Companion")))
@interface ClientCoinProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientCoinProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/v1beta1/coin.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/cosmos/cosmos-sdk/blob/main/proto/cosmos/tx/v1beta1/tx.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FeeProto")))
@interface ClientFeeProto : ClientMsgProto
- (instancetype)initWithAmount:(NSArray<ClientCoinProto *> *)amount gasLimit:(ClientInt * _Nullable)gasLimit payer:(NSString * _Nullable)payer granter:(NSString * _Nullable)granter __attribute__((swift_name("init(amount:gasLimit:payer:granter:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientFeeProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSArray<ClientCoinProto *> *amount __attribute__((swift_name("amount")));
@property (readonly) ClientInt * _Nullable gasLimit __attribute__((swift_name("gasLimit")));
@property (readonly) NSString * _Nullable granter __attribute__((swift_name("granter")));
@property (readonly) NSString * _Nullable payer __attribute__((swift_name("payer")));
@end


/***
 * Reference:
 * https://github.com/cosmos/cosmos-sdk/blob/main/proto/cosmos/tx/v1beta1/tx.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FeeProto.Companion")))
@interface ClientFeeProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/cosmos/cosmos-sdk/blob/main/proto/cosmos/tx/v1beta1/tx.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientFeeProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/cosmos/cosmos-sdk/blob/main/proto/cosmos/tx/v1beta1/tx.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/registration/v1beta1/msg.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KeyProto")))
@interface ClientKeyProto : ClientMsgProto
- (instancetype)initWithKey:(ClientKotlinByteArray * _Nullable)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientKeyProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientKotlinByteArray * _Nullable key __attribute__((swift_name("key")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/registration/v1beta1/msg.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KeyProto.Companion")))
@interface ClientKeyProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/registration/v1beta1/msg.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientKeyProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/secret/registration/v1beta1/msg.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModeInfoProto")))
@interface ClientModeInfoProto : ClientMsgProto
- (instancetype)initWithSingle:(ClientModeInfoProtoSingle * _Nullable)single multi:(ClientModeInfoProtoMulti * _Nullable)multi __attribute__((swift_name("init(single:multi:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientModeInfoProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientModeInfoProtoMulti * _Nullable multi __attribute__((swift_name("multi")));
@property (readonly) ClientModeInfoProtoSingle * _Nullable single __attribute__((swift_name("single")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModeInfoProto.Companion")))
@interface ClientModeInfoProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientModeInfoProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModeInfoProtoMulti")))
@interface ClientModeInfoProtoMulti : ClientMsgProto
- (instancetype)initWithModeInfos:(NSString * _Nullable)modeInfos __attribute__((swift_name("init(modeInfos:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientModeInfoProtoMultiCompanion *companion __attribute__((swift_name("companion")));
- (ClientModeInfoProtoMulti *)doCopyModeInfos:(NSString * _Nullable)modeInfos __attribute__((swift_name("doCopy(modeInfos:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable modeInfos __attribute__((swift_name("modeInfos")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModeInfoProtoMulti.Companion")))
@interface ClientModeInfoProtoMultiCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientModeInfoProtoMultiCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModeInfoProtoSingle")))
@interface ClientModeInfoProtoSingle : ClientMsgProto
- (instancetype)initWithMode:(int32_t)mode __attribute__((swift_name("init(mode:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientModeInfoProtoSingleCompanion *companion __attribute__((swift_name("companion")));
- (ClientModeInfoProtoSingle *)doCopyMode:(int32_t)mode __attribute__((swift_name("doCopy(mode:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t mode __attribute__((swift_name("mode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModeInfoProtoSingle.Companion")))
@interface ClientModeInfoProtoSingleCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientModeInfoProtoSingleCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminProto")))
@interface ClientMsgClearAdminProto : ClientMsgProto
- (instancetype)initWithSender:(NSString *)sender contract:(NSString *)contract callbackSig:(ClientKotlinByteArray * _Nullable)callbackSig __attribute__((swift_name("init(sender:contract:callbackSig:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgClearAdminProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientKotlinByteArray * _Nullable callbackSig __attribute__((swift_name("callbackSig")));
@property (readonly) NSString *contract __attribute__((swift_name("contract")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminProto.Companion")))
@interface ClientMsgClearAdminProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgClearAdminProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminResponseProto")))
@interface ClientMsgClearAdminResponseProto : ClientMsgProto

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) ClientMsgClearAdminResponseProtoCompanion *companion __attribute__((swift_name("companion")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgClearAdminResponseProto.Companion")))
@interface ClientMsgClearAdminResponseProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgClearAdminResponseProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgDataProto")))
@interface ClientMsgDataProto : ClientMsgProto
- (instancetype)initWithMsgType:(NSString *)msgType data:(ClientKotlinByteArray * _Nullable)data __attribute__((swift_name("init(msgType:data:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgDataProtoCompanion *companion __attribute__((swift_name("companion")));
- (ClientMsgProto *)toMsgResponseType __attribute__((swift_name("toMsgResponseType()")));
@property (readonly) ClientKotlinByteArray * _Nullable data __attribute__((swift_name("data")));
@property (readonly) NSString *msgType __attribute__((swift_name("msgType")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgDataProto.Companion")))
@interface ClientMsgDataProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgDataProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractProto")))
@interface ClientMsgExecuteContractProto : ClientMsgProto
- (instancetype)initWithSender:(ClientKotlinByteArray *)sender contract:(ClientKotlinByteArray *)contract msg:(ClientKotlinByteArray *)msg callbackCodeHash:(NSString * _Nullable)callbackCodeHash sentFunds:(NSArray<ClientCoinProto *> *)sentFunds callbackSig:(ClientKotlinByteArray * _Nullable)callbackSig __attribute__((swift_name("init(sender:contract:msg:callbackCodeHash:sentFunds:callbackSig:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgExecuteContractProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString * _Nullable callbackCodeHash __attribute__((swift_name("callbackCodeHash")));
@property (readonly) ClientKotlinByteArray * _Nullable callbackSig __attribute__((swift_name("callbackSig")));
@property (readonly) ClientKotlinByteArray *contract __attribute__((swift_name("contract")));
@property (readonly) ClientKotlinByteArray *msg __attribute__((swift_name("msg")));
@property (readonly) ClientKotlinByteArray *sender __attribute__((swift_name("sender")));
@property (readonly) NSArray<ClientCoinProto *> *sentFunds __attribute__((swift_name("sentFunds")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractProto.Companion")))
@interface ClientMsgExecuteContractProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgExecuteContractProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractResponseProto")))
@interface ClientMsgExecuteContractResponseProto : ClientMsgProto
- (instancetype)initWithData:(ClientKotlinByteArray * _Nullable)data __attribute__((swift_name("init(data:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgExecuteContractResponseProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientKotlinByteArray * _Nullable data __attribute__((swift_name("data")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgExecuteContractResponseProto.Companion")))
@interface ClientMsgExecuteContractResponseProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgExecuteContractResponseProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgInstantiateContractProto")))
@interface ClientMsgInstantiateContractProto : ClientMsgProto
- (instancetype)initWithSender:(ClientKotlinByteArray *)sender callbackCodeHash:(NSString * _Nullable)callbackCodeHash codeId:(int32_t)codeId label:(NSString *)label initMsg:(ClientKotlinByteArray *)initMsg initFunds:(NSArray<ClientCoinProto *> *)initFunds callbackSig:(ClientKotlinByteArray * _Nullable)callbackSig admin:(NSString * _Nullable)admin __attribute__((swift_name("init(sender:callbackCodeHash:codeId:label:initMsg:initFunds:callbackSig:admin:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgInstantiateContractProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString * _Nullable admin __attribute__((swift_name("admin")));
@property (readonly) NSString * _Nullable callbackCodeHash __attribute__((swift_name("callbackCodeHash")));
@property (readonly) ClientKotlinByteArray * _Nullable callbackSig __attribute__((swift_name("callbackSig")));
@property (readonly) int32_t codeId __attribute__((swift_name("codeId")));
@property (readonly, getter=doInitFunds) NSArray<ClientCoinProto *> *initFunds __attribute__((swift_name("initFunds")));
@property (readonly, getter=doInitMsg) ClientKotlinByteArray *initMsg __attribute__((swift_name("initMsg")));
@property (readonly) NSString *label __attribute__((swift_name("label")));
@property (readonly) ClientKotlinByteArray *sender __attribute__((swift_name("sender")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgInstantiateContractProto.Companion")))
@interface ClientMsgInstantiateContractProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgInstantiateContractProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgInstantiateContractResponseProto")))
@interface ClientMsgInstantiateContractResponseProto : ClientMsgProto
- (instancetype)initWithAddress:(NSString *)address data:(ClientKotlinByteArray * _Nullable)data __attribute__((swift_name("init(address:data:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgInstantiateContractResponseProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString *address __attribute__((swift_name("address")));
@property (readonly) ClientKotlinByteArray * _Nullable data __attribute__((swift_name("data")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgInstantiateContractResponseProto.Companion")))
@interface ClientMsgInstantiateContractResponseProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgInstantiateContractResponseProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractProto")))
@interface ClientMsgMigrateContractProto : ClientMsgProto
- (instancetype)initWithSender:(NSString *)sender contract:(NSString *)contract codeId:(int32_t)codeId msg:(ClientKotlinByteArray *)msg callbackSig:(ClientKotlinByteArray * _Nullable)callbackSig callbackCodeHash:(NSString * _Nullable)callbackCodeHash __attribute__((swift_name("init(sender:contract:codeId:msg:callbackSig:callbackCodeHash:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgMigrateContractProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString * _Nullable callbackCodeHash __attribute__((swift_name("callbackCodeHash")));
@property (readonly) ClientKotlinByteArray * _Nullable callbackSig __attribute__((swift_name("callbackSig")));
@property (readonly) int32_t codeId __attribute__((swift_name("codeId")));
@property (readonly) NSString *contract __attribute__((swift_name("contract")));
@property (readonly) ClientKotlinByteArray *msg __attribute__((swift_name("msg")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractProto.Companion")))
@interface ClientMsgMigrateContractProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgMigrateContractProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractResponseProto")))
@interface ClientMsgMigrateContractResponseProto : ClientMsgProto
- (instancetype)initWithData:(ClientKotlinByteArray * _Nullable)data __attribute__((swift_name("init(data:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgMigrateContractResponseProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientKotlinByteArray * _Nullable data __attribute__((swift_name("data")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgMigrateContractResponseProto.Companion")))
@interface ClientMsgMigrateContractResponseProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgMigrateContractResponseProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendProto")))
@interface ClientMsgSendProto : ClientMsgProto
- (instancetype)initWithFromAddress:(NSString *)fromAddress toAddress:(NSString *)toAddress amount:(NSArray<ClientCoinProto *> *)amount __attribute__((swift_name("init(fromAddress:toAddress:amount:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgSendProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSArray<ClientCoinProto *> *amount __attribute__((swift_name("amount")));
@property (readonly) NSString *fromAddress __attribute__((swift_name("fromAddress")));
@property (readonly) NSString *toAddress __attribute__((swift_name("toAddress")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendProto.Companion")))
@interface ClientMsgSendProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgSendProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendResponseProto")))
@interface ClientMsgSendResponseProto : ClientMsgProto

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) ClientMsgSendResponseProtoCompanion *companion __attribute__((swift_name("companion")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgSendResponseProto.Companion")))
@interface ClientMsgSendResponseProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgSendResponseProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/third_party/proto/cosmos/bank/v1beta1/tx.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeProto")))
@interface ClientMsgStoreCodeProto : ClientMsgProto
- (instancetype)initWithSender:(ClientKotlinByteArray *)sender wasmByteCode:(ClientKotlinByteArray *)wasmByteCode source:(NSString * _Nullable)source builder:(NSString * _Nullable)builder __attribute__((swift_name("init(sender:wasmByteCode:source:builder:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgStoreCodeProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString * _Nullable builder __attribute__((swift_name("builder")));
@property (readonly) ClientKotlinByteArray *sender __attribute__((swift_name("sender")));
@property (readonly) NSString * _Nullable source __attribute__((swift_name("source")));
@property (readonly) ClientKotlinByteArray *wasmByteCode __attribute__((swift_name("wasmByteCode")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeProto.Companion")))
@interface ClientMsgStoreCodeProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgStoreCodeProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeResponseProto")))
@interface ClientMsgStoreCodeResponseProto : ClientMsgProto
- (instancetype)initWithCodeId:(int32_t)codeId __attribute__((swift_name("init(codeId:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgStoreCodeResponseProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) int32_t codeId __attribute__((swift_name("codeId")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgStoreCodeResponseProto.Companion")))
@interface ClientMsgStoreCodeResponseProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgStoreCodeResponseProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminProto")))
@interface ClientMsgUpdateAdminProto : ClientMsgProto
- (instancetype)initWithSender:(NSString *)sender newAdmin:(NSString *)newAdmin contract:(NSString *)contract callbackSig:(ClientKotlinByteArray * _Nullable)callbackSig __attribute__((swift_name("init(sender:newAdmin:contract:callbackSig:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientMsgUpdateAdminProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientKotlinByteArray * _Nullable callbackSig __attribute__((swift_name("callbackSig")));
@property (readonly) NSString *contract __attribute__((swift_name("contract")));
@property (readonly, getter=doNewAdmin) NSString *newAdmin __attribute__((swift_name("newAdmin")));
@property (readonly) NSString *sender __attribute__((swift_name("sender")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminProto.Companion")))
@interface ClientMsgUpdateAdminProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgUpdateAdminProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminResponseProto")))
@interface ClientMsgUpdateAdminResponseProto : ClientMsgProto

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) ClientMsgUpdateAdminResponseProtoCompanion *companion __attribute__((swift_name("companion")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MsgUpdateAdminResponseProto.Companion")))
@interface ClientMsgUpdateAdminResponseProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientMsgUpdateAdminResponseProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/proto/secret/compute/v1beta1/msg.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProtoMsg")))
@interface ClientProtoMsg<M> : ClientBase
- (instancetype)initWithTypeUrl:(NSString *)typeUrl value:(M)value __attribute__((swift_name("init(typeUrl:value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientProtoMsgCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSString *typeUrl __attribute__((swift_name("typeUrl")));
@property (readonly) M value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProtoMsgCompanion")))
@interface ClientProtoMsgCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientProtoMsgCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeSerial0:(id<ClientKotlinx_serialization_coreKSerializer>)typeSerial0 __attribute__((swift_name("serializer(typeSerial0:)")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignDocProto")))
@interface ClientSignDocProto : ClientMsgProto
- (instancetype)initWithBodyBytes:(ClientKotlinByteArray *)bodyBytes authInfoBytes:(ClientKotlinByteArray *)authInfoBytes chainId:(NSString *)chainId accountNumber:(ClientInt * _Nullable)accountNumber __attribute__((swift_name("init(bodyBytes:authInfoBytes:chainId:accountNumber:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSignDocProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientInt * _Nullable accountNumber __attribute__((swift_name("accountNumber")));
@property (readonly) ClientKotlinByteArray *authInfoBytes __attribute__((swift_name("authInfoBytes")));
@property (readonly) ClientKotlinByteArray *bodyBytes __attribute__((swift_name("bodyBytes")));
@property (readonly) NSString *chainId __attribute__((swift_name("chainId")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignDocProto.Companion")))
@interface ClientSignDocProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSignDocProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/signing/v1beta1/signing.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignMode")))
@interface ClientSignMode : ClientKotlinEnum<ClientSignMode *>
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/signing/v1beta1/signing.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ClientSignModeCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) ClientSignMode *signModeUnspecified __attribute__((swift_name("signModeUnspecified")));
@property (class, readonly) ClientSignMode *signModeDirect __attribute__((swift_name("signModeDirect")));
@property (class, readonly) ClientSignMode *signModeTextual __attribute__((swift_name("signModeTextual")));
@property (class, readonly) ClientSignMode *signModeLegacyAminoJson __attribute__((swift_name("signModeLegacyAminoJson")));
@property (class, readonly) ClientSignMode *signModeEip191 __attribute__((swift_name("signModeEip191")));
@property (class, readonly) ClientSignMode *unrecognized __attribute__((swift_name("unrecognized")));
+ (ClientKotlinArray<ClientSignMode *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClientSignMode *> *entries __attribute__((swift_name("entries")));
@property (readonly) int32_t value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignMode.Companion")))
@interface ClientSignModeCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSignModeCompanion *shared __attribute__((swift_name("shared")));
- (ClientSignMode * _Nullable)getByValueValue:(ClientInt * _Nullable)value __attribute__((swift_name("getByValue(value:)")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/cosmwasm/enclaves/execute/proto/cosmos/tx/v1beta1/tx.proto
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignerInfoProto")))
@interface ClientSignerInfoProto : ClientMsgProto
- (instancetype)initWithPublicKey:(ClientAnyProto * _Nullable)publicKey modeInfo:(ClientModeInfoProto * _Nullable)modeInfo sequence:(ClientInt * _Nullable)sequence __attribute__((swift_name("init(publicKey:modeInfo:sequence:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSignerInfoProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientModeInfoProto * _Nullable modeInfo __attribute__((swift_name("modeInfo")));
@property (readonly) ClientAnyProto * _Nullable publicKey __attribute__((swift_name("publicKey")));
@property (readonly) ClientInt * _Nullable sequence __attribute__((swift_name("sequence")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/cosmwasm/enclaves/execute/proto/cosmos/tx/v1beta1/tx.proto
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignerInfoProto.Companion")))
@interface ClientSignerInfoProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/cosmwasm/enclaves/execute/proto/cosmos/tx/v1beta1/tx.proto
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSignerInfoProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/SecretNetwork/blob/master/cosmwasm/enclaves/execute/proto/cosmos/tx/v1beta1/tx.proto
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxBodyProto")))
@interface ClientTxBodyProto : ClientMsgProto
- (instancetype)initWithMessages:(NSArray<ClientAnyProto *> *)messages memo:(NSString *)memo timeoutHeight:(NSString *)timeoutHeight extensionOptions:(NSArray<ClientAnyProto *> *)extensionOptions nonCriticalExtensionOptions:(NSArray<ClientAnyProto *> *)nonCriticalExtensionOptions __attribute__((swift_name("init(messages:memo:timeoutHeight:extensionOptions:nonCriticalExtensionOptions:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxBodyProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSArray<ClientAnyProto *> *extensionOptions __attribute__((swift_name("extensionOptions")));
@property (readonly) NSString *memo __attribute__((swift_name("memo")));
@property (readonly) NSArray<ClientAnyProto *> *messages __attribute__((swift_name("messages")));
@property (readonly) NSArray<ClientAnyProto *> *nonCriticalExtensionOptions __attribute__((swift_name("nonCriticalExtensionOptions")));
@property (readonly) NSString *timeoutHeight __attribute__((swift_name("timeoutHeight")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxBodyProto.Companion")))
@interface ClientTxBodyProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxBodyProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxMsgDataProto")))
@interface ClientTxMsgDataProto : ClientMsgProto
- (instancetype)initWithMsg_responses:(NSArray<ClientAnyProto *> *)msg_responses __attribute__((swift_name("init(msg_responses:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxMsgDataProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) NSArray<ClientAnyProto *> *msg_responses __attribute__((swift_name("msg_responses")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxMsgDataProto.Companion")))
@interface ClientTxMsgDataProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxMsgDataProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/base/abci/v1beta1/abci.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 *
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxRawProto")))
@interface ClientTxRawProto : ClientMsgProto
- (instancetype)initWithBodyBytes:(ClientKotlinByteArray *)bodyBytes authInfoBytes:(ClientKotlinByteArray *)authInfoBytes signatures:(NSArray<ClientKotlinByteArray *> *)signatures __attribute__((swift_name("init(bodyBytes:authInfoBytes:signatures:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxRawProtoCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientKotlinByteArray *authInfoBytes __attribute__((swift_name("authInfoBytes")));
@property (readonly) ClientKotlinByteArray *bodyBytes __attribute__((swift_name("bodyBytes")));
@property (readonly) NSArray<ClientKotlinByteArray *> *signatures __attribute__((swift_name("signatures")));
@end


/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxRawProto.Companion")))
@interface ClientTxRawProtoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxRawProtoCompanion *shared __attribute__((swift_name("shared")));

/***
 * Reference:
 * https://github.com/scrtlabs/secret.js/blob/master/src/protobuf_stuff/cosmos/tx/v1beta1/tx.ts
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((swift_name("V1BetaType")))
@interface ClientV1BetaType : ClientBase
@property (class, readonly, getter=companion) ClientV1BetaTypeCompanion *companion __attribute__((swift_name("companion")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="/cosmos.auth.v1beta1.BaseAccount")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Account")))
@interface ClientAccount : ClientV1BetaType
- (instancetype)initWithAddress:(NSString *)address pub_key:(ClientSecp256k1PubKey * _Nullable)pub_key accountNumber:(ClientBignumBigInteger * _Nullable)accountNumber sequence:(ClientBignumBigInteger * _Nullable)sequence __attribute__((swift_name("init(address:pub_key:accountNumber:sequence:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientAccountCompanion *companion __attribute__((swift_name("companion")));
- (ClientAccount *)doCopyAddress:(NSString *)address pub_key:(ClientSecp256k1PubKey * _Nullable)pub_key accountNumber:(ClientBignumBigInteger * _Nullable)accountNumber sequence:(ClientBignumBigInteger * _Nullable)sequence __attribute__((swift_name("doCopy(address:pub_key:accountNumber:sequence:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="account_number")
*/
@property (readonly) ClientBignumBigInteger * _Nullable accountNumber __attribute__((swift_name("accountNumber")));
@property (readonly) NSString *address __attribute__((swift_name("address")));
@property (readonly) ClientSecp256k1PubKey * _Nullable pub_key __attribute__((swift_name("pub_key")));
@property (readonly) ClientBignumBigInteger * _Nullable sequence __attribute__((swift_name("sequence")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Account.Companion")))
@interface ClientAccountCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientAccountCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountResponse")))
@interface ClientAccountResponse : ClientBase
- (instancetype)initWithAccount:(ClientAccount *)account __attribute__((swift_name("init(account:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientAccountResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientAccountResponse *)doCopyAccount:(ClientAccount *)account __attribute__((swift_name("doCopy(account:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientAccount *account __attribute__((swift_name("account")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountResponse.Companion")))
@interface ClientAccountResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientAccountResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ApplicationVersion")))
@interface ClientApplicationVersion : ClientBase
- (instancetype)initWithName:(NSString *)name appName:(NSString *)appName version:(NSString *)version gitCommit:(NSString *)gitCommit buildTags:(NSString *)buildTags goVersion:(NSString *)goVersion __attribute__((swift_name("init(name:appName:version:gitCommit:buildTags:goVersion:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientApplicationVersionCompanion *companion __attribute__((swift_name("companion")));
- (ClientApplicationVersion *)doCopyName:(NSString *)name appName:(NSString *)appName version:(NSString *)version gitCommit:(NSString *)gitCommit buildTags:(NSString *)buildTags goVersion:(NSString *)goVersion __attribute__((swift_name("doCopy(name:appName:version:gitCommit:buildTags:goVersion:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *appName __attribute__((swift_name("appName")));
@property (readonly) NSString *buildTags __attribute__((swift_name("buildTags")));
@property (readonly) NSString *gitCommit __attribute__((swift_name("gitCommit")));
@property (readonly) NSString *goVersion __attribute__((swift_name("goVersion")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString *version __attribute__((swift_name("version")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ApplicationVersion.Companion")))
@interface ClientApplicationVersionCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientApplicationVersionCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BalanceResponse")))
@interface ClientBalanceResponse : ClientBase
- (instancetype)initWithBalances:(NSArray<ClientCosmwasm_std_typesCoin *> *)balances __attribute__((swift_name("init(balances:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientBalanceResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientBalanceResponse *)doCopyBalances:(NSArray<ClientCosmwasm_std_typesCoin *> *)balances __attribute__((swift_name("doCopy(balances:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<ClientCosmwasm_std_typesCoin *> *balances __attribute__((swift_name("balances")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BalanceResponse.Companion")))
@interface ClientBalanceResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientBalanceResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Block")))
@interface ClientBlock : ClientBase
- (instancetype)initWithHeader:(ClientHeader *)header data:(ClientData *)data lastCommit:(ClientLastCommit *)lastCommit __attribute__((swift_name("init(header:data:lastCommit:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientBlockCompanion *companion __attribute__((swift_name("companion")));
- (ClientBlock *)doCopyHeader:(ClientHeader *)header data:(ClientData *)data lastCommit:(ClientLastCommit *)lastCommit __attribute__((swift_name("doCopy(header:data:lastCommit:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientData *data __attribute__((swift_name("data")));
@property (readonly) ClientHeader *header __attribute__((swift_name("header")));
@property (readonly) ClientLastCommit *lastCommit __attribute__((swift_name("lastCommit")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Block.Companion")))
@interface ClientBlockCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientBlockCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockId")))
@interface ClientBlockId : ClientBase
- (instancetype)initWithHash:(NSString *)hash partSetHeader:(ClientPartSetHeader *)partSetHeader __attribute__((swift_name("init(hash:partSetHeader:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientBlockIdCompanion *companion __attribute__((swift_name("companion")));
- (ClientBlockId *)doCopyHash:(NSString *)hash partSetHeader:(ClientPartSetHeader *)partSetHeader __attribute__((swift_name("doCopy(hash:partSetHeader:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly, getter=hash_) NSString *hash __attribute__((swift_name("hash")));
@property (readonly) ClientPartSetHeader *partSetHeader __attribute__((swift_name("partSetHeader")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockId.Companion")))
@interface ClientBlockIdCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientBlockIdCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockResponse")))
@interface ClientBlockResponse : ClientBase
- (instancetype)initWithBlockId:(ClientBlockId *)blockId block:(ClientBlock *)block __attribute__((swift_name("init(blockId:block:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientBlockResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientBlockResponse *)doCopyBlockId:(ClientBlockId *)blockId block:(ClientBlock *)block __attribute__((swift_name("doCopy(blockId:block:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientBlock *block __attribute__((swift_name("block")));
@property (readonly) ClientBlockId *blockId __attribute__((swift_name("blockId")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockResponse.Companion")))
@interface ClientBlockResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientBlockResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CodeHashResponse")))
@interface ClientCodeHashResponse : ClientBase
- (instancetype)initWithCodeHash:(NSString *)codeHash __attribute__((swift_name("init(codeHash:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientCodeHashResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientCodeHashResponse *)doCopyCodeHash:(NSString *)codeHash __attribute__((swift_name("doCopy(codeHash:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *codeHash __attribute__((swift_name("codeHash")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CodeHashResponse.Companion")))
@interface ClientCodeHashResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientCodeHashResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CodeInfoResponse")))
@interface ClientCodeInfoResponse : ClientBase
- (instancetype)initWithCodeInfo:(ClientCosmwasm_std_typesCodeInfo *)codeInfo __attribute__((swift_name("init(codeInfo:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientCodeInfoResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientCodeInfoResponse *)doCopyCodeInfo:(ClientCosmwasm_std_typesCodeInfo *)codeInfo __attribute__((swift_name("doCopy(codeInfo:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="code_info")
*/
@property (readonly) ClientCosmwasm_std_typesCodeInfo *codeInfo __attribute__((swift_name("codeInfo")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CodeInfoResponse.Companion")))
@interface ClientCodeInfoResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientCodeInfoResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ContractInfoResponse")))
@interface ClientContractInfoResponse : ClientBase
- (instancetype)initWithContractAddress:(NSString *)contractAddress contractInfo:(ClientContractInfoResponseContractInfo *)contractInfo __attribute__((swift_name("init(contractAddress:contractInfo:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientContractInfoResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientContractInfoResponse *)doCopyContractAddress:(NSString *)contractAddress contractInfo:(ClientContractInfoResponseContractInfo *)contractInfo __attribute__((swift_name("doCopy(contractAddress:contractInfo:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="contract_address")
*/
@property (readonly) NSString *contractAddress __attribute__((swift_name("contractAddress")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="contract_info")
*/
@property (readonly) ClientContractInfoResponseContractInfo *contractInfo __attribute__((swift_name("contractInfo")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ContractInfoResponse.Companion")))
@interface ClientContractInfoResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientContractInfoResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ContractInfoResponse.ContractInfo")))
@interface ClientContractInfoResponseContractInfo : ClientBase
- (instancetype)initWithCodeId:(int32_t)codeId creator:(NSString *)creator label:(NSString *)label created:(ClientContractInfoResponseCreationInfo *)created ibcPortId:(NSString *)ibcPortId admin:(NSString *)admin adminProof:(NSString * _Nullable)adminProof __attribute__((swift_name("init(codeId:creator:label:created:ibcPortId:admin:adminProof:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientContractInfoResponseContractInfoCompanion *companion __attribute__((swift_name("companion")));
- (ClientContractInfoResponseContractInfo *)doCopyCodeId:(int32_t)codeId creator:(NSString *)creator label:(NSString *)label created:(ClientContractInfoResponseCreationInfo *)created ibcPortId:(NSString *)ibcPortId admin:(NSString *)admin adminProof:(NSString * _Nullable)adminProof __attribute__((swift_name("doCopy(codeId:creator:label:created:ibcPortId:admin:adminProof:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *admin __attribute__((swift_name("admin")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="admin_proof")
*/
@property (readonly) NSString * _Nullable adminProof __attribute__((swift_name("adminProof")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="code_id")
*/
@property (readonly) int32_t codeId __attribute__((swift_name("codeId")));
@property (readonly) ClientContractInfoResponseCreationInfo *created __attribute__((swift_name("created")));
@property (readonly) NSString *creator __attribute__((swift_name("creator")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="ibc_port_id")
*/
@property (readonly) NSString *ibcPortId __attribute__((swift_name("ibcPortId")));
@property (readonly) NSString *label __attribute__((swift_name("label")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ContractInfoResponse.ContractInfoCompanion")))
@interface ClientContractInfoResponseContractInfoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientContractInfoResponseContractInfoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ContractInfoResponse.CreationInfo")))
@interface ClientContractInfoResponseCreationInfo : ClientBase
- (instancetype)initWithBlockHeight:(NSString *)blockHeight txIndex:(NSString *)txIndex __attribute__((swift_name("init(blockHeight:txIndex:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientContractInfoResponseCreationInfoCompanion *companion __attribute__((swift_name("companion")));
- (ClientContractInfoResponseCreationInfo *)doCopyBlockHeight:(NSString *)blockHeight txIndex:(NSString *)txIndex __attribute__((swift_name("doCopy(blockHeight:txIndex:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="block_height")
*/
@property (readonly) NSString *blockHeight __attribute__((swift_name("blockHeight")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="tx_index")
*/
@property (readonly) NSString *txIndex __attribute__((swift_name("txIndex")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ContractInfoResponse.CreationInfoCompanion")))
@interface ClientContractInfoResponseCreationInfoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientContractInfoResponseCreationInfoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Data")))
@interface ClientData : ClientBase
- (instancetype)initWithTxs:(NSArray<NSString *> *)txs __attribute__((swift_name("init(txs:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientDataCompanion *companion __attribute__((swift_name("companion")));
- (ClientData *)doCopyTxs:(NSArray<NSString *> *)txs __attribute__((swift_name("doCopy(txs:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<NSString *> *txs __attribute__((swift_name("txs")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Data.Companion")))
@interface ClientDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EncryptedRandom")))
@interface ClientEncryptedRandom : ClientBase
- (instancetype)initWithRandom:(NSString *)random proof:(NSString *)proof __attribute__((swift_name("init(random:proof:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientEncryptedRandomCompanion *companion __attribute__((swift_name("companion")));
- (ClientEncryptedRandom *)doCopyRandom:(NSString *)random proof:(NSString *)proof __attribute__((swift_name("doCopy(random:proof:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *proof __attribute__((swift_name("proof")));
@property (readonly) NSString *random __attribute__((swift_name("random")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EncryptedRandom.Companion")))
@interface ClientEncryptedRandomCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientEncryptedRandomCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GasInfo")))
@interface ClientGasInfo : ClientBase
- (instancetype)initWithGasWanted:(NSString *)gasWanted gasUsed:(NSString *)gasUsed __attribute__((swift_name("init(gasWanted:gasUsed:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientGasInfoCompanion *companion __attribute__((swift_name("companion")));
- (ClientGasInfo *)doCopyGasWanted:(NSString *)gasWanted gasUsed:(NSString *)gasUsed __attribute__((swift_name("doCopy(gasWanted:gasUsed:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/** Amount of gas consumed by transaction.
 *
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gas_used")
*/
@property (readonly) NSString *gasUsed __attribute__((swift_name("gasUsed")));

/** Amount of gas requested for transaction.
 *
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gas_wanted")
*/
@property (readonly) NSString *gasWanted __attribute__((swift_name("gasWanted")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GasInfo.Companion")))
@interface ClientGasInfoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientGasInfoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GetNonceResult")))
@interface ClientGetNonceResult : ClientBase
- (instancetype)initWithAccountNumber:(ClientBignumBigInteger *)accountNumber sequence:(ClientBignumBigInteger *)sequence __attribute__((swift_name("init(accountNumber:sequence:)"))) __attribute__((objc_designated_initializer));
- (ClientGetNonceResult *)doCopyAccountNumber:(ClientBignumBigInteger *)accountNumber sequence:(ClientBignumBigInteger *)sequence __attribute__((swift_name("doCopy(accountNumber:sequence:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientBignumBigInteger *accountNumber __attribute__((swift_name("accountNumber")));
@property (readonly) ClientBignumBigInteger *sequence __attribute__((swift_name("sequence")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Header")))
@interface ClientHeader : ClientBase
- (instancetype)initWithVersion:(ClientVersion *)version chainId:(NSString *)chainId height:(NSString *)height time:(NSString *)time lastBlockId:(ClientBlockId *)lastBlockId lastCommitHash:(NSString *)lastCommitHash dataHash:(NSString *)dataHash validatorsHash:(NSString *)validatorsHash nextValidatorsHash:(NSString *)nextValidatorsHash consensusHash:(NSString *)consensusHash appHash:(NSString *)appHash lastResultsHash:(NSString *)lastResultsHash evidenceHash:(NSString *)evidenceHash proposerAddress:(NSString *)proposerAddress encryptedRandom:(ClientEncryptedRandom *)encryptedRandom __attribute__((swift_name("init(version:chainId:height:time:lastBlockId:lastCommitHash:dataHash:validatorsHash:nextValidatorsHash:consensusHash:appHash:lastResultsHash:evidenceHash:proposerAddress:encryptedRandom:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientHeaderCompanion *companion __attribute__((swift_name("companion")));
- (ClientHeader *)doCopyVersion:(ClientVersion *)version chainId:(NSString *)chainId height:(NSString *)height time:(NSString *)time lastBlockId:(ClientBlockId *)lastBlockId lastCommitHash:(NSString *)lastCommitHash dataHash:(NSString *)dataHash validatorsHash:(NSString *)validatorsHash nextValidatorsHash:(NSString *)nextValidatorsHash consensusHash:(NSString *)consensusHash appHash:(NSString *)appHash lastResultsHash:(NSString *)lastResultsHash evidenceHash:(NSString *)evidenceHash proposerAddress:(NSString *)proposerAddress encryptedRandom:(ClientEncryptedRandom *)encryptedRandom __attribute__((swift_name("doCopy(version:chainId:height:time:lastBlockId:lastCommitHash:dataHash:validatorsHash:nextValidatorsHash:consensusHash:appHash:lastResultsHash:evidenceHash:proposerAddress:encryptedRandom:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *appHash __attribute__((swift_name("appHash")));
@property (readonly) NSString *chainId __attribute__((swift_name("chainId")));
@property (readonly) NSString *consensusHash __attribute__((swift_name("consensusHash")));
@property (readonly) NSString *dataHash __attribute__((swift_name("dataHash")));
@property (readonly) ClientEncryptedRandom *encryptedRandom __attribute__((swift_name("encryptedRandom")));
@property (readonly) NSString *evidenceHash __attribute__((swift_name("evidenceHash")));
@property (readonly) NSString *height __attribute__((swift_name("height")));
@property (readonly) ClientBlockId *lastBlockId __attribute__((swift_name("lastBlockId")));
@property (readonly) NSString *lastCommitHash __attribute__((swift_name("lastCommitHash")));
@property (readonly) NSString *lastResultsHash __attribute__((swift_name("lastResultsHash")));
@property (readonly) NSString *nextValidatorsHash __attribute__((swift_name("nextValidatorsHash")));
@property (readonly) NSString *proposerAddress __attribute__((swift_name("proposerAddress")));
@property (readonly) NSString *time __attribute__((swift_name("time")));
@property (readonly) NSString *validatorsHash __attribute__((swift_name("validatorsHash")));
@property (readonly) ClientVersion *version __attribute__((swift_name("version")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Header.Companion")))
@interface ClientHeaderCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientHeaderCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LabelResponse")))
@interface ClientLabelResponse : ClientBase
- (instancetype)initWithLabel:(NSString *)label __attribute__((swift_name("init(label:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientLabelResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientLabelResponse *)doCopyLabel:(NSString *)label __attribute__((swift_name("doCopy(label:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *label __attribute__((swift_name("label")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LabelResponse.Companion")))
@interface ClientLabelResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientLabelResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LastCommit")))
@interface ClientLastCommit : ClientBase
- (instancetype)initWithHeight:(NSString *)height round:(int32_t)round blockId:(ClientBlockId *)blockId signatures:(NSArray<ClientSignature *> *)signatures __attribute__((swift_name("init(height:round:blockId:signatures:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientLastCommitCompanion *companion __attribute__((swift_name("companion")));
- (ClientLastCommit *)doCopyHeight:(NSString *)height round:(int32_t)round blockId:(ClientBlockId *)blockId signatures:(NSArray<ClientSignature *> *)signatures __attribute__((swift_name("doCopy(height:round:blockId:signatures:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientBlockId *blockId __attribute__((swift_name("blockId")));
@property (readonly) NSString *height __attribute__((swift_name("height")));
@property (readonly) int32_t round __attribute__((swift_name("round")));
@property (readonly) NSArray<ClientSignature *> *signatures __attribute__((swift_name("signatures")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LastCommit.Companion")))
@interface ClientLastCommitCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientLastCommitCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("NodeInfo")))
@interface ClientNodeInfo : ClientBase
- (instancetype)initWithProtocolVersion:(ClientProtocolVersion *)protocolVersion defaultNodeId:(NSString *)defaultNodeId listenAddr:(NSString *)listenAddr network:(NSString *)network version:(NSString *)version channels:(NSString *)channels moniker:(NSString *)moniker other:(ClientNodeInfoOther *)other __attribute__((swift_name("init(protocolVersion:defaultNodeId:listenAddr:network:version:channels:moniker:other:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientNodeInfoCompanion *companion __attribute__((swift_name("companion")));
- (ClientNodeInfo *)doCopyProtocolVersion:(ClientProtocolVersion *)protocolVersion defaultNodeId:(NSString *)defaultNodeId listenAddr:(NSString *)listenAddr network:(NSString *)network version:(NSString *)version channels:(NSString *)channels moniker:(NSString *)moniker other:(ClientNodeInfoOther *)other __attribute__((swift_name("doCopy(protocolVersion:defaultNodeId:listenAddr:network:version:channels:moniker:other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *channels __attribute__((swift_name("channels")));
@property (readonly) NSString *defaultNodeId __attribute__((swift_name("defaultNodeId")));
@property (readonly) NSString *listenAddr __attribute__((swift_name("listenAddr")));
@property (readonly) NSString *moniker __attribute__((swift_name("moniker")));
@property (readonly) NSString *network __attribute__((swift_name("network")));
@property (readonly) ClientNodeInfoOther *other __attribute__((swift_name("other")));
@property (readonly) ClientProtocolVersion *protocolVersion __attribute__((swift_name("protocolVersion")));
@property (readonly) NSString *version __attribute__((swift_name("version")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("NodeInfo.Companion")))
@interface ClientNodeInfoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientNodeInfoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("NodeInfoOther")))
@interface ClientNodeInfoOther : ClientBase
- (instancetype)initWithTxIndex:(NSString *)txIndex rpcAddress:(NSString *)rpcAddress __attribute__((swift_name("init(txIndex:rpcAddress:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientNodeInfoOtherCompanion *companion __attribute__((swift_name("companion")));
- (ClientNodeInfoOther *)doCopyTxIndex:(NSString *)txIndex rpcAddress:(NSString *)rpcAddress __attribute__((swift_name("doCopy(txIndex:rpcAddress:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *rpcAddress __attribute__((swift_name("rpcAddress")));
@property (readonly) NSString *txIndex __attribute__((swift_name("txIndex")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("NodeInfoOther.Companion")))
@interface ClientNodeInfoOtherCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientNodeInfoOtherCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("NodeInfoResponse")))
@interface ClientNodeInfoResponse : ClientBase
- (instancetype)initWithDefaultNodeInfo:(ClientNodeInfo *)defaultNodeInfo applicationVersion:(ClientApplicationVersion *)applicationVersion __attribute__((swift_name("init(defaultNodeInfo:applicationVersion:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientNodeInfoResponseCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientApplicationVersion *applicationVersion __attribute__((swift_name("applicationVersion")));
@property (readonly) ClientNodeInfo *defaultNodeInfo __attribute__((swift_name("defaultNodeInfo")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("NodeInfoResponse.Companion")))
@interface ClientNodeInfoResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientNodeInfoResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PartSetHeader")))
@interface ClientPartSetHeader : ClientBase
- (instancetype)initWithTotal:(int32_t)total hash:(NSString *)hash __attribute__((swift_name("init(total:hash:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientPartSetHeaderCompanion *companion __attribute__((swift_name("companion")));
- (ClientPartSetHeader *)doCopyTotal:(int32_t)total hash:(NSString *)hash __attribute__((swift_name("doCopy(total:hash:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly, getter=hash_) NSString *hash __attribute__((swift_name("hash")));
@property (readonly) int32_t total __attribute__((swift_name("total")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PartSetHeader.Companion")))
@interface ClientPartSetHeaderCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientPartSetHeaderCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProtocolVersion")))
@interface ClientProtocolVersion : ClientBase
- (instancetype)initWithP2p:(NSString *)p2p block:(NSString *)block app:(NSString *)app __attribute__((swift_name("init(p2p:block:app:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientProtocolVersionCompanion *companion __attribute__((swift_name("companion")));
- (ClientProtocolVersion *)doCopyP2p:(NSString *)p2p block:(NSString *)block app:(NSString *)app __attribute__((swift_name("doCopy(p2p:block:app:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *app __attribute__((swift_name("app")));
@property (readonly) NSString *block __attribute__((swift_name("block")));
@property (readonly) NSString *p2p __attribute__((swift_name("p2p")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProtocolVersion.Companion")))
@interface ClientProtocolVersionCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientProtocolVersionCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="/cosmos.crypto.secp256k1.PubKey")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secp256k1PubKey")))
@interface ClientSecp256k1PubKey : ClientV1BetaType
- (instancetype)initWithKey:(NSString *)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSecp256k1PubKeyCompanion *companion __attribute__((swift_name("companion")));
- (ClientSecp256k1PubKey *)doCopyKey:(NSString *)key __attribute__((swift_name("doCopy(key:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secp256k1PubKey.Companion")))
@interface ClientSecp256k1PubKeyCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecp256k1PubKeyCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Signature")))
@interface ClientSignature : ClientBase
- (instancetype)initWithBlockIdFlag:(NSString *)blockIdFlag validatorAddress:(NSString * _Nullable)validatorAddress timestamp:(NSString *)timestamp signature:(NSString * _Nullable)signature __attribute__((swift_name("init(blockIdFlag:validatorAddress:timestamp:signature:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSignatureCompanion *companion __attribute__((swift_name("companion")));
- (ClientSignature *)doCopyBlockIdFlag:(NSString *)blockIdFlag validatorAddress:(NSString * _Nullable)validatorAddress timestamp:(NSString *)timestamp signature:(NSString * _Nullable)signature __attribute__((swift_name("doCopy(blockIdFlag:validatorAddress:timestamp:signature:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *blockIdFlag __attribute__((swift_name("blockIdFlag")));
@property (readonly) NSString * _Nullable signature __attribute__((swift_name("signature")));
@property (readonly) NSString *timestamp __attribute__((swift_name("timestamp")));
@property (readonly) NSString * _Nullable validatorAddress __attribute__((swift_name("validatorAddress")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Signature.Companion")))
@interface ClientSignatureCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSignatureCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SimulateTxsResponse")))
@interface ClientSimulateTxsResponse : ClientBase
- (instancetype)initWithCode:(ClientInt * _Nullable)code message:(NSString * _Nullable)message details:(NSArray<NSString *> * _Nullable)details gasInfo:(ClientGasInfo * _Nullable)gasInfo result:(ClientSimulateTxsResponseData * _Nullable)result __attribute__((swift_name("init(code:message:details:gasInfo:result:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSimulateTxsResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientSimulateTxsResponse *)doCopyCode:(ClientInt * _Nullable)code message:(NSString * _Nullable)message details:(NSArray<NSString *> * _Nullable)details gasInfo:(ClientGasInfo * _Nullable)gasInfo result:(ClientSimulateTxsResponseData * _Nullable)result __attribute__((swift_name("doCopy(code:message:details:gasInfo:result:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/** Response code. */
@property (readonly) ClientInt * _Nullable code __attribute__((swift_name("code")));
@property (readonly) NSArray<NSString *> * _Nullable details __attribute__((swift_name("details")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gas_info")
*/
@property (readonly) ClientGasInfo * _Nullable gasInfo __attribute__((swift_name("gasInfo")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@property (readonly) ClientSimulateTxsResponseData * _Nullable result __attribute__((swift_name("result")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SimulateTxsResponse.Companion")))
@interface ClientSimulateTxsResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSimulateTxsResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SimulateTxsResponseData")))
@interface ClientSimulateTxsResponseData : ClientBase
- (instancetype)initWithData:(NSString *)data logs:(NSArray<ClientLog *> *)logs events:(NSArray<ClientEvent *> *)events __attribute__((swift_name("init(data:logs:events:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSimulateTxsResponseDataCompanion *companion __attribute__((swift_name("companion")));
- (ClientSimulateTxsResponseData *)doCopyData:(NSString *)data logs:(NSArray<ClientLog *> *)logs events:(NSArray<ClientEvent *> *)events __attribute__((swift_name("doCopy(data:logs:events:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/** Result bytes, if any. */
@property (readonly) NSString *data __attribute__((swift_name("data")));

/**
 * Events defines all the events emitted by processing a transaction. Note,
 * these events include those emitted by processing all the messages and those
 * emitted from the ante handler. Whereas Logs contains the events, with
 * additional metadata, emitted only by processing the messages.
 *
 * Since: cosmos-sdk 0.42.11, 0.44.5, 0.45
 */
@property (readonly) NSArray<ClientEvent *> *events __attribute__((swift_name("events")));

/** The output of the application's logger (typed). May be non-deterministic. */
@property (readonly) NSArray<ClientLog *> *logs __attribute__((swift_name("logs")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SimulateTxsResponseData.Companion")))
@interface ClientSimulateTxsResponseDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSimulateTxsResponseDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SmartQueryResponse")))
@interface ClientSmartQueryResponse : ClientBase
- (instancetype)initWithData:(NSString * _Nullable)data code:(ClientInt * _Nullable)code message:(NSString * _Nullable)message __attribute__((swift_name("init(data:code:message:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSmartQueryResponseCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) ClientInt * _Nullable code __attribute__((swift_name("code")));
@property (readonly) NSString * _Nullable data __attribute__((swift_name("data")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SmartQueryResponse.Companion")))
@interface ClientSmartQueryResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSmartQueryResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=io/eqoty/secretk/types/response/TxResponseSerializer))
*/
__attribute__((swift_name("TxResponse")))
@protocol ClientTxResponse
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseCompanion")))
@interface ClientTxResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseData")))
@interface ClientTxResponseData : ClientBase
- (instancetype)initWithHeight:(NSString *)height txhash:(NSString *)txhash codespace:(NSString *)codespace code:(ClientInt * _Nullable)code rawData:(NSString *)rawData data:(NSArray<NSString *> *)data rawLog:(NSString * _Nullable)rawLog logs:(NSArray<ClientLog *> *)logs info:(NSString * _Nullable)info gasWanted:(NSString * _Nullable)gasWanted gasUsed:(NSString * _Nullable)gasUsed tx:(ClientAnyProto * _Nullable)tx timestamp:(NSString *)timestamp events:(NSArray<ClientEvent *> *)events __attribute__((swift_name("init(height:txhash:codespace:code:rawData:data:rawLog:logs:info:gasWanted:gasUsed:tx:timestamp:events:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxResponseDataCompanion *companion __attribute__((swift_name("companion")));
- (ClientTxResponseData *)doCopyHeight:(NSString *)height txhash:(NSString *)txhash codespace:(NSString *)codespace code:(ClientInt * _Nullable)code rawData:(NSString *)rawData data:(NSArray<NSString *> *)data rawLog:(NSString * _Nullable)rawLog logs:(NSArray<ClientLog *> *)logs info:(NSString * _Nullable)info gasWanted:(NSString * _Nullable)gasWanted gasUsed:(NSString * _Nullable)gasUsed tx:(ClientAnyProto * _Nullable)tx timestamp:(NSString *)timestamp events:(NSArray<ClientEvent *> *)events __attribute__((swift_name("doCopy(height:txhash:codespace:code:rawData:data:rawLog:logs:info:gasWanted:gasUsed:tx:timestamp:events:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/** Response code. */
@property (readonly) ClientInt * _Nullable code __attribute__((swift_name("code")));

/** Namespace for the Code */
@property (readonly) NSString *codespace __attribute__((swift_name("codespace")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="unused")
*/
@property NSArray<NSString *> *data __attribute__((swift_name("data")));

/**
 * Events defines all the events emitted by processing a transaction. Note,
 * these events include those emitted by processing all the messages and those
 * emitted from the ante handler. Whereas Logs contains the events, with
 * additional metadata, emitted only by processing the messages.
 *
 * Since: cosmos-sdk 0.42.11, 0.44.5, 0.45
 */
@property (readonly) NSArray<ClientEvent *> *events __attribute__((swift_name("events")));

/** Amount of gas consumed by transaction.
 *
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gas_used")
*/
@property (readonly) NSString * _Nullable gasUsed __attribute__((swift_name("gasUsed")));

/** Amount of gas requested for transaction.
 *
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gas_wanted")
*/
@property (readonly) NSString * _Nullable gasWanted __attribute__((swift_name("gasWanted")));

/** The block height */
@property (readonly) NSString *height __attribute__((swift_name("height")));

/** Additional information. May be non-deterministic. */
@property (readonly) NSString * _Nullable info __attribute__((swift_name("info")));

/** The output of the application's logger (typed). May be non-deterministic. */
@property (readonly) NSArray<ClientLog *> *logs __attribute__((swift_name("logs")));

/** Result bytes, if any.
 *
 * @note annotations
 *   kotlinx.serialization.SerialName(value="data")
*/
@property (readonly) NSString *rawData __attribute__((swift_name("rawData")));

/**
 * The output of the application's logger (raw string). May be
 * non-deterministic.
 *
 * @note annotations
 *   kotlinx.serialization.SerialName(value="raw_log")
*/
@property (readonly) NSString * _Nullable rawLog __attribute__((swift_name("rawLog")));

/**
 * Time of the previous block. For heights > 1, it's the weighted median of
 * the timestamps of the valid votes in the block.LastCommit. For height == 1,
 * it's genesis time.
 */
@property (readonly) NSString *timestamp __attribute__((swift_name("timestamp")));

/** The request transaction bytes. */
@property ClientAnyProto * _Nullable tx __attribute__((swift_name("tx")));

/** The transaction hash. */
@property (readonly) NSString *txhash __attribute__((swift_name("txhash")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseData.Companion")))
@interface ClientTxResponseDataCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxResponseDataCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseError")))
@interface ClientTxResponseError : ClientBase <ClientTxResponse>
- (instancetype)initWithCode:(int32_t)code message:(NSString *)message details:(NSArray<NSString *> *)details __attribute__((swift_name("init(code:message:details:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxResponseErrorCompanion *companion __attribute__((swift_name("companion")));
- (ClientTxResponseError *)doCopyCode:(int32_t)code message:(NSString *)message details:(NSArray<NSString *> *)details __attribute__((swift_name("doCopy(code:message:details:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t code __attribute__((swift_name("code")));
@property (readonly) NSArray<NSString *> *details __attribute__((swift_name("details")));
@property (readonly) NSString *message __attribute__((swift_name("message")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseError.Companion")))
@interface ClientTxResponseErrorCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxResponseErrorCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * Serialization strategy defines the serial form of a type [T], including its structural description,
 * declared by the [descriptor] and the actual serialization process, defined by the implementation
 * of the [serialize] method.
 *
 * [serialize] method takes an instance of [T] and transforms it into its serial form (a sequence of primitives),
 * calling the corresponding [Encoder] methods.
 *
 * A serial form of the type is a transformation of the concrete instance into a sequence of primitive values
 * and vice versa. The serial form is not required to completely mimic the structure of the class, for example,
 * a specific implementation may represent multiple integer values as a single string, omit or add some
 * values that are present in the type, but not in the instance.
 *
 * For a more detailed explanation of the serialization process, please refer to [KSerializer] documentation.
 */
__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol ClientKotlinx_serialization_coreSerializationStrategy
@required

/**
 * Serializes the [value] of type [T] using the format that is represented by the given [encoder].
 * [serialize] method is format-agnostic and operates with a high-level structured [Encoder] API.
 * Throws [SerializationException] if value cannot be serialized.
 *
 * Example of serialize method:
 * ```
 * class MyData(int: Int, stringList: List<String>, alwaysZero: Long)
 *
 * fun serialize(encoder: Encoder, value: MyData): Unit = encoder.encodeStructure(descriptor) {
 *     // encodeStructure encodes beginning and end of the structure
 *     // encode 'int' property as Int
 *     encodeIntElement(descriptor, index = 0, value.int)
 *     // encode 'stringList' property as List<String>
 *     encodeSerializableElement(descriptor, index = 1, serializer<List<String>>, value.stringList)
 *     // don't encode 'alwaysZero' property because we decided to do so
 * } // end of the structure
 * ```
 *
 * @throws SerializationException in case of any serialization-specific error
 * @throws IllegalArgumentException if the supplied input does not comply encoder's specification
 * @see KSerializer for additional information about general contracts and exception specifics
 */
- (void)serializeEncoder:(id<ClientKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));

/**
 * Describes the structure of the serializable representation of [T], produced
 * by this serializer.
 */
@property (readonly) id<ClientKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end


/**
 * Deserialization strategy defines the serial form of a type [T], including its structural description,
 * declared by the [descriptor] and the actual deserialization process, defined by the implementation
 * of the [deserialize] method.
 *
 * [deserialize] method takes an instance of [Decoder], and, knowing the serial form of the [T],
 * invokes primitive retrieval methods on the decoder and then transforms the received primitives
 * to an instance of [T].
 *
 * A serial form of the type is a transformation of the concrete instance into a sequence of primitive values
 * and vice versa. The serial form is not required to completely mimic the structure of the class, for example,
 * a specific implementation may represent multiple integer values as a single string, omit or add some
 * values that are present in the type, but not in the instance.
 *
 * For a more detailed explanation of the serialization process, please refer to [KSerializer] documentation.
 */
__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol ClientKotlinx_serialization_coreDeserializationStrategy
@required

/**
 * Deserializes the value of type [T] using the format that is represented by the given [decoder].
 * [deserialize] method is format-agnostic and operates with a high-level structured [Decoder] API.
 * As long as most of the formats imply an arbitrary order of properties, deserializer should be able
 * to decode these properties in an arbitrary order and in a format-agnostic way.
 * For that purposes, [CompositeDecoder.decodeElementIndex]-based loop is used: decoder firstly
 * signals property at which index it is ready to decode and then expects caller to decode
 * property with the given index.
 *
 * Throws [SerializationException] if value cannot be deserialized.
 *
 * Example of deserialize method:
 * ```
 * class MyData(int: Int, stringList: List<String>, alwaysZero: Long)
 *
 * fun deserialize(decoder: Decoder): MyData = decoder.decodeStructure(descriptor) {
 *     // decodeStructure decodes beginning and end of the structure
 *     var int: Int? = null
 *     var list: List<String>? = null
 *     loop@ while (true) {
 *         when (val index = decodeElementIndex(descriptor)) {
 *             DECODE_DONE -> break@loop
 *             0 -> {
 *                 // Decode 'int' property as Int
 *                 int = decodeIntElement(descriptor, index = 0)
 *             }
 *             1 -> {
 *                 // Decode 'stringList' property as List<String>
 *                 list = decodeSerializableElement(descriptor, index = 1, serializer<List<String>>())
 *             }
 *             else -> throw SerializationException("Unexpected index $index")
 *         }
 *      }
 *     if (int == null || list == null) throwMissingFieldException()
 *     // Always use 0 as a value for alwaysZero property because we decided to do so.
 *     return MyData(int, list, alwaysZero = 0L)
 * }
 * ```
 *
 * @throws MissingFieldException if non-optional fields were not found during deserialization
 * @throws SerializationException in case of any deserialization-specific error
 * @throws IllegalArgumentException if the decoded input is not a valid instance of [T]
 * @see KSerializer for additional information about general contracts and exception specifics
 */
- (id _Nullable)deserializeDecoder:(id<ClientKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));

/**
 * Describes the structure of the serializable representation of [T], that current
 * deserializer is able to deserialize.
 */
@property (readonly) id<ClientKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end


/**
 * KSerializer is responsible for the representation of a serial form of a type [T]
 * in terms of [encoders][Encoder] and [decoders][Decoder] and for constructing and deconstructing [T]
 * from/to a sequence of encoding primitives. For classes marked with [@Serializable][Serializable], can be
 * obtained from generated companion extension `.serializer()` or from [serializer<T>()][serializer] function.
 *
 * Serialization is decoupled from the encoding process to make it completely format-agnostic.
 * Serialization represents a type as its serial form and is abstracted from the actual
 * format (whether its JSON, ProtoBuf or a hashing) and unaware of the underlying storage
 * (whether it is a string builder, byte array or a network socket), while
 * encoding/decoding is abstracted from a particular type and its serial form and is responsible
 * for transforming primitives ("here in an int property 'foo'" call from a serializer) into a particular
 * format-specific representation ("for a given int, append a property name in quotation marks,
 * then append a colon, then append an actual value" for JSON) and how to retrieve a primitive
 * ("give me an int that is 'foo' property") from the underlying representation ("expect the next string to be 'foo',
 * parse it, then parse colon, then parse a string until the next comma as an int and return it).
 *
 * Serial form consists of a structural description, declared by the [descriptor] and
 * actual serialization and deserialization processes, defined by the corresponding
 * [serialize] and [deserialize] methods implementation.
 *
 * Structural description specifies how the [T] is represented in the serial form:
 * its [kind][SerialKind] (e.g. whether it is represented as a primitive, a list or a class),
 * its [elements][SerialDescriptor.elementNames] and their [positional names][SerialDescriptor.getElementName].
 *
 * Serialization process is defined as a sequence of calls to an [Encoder], and transforms a type [T]
 * into a stream of format-agnostic primitives that represent [T], such as "here is an int, here is a double
 * and here is another nested object". It can be demonstrated by the example:
 * ```
 * class MyData(int: Int, stringList: List<String>, alwaysZero: Long)
 *
 * // .. serialize method of a corresponding serializer
 * fun serialize(encoder: Encoder, value: MyData): Unit = encoder.encodeStructure(descriptor) {
 *     // encodeStructure encodes beginning and end of the structure
 *     // encode 'int' property as Int
 *     encodeIntElement(descriptor, index = 0, value.int)
 *     // encode 'stringList' property as List<String>
 *     encodeSerializableElement(descriptor, index = 1, serializer<List<String>>, value.stringList)
 *     // don't encode 'alwaysZero' property because we decided to do so
 * } // end of the structure
 * ```
 *
 * Deserialization process is symmetric and uses [Decoder].
 *
 * ### Exception types for `KSerializer` implementation
 *
 * Implementations of [serialize] and [deserialize] methods are allowed to throw
 * any subtype of [IllegalArgumentException] in order to indicate serialization
 * and deserialization errors.
 *
 * For serializer implementations, it is recommended to throw subclasses of [SerializationException] for
 * any serialization-specific errors related to invalid or unsupported format of the data
 * and [IllegalStateException] for errors during validation of the data.
 */
__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol ClientKotlinx_serialization_coreKSerializer <ClientKotlinx_serialization_coreSerializationStrategy, ClientKotlinx_serialization_coreDeserializationStrategy>
@required
@end


/**
 * Base class for custom serializers that allows selecting polymorphic serializer
 * without a dedicated class discriminator, on a content basis.
 *
 * Usually, polymorphic serialization (represented by [PolymorphicSerializer] and [SealedClassSerializer])
 * requires a dedicated `"type"` property in the JSON to
 * determine actual serializer that is used to deserialize Kotlin class.
 *
 * However, sometimes (e.g. when interacting with external API) type property is not present in the input
 * and it is expected to guess the actual type by the shape of JSON, for example by the presence of specific key.
 * [JsonContentPolymorphicSerializer] provides a skeleton implementation for such strategy. Please note that
 * since JSON content is represented by [JsonElement] class and could be read only with [JsonDecoder] decoder,
 * this class works only with [Json] format.
 *
 * Deserialization happens in two stages: first, a value from the input JSON is read
 * to as a [JsonElement]. Second, [selectDeserializer] function is called to determine which serializer should be used.
 * The returned serializer is used to deserialize [JsonElement] back to Kotlin object.
 *
 * It is possible to serialize values this serializer. In that case, class discriminator property won't
 * be added to JSON stream, i.e., deserializing a class from the string and serializing it back yields the original string.
 * However, to determine a serializer, a standard polymorphic mechanism represented by [SerializersModule] is used.
 * For convenience, [serialize] method can lookup default serializer, but it is recommended to follow
 * standard procedure with [registering][SerializersModuleBuilder.polymorphic].
 *
 * Usage example:
 * ```
 * interface Payment {
 *     val amount: String
 * }
 *
 * @Serializable
 * data class SuccessfulPayment(override val amount: String, val date: String) : Payment
 *
 * @Serializable
 * data class RefundedPayment(override val amount: String, val date: String, val reason: String) : Payment
 *
 * object PaymentSerializer : JsonContentPolymorphicSerializer<Payment>(Payment::class) {
 *     override fun selectDeserializer(content: JsonElement) = when {
 *         "reason" in content.jsonObject -> RefundedPayment.serializer()
 *         else -> SuccessfulPayment.serializer()
 *     }
 * }
 *
 * // Now both statements will yield different subclasses of Payment:
 *
 * Json.decodeFromString(PaymentSerializer, """{"amount":"1.0","date":"03.02.2020"}""")
 * Json.decodeFromString(PaymentSerializer, """{"amount":"2.0","date":"03.02.2020","reason":"complaint"}""")
 * ```
 *
 * @param T A root type for all classes that could be possibly encountered during serialization and deserialization.
 * Must be non-final class or interface.
 * @param baseClass A class token for [T].
 */
__attribute__((swift_name("Kotlinx_serialization_jsonJsonContentPolymorphicSerializer")))
@interface ClientKotlinx_serialization_jsonJsonContentPolymorphicSerializer<T> : ClientBase <ClientKotlinx_serialization_coreKSerializer>
- (instancetype)initWithBaseClass:(id<ClientKotlinKClass>)baseClass __attribute__((swift_name("init(baseClass:)"))) __attribute__((objc_designated_initializer));
- (T)deserializeDecoder:(id<ClientKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));

/**
 * Determines a particular strategy for deserialization by looking on a parsed JSON [element].
 *
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (id<ClientKotlinx_serialization_coreDeserializationStrategy>)selectDeserializerElement:(ClientKotlinx_serialization_jsonJsonElement *)element __attribute__((swift_name("selectDeserializer(element:)")));
- (void)serializeEncoder:(id<ClientKotlinx_serialization_coreEncoder>)encoder value:(T)value __attribute__((swift_name("serialize(encoder:value:)")));

/**
 * A descriptor for this set of content-based serializers.
 * By default, it uses the name composed of [baseClass] simple name,
 * kind is set to [PolymorphicKind.SEALED] and contains 0 elements.
 *
 * However, this descriptor can be overridden to achieve better representation of custom transformed JSON shape
 * for schema generating/introspection purposes.
 */
@property (readonly) id<ClientKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseSerializer")))
@interface ClientTxResponseSerializer : ClientKotlinx_serialization_jsonJsonContentPolymorphicSerializer<id<ClientTxResponse>>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithBaseClass:(id<ClientKotlinKClass>)baseClass __attribute__((swift_name("init(baseClass:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)txResponseSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxResponseSerializer *shared __attribute__((swift_name("shared")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (id<ClientKotlinx_serialization_coreKSerializer>)selectDeserializerElement:(ClientKotlinx_serialization_jsonJsonElement *)element __attribute__((swift_name("selectDeserializer(element:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseValid")))
@interface ClientTxResponseValid : ClientBase <ClientTxResponse>
- (instancetype)initWithTxResponse:(ClientTxResponseData *)txResponse __attribute__((swift_name("init(txResponse:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxResponseValidCompanion *companion __attribute__((swift_name("companion")));
- (ClientTxResponseValid *)doCopyTxResponse:(ClientTxResponseData *)txResponse __attribute__((swift_name("doCopy(txResponse:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="tx_response")
*/
@property (readonly) ClientTxResponseData *txResponse __attribute__((swift_name("txResponse")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxResponseValid.Companion")))
@interface ClientTxResponseValidCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxResponseValidCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("V1BetaType.Companion")))
@interface ClientV1BetaTypeCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientV1BetaTypeCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Version")))
@interface ClientVersion : ClientBase
- (instancetype)initWithBlock:(NSString *)block app:(NSString *)app __attribute__((swift_name("init(block:app:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientVersionCompanion *companion __attribute__((swift_name("companion")));
- (ClientVersion *)doCopyBlock:(NSString *)block app:(NSString *)app __attribute__((swift_name("doCopy(block:app:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *app __attribute__((swift_name("app")));
@property (readonly) NSString *block __attribute__((swift_name("block")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Version.Companion")))
@interface ClientVersionCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientVersionCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("WasmResponse")))
@interface ClientWasmResponse<R> : ClientBase
- (instancetype)initWithHeight:(NSString *)height result:(R _Nullable)result __attribute__((swift_name("init(height:result:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientWasmResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientWasmResponse<R> *)doCopyHeight:(NSString *)height result:(R _Nullable)result __attribute__((swift_name("doCopy(height:result:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *height __attribute__((swift_name("height")));
@property (readonly) R _Nullable result __attribute__((swift_name("result")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("WasmResponseCompanion")))
@interface ClientWasmResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientWasmResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeSerial0:(id<ClientKotlinx_serialization_coreKSerializer>)typeSerial0 __attribute__((swift_name("serializer(typeSerial0:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Attribute")))
@interface ClientAttribute : ClientBase
- (instancetype)initWithKey:(NSString *)key value:(NSString *)value __attribute__((swift_name("init(key:value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientAttributeCompanion *companion __attribute__((swift_name("companion")));
- (ClientAttribute *)doCopyKey:(NSString *)key value:(NSString *)value __attribute__((swift_name("doCopy(key:value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property NSString *key __attribute__((swift_name("key")));
@property NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Attribute.Companion")))
@interface ClientAttributeCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientAttributeCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Event")))
@interface ClientEvent : ClientBase
- (instancetype)initWithType:(NSString *)type attributes:(NSArray<ClientAttribute *> *)attributes __attribute__((swift_name("init(type:attributes:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientEventCompanion *companion __attribute__((swift_name("companion")));
- (ClientEvent *)doCopyType:(NSString *)type attributes:(NSArray<ClientAttribute *> *)attributes __attribute__((swift_name("doCopy(type:attributes:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<ClientAttribute *> *attributes __attribute__((swift_name("attributes")));
@property (readonly) NSString *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Event.Companion")))
@interface ClientEventCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientEventCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Log")))
@interface ClientLog : ClientBase
- (instancetype)initWithMsg_index:(int64_t)msg_index log:(NSString *)log events:(NSArray<ClientEvent *> *)events __attribute__((swift_name("init(msg_index:log:events:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientLogCompanion *companion __attribute__((swift_name("companion")));
- (ClientLog *)doCopyMsg_index:(int64_t)msg_index log:(NSString *)log events:(NSArray<ClientEvent *> *)events __attribute__((swift_name("doCopy(msg_index:log:events:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<ClientEvent *> *events __attribute__((swift_name("events")));
@property (readonly) NSString *log __attribute__((swift_name("log")));
@property (readonly) int64_t msg_index __attribute__((swift_name("msg_index")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Log.Companion")))
@interface ClientLogCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientLogCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Address")))
@interface ClientAddress : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)address __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientAddress *shared __attribute__((swift_name("shared")));
- (NSString *)pubkeyToAddressPubkey:(ClientSecret_std_typesPubKey *)pubkey prefix:(NSString *)prefix __attribute__((swift_name("pubkeyToAddress(pubkey:prefix:)")));
- (NSString *)rawSecp256k1PubkeyToAddressPubkeyRaw:(id)pubkeyRaw prefix:(NSString *)prefix __attribute__((swift_name("rawSecp256k1PubkeyToAddress(pubkeyRaw:prefix:)")));
@end

__attribute__((swift_name("EncryptionUtils")))
@protocol ClientEncryptionUtils
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)decryptCiphertext:(id)ciphertext nonce:(id)nonce completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("decrypt(ciphertext:nonce:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)encryptContractCodeHash:(NSString *)contractCodeHash message:(NSDictionary<NSString *, ClientKotlinx_serialization_jsonJsonElement *> *)message completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("encrypt(contractCodeHash:message:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getPubkeyWithCompletionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getPubkey(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getTxEncryptionKeyNonce:(id)nonce completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getTxEncryptionKey(nonce:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EnigmaUtils")))
@interface ClientEnigmaUtils : ClientBase <ClientEncryptionUtils>
- (instancetype)initWithApiUrl:(NSString *)apiUrl seed:(id)seed __attribute__((swift_name("init(apiUrl:seed:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientEnigmaUtilsCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)decryptCiphertext:(id)ciphertext nonce:(id)nonce completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("decrypt(ciphertext:nonce:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)encryptContractCodeHash:(NSString *)contractCodeHash message:(NSDictionary<NSString *, ClientKotlinx_serialization_jsonJsonElement *> *)message completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("encrypt(contractCodeHash:message:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getPubkeyWithCompletionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getPubkey(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getTxEncryptionKeyNonce:(id)nonce completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getTxEncryptionKey(nonce:completionHandler:)")));
@property (readonly) NSString *apiUrl __attribute__((swift_name("apiUrl")));
@property (readonly) id hkdfSalt __attribute__((swift_name("hkdfSalt")));
@property (readonly) id pubKey __attribute__((swift_name("pubKey")));
@property (readonly) id seed __attribute__((swift_name("seed")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EnigmaUtils.Companion")))
@interface ClientEnigmaUtilsCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientEnigmaUtilsCompanion *shared __attribute__((swift_name("shared")));
- (ClientKeyPair *)GenerateNewKeyPair __attribute__((swift_name("GenerateNewKeyPair()")));
- (ClientKeyPair *)GenerateNewKeyPairFromSeedSeed:(id)seed __attribute__((swift_name("GenerateNewKeyPairFromSeed(seed:)")));
- (id)GenerateNewSeed __attribute__((swift_name("GenerateNewSeed()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KeyPair")))
@interface ClientKeyPair : ClientBase
- (instancetype)initWithPrivKey:(id)privKey pubKey:(id)pubKey __attribute__((swift_name("init(privKey:pubKey:)"))) __attribute__((objc_designated_initializer));
- (ClientKeyPair *)doCopyPrivKey:(id)privKey pubKey:(id)pubKey __attribute__((swift_name("doCopy(privKey:pubKey:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id privKey __attribute__((swift_name("privKey")));
@property (readonly) id pubKey __attribute__((swift_name("pubKey")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Result")))
@interface ClientResult : ClientBase
- (instancetype)initWithTxKey:(NSString *)TxKey __attribute__((swift_name("init(TxKey:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientResultCompanion *companion __attribute__((swift_name("companion")));
- (ClientResult *)doCopyTxKey:(NSString *)TxKey __attribute__((swift_name("doCopy(TxKey:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *TxKey __attribute__((swift_name("TxKey")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Result.Companion")))
@interface ClientResultCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientResultCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxKeyResponse")))
@interface ClientTxKeyResponse : ClientBase
- (instancetype)initWithKey:(NSString *)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientTxKeyResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientTxKeyResponse *)doCopyKey:(NSString *)key __attribute__((swift_name("doCopy(key:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TxKeyResponse.Companion")))
@interface ClientTxKeyResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientTxKeyResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountData")))
@interface ClientAccountData : ClientBase
- (instancetype)initWithAddress:(NSString *)address algo:(ClientAlgo *)algo pubkey:(id)pubkey __attribute__((swift_name("init(address:algo:pubkey:)"))) __attribute__((objc_designated_initializer));
- (ClientAccountData *)doCopyAddress:(NSString *)address algo:(ClientAlgo *)algo pubkey:(id)pubkey __attribute__((swift_name("doCopy(address:algo:pubkey:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/** A printable address (typically bech32 encoded) */
@property (readonly) NSString *address __attribute__((swift_name("address")));
@property (readonly) ClientAlgo *algo __attribute__((swift_name("algo")));
@property (readonly) id pubkey __attribute__((swift_name("pubkey")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountSigningData")))
@interface ClientAccountSigningData : ClientBase
- (instancetype)initWithAddress:(NSString *)address algo:(ClientAlgo *)algo pubkey:(id)pubkey privkey:(id)privkey mnemonic:(NSArray<ClientKotlinCharArray *> * _Nullable)mnemonic __attribute__((swift_name("init(address:algo:pubkey:privkey:mnemonic:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSArray<ClientKotlinCharArray *> * _Nullable mnemonic __attribute__((swift_name("mnemonic")));
@property (readonly) id privkey __attribute__((swift_name("privkey")));
@property (readonly) ClientAccountData *publicData __attribute__((swift_name("publicData")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Algo")))
@interface ClientAlgo : ClientKotlinEnum<ClientAlgo *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClientAlgo *secp256k1 __attribute__((swift_name("secp256k1")));
@property (class, readonly) ClientAlgo *ed25519 __attribute__((swift_name("ed25519")));
@property (class, readonly) ClientAlgo *sr25519 __attribute__((swift_name("sr25519")));
+ (ClientKotlinArray<ClientAlgo *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClientAlgo *> *entries __attribute__((swift_name("entries")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AminoSignResponse")))
@interface ClientAminoSignResponse : ClientBase
- (instancetype)initWithSigned:(ClientStdSignDoc *)signed_ signature:(ClientSecret_std_typesStdSignature *)signature __attribute__((swift_name("init(signed:signature:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientAminoSignResponseCompanion *companion __attribute__((swift_name("companion")));
- (ClientAminoSignResponse *)doCopySigned:(ClientStdSignDoc *)signed_ signature:(ClientSecret_std_typesStdSignature *)signature __attribute__((swift_name("doCopy(signed:signature:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientSecret_std_typesStdSignature *signature __attribute__((swift_name("signature")));

/**
 * The sign doc that was signed.
 * This may be different from the input signDoc when the signer modifies it as part of the signing process.
 */
@property (readonly, getter=signed) ClientStdSignDoc *signed_ __attribute__((swift_name("signed_")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AminoSignResponse.Companion")))
@interface ClientAminoSignResponseCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientAminoSignResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("Wallet")))
@protocol ClientWallet
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getAccountAddress:(NSString *)address completionHandler:(void (^)(ClientAccountData * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("getAccount(address:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getAccountsWithCompletionHandler:(void (^)(NSArray<ClientAccountData *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getAccounts(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getSignModeWithCompletionHandler:(void (^)(ClientSignMode * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("getSignMode(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signAminoSignerAddress:(NSString *)signerAddress signDoc:(ClientStdSignDoc *)signDoc completionHandler:(void (^)(ClientAminoSignResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("signAmino(signerAddress:signDoc:completionHandler:)")));
@end

__attribute__((swift_name("BaseWallet")))
@interface ClientBaseWallet : ClientBase <ClientWallet>
- (ClientAccountSigningData *)addAccountMnemonic:(NSString * _Nullable)mnemonic __attribute__((swift_name("addAccount(mnemonic:)")));
- (ClientAccountSigningData *)addAccountPrivkey:(id)privkey __attribute__((swift_name("addAccount(privkey:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getAccountAddress:(NSString *)address completionHandler:(void (^)(ClientAccountData * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("getAccount(address:completionHandler:)")));

/**
 * Get AccountData array from wallet. Rejects if not enabled.
 *
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getAccountsWithCompletionHandler:(void (^)(NSArray<ClientAccountData *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getAccounts(completionHandler:)")));

/**
 * Removes all account data for an address including private keys.
 *
 * @return Returns [AccountData] if account is successfully removed from wallet.
 */
- (ClientAccountData * _Nullable)removeAccountAddress:(NSString *)address __attribute__((swift_name("removeAccount(address:)")));

/**
 * Creates and returns a signature
 */
- (ClientSecret_std_typesStdSignature *)signSignerAddress:(NSString *)signerAddress signBytes:(id)signBytes prehashType:(ClientPrehashType *)prehashType __attribute__((swift_name("sign(signerAddress:signBytes:prehashType:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signAminoSignerAddress:(NSString *)signerAddress signDoc:(ClientStdSignDoc *)signDoc completionHandler:(void (^)(ClientAminoSignResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("signAmino(signerAddress:signDoc:completionHandler:)")));
@property (readonly) ClientMutableSet<NSString *> *accountAddresses __attribute__((swift_name("accountAddresses")));
@property (readonly) NSArray<ClientAccountData *> *accounts __attribute__((swift_name("accounts")));
@property (readonly) ClientMutableDictionary<NSString *, ClientAccountSigningData *> *addressToAccountSigningData __attribute__((swift_name("addressToAccountSigningData")));
@property (readonly) NSString *bech32Prefix __attribute__((swift_name("bech32Prefix")));
@property (readonly) ClientKotlinArray<id> *hdPath __attribute__((swift_name("hdPath")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AminoWallet")))
@interface ClientAminoWallet : ClientBaseWallet
- (instancetype)initWithMnemonic:(NSString *)mnemonic __attribute__((swift_name("init(mnemonic:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getSignModeWithCompletionHandler:(void (^)(ClientSignMode * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("getSignMode(completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DirectSigningWallet")))
@interface ClientDirectSigningWallet : ClientBaseWallet
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMnemonic:(NSString * _Nullable)mnemonic __attribute__((swift_name("init(mnemonic:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPrivkey:(id)privkey __attribute__((swift_name("init(privkey:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getSignModeWithCompletionHandler:(void (^)(ClientSignMode * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("getSignMode(completionHandler:)")));
- (ClientSignResponse *)signDirectSignerAddress:(NSString *)signerAddress signDoc:(ClientSignDocProto *)signDoc __attribute__((swift_name("signDirect(signerAddress:signDoc:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PrehashType")))
@interface ClientPrehashType : ClientKotlinEnum<ClientPrehashType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClientPrehashType *sha256 __attribute__((swift_name("sha256")));
@property (class, readonly) ClientPrehashType *sha512 __attribute__((swift_name("sha512")));
+ (ClientKotlinArray<ClientPrehashType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClientPrehashType *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignResponse")))
@interface ClientSignResponse : ClientBase
- (instancetype)initWithSigned:(ClientSignDocProto *)signed_ signature:(ClientSecret_std_typesStdSignature *)signature __attribute__((swift_name("init(signed:signature:)"))) __attribute__((objc_designated_initializer));
- (ClientSignResponse *)doCopySigned:(ClientSignDocProto *)signed_ signature:(ClientSecret_std_typesStdSignature *)signature __attribute__((swift_name("doCopy(signed:signature:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientSecret_std_typesStdSignature *signature __attribute__((swift_name("signature")));

/**
 * The sign doc that was signed.
 * This may be different from the input signDoc when the signer modifies it as part of the signing process.
 */
@property (readonly, getter=signed) ClientSignDocProto *signed_ __attribute__((swift_name("signed_")));
@end


/**
 * implementation of RIPEMD see,
 * http://www.esat.kuleuven.ac.be/~bosselae/ripemd160.html
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ripemd160Digest")))
@interface ClientRipemd160Digest : ClientBase

/**
 * implementation of RIPEMD see,
 * http://www.esat.kuleuven.ac.be/~bosselae/ripemd160.html
 */
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));

/**
 * implementation of RIPEMD see,
 * http://www.esat.kuleuven.ac.be/~bosselae/ripemd160.html
 */
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) ClientRipemd160DigestCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)doFinalOut:(ClientKotlinByteArray *)out outOffset:(int32_t)outOffset __attribute__((swift_name("doFinal(out:outOffset:)")));
- (void)updateInput:(int8_t)input __attribute__((swift_name("update(input:)")));
- (void)updateInput:(ClientKotlinByteArray *)input inputOffset:(int32_t)inputOffset len:(int32_t)len __attribute__((swift_name("update(input:inputOffset:len:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ripemd160Digest.Companion")))
@interface ClientRipemd160DigestCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientRipemd160DigestCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) int32_t DIGEST_LENGTH __attribute__((swift_name("DIGEST_LENGTH")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cosmwasm_std_typesCoin")))
@interface ClientCosmwasm_std_typesCoin : ClientBase
- (instancetype)initWithAmount:(ClientBignumBigInteger *)amount denom:(NSString *)denom __attribute__((swift_name("init(amount:denom:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithAmount:(int32_t)amount denom_:(NSString *)denom __attribute__((swift_name("init(amount:denom_:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithAmount:(NSString *)amount denom__:(NSString *)denom __attribute__((swift_name("init(amount:denom__:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientCosmwasm_std_typesCoinCompanion *companion __attribute__((swift_name("companion")));
- (ClientCosmwasm_std_typesCoin *)doCopyAmount:(NSString *)amount denom:(NSString *)denom __attribute__((swift_name("doCopy(amount:denom:)")));
- (ClientCosmwasm_std_typesCoin *)divOther:(ClientBignumBigInteger *)other __attribute__((swift_name("div(other:)")));
- (ClientCosmwasm_std_typesCoin *)divOther_:(ClientCosmwasm_std_typesCoin *)other __attribute__((swift_name("div(other_:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (ClientCosmwasm_std_typesCoin *)minusIncrement:(ClientBignumBigInteger *)increment __attribute__((swift_name("minus(increment:)")));
- (ClientCosmwasm_std_typesCoin *)minusIncrement_:(ClientCosmwasm_std_typesCoin *)increment __attribute__((swift_name("minus(increment_:)")));
- (ClientCosmwasm_std_typesCoin *)plusIncrement:(ClientBignumBigInteger *)increment __attribute__((swift_name("plus(increment:)")));
- (ClientCosmwasm_std_typesCoin *)plusIncrement_:(ClientCosmwasm_std_typesCoin *)increment __attribute__((swift_name("plus(increment_:)")));
- (ClientCosmwasm_std_typesCoin *)remOther:(ClientBignumBigInteger *)other __attribute__((swift_name("rem(other:)")));
- (ClientCosmwasm_std_typesCoin *)remOther_:(ClientCosmwasm_std_typesCoin *)other __attribute__((swift_name("rem(other_:)")));
- (ClientCosmwasm_std_typesCoin *)timesOther:(ClientBignumBigInteger *)other __attribute__((swift_name("times(other:)")));
- (ClientCosmwasm_std_typesCoin *)timesOther_:(ClientCosmwasm_std_typesCoin *)other __attribute__((swift_name("times(other_:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *amount __attribute__((swift_name("amount")));
@property (readonly) NSString *denom __attribute__((swift_name("denom")));
@end

@interface ClientCosmwasm_std_typesCoin (Extensions)
- (ClientCoinProto *)toProto __attribute__((swift_name("toProto()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface ClientKotlinByteArray : ClientBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(ClientByte *(^)(ClientInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (ClientKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

@interface ClientKotlinByteArray (Extensions)

/**
 * Computes the RIPEMD160 from [this] [ByteArray].
 */
- (ClientKotlinByteArray *)digestRipemd160 __attribute__((swift_name("digestRipemd160()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinIntArray")))
@interface ClientKotlinIntArray : ClientBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(ClientInt *(^)(ClientInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int32_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (ClientKotlinIntIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int32_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

@interface ClientKotlinIntArray (Extensions)
- (id)toUByteArray __attribute__((swift_name("toUByteArray()")));
@end

__attribute__((swift_name("OkioByteString")))
@interface ClientOkioByteString : ClientBase <ClientKotlinComparable>
@property (class, readonly, getter=companion) ClientOkioByteStringCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)base64 __attribute__((swift_name("base64()")));
- (NSString *)base64Url __attribute__((swift_name("base64Url()")));
- (int32_t)compareToOther:(ClientOkioByteString *)other __attribute__((swift_name("compareTo(other:)")));
- (void)doCopyIntoOffset:(int32_t)offset target:(ClientKotlinByteArray *)target targetOffset:(int32_t)targetOffset byteCount:(int32_t)byteCount __attribute__((swift_name("doCopyInto(offset:target:targetOffset:byteCount:)")));
- (BOOL)endsWithSuffix:(ClientKotlinByteArray *)suffix __attribute__((swift_name("endsWith(suffix:)")));
- (BOOL)endsWithSuffix_:(ClientOkioByteString *)suffix __attribute__((swift_name("endsWith(suffix_:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)hex __attribute__((swift_name("hex()")));

/** Returns the 160-bit SHA-1 HMAC of this byte string.  */
- (ClientOkioByteString *)hmacSha1Key:(ClientOkioByteString *)key __attribute__((swift_name("hmacSha1(key:)")));

/** Returns the 256-bit SHA-256 HMAC of this byte string.  */
- (ClientOkioByteString *)hmacSha256Key:(ClientOkioByteString *)key __attribute__((swift_name("hmacSha256(key:)")));

/** Returns the 512-bit SHA-512 HMAC of this byte string.  */
- (ClientOkioByteString *)hmacSha512Key:(ClientOkioByteString *)key __attribute__((swift_name("hmacSha512(key:)")));
- (int32_t)indexOfOther:(ClientKotlinByteArray *)other fromIndex:(int32_t)fromIndex __attribute__((swift_name("indexOf(other:fromIndex:)")));
- (int32_t)indexOfOther:(ClientOkioByteString *)other fromIndex_:(int32_t)fromIndex __attribute__((swift_name("indexOf(other:fromIndex_:)")));
- (int32_t)lastIndexOfOther:(ClientKotlinByteArray *)other fromIndex:(int32_t)fromIndex __attribute__((swift_name("lastIndexOf(other:fromIndex:)")));
- (int32_t)lastIndexOfOther:(ClientOkioByteString *)other fromIndex_:(int32_t)fromIndex __attribute__((swift_name("lastIndexOf(other:fromIndex_:)")));
- (ClientOkioByteString *)md5 __attribute__((swift_name("md5()")));
- (BOOL)rangeEqualsOffset:(int32_t)offset other:(ClientKotlinByteArray *)other otherOffset:(int32_t)otherOffset byteCount:(int32_t)byteCount __attribute__((swift_name("rangeEquals(offset:other:otherOffset:byteCount:)")));
- (BOOL)rangeEqualsOffset:(int32_t)offset other:(ClientOkioByteString *)other otherOffset:(int32_t)otherOffset byteCount_:(int32_t)byteCount __attribute__((swift_name("rangeEquals(offset:other:otherOffset:byteCount_:)")));
- (ClientOkioByteString *)sha1 __attribute__((swift_name("sha1()")));
- (ClientOkioByteString *)sha256 __attribute__((swift_name("sha256()")));
- (ClientOkioByteString *)sha512 __attribute__((swift_name("sha512()")));
- (BOOL)startsWithPrefix:(ClientKotlinByteArray *)prefix __attribute__((swift_name("startsWith(prefix:)")));
- (BOOL)startsWithPrefix_:(ClientOkioByteString *)prefix __attribute__((swift_name("startsWith(prefix_:)")));
- (ClientOkioByteString *)substringBeginIndex:(int32_t)beginIndex endIndex:(int32_t)endIndex __attribute__((swift_name("substring(beginIndex:endIndex:)")));
- (ClientOkioByteString *)toAsciiLowercase __attribute__((swift_name("toAsciiLowercase()")));
- (ClientOkioByteString *)toAsciiUppercase __attribute__((swift_name("toAsciiUppercase()")));
- (ClientKotlinByteArray *)toByteArray __attribute__((swift_name("toByteArray()")));

/**
 * Returns a human-readable string that describes the contents of this byte string. Typically this
 * is a string like `[text=Hello]` or `[hex=0000ffff]`.
 */
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)utf8 __attribute__((swift_name("utf8()")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

@interface ClientOkioByteString (Extensions)
- (id)toUByteArray __attribute__((swift_name("toUByteArray()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BaseWalletKt")))
@interface ClientBaseWalletKt : ClientBase

/**
 * The Cosmoshub derivation path in the form `m/44'/118'/0'/0/a`
 * with 0-based account index `a`.
 * The Secret Network derivation path in the form `m/44'/529'/0'/0/a`
 * with 0-based account index `a`.
 */
+ (ClientKotlinArray<id> *)makeSecretNetworkPathA:(uint32_t)a __attribute__((swift_name("makeSecretNetworkPath(a:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HexKt")))
@interface ClientHexKt : ClientBase

/**
 * Parses the given [value] reading it as an hexadecimal string, and returns its byte array representation.
 *
 * Note that either 0x-prefixed string and no-prefixed hex strings are supported.
 *
 * @throws IllegalArgumentException if the [value] is not an hexadecimal string.
 */
+ (ClientKotlinByteArray *)decodeValue:(NSString *)value __attribute__((swift_name("decode(value:)")));

/**
 * Encodes the given byte [value] as an hexadecimal character.
 */
+ (NSString *)encodeValue:(int8_t)value __attribute__((swift_name("encode(value:)")));

/**
 * Encodes the given byte array [value] to its hexadecimal representations, and prepends the given [prefix] to it.
 *
 * Note that by default the 0x prefix is prepended to the result of the conversion.
 * If you want to have the representation without the 0x prefix, pass to this method an empty [prefix].
 */
+ (NSString *)encodeValue:(ClientKotlinByteArray *)value prefix:(NSString *)prefix __attribute__((swift_name("encode(value:prefix:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("JsonKt")))
@interface ClientJsonKt : ClientBase
@property (class, readonly) ClientKotlinx_serialization_jsonJson *Json __attribute__((swift_name("Json")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PubkeyKt")))
@interface ClientPubkeyKt : ClientBase
+ (ClientSecret_std_typesPubKeySecp256k1 *)encodeSecp256k1PubkeyPubkey:(id)pubkey __attribute__((swift_name("encodeSecp256k1Pubkey(pubkey:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PublicExtensionsKt")))
@interface ClientPublicExtensionsKt : ClientBase

/**
 * Computes the RIPEMD160 for [this] string.
 */
+ (ClientKotlinByteArray *)digestRipemd160:(NSString *)receiver __attribute__((swift_name("digestRipemd160(_:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignatureKt")))
@interface ClientSignatureKt : ClientBase
+ (ClientSecret_std_typesStdSignature *)encodeSecp256k1SignaturePubkey:(id)pubkey signature:(id)signature __attribute__((swift_name("encodeSecp256k1Signature(pubkey:signature:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UByteArrayUtilsKt")))
@interface ClientUByteArrayUtilsKt : ClientBase
+ (NSString *)decodeToString:(id)receiver __attribute__((swift_name("decodeToString(_:)")));
+ (ClientOkioByteString *)toByteString:(id)receiver __attribute__((swift_name("toByteString(_:)")));
+ (ClientKotlinIntArray *)toIntArray:(id)receiver __attribute__((swift_name("toIntArray(_:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface ClientKotlinEnumCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface ClientKotlinArray<T> : ClientBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(ClientInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<ClientKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface ClientKotlinThrowable : ClientBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (ClientKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface ClientKotlinException : ClientKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface ClientKotlinRuntimeException : ClientKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface ClientKotlinIllegalStateException : ClientKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface ClientKotlinCancellationException : ClientKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ClientKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cosmwasm_std_typesCodeInfo")))
@interface ClientCosmwasm_std_typesCodeInfo : ClientBase
- (instancetype)initWithCodeId:(NSString *)codeId creator:(NSString *)creator codeHash:(NSString *)codeHash source:(NSString *)source builder:(NSString *)builder __attribute__((swift_name("init(codeId:creator:codeHash:source:builder:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientCosmwasm_std_typesCodeInfoCompanion *companion __attribute__((swift_name("companion")));
- (ClientCosmwasm_std_typesCodeInfo *)doCopyCodeId:(NSString *)codeId creator:(NSString *)creator codeHash:(NSString *)codeHash source:(NSString *)source builder:(NSString *)builder __attribute__((swift_name("doCopy(codeId:creator:codeHash:source:builder:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *builder __attribute__((swift_name("builder")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="code_hash")
*/
@property (readonly) NSString *codeHash __attribute__((swift_name("codeHash")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="code_id")
*/
@property (readonly) NSString *codeId __attribute__((swift_name("codeId")));
@property (readonly) NSString *creator __attribute__((swift_name("creator")));
@property (readonly) NSString *source __attribute__((swift_name("source")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPermission")))
@interface ClientSecret_std_typesPermission : ClientKotlinEnum<ClientSecret_std_typesPermission *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ClientSecret_std_typesPermissionCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) ClientSecret_std_typesPermission *owner __attribute__((swift_name("owner")));
@property (class, readonly) ClientSecret_std_typesPermission *history __attribute__((swift_name("history")));
@property (class, readonly) ClientSecret_std_typesPermission *balance __attribute__((swift_name("balance")));
@property (class, readonly) ClientSecret_std_typesPermission *allowance __attribute__((swift_name("allowance")));
+ (ClientKotlinArray<ClientSecret_std_typesPermission *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClientSecret_std_typesPermission *> *entries __attribute__((swift_name("entries")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPermit")))
@interface ClientSecret_std_typesPermit : ClientBase
- (instancetype)initWithParams:(ClientSecret_std_typesPermitParams *)params signature:(ClientSecret_std_typesStdSignature *)signature __attribute__((swift_name("init(params:signature:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSecret_std_typesPermitCompanion *companion __attribute__((swift_name("companion")));
- (ClientSecret_std_typesPermit *)doCopyParams:(ClientSecret_std_typesPermitParams *)params signature:(ClientSecret_std_typesStdSignature *)signature __attribute__((swift_name("doCopy(params:signature:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientSecret_std_typesPermitParams *params __attribute__((swift_name("params")));
@property (readonly) ClientSecret_std_typesStdSignature *signature __attribute__((swift_name("signature")));
@end

__attribute__((swift_name("BignumBigNumber")))
@protocol ClientBignumBigNumber
@required
- (id<ClientBignumBigNumber>)abs __attribute__((swift_name("abs()")));
- (id<ClientBignumBigNumber>)addOther:(id<ClientBignumBigNumber>)other __attribute__((swift_name("add(other:)")));
- (int32_t)compareToOther_:(id)other __attribute__((swift_name("compareTo(other_:)")));
- (id<ClientBignumBigNumber>)divideOther:(id<ClientBignumBigNumber>)other __attribute__((swift_name("divide(other:)")));
- (ClientKotlinPair<id<ClientBignumBigNumber>, id<ClientBignumBigNumber>> *)divideAndRemainderOther:(id<ClientBignumBigNumber>)other __attribute__((swift_name("divideAndRemainder(other:)")));
- (id<ClientBignumBigNumberCreator>)getCreator __attribute__((swift_name("getCreator()")));
- (BOOL)isZero __attribute__((swift_name("isZero()")));
- (id<ClientBignumBigNumber>)multiplyOther:(id<ClientBignumBigNumber>)other __attribute__((swift_name("multiply(other:)")));
- (id<ClientBignumBigNumber>)negate __attribute__((swift_name("negate()")));
- (int64_t)numberOfDecimalDigits __attribute__((swift_name("numberOfDecimalDigits()")));
- (id<ClientBignumBigNumber>)powExponent:(int32_t)exponent __attribute__((swift_name("pow(exponent:)")));
- (id<ClientBignumBigNumber>)powExponent_:(int64_t)exponent __attribute__((swift_name("pow(exponent_:)")));
- (id<ClientBignumBigNumber>)remainderOther:(id<ClientBignumBigNumber>)other __attribute__((swift_name("remainder(other:)")));
- (void)secureOverwrite __attribute__((swift_name("secureOverwrite()")));
- (int32_t)signum __attribute__((swift_name("signum()")));
- (id<ClientBignumBigNumber>)subtractOther:(id<ClientBignumBigNumber>)other __attribute__((swift_name("subtract(other:)")));
- (NSString *)toStringBase:(int32_t)base __attribute__((swift_name("toString(base:)")));
- (id<ClientBignumBigNumber>)unaryMinus __attribute__((swift_name("unaryMinus()")));
@property (readonly) BOOL isNegative __attribute__((swift_name("isNegative")));
@property (readonly) BOOL isPositive __attribute__((swift_name("isPositive")));
@end

__attribute__((swift_name("BignumBitwiseCapable")))
@protocol ClientBignumBitwiseCapable
@required
- (id _Nullable)andOther:(id _Nullable)other __attribute__((swift_name("and(other:)")));
- (BOOL)bitAtPosition:(int64_t)position __attribute__((swift_name("bitAt(position:)")));
- (int32_t)bitLength __attribute__((swift_name("bitLength()")));
- (id _Nullable)not __attribute__((swift_name("not()")));
- (id _Nullable)orOther:(id _Nullable)other __attribute__((swift_name("or(other:)")));
- (id _Nullable)setBitAtPosition:(int64_t)position bit:(BOOL)bit __attribute__((swift_name("setBitAt(position:bit:)")));
- (id _Nullable)shlPlaces:(int32_t)places __attribute__((swift_name("shl(places:)")));
- (id _Nullable)shrPlaces:(int32_t)places __attribute__((swift_name("shr(places:)")));
- (id _Nullable)xorOther:(id _Nullable)other __attribute__((swift_name("xor(other:)")));
@end

__attribute__((swift_name("BignumByteArraySerializable")))
@protocol ClientBignumByteArraySerializable
@required
- (ClientKotlinByteArray *)toByteArray __attribute__((swift_name("toByteArray()")));
- (id)toUByteArray_ __attribute__((swift_name("toUByteArray_()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger")))
@interface ClientBignumBigInteger : ClientBase <ClientBignumBigNumber, ClientBignumBitwiseCapable, ClientKotlinComparable, ClientBignumByteArraySerializable>
- (instancetype)initWithByte:(int8_t)byte __attribute__((swift_name("init(byte:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithInt:(int32_t)int_ __attribute__((swift_name("init(int:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithLong:(int64_t)long_ __attribute__((swift_name("init(long:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithShort:(int16_t)short_ __attribute__((swift_name("init(short:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientBignumBigIntegerCompanion *companion __attribute__((swift_name("companion")));
- (ClientBignumBigInteger *)abs __attribute__((swift_name("abs()")));
- (ClientBignumBigInteger *)addOther:(ClientBignumBigInteger *)other __attribute__((swift_name("add(other:)")));
- (ClientBignumBigInteger *)andOther:(ClientBignumBigInteger *)other __attribute__((swift_name("and(other:)")));
- (BOOL)bitAtPosition:(int64_t)position __attribute__((swift_name("bitAt(position:)")));
- (int32_t)bitLength __attribute__((swift_name("bitLength()")));
- (int8_t)byteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("byteValue(exactRequired:)")));
- (int32_t)compareOther:(ClientBignumBigInteger *)other __attribute__((swift_name("compare(other:)")));
- (int32_t)compareDoubleAndBigIntDouble:(double)double_ comparisonBlock:(ClientInt *(^)(ClientBignumBigInteger *))comparisonBlock __attribute__((swift_name("compareDoubleAndBigInt(double:comparisonBlock:)")));
- (int32_t)compareFloatAndBigIntFloat:(float)float_ comparisonBlock:(ClientInt *(^)(ClientBignumBigInteger *))comparisonBlock __attribute__((swift_name("compareFloatAndBigInt(float:comparisonBlock:)")));
- (int32_t)compareToOther:(id)other __attribute__((swift_name("compareTo(other:)")));
- (int32_t)compareToOther_:(id)other __attribute__((swift_name("compareTo(other_:)")));
- (ClientBignumBigInteger *)dec __attribute__((swift_name("dec()")));
- (ClientBignumBigInteger *)divideOther:(ClientBignumBigInteger *)other __attribute__((swift_name("divide(other:)")));
- (ClientKotlinPair<ClientBignumBigInteger *, ClientBignumBigInteger *> *)divideAndRemainderOther:(ClientBignumBigInteger *)other __attribute__((swift_name("divideAndRemainder(other:)")));
- (ClientBignumBigIntegerQuotientAndRemainder *)divremOther:(ClientBignumBigInteger *)other __attribute__((swift_name("divrem(other:)")));
- (double)doubleValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("doubleValue(exactRequired:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (ClientBignumBigInteger *)factorial __attribute__((swift_name("factorial()")));
- (float)floatValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("floatValue(exactRequired:)")));
- (ClientBignumBigInteger *)gcdOther:(ClientBignumBigInteger *)other __attribute__((swift_name("gcd(other:)")));
- (id)getBackingArrayCopy __attribute__((swift_name("getBackingArrayCopy()")));
- (id<ClientBignumBigNumberCreator>)getCreator __attribute__((swift_name("getCreator()")));
- (ClientBignumBigInteger *)getInstance __attribute__((swift_name("getInstance()")));
- (ClientBignumSign *)getSign __attribute__((swift_name("getSign()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (ClientBignumBigInteger *)inc __attribute__((swift_name("inc()")));
- (int32_t)intValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("intValue(exactRequired:)")));
- (BOOL)isZero __attribute__((swift_name("isZero()")));
- (int64_t)longValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("longValue(exactRequired:)")));
- (ClientBignumBigInteger *)modModulo:(ClientBignumBigInteger *)modulo __attribute__((swift_name("mod(modulo:)")));
- (ClientBignumBigInteger *)modInverseModulo:(ClientBignumBigInteger *)modulo __attribute__((swift_name("modInverse(modulo:)")));
- (ClientBignumBigInteger *)multiplyOther:(ClientBignumBigInteger *)other __attribute__((swift_name("multiply(other:)")));
- (ClientBignumBigInteger *)negate __attribute__((swift_name("negate()")));
- (ClientBignumBigInteger *)not __attribute__((swift_name("not()")));
- (int64_t)numberOfDecimalDigits __attribute__((swift_name("numberOfDecimalDigits()")));
- (ClientBignumBigInteger *)orOther:(ClientBignumBigInteger *)other __attribute__((swift_name("or(other:)")));
- (ClientBignumBigInteger *)powExponent__:(ClientBignumBigInteger *)exponent __attribute__((swift_name("pow(exponent__:)")));
- (ClientBignumBigInteger *)powExponent:(int32_t)exponent __attribute__((swift_name("pow(exponent:)")));
- (ClientBignumBigInteger *)powExponent_:(int64_t)exponent __attribute__((swift_name("pow(exponent_:)")));
- (ClientBignumBigIntegerBigIntegerRange *)rangeToOther:(ClientBignumBigInteger *)other __attribute__((swift_name("rangeTo(other:)")));
- (ClientBignumBigInteger *)remainderOther:(ClientBignumBigInteger *)other __attribute__((swift_name("remainder(other:)")));
- (void)secureOverwrite __attribute__((swift_name("secureOverwrite()")));
- (ClientBignumBigInteger *)setBitAtPosition:(int64_t)position bit:(BOOL)bit __attribute__((swift_name("setBitAt(position:bit:)")));
- (ClientBignumBigInteger *)shlPlaces:(int32_t)places __attribute__((swift_name("shl(places:)")));
- (int16_t)shortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("shortValue(exactRequired:)")));
- (ClientBignumBigInteger *)shrPlaces:(int32_t)places __attribute__((swift_name("shr(places:)")));
- (int32_t)signum __attribute__((swift_name("signum()")));
- (ClientBignumBigInteger *)sqrt __attribute__((swift_name("sqrt()")));
- (ClientBignumBigIntegerSqareRootAndRemainder *)sqrtAndRemainder __attribute__((swift_name("sqrtAndRemainder()")));
- (ClientBignumBigInteger *)subtractOther:(ClientBignumBigInteger *)other __attribute__((swift_name("subtract(other:)")));
- (NSString *)timesChar:(unichar)char_ __attribute__((swift_name("times(char:)")));
- (ClientKotlinByteArray *)toByteArray __attribute__((swift_name("toByteArray()")));
- (ClientBignumModularBigInteger *)toModularBigIntegerModulo:(ClientBignumBigInteger *)modulo __attribute__((swift_name("toModularBigInteger(modulo:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)toStringBase:(int32_t)base __attribute__((swift_name("toString(base:)")));
- (id)toUByteArray_ __attribute__((swift_name("toUByteArray_()")));
- (uint8_t)ubyteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ubyteValue(exactRequired:)")));
- (uint32_t)uintValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("uintValue(exactRequired:)")));
- (uint64_t)ulongValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ulongValue(exactRequired:)")));
- (ClientBignumBigInteger *)unaryMinus __attribute__((swift_name("unaryMinus()")));
- (uint16_t)ushortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ushortValue(exactRequired:)")));
- (ClientBignumBigInteger *)xorOther:(ClientBignumBigInteger *)other __attribute__((swift_name("xor(other:)")));
@property (readonly) int32_t numberOfWords __attribute__((swift_name("numberOfWords")));
@property NSString * _Nullable stringRepresentation __attribute__((swift_name("stringRepresentation")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((swift_name("Secret_std_typesTypeValue")))
@interface ClientSecret_std_typesTypeValue<V> : ClientBase
@property (class, readonly, getter=companion) ClientSecret_std_typesTypeValueCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) V _Nullable value __attribute__((swift_name("value")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesStdSignature")))
@interface ClientSecret_std_typesStdSignature : ClientBase
- (instancetype)initWithPubKey:(ClientSecret_std_typesPubKey *)pubKey signature:(NSString *)signature __attribute__((swift_name("init(pubKey:signature:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSecret_std_typesStdSignatureCompanion *companion __attribute__((swift_name("companion")));
- (ClientSecret_std_typesStdSignature *)doCopyPubKey:(ClientSecret_std_typesPubKey *)pubKey signature:(NSString *)signature __attribute__((swift_name("doCopy(pubKey:signature:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="pub_key")
*/
@property (readonly) ClientSecret_std_typesPubKey *pubKey __attribute__((swift_name("pubKey")));
@property (readonly) NSString *signature __attribute__((swift_name("signature")));
@end


/**
 * Encoder is a core serialization primitive that encapsulates the knowledge of the underlying
 * format and its storage, exposing only structural methods to the serializer, making it completely
 * format-agnostic. Serialization process transforms a single value into the sequence of its
 * primitive elements, also called its serial form, while encoding transforms these primitive elements into an actual
 * format representation: JSON string, ProtoBuf ByteArray, in-memory map representation etc.
 *
 * Encoder provides high-level API that operates with basic primitive types, collections
 * and nested structures. Internally, encoder represents output storage and operates with its state
 * and lower level format-specific details.
 *
 * To be more specific, serialization transforms a value into a sequence of "here is an int, here is
 * a double, here a list of strings and here is another object that is a nested int", while encoding
 * transforms this sequence into a format-specific commands such as "insert opening curly bracket
 * for a nested object start, insert a name of the value, and the value separated with colon for an int etc."
 *
 * The symmetric interface for the deserialization process is [Decoder].
 *
 * ### Serialization. Primitives
 *
 * If a class is represented as a single [primitive][PrimitiveKind] value in its serialized form,
 * then one of the `encode*` methods (e.g. [encodeInt]) can be used directly.
 *
 * ### Serialization. Structured types.
 *
 * If a class is represented as a structure or has multiple values in its serialized form,
 * `encode*` methods are not that helpful, because they do not allow working with collection types or establish structure boundaries.
 * All these capabilities are delegated to the [CompositeEncoder] interface with a more specific API surface.
 * To denote a structure start, [beginStructure] should be used.
 * ```
 * // Denote the structure start,
 * val composite = encoder.beginStructure(descriptor)
 * // Encoding all elements within the structure using 'composite'
 * ...
 * // Denote the structure end
 * composite.endStructure(descriptor)
 * ```
 *
 * E.g. if the encoder belongs to JSON format, then [beginStructure] will write an opening bracket
 * (`{` or `[`, depending on the descriptor kind), returning the [CompositeEncoder] that is aware of colon separator,
 * that should be appended between each key-value pair, whilst [CompositeEncoder.endStructure] will write a closing bracket.
 *
 * ### Exception guarantees
 *
 * For the regular exceptions, such as invalid input, conflicting serial names,
 * [SerializationException] can be thrown by any encoder methods.
 * It is recommended to declare a format-specific subclass of [SerializationException] and throw it.
 *
 * ### Exception safety
 *
 * In general, catching [SerializationException] from any of `encode*` methods is not allowed and produces unspecified behaviour.
 * After thrown exception, the current encoder is left in an arbitrary state, no longer suitable for further encoding.
 *
 * ### Format encapsulation
 *
 * For example, for the following serializer:
 * ```
 * class StringHolder(val stringValue: String)
 *
 * object StringPairDeserializer : SerializationStrategy<StringHolder> {
 *    override val descriptor = ...
 *
 *    override fun serializer(encoder: Encoder, value: StringHolder) {
 *        // Denotes start of the structure, StringHolder is not a "plain" data type
 *        val composite = encoder.beginStructure(descriptor)
 *        // Encode the nested string value
 *        composite.encodeStringElement(descriptor, index = 0)
 *        // Denotes end of the structure
 *        composite.endStructure(descriptor)
 *    }
 * }
 * ```
 *
 * This serializer does not know anything about the underlying storage and will work with any properly-implemented encoder.
 * JSON, for example, writes an opening bracket `{` during the `beginStructure` call, writes `stringValue` key along
 * with its value in `encodeStringElement` and writes the closing bracket `}` during the `endStructure`.
 * XML would do roughly the same, but with different separators and structures, while ProtoBuf
 * machinery could be completely different.
 * In any case, all these parsing details are encapsulated by an encoder.
 *
 * ### Encoder implementation.
 *
 * While being strictly typed, an underlying format can transform actual types in the way it wants.
 * For example, a format can support only string types and encode/decode all primitives in a string form:
 * ```
 * StringFormatEncoder : Encoder {
 *
 *     ...
 *     override fun encodeDouble(value: Double) = encodeString(value.toString())
 *     override fun encodeInt(value: Int) = encodeString(value.toString())
 *     ...
 * }
 * ```
 *
 * ### Not stable for inheritance
 *
 * `Encoder` interface is not stable for inheritance in 3rd party libraries, as new methods
 * might be added to this interface or contracts of the existing methods can be changed.
 */
__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol ClientKotlinx_serialization_coreEncoder
@required

/**
 * Encodes the beginning of the collection with size [collectionSize] and the given serializer of its type parameters.
 * This method has to be implemented only if you need to know collection size in advance, otherwise, [beginStructure] can be used.
 */
- (id<ClientKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));

/**
 * Encodes the beginning of the nested structure in a serialized form
 * and returns [CompositeDecoder] responsible for encoding this very structure.
 * E.g the hierarchy:
 * ```
 * class StringHolder(val stringValue: String)
 * class Holder(val stringHolder: StringHolder)
 * ```
 *
 * with the following serialized form in JSON:
 * ```
 * {
 *   "stringHolder" : { "stringValue": "value" }
 * }
 * ```
 *
 * will be roughly represented as the following sequence of calls:
 * ```
 * // Holder serializer
 * fun serialize(encoder: Encoder, value: Holder) {
 *     val composite = encoder.beginStructure(descriptor) // the very first opening bracket '{'
 *     composite.encodeSerializableElement(descriptor, 0, value.stringHolder) // Serialize nested StringHolder
 *     composite.endStructure(descriptor) // The very last closing bracket
 * }
 *
 * // StringHolder serializer
 * fun serialize(encoder: Encoder, value: StringHolder) {
 *     val composite = encoder.beginStructure(descriptor) // One more '{' when the key "stringHolder" is already written
 *     composite.encodeStringElement(descriptor, 0, value.stringValue) // Serialize actual value
 *     composite.endStructure(descriptor) // Closing bracket
 * }
 * ```
 */
- (id<ClientKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));

/**
 * Encodes a boolean value.
 * Corresponding kind is [PrimitiveKind.BOOLEAN].
 */
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));

/**
 * Encodes a single byte value.
 * Corresponding kind is [PrimitiveKind.BYTE].
 */
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));

/**
 * Encodes a 16-bit unicode character value.
 * Corresponding kind is [PrimitiveKind.CHAR].
 */
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));

/**
 * Encodes a 64-bit IEEE 754 floating point value.
 * Corresponding kind is [PrimitiveKind.DOUBLE].
 */
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));

/**
 * Encodes a enum value that is stored at the [index] in [enumDescriptor] elements collection.
 * Corresponding kind is [SerialKind.ENUM].
 *
 * E.g. for the enum `enum class Letters { A, B, C, D }` and
 * serializable value "C", [encodeEnum] method should be called with `2` as am index.
 *
 * This method does not imply any restrictions on the output format,
 * the format is free to store the enum by its name, index, ordinal or any other
 */
- (void)encodeEnumEnumDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));

/**
 * Encodes a 32-bit IEEE 754 floating point value.
 * Corresponding kind is [PrimitiveKind.FLOAT].
 */
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));

/**
 * Returns [Encoder] for encoding an underlying type of a value class in an inline manner.
 * [descriptor] describes a serializable value class.
 *
 * Namely, for the `@Serializable @JvmInline value class MyInt(val my: Int)`,
 * the following sequence is used:
 * ```
 * thisEncoder.encodeInline(MyInt.serializer().descriptor).encodeInt(my)
 * ```
 *
 * Current encoder may return any other instance of [Encoder] class, depending on the provided [descriptor].
 * For example, when this function is called on Json encoder with `UInt.serializer().descriptor`, the returned encoder is able
 * to encode unsigned integers.
 *
 * Note that this function returns [Encoder] instead of the [CompositeEncoder]
 * because value classes always have the single property.
 * Calling [Encoder.beginStructure] on returned instance leads to an unspecified behavior and, in general, is prohibited.
 */
- (id<ClientKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));

/**
 * Encodes a 32-bit integer value.
 * Corresponding kind is [PrimitiveKind.INT].
 */
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));

/**
 * Encodes a 64-bit integer value.
 * Corresponding kind is [PrimitiveKind.LONG].
 */
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));

/**
 * Notifies the encoder that value of a nullable type that is
 * being serialized is not null. It should be called before writing a non-null value
 * of nullable type:
 * ```
 * // Could be String? serialize method
 * if (value != null) {
 *     encoder.encodeNotNullMark()
 *     encoder.encodeStringValue(value)
 * } else {
 *     encoder.encodeNull()
 * }
 * ```
 *
 * This method has a use in highly-performant binary formats and can
 * be safely ignore by most of the regular formats.
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));

/**
 * Encodes `null` value.
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNull __attribute__((swift_name("encodeNull()")));

/**
 * Encodes the nullable [value] of type [T] by delegating the encoding process to the given [serializer].
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableValueSerializer:(id<ClientKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));

/**
 * Encodes the [value] of type [T] by delegating the encoding process to the given [serializer].
 * For example, `encodeInt` call is equivalent to delegating integer encoding to [Int.serializer][Int.Companion.serializer]:
 * `encodeSerializableValue(Int.serializer())`
 */
- (void)encodeSerializableValueSerializer:(id<ClientKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));

/**
 * Encodes a 16-bit short value.
 * Corresponding kind is [PrimitiveKind.SHORT].
 */
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));

/**
 * Encodes a string value.
 * Corresponding kind is [PrimitiveKind.STRING].
 */
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));

/**
 * Context of the current serialization process, including contextual and polymorphic serialization and,
 * potentially, a format-specific configuration.
 */
@property (readonly) ClientKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end


/**
 * Serial descriptor is an inherent property of [KSerializer] that describes the structure of the serializable type.
 * The structure of the serializable type is not only the characteristic of the type itself, but also of the serializer as well,
 * meaning that one type can have multiple descriptors that have completely different structures.
 *
 * For example, the class `class Color(val rgb: Int)` can have multiple serializable representations,
 * such as `{"rgb": 255}`, `"#0000FF"`, `[0, 0, 255]` and `{"red": 0, "green": 0, "blue": 255}`.
 * Representations are determined by serializers, and each such serializer has its own descriptor that identifies
 * each structure in a distinguishable and format-agnostic manner.
 *
 * ### Structure
 * Serial descriptor is identified by its [name][serialName] and consists of a kind, potentially empty set of
 * children elements, and additional metadata.
 *
 * * [serialName] uniquely identifies the descriptor (and the corresponding serializer) for non-generic types.
 *   For generic types, the actual type substitution is omitted from the string representation, and the name
 *   identifies the family of the serializers without type substitutions. However, type substitution is accounted for
 *   in [equals] and [hashCode] operations, meaning that descriptors of generic classes with the same name but different type
 *   arguments are not equal to each other.
 *   [serialName] is typically used to specify the type of the target class during serialization of polymorphic and sealed
 *   classes, for observability and diagnostics.
 * * [Kind][SerialKind] defines what this descriptor represents: primitive, enum, object, collection, etc.
 * * Children elements are represented as serial descriptors as well and define the structure of the type's elements.
 * * Metadata carries additional information, such as [nullability][nullable], [optionality][isElementOptional]
 *   and [serial annotations][getElementAnnotations].
 *
 * ### Usages
 * There are two general usages of the descriptors: THE serialization process and serialization introspection.
 *
 * #### Serialization
 * Serial descriptor is used as a bridge between decoders/encoders and serializers.
 * When asking for a next element, the serializer provides an expected descriptor to the decoder, and,
 * based on the descriptor content, the decoder decides how to parse its input.
 * In JSON, for example, when the encoder is asked to encode the next element and this element
 * is a subtype of [List], the encoder receives a descriptor with [StructureKind.LIST] and, based on that,
 * first writes an opening square bracket before writing the content of the list.
 *
 * Serial descriptor _encapsulates_ the structure of the data, so serializers can be free from
 * format-specific details. `ListSerializer` knows nothing about JSON and square brackets, providing
 * only the structure of the data and delegating encoding decision to the format itself.
 *
 * #### Introspection
 * Another usage of a serial descriptor is type introspection without its serialization.
 * Introspection can be used to check whether the given serializable class complies the
 * corresponding scheme and to generate JSON or ProtoBuf schema from the given class.
 *
 * ### Indices
 * Serial descriptor API operates with children indices.
 * For the fixed-size structures, such as regular classes, index is represented by a value in
 * the range from zero to [elementsCount] and represent and index of the property in this class.
 * Consequently, primitives do not have children and their element count is zero.
 *
 * For collections and maps indices do not have a fixed bound. Regular collections descriptors usually
 * have one element (`T`, maps have two, one for keys and one for values), but potentially unlimited
 * number of actual children values. Valid indices range is not known statically,
 * and implementations of such a descriptor should provide consistent and unbounded names and indices.
 *
 * In practice, for regular classes it is allowed to invoke `getElement*(index)` methods
 * with an index from `0` to [elementsCount] range and the element at the particular index corresponds to the
 * serializable property at the given position.
 * For collections and maps, index parameter for `getElement*(index)` methods is effectively bounded
 * by the maximal number of collection/map elements.
 *
 * ### Thread-safety and mutability
 * Serial descriptor implementation should be immutable and, thus, thread-safe.
 *
 * ### Equality and caching
 * Serial descriptor can be used as a unique identifier for format-specific data or schemas and
 * this implies the following restrictions on its `equals` and `hashCode`:
 *
 * An [equals] implementation should use both [serialName] and elements structure.
 * Comparing [elementDescriptors] directly is discouraged,
 * because it may cause a stack overflow error, e.g., if a serializable class `T` contains elements of type `T`.
 * To avoid it, a serial descriptor implementation should compare only descriptors
 * of class' type parameters, in a way that `serializer<Box<Int>>().descriptor != serializer<Box<String>>().descriptor`.
 * If type parameters are equal, descriptor structure should be compared by using children elements
 * descriptors' [serialName]s, which correspond to class names
 * (do not confuse with elements' own names, which correspond to properties' names); and/or other [SerialDescriptor]
 * properties, such as [kind].
 * An example of [equals] implementation:
 * ```
 * if (this === other) return true
 * if (other::class != this::class) return false
 * if (serialName != other.serialName) return false
 * if (!typeParametersAreEqual(other)) return false
 * if (this.elementDescriptors().map { it.serialName } != other.elementDescriptors().map { it.serialName }) return false
 * return true
 * ```
 *
 * [hashCode] implementation should use the same properties for computing the result.
 *
 * ### User-defined serial descriptors
 * The best way to define a custom descriptor is to use [buildClassSerialDescriptor] builder function, where
 * for each serializable property the corresponding element is declared.
 *
 * Example:
 * ```
 * // Class with custom serializer and custom serial descriptor
 * class Data(
 *     val intField: Int, // This field is ignored by custom serializer
 *     val longField: Long, // This field is written as long, but in serialized form is named as "_longField"
 *     val stringList: List<String> // This field is written as regular list of strings
 * )
 *
 * // Descriptor for such class:
 * buildClassSerialDescriptor("my.package.Data") {
 *     // intField is deliberately ignored by serializer -- not present in the descriptor as well
 *     element<Long>("_longField") // longField is named as _longField
 *     element("stringField", listSerialDescriptor<String>())
 * }
 *
 * // Example of 'serialize' function for such descriptor
 * override fun serialize(encoder: Encoder, value: Data) {
 *     encoder.encodeStructure(descriptor) {
 *         encodeLongElement(descriptor, 0, value.longField) // Will be written as "_longField" because descriptor's child at index 0 says so
 *         encodeSerializableElement(descriptor, 1, ListSerializer(String.serializer()), value.stringList)
 *     }
 * }
 * ```
 *
 * For classes that are represented as a single primitive value, [PrimitiveSerialDescriptor] builder function can be used instead.
 *
 * ### Consistency violations
 * An implementation of [SerialDescriptor] should be consistent with the implementation of the corresponding [KSerializer].
 * Yet it is not type-checked statically, thus making it possible to declare a non-consistent implementation of descriptor and serializer.
 * In such cases, the behavior of an underlying format is unspecified and may lead to both runtime errors and encoding of
 * corrupted data that is impossible to decode back.
 *
 * ### Not for implementation
 *
 * `SerialDescriptor` interface should not be implemented in 3rd party libraries, as new methods
 * might be added to this interface when kotlinx.serialization adds support for new Kotlin features.
 * This interface is safe to use and construct via [buildClassSerialDescriptor], [PrimitiveSerialDescriptor], and `SerialDescriptor` factory function.
 */
__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol ClientKotlinx_serialization_coreSerialDescriptor
@required

/**
 * Returns serial annotations of the child element at the given [index].
 * This method differs from `getElementDescriptor(index).annotations` by reporting only
 * element-specific annotations:
 * ```
 * @Serializable
 * @OnClassSerialAnnotation
 * class Nested(...)
 *
 * @Serializable
 * class Outer(@OnPropertySerialAnnotation val nested: Nested)
 *
 * val outerDescriptor = Outer.serializer().descriptor
 *
 * outerDescriptor.getElementAnnotations(0) // Returns [@OnPropertySerialAnnotation]
 * outerDescriptor.getElementDescriptor(0).annotations // Returns [@OnClassSerialAnnotation]
 * ```
 * Only annotations marked with [SerialInfo] are added to the resulting list.
 *
 * @throws IndexOutOfBoundsException for an illegal [index] values.
 * @throws IllegalStateException if the current descriptor does not support children elements (e.g. is a primitive).
 */
- (NSArray<id<ClientKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));

/**
 * Retrieves the descriptor of the child element for the given [index].
 * For the property of type `T` on the position `i`, `getElementDescriptor(i)` yields the same result
 * as for `T.serializer().descriptor`, if the serializer for this property is not explicitly overridden
 * with `@Serializable(with = ...`)`, [Polymorphic] or [Contextual].
 * This method can be used to completely introspect the type that the current descriptor describes.
 *
 * Example:
 * ```
 * @Serializable
 * @OnClassSerialAnnotation
 * class Nested(...)
 *
 * @Serializable
 * class Outer(val nested: Nested)
 *
 * val outerDescriptor = Outer.serializer().descriptor
 *
 * outerDescriptor.getElementDescriptor(0).serialName // Returns "Nested"
 * outerDescriptor.getElementDescriptor(0).annotations // Returns [@OnClassSerialAnnotation]
 * ```
 *
 * @throws IndexOutOfBoundsException for illegal [index] values.
 * @throws IllegalStateException if the current descriptor does not support children elements (e.g. is a primitive).
 */
- (id<ClientKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));

/**
 * Returns an index in the children list of the given element by its name or [CompositeDecoder.UNKNOWN_NAME]
 * if there is no such element.
 * The resulting index, if it is not [CompositeDecoder.UNKNOWN_NAME], is guaranteed to be usable with [getElementName].
 *
 * Example:
 *
 * ```
 * @Serializable
 * class User(val name: String, val alias: String?)
 *
 * val userDescriptor = User.serializer().descriptor
 *
 * userDescriptor.getElementIndex("name") // Returns 0
 * userDescriptor.getElementIndex("alias") // Returns 1
 * userDescriptor.getElementIndex("lastName") // Returns CompositeDecoder.UNKNOWN_NAME = -3
 * ```
 */
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));

/**
 * Returns a positional name of the child at the given [index].
 * Positional name represents a corresponding property name in the class, associated with
 * the current descriptor.
 *
 * Do not confuse with [serialName], which returns class name:
 *
 * ```
 * package my.app
 *
 * @Serializable
 * class User(val name: String)
 *
 * val userDescriptor = User.serializer().descriptor
 *
 * userDescriptor.serialName // Returns "my.app.User"
 * userDescriptor.getElementName(0) // Returns "name"
 * ```
 *
 * @throws IndexOutOfBoundsException for an illegal [index] values.
 * @throws IllegalStateException if the current descriptor does not support children elements (e.g. is a primitive)
 */
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));

/**
 * Whether the element at the given [index] is optional (can be absent in serialized form).
 * For generated descriptors, all elements that have a corresponding default parameter value are
 * marked as optional. Custom serializers can treat optional values in a serialization-specific manner
 * without a default parameters constraint.
 *
 * Example of optionality:
 * ```
 * @Serializable
 * class Holder(
 *     val a: Int, // isElementOptional(0) == false
 *     val b: Int?, // isElementOptional(1) == false
 *     val c: Int? = null, // isElementOptional(2) == true
 *     val d: List<Int>, // isElementOptional(3) == false
 *     val e: List<Int> = listOf(1), // isElementOptional(4) == true
 * )
 * ```
 * Returns `false` for valid indices of collections, maps, and enums.
 *
 * @throws IndexOutOfBoundsException for an illegal [index] values.
 * @throws IllegalStateException if the current descriptor does not support children elements (e.g. is a primitive).
 */
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));

/**
 * Returns serial annotations of the associated class.
 * Serial annotations can be used to specify additional metadata that may be used during serialization.
 * Only annotations marked with [SerialInfo] are added to the resulting list.
 *
 * Do not confuse with [getElementAnnotations]:
 * ```
 * @Serializable
 * @OnClassSerialAnnotation
 * class Nested(...)
 *
 * @Serializable
 * class Outer(@OnPropertySerialAnnotation val nested: Nested)
 *
 * val outerDescriptor = Outer.serializer().descriptor
 *
 * outerDescriptor.getElementAnnotations(0) // Returns [@OnPropertySerialAnnotation]
 * outerDescriptor.getElementDescriptor(0).annotations // Returns [@OnClassSerialAnnotation]
 * ```
 */
@property (readonly) NSArray<id<ClientKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));

/**
 * The number of elements this descriptor describes, besides from the class itself.
 * [elementsCount] describes the number of **semantic** elements, not the number
 * of actual fields/properties in the serialized form, even though they frequently match.
 *
 * For example, for the following class
 * `class Complex(val real: Long, val imaginary: Long)` the corresponding descriptor
 * and the serialized form both have two elements, while for `List<Int>`
 * the corresponding descriptor has a single element (`IntDescriptor`, the type of list element),
 * but from zero up to `Int.MAX_VALUE` values in the serialized form:
 *
 * ```
 * @Serializable
 * class Complex(val real: Long, val imaginary: Long)
 *
 * Complex.serializer().descriptor.elementsCount // Returns 2
 *
 * @Serializable
 * class OuterList(val list: List<Int>)
 *
 * OuterList.serializer().descriptor.getElementDescriptor(0).elementsCount // Returns 1
 * ```
 */
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));

/**
 * Returns `true` if this descriptor describes a serializable value class which underlying value
 * is serialized directly.
 *
 * This property is true for serializable `@JvmInline value` classes:
 * ```
 * @Serializable
 * class User(val name: Name)
 *
 * @Serializable
 * @JvmInline
 * value class Name(val value: String)
 *
 * User.serializer().descriptor.isInline // false
 * User.serializer().descriptor.getElementDescriptor(0).isInline // true
 * Name.serializer().descriptor.isInline // true
 * ```
 */
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));

/**
 * Whether the descriptor describes a nullable type.
 * Returns `true` if associated serializer can serialize/deserialize nullable elements of the described type.
 *
 * Example:
 *
 * ```
 * @Serializable
 * class User(val name: String, val alias: String?)
 *
 * val userDescriptor = User.serializer().descriptor
 *
 * userDescriptor.isNullable // Returns false
 * userDescriptor.getElementDescriptor(0).isNullable // Returns false
 * userDescriptor.getElementDescriptor(1).isNullable // Returns true
 * ```
 */
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));

/**
 * The kind of the serialized form that determines **the shape** of the serialized data.
 * Formats use serial kind to add and parse serializer-agnostic metadata to the result.
 *
 * For example, JSON format wraps [classes][StructureKind.CLASS] and [StructureKind.MAP] into
 * brackets, while ProtoBuf just serialize these types in separate ways.
 *
 * Kind should be consistent with the implementation, for example, if it is a [primitive][PrimitiveKind],
 * then its element count should be zero and vice versa.
 *
 * Example of introspecting kinds:
 *
 * ```
 * @Serializable
 * class User(val name: String)
 *
 * val userDescriptor = User.serializer().descriptor
 *
 * userDescriptor.kind // Returns StructureKind.CLASS
 * userDescriptor.getElementDescriptor(0).kind // Returns PrimitiveKind.STRING
 * ```
 */
@property (readonly) ClientKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));

/**
 * Serial name of the descriptor that identifies a pair of the associated serializer and target class.
 *
 * For generated and default serializers, the serial name is equal to the corresponding class's fully qualified name
 * or, if overridden, [SerialName].
 * Custom serializers should provide a unique serial name that identifies both the serializable class and
 * the serializer itself, ignoring type arguments if they are present, for example: `my.package.LongAsTrimmedString`.
 *
 * Do not confuse with [getElementName], which returns property name:
 *
 * ```
 * package my.app
 *
 * @Serializable
 * class User(val name: String)
 *
 * val userDescriptor = User.serializer().descriptor
 *
 * userDescriptor.serialName // Returns "my.app.User"
 * userDescriptor.getElementName(0) // Returns "name"
 * ```
 */
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end


/**
 * Decoder is a core deserialization primitive that encapsulates the knowledge of the underlying
 * format and an underlying storage, exposing only structural methods to the deserializer, making it completely
 * format-agnostic. Deserialization process takes a decoder and asks him for a sequence of primitive elements,
 * defined by a deserializer serial form, while decoder knows how to retrieve these primitive elements from an actual format
 * representations.
 *
 * Decoder provides high-level API that operates with basic primitive types, collections
 * and nested structures. Internally, the decoder represents input storage, and operates with its state
 * and lower level format-specific details.
 *
 * To be more specific, serialization asks a decoder for a sequence of "give me an int, give me
 * a double, give me a list of strings and give me another object that is a nested int", while decoding
 * transforms this sequence into a format-specific commands such as "parse the part of the string until the next quotation mark
 * as an int to retrieve an int, parse everything within the next curly braces to retrieve elements of a nested object etc."
 *
 * The symmetric interface for the serialization process is [Encoder].
 *
 * ### Deserialization. Primitives
 *
 * If a class is represented as a single [primitive][PrimitiveKind] value in its serialized form,
 * then one of the `decode*` methods (e.g. [decodeInt]) can be used directly.
 *
 * ### Deserialization. Structured types
 *
 * If a class is represented as a structure or has multiple values in its serialized form,
 * `decode*` methods are not that helpful, because format may not require a strict order of data
 * (e.g. JSON or XML), do not allow working with collection types or establish structure boundaries.
 * All these capabilities are delegated to the [CompositeDecoder] interface with a more specific API surface.
 * To denote a structure start, [beginStructure] should be used.
 * ```
 * // Denote the structure start,
 * val composite = decoder.beginStructure(descriptor)
 * // Decode all elements within the structure using 'composite'
 * ...
 * // Denote the structure end
 * composite.endStructure(descriptor)
 * ```
 *
 * E.g. if the decoder belongs to JSON format, then [beginStructure] will parse an opening bracket
 * (`{` or `[`, depending on the descriptor kind), returning the [CompositeDecoder] that is aware of colon separator,
 * that should be read after each key-value pair, whilst [CompositeDecoder.endStructure] will parse a closing bracket.
 *
 * ### Exception guarantees
 *
 * For the regular exceptions, such as invalid input, missing control symbols or attributes, and unknown symbols,
 * [SerializationException] can be thrown by any decoder methods. It is recommended to declare a format-specific
 * subclass of [SerializationException] and throw it.
 *
 * ### Exception safety
 *
 * In general, catching [SerializationException] from any of `decode*` methods is not allowed and produces unspecified behavior.
 * After thrown exception, the current decoder is left in an arbitrary state, no longer suitable for further decoding.
 *
 * ### Format encapsulation
 *
 * For example, for the following deserializer:
 * ```
 * class StringHolder(val stringValue: String)
 *
 * object StringPairDeserializer : DeserializationStrategy<StringHolder> {
 *    override val descriptor = ...
 *
 *    override fun deserializer(decoder: Decoder): StringHolder {
 *        // Denotes start of the structure, StringHolder is not a "plain" data type
 *        val composite = decoder.beginStructure(descriptor)
 *        if (composite.decodeElementIndex(descriptor) != 0)
 *            throw MissingFieldException("Field 'stringValue' is missing")
 *        // Decode the nested string value
 *        val value = composite.decodeStringElement(descriptor, index = 0)
 *        // Denotes end of the structure
 *        composite.endStructure(descriptor)
 *    }
 * }
 * ```
 *
 * This deserializer does not know anything about the underlying data and will work with any properly-implemented decoder.
 * JSON, for example, parses an opening bracket `{` during the `beginStructure` call, checks that the next key
 * after this bracket is `stringValue` (using the descriptor), returns the value after the colon as string value
 * and parses closing bracket `}` during the `endStructure`.
 * XML would do roughly the same, but with different separators and parsing structures, while ProtoBuf
 * machinery could be completely different.
 * In any case, all these parsing details are encapsulated by a decoder.
 *
 * ### Decoder implementation
 *
 * While being strictly typed, an underlying format can transform actual types in the way it wants.
 * For example, a format can support only string types and encode/decode all primitives in a string form:
 * ```
 * StringFormatDecoder : Decoder {
 *
 *     ...
 *     override fun decodeDouble(): Double = decodeString().toDouble()
 *     override fun decodeInt(): Int = decodeString().toInt()
 *     ...
 * }
 * ```
 *
 * ### Not stable for inheritance
 *
 * `Decoder` interface is not stable for inheritance in 3rd-party libraries, as new methods
 * might be added to this interface or contracts of the existing methods can be changed.
 */
__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol ClientKotlinx_serialization_coreDecoder
@required

/**
 * Decodes the beginning of the nested structure in a serialized form
 * and returns [CompositeDecoder] responsible for decoding this very structure.
 *
 * Typically, classes, collections and maps are represented as a nested structure in a serialized form.
 * E.g. the following JSON
 * ```
 * {
 *     "a": 2,
 *     "b": { "nested": "c" }
 *     "c": [1, 2, 3],
 *     "d": null
 * }
 * ```
 * has three nested structures: the very beginning of the data, "b" value and "c" value.
 */
- (id<ClientKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));

/**
 * Decodes a boolean value.
 * Corresponding kind is [PrimitiveKind.BOOLEAN].
 */
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));

/**
 * Decodes a single byte value.
 * Corresponding kind is [PrimitiveKind.BYTE].
 */
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));

/**
 * Decodes a 16-bit unicode character value.
 * Corresponding kind is [PrimitiveKind.CHAR].
 */
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));

/**
 * Decodes a 64-bit IEEE 754 floating point value.
 * Corresponding kind is [PrimitiveKind.DOUBLE].
 */
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));

/**
 * Decodes a enum value and returns its index in [enumDescriptor] elements collection.
 * Corresponding kind is [SerialKind.ENUM].
 *
 * E.g. for the enum `enum class Letters { A, B, C, D }` and
 * underlying input "C", [decodeEnum] method should return `2` as a result.
 *
 * This method does not imply any restrictions on the input format,
 * the format is free to store the enum by its name, index, ordinal or any other enum representation.
 */
- (int32_t)decodeEnumEnumDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));

/**
 * Decodes a 32-bit IEEE 754 floating point value.
 * Corresponding kind is [PrimitiveKind.FLOAT].
 */
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));

/**
 * Returns [Decoder] for decoding an underlying type of a value class in an inline manner.
 * [descriptor] describes a target value class.
 *
 * Namely, for the `@Serializable @JvmInline value class MyInt(val my: Int)`, the following sequence is used:
 * ```
 * thisDecoder.decodeInline(MyInt.serializer().descriptor).decodeInt()
 * ```
 *
 * Current decoder may return any other instance of [Decoder] class, depending on the provided [descriptor].
 * For example, when this function is called on `Json` decoder with
 * `UInt.serializer().descriptor`, the returned decoder is able to decode unsigned integers.
 *
 * Note that this function returns [Decoder] instead of the [CompositeDecoder]
 * because value classes always have the single property.
 *
 * Calling [Decoder.beginStructure] on returned instance leads to an unspecified behavior and, in general, is prohibited.
 */
- (id<ClientKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));

/**
 * Decodes a 32-bit integer value.
 * Corresponding kind is [PrimitiveKind.INT].
 */
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));

/**
 * Decodes a 64-bit integer value.
 * Corresponding kind is [PrimitiveKind.LONG].
 */
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));

/**
 * Returns `true` if the current value in decoder is not null, false otherwise.
 * This method is usually used to decode potentially nullable data:
 * ```
 * // Could be String? deserialize() method
 * public fun deserialize(decoder: Decoder): String? {
 *     if (decoder.decodeNotNullMark()) {
 *         return decoder.decodeString()
 *     } else {
 *         return decoder.decodeNull()
 *     }
 * }
 * ```
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));

/**
 * Decodes the `null` value and returns it.
 *
 * It is expected that `decodeNotNullMark` was called
 * prior to `decodeNull` invocation and the case when it returned `true` was handled.
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (ClientKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));

/**
 * Decodes the nullable value of type [T] by delegating the decoding process to the given [deserializer].
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<ClientKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));

/**
 * Decodes the value of type [T] by delegating the decoding process to the given [deserializer].
 * For example, `decodeInt` call is equivalent to delegating integer decoding to [Int.serializer][Int.Companion.serializer]:
 * `decodeSerializableValue(Int.serializer())`
 */
- (id _Nullable)decodeSerializableValueDeserializer:(id<ClientKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));

/**
 * Decodes a 16-bit short value.
 * Corresponding kind is [PrimitiveKind.SHORT].
 */
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));

/**
 * Decodes a string value.
 * Corresponding kind is [PrimitiveKind.STRING].
 */
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));

/**
 * Context of the current serialization process, including contextual and polymorphic serialization and,
 * potentially, a format-specific configuration.
 */
@property (readonly) ClientKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol ClientKotlinKDeclarationContainer
@required
@end

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol ClientKotlinKAnnotatedElement
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((swift_name("KotlinKClassifier")))
@protocol ClientKotlinKClassifier
@required
@end

__attribute__((swift_name("KotlinKClass")))
@protocol ClientKotlinKClass <ClientKotlinKDeclarationContainer, ClientKotlinKAnnotatedElement, ClientKotlinKClassifier>
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end


/**
 * Class representing single JSON element.
 * Can be [JsonPrimitive], [JsonArray] or [JsonObject].
 *
 * [JsonElement.toString] properly prints JSON tree as valid JSON, taking into account quoted values and primitives.
 * Whole hierarchy is serializable, but only when used with [Json] as [JsonElement] is purely JSON-specific structure
 * which has a meaningful schemaless semantics only for JSON.
 *
 * The whole hierarchy is [serializable][Serializable] only by [Json] format.
 *
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/serialization/json/JsonElementSerializer))
*/
__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement")))
@interface ClientKotlinx_serialization_jsonJsonElement : ClientBase
@property (class, readonly, getter=companion) ClientKotlinx_serialization_jsonJsonElementCompanion *companion __attribute__((swift_name("companion")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((swift_name("Secret_std_typesPubKey")))
@interface ClientSecret_std_typesPubKey : ClientSecret_std_typesTypeValue<NSString *>
@property (class, readonly, getter=companion) ClientSecret_std_typesPubKeyCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinCharArray")))
@interface ClientKotlinCharArray : ClientBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(id (^)(ClientInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (unichar)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (ClientKotlinCharIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(unichar)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cosmwasm_std_typesCoin.Companion")))
@interface ClientCosmwasm_std_typesCoinCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientCosmwasm_std_typesCoinCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol ClientKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("KotlinByteIterator")))
@interface ClientKotlinByteIterator : ClientBase <ClientKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (ClientByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end

__attribute__((swift_name("KotlinIntIterator")))
@interface ClientKotlinIntIterator : ClientBase <ClientKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (ClientInt *)next __attribute__((swift_name("next()")));
- (int32_t)nextInt __attribute__((swift_name("nextInt()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("OkioByteString.Companion")))
@interface ClientOkioByteStringCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientOkioByteStringCompanion *shared __attribute__((swift_name("shared")));
- (ClientOkioByteString * _Nullable)decodeBase64:(NSString *)receiver __attribute__((swift_name("decodeBase64(_:)")));
- (ClientOkioByteString *)decodeHex:(NSString *)receiver __attribute__((swift_name("decodeHex(_:)")));
- (ClientOkioByteString *)encodeUtf8:(NSString *)receiver __attribute__((swift_name("encodeUtf8(_:)")));
- (ClientOkioByteString *)ofData:(ClientKotlinByteArray *)data __attribute__((swift_name("of(data:)")));
- (ClientOkioByteString *)toByteString:(NSData *)receiver __attribute__((swift_name("toByteString(_:)")));
- (ClientOkioByteString *)toByteString:(ClientKotlinByteArray *)receiver offset:(int32_t)offset byteCount:(int32_t)byteCount __attribute__((swift_name("toByteString(_:offset:byteCount:)")));
@property (readonly) ClientOkioByteString *EMPTY __attribute__((swift_name("EMPTY")));
@end


/**
 * Represents an instance of a serialization format
 * that can interact with [KSerializer] and is a supertype of all entry points for a serialization.
 * It does not impose any restrictions on a serialized form or underlying storage, neither it exposes them.
 *
 * Concrete data types and API for user-interaction are responsibility of a concrete subclass or subinterface,
 * for example [StringFormat], [BinaryFormat] or `Json`.
 *
 * Typically, formats have their specific [Encoder] and [Decoder] implementations
 * as private classes and do not expose them.
 *
 * ### Exception types for `SerialFormat` implementation
 *
 * Methods responsible for format-specific encoding and decoding are allowed to throw
 * any subtype of [IllegalArgumentException] in order to indicate serialization
 * and deserialization errors. It is recommended to throw subtypes of [SerializationException]
 * for encoder and decoder specific errors and [IllegalArgumentException] for input
 * and output validation-specific errors.
 *
 * For formats
 *
 * ### Not stable for inheritance
 *
 * `SerialFormat` interface is not stable for inheritance in 3rd party libraries, as new methods
 * might be added to this interface or contracts of the existing methods can be changed.
 *
 * It is safe to operate with instances of `SerialFormat` and call its methods.
 */
__attribute__((swift_name("Kotlinx_serialization_coreSerialFormat")))
@protocol ClientKotlinx_serialization_coreSerialFormat
@required

/**
 * Contains all serializers registered by format user for [Contextual] and [Polymorphic] serialization.
 *
 * The same module should be exposed in the format's [Encoder] and [Decoder].
 */
@property (readonly) ClientKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end


/**
 * [SerialFormat] that allows conversions to and from [String] via [encodeToString] and [decodeFromString] methods.
 *
 * ### Not stable for inheritance
 *
 * `StringFormat` interface is not stable for inheritance in 3rd party libraries, as new methods
 * might be added to this interface or contracts of the existing methods can be changed.
 *
 * It is safe to operate with instances of `StringFormat` and call its methods.
 */
__attribute__((swift_name("Kotlinx_serialization_coreStringFormat")))
@protocol ClientKotlinx_serialization_coreStringFormat <ClientKotlinx_serialization_coreSerialFormat>
@required

/**
 * Decodes and deserializes the given [string] to the value of type [T] using the given [deserializer].
 *
 * @throws SerializationException in case of any decoding-specific error
 * @throws IllegalArgumentException if the decoded input is not a valid instance of [T]
 */
- (id _Nullable)decodeFromStringDeserializer:(id<ClientKotlinx_serialization_coreDeserializationStrategy>)deserializer string:(NSString *)string __attribute__((swift_name("decodeFromString(deserializer:string:)")));

/**
 * Serializes and encodes the given [value] to string using the given [serializer].
 *
 * @throws SerializationException in case of any encoding-specific error
 * @throws IllegalArgumentException if the encoded input does not comply format's specification
 */
- (NSString *)encodeToStringSerializer:(id<ClientKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToString(serializer:value:)")));
@end


/**
 * The main entry point to work with JSON serialization.
 * It is typically used by constructing an application-specific instance, with configured JSON-specific behaviour
 * and, if necessary, registered in [SerializersModule] custom serializers.
 * `Json` instance can be configured in its `Json {}` factory function using [JsonBuilder].
 * For demonstration purposes or trivial usages, Json [companion][Json.Default] can be used instead.
 *
 * Then constructed instance can be used either as regular [SerialFormat] or [StringFormat]
 * or for converting objects to [JsonElement] back and forth.
 *
 * This is the only serial format which has the first-class [JsonElement] support.
 * Any serializable class can be serialized to or from [JsonElement] with [Json.decodeFromJsonElement] and [Json.encodeToJsonElement] respectively or
 * serialize properties of [JsonElement] type.
 *
 * Example of usage:
 * ```
 * @Serializable
 * data class Data(val id: Int, val data: String, val extensions: JsonElement)
 *
 * val json = Json { ignoreUnknownKeys = true }
 * val instance = Data(42, "some data", buildJsonObject { put("key", "value") })
 *
 * // Plain Json usage: returns '{"id": 42, "some data", "extensions": {"key": "value" } }'
 * val jsonString: String = json.encodeToString(instance)
 *
 * // JsonElement serialization, specific for JSON format
 * val jsonElement: JsonElement = json.encodeToJsonElement(instance)
 *
 * // Deserialize from string
 * val deserialized: Data = json.decodeFromString<Data>(jsonString)
 *
 * // Deserialize from json element, JSON-specific
 * val deserializedFromElement: Data = json.decodeFromJsonElement<Data>(jsonElement)
 *
 *  // Deserialize from string to JSON tree, JSON-specific
 * val deserializedElement: JsonElement = json.parseToJsonElement(jsonString)
 *
 * // Deserialize a stream of a single item from an input stream
 * val sequence = Json.decodeToSequence<Data>(ByteArrayInputStream(jsonString.encodeToByteArray()))
 * for (item in sequence) {
 *     println(item) // Prints deserialized Data value
 * }
 * ```
 *
 * Json instance also exposes its [configuration] that can be used in custom serializers
 * that rely on [JsonDecoder] and [JsonEncoder] for customizable behaviour.
 *
 * Json format configuration can be refined using the corresponding constructor:
 * ```
 * val defaultJson = Json {
 *     encodeDefaults = true
 *     ignoreUnknownKeys = true
 * }
 * // Will inherit the properties of defaultJson
 * val debugEndpointJson = Json(defaultJson) {
 *     // ignoreUnknownKeys and encodeDefaults are set to true
 *     prettyPrint = true
 * }
 * ```
 */
__attribute__((swift_name("Kotlinx_serialization_jsonJson")))
@interface ClientKotlinx_serialization_jsonJson : ClientBase <ClientKotlinx_serialization_coreStringFormat>
@property (class, readonly, getter=companion) ClientKotlinx_serialization_jsonJsonDefault *companion __attribute__((swift_name("companion")));

/**
 * Deserializes the given [element] into a value of type [T] using the given [deserializer].
 *
 * @throws [SerializationException] if the given JSON element is not a valid JSON input for the type [T]
 * @throws [IllegalArgumentException] if the decoded input cannot be represented as a valid instance of type [T]
 */
- (id _Nullable)decodeFromJsonElementDeserializer:(id<ClientKotlinx_serialization_coreDeserializationStrategy>)deserializer element:(ClientKotlinx_serialization_jsonJsonElement *)element __attribute__((swift_name("decodeFromJsonElement(deserializer:element:)")));

/**
 * Decodes and deserializes the given JSON [string] to the value of type [T] using deserializer
 * retrieved from the reified type parameter.
 * Example:
 * ```
 * @Serializable
 * data class Project(val name: String, val language: String)
 * //  Project(name=kotlinx.serialization, language=Kotlin)
 * println(Json.decodeFromString<Project>("""{"name":"kotlinx.serialization","language":"Kotlin"}"""))
 * ```
 *
 * @throws SerializationException in case of any decoding-specific error
 * @throws IllegalArgumentException if the decoded input is not a valid instance of [T]
 */
- (id _Nullable)decodeFromStringString:(NSString *)string __attribute__((swift_name("decodeFromString(string:)")));

/**
 * Deserializes the given JSON [string] into a value of type [T] using the given [deserializer].
 * Example:
 * ```
 * @Serializable
 * data class Project(val name: String, val language: String)
 * //  Project(name=kotlinx.serialization, language=Kotlin)
 * println(Json.decodeFromString(Project.serializer(), """{"name":"kotlinx.serialization","language":"Kotlin"}"""))
 * ```
 *
 * @throws [SerializationException] if the given JSON string is not a valid JSON input for the type [T]
 * @throws [IllegalArgumentException] if the decoded input cannot be represented as a valid instance of type [T]
 */
- (id _Nullable)decodeFromStringDeserializer:(id<ClientKotlinx_serialization_coreDeserializationStrategy>)deserializer string:(NSString *)string __attribute__((swift_name("decodeFromString(deserializer:string:)")));

/**
 * Serializes the given [value] into an equivalent [JsonElement] using the given [serializer]
 *
 * @throws [SerializationException] if the given value cannot be serialized to JSON
 */
- (ClientKotlinx_serialization_jsonJsonElement *)encodeToJsonElementSerializer:(id<ClientKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToJsonElement(serializer:value:)")));

/**
 * Serializes the [value] of type [T] into an equivalent JSON using serializer
 * retrieved from the reified type parameter.
 *
 * Example of usage:
 * ```
 * @Serializable
 * class Project(val name: String, val language: String)
 *
 * val data = Project("kotlinx.serialization", "Kotlin")
 *
 * // Prints {"name":"kotlinx.serialization","language":"Kotlin"}
 * println(Json.encodeToString(data))
 * ```
 *
 * @throws [SerializationException] if the given value cannot be serialized to JSON.
 */
- (NSString *)encodeToStringValue:(id _Nullable)value __attribute__((swift_name("encodeToString(value:)")));

/**
 * Serializes the [value] into an equivalent JSON using the given [serializer].
 * This method is recommended to be used with an explicit serializer (e.g. the custom or third-party one),
 * otherwise the `encodeToString(value: T)` version might be preferred as the most concise one.
 *
 * Example of usage:
 * ```
 * @Serializable
 * class Project(val name: String, val language: String)
 *
 * val data = Project("kotlinx.serialization", "Kotlin")
 *
 * // Prints {"name":"kotlinx.serialization","language":"Kotlin"}
 * println(Json.encodeToString(Project.serializer(), data))
 * // The same as Json.encodeToString<T>(value: T) overload
 * println(Json.encodeToString(data))
 * ```
 *
 * @throws [SerializationException] if the given value cannot be serialized to JSON.
 */
- (NSString *)encodeToStringSerializer:(id<ClientKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToString(serializer:value:)")));

/**
 * Deserializes the given JSON [string] into a corresponding [JsonElement] representation.
 *
 * @throws [SerializationException] if the given string is not a valid JSON
 */
- (ClientKotlinx_serialization_jsonJsonElement *)parseToJsonElementString:(NSString *)string __attribute__((swift_name("parseToJsonElement(string:)")));
@property (readonly) ClientKotlinx_serialization_jsonJsonConfiguration *configuration __attribute__((swift_name("configuration")));
@property (readonly) ClientKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="tendermint/PubKeySecp256k1")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPubKeySecp256k1")))
@interface ClientSecret_std_typesPubKeySecp256k1 : ClientSecret_std_typesPubKey
- (instancetype)initWithValue:(NSString *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSecret_std_typesPubKeySecp256k1Companion *companion __attribute__((swift_name("companion")));
- (ClientSecret_std_typesPubKeySecp256k1 *)doCopyValue:(NSString *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cosmwasm_std_typesCodeInfo.Companion")))
@interface ClientCosmwasm_std_typesCodeInfoCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientCosmwasm_std_typesCodeInfoCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPermission.Companion")))
@interface ClientSecret_std_typesPermissionCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecret_std_typesPermissionCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPermit.Params")))
@interface ClientSecret_std_typesPermitParams : ClientBase
- (instancetype)initWithPermitName:(NSString *)permitName allowedTokens:(NSArray<NSString *> *)allowedTokens chainId:(NSString *)chainId permissions:(NSArray<ClientSecret_std_typesPermission *> *)permissions __attribute__((swift_name("init(permitName:allowedTokens:chainId:permissions:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ClientSecret_std_typesPermitParamsCompanion *companion __attribute__((swift_name("companion")));
- (ClientSecret_std_typesPermitParams *)doCopyPermitName:(NSString *)permitName allowedTokens:(NSArray<NSString *> *)allowedTokens chainId:(NSString *)chainId permissions:(NSArray<ClientSecret_std_typesPermission *> *)permissions __attribute__((swift_name("doCopy(permitName:allowedTokens:chainId:permissions:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="allowed_tokens")
*/
@property (readonly) NSArray<NSString *> *allowedTokens __attribute__((swift_name("allowedTokens")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="chain_id")
*/
@property (readonly) NSString *chainId __attribute__((swift_name("chainId")));
@property (readonly) NSArray<ClientSecret_std_typesPermission *> *permissions __attribute__((swift_name("permissions")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="permit_name")
*/
@property (readonly) NSString *permitName __attribute__((swift_name("permitName")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPermit.Companion")))
@interface ClientSecret_std_typesPermitCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecret_std_typesPermitCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinPair")))
@interface ClientKotlinPair<__covariant A, __covariant B> : ClientBase
- (instancetype)initWithFirst:(A _Nullable)first second:(B _Nullable)second __attribute__((swift_name("init(first:second:)"))) __attribute__((objc_designated_initializer));
- (ClientKotlinPair<A, B> *)doCopyFirst:(A _Nullable)first second:(B _Nullable)second __attribute__((swift_name("doCopy(first:second:)")));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@property (readonly) A _Nullable first __attribute__((swift_name("first")));
@property (readonly) B _Nullable second __attribute__((swift_name("second")));
@end

__attribute__((swift_name("BignumBigNumberCreator")))
@protocol ClientBignumBigNumberCreator
@required
- (id _Nullable)fromBigIntegerBigInteger:(ClientBignumBigInteger *)bigInteger __attribute__((swift_name("fromBigInteger(bigInteger:)")));
- (id _Nullable)fromByteByte:(int8_t)byte __attribute__((swift_name("fromByte(byte:)")));
- (id _Nullable)fromIntInt:(int32_t)int_ __attribute__((swift_name("fromInt(int:)")));
- (id _Nullable)fromLongLong:(int64_t)long_ __attribute__((swift_name("fromLong(long:)")));
- (id _Nullable)fromShortShort:(int16_t)short_ __attribute__((swift_name("fromShort(short:)")));
- (id _Nullable)fromUByteUByte:(uint8_t)uByte __attribute__((swift_name("fromUByte(uByte:)")));
- (id _Nullable)fromUIntUInt:(uint32_t)uInt __attribute__((swift_name("fromUInt(uInt:)")));
- (id _Nullable)fromULongULong:(uint64_t)uLong __attribute__((swift_name("fromULong(uLong:)")));
- (id _Nullable)fromUShortUShort:(uint16_t)uShort __attribute__((swift_name("fromUShort(uShort:)")));
- (id _Nullable)parseStringString:(NSString *)string base:(int32_t)base __attribute__((swift_name("parseString(string:base:)")));
- (id _Nullable)tryFromDoubleDouble:(double)double_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromDouble(double:exactRequired:)")));
- (id _Nullable)tryFromFloatFloat:(float)float_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromFloat(float:exactRequired:)")));
@property (readonly) id _Nullable ONE __attribute__((swift_name("ONE")));
@property (readonly) id _Nullable TEN __attribute__((swift_name("TEN")));
@property (readonly) id _Nullable TWO __attribute__((swift_name("TWO")));
@property (readonly) id _Nullable ZERO __attribute__((swift_name("ZERO")));
@end

__attribute__((swift_name("BignumBigNumberUtil")))
@protocol ClientBignumBigNumberUtil
@required
- (id _Nullable)maxFirst:(id _Nullable)first second:(id _Nullable)second __attribute__((swift_name("max(first:second:)")));
- (id _Nullable)minFirst:(id _Nullable)first second:(id _Nullable)second __attribute__((swift_name("min(first:second:)")));
@end

__attribute__((swift_name("BignumByteArrayDeserializable")))
@protocol ClientBignumByteArrayDeserializable
@required
- (id<ClientBignumBigNumber>)fromByteArraySource:(ClientKotlinByteArray *)source sign:(ClientBignumSign *)sign __attribute__((swift_name("fromByteArray(source:sign:)")));
- (id<ClientBignumBigNumber>)fromUByteArraySource:(id)source sign:(ClientBignumSign *)sign __attribute__((swift_name("fromUByteArray(source:sign:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.Companion")))
@interface ClientBignumBigIntegerCompanion : ClientBase <ClientBignumBigNumberCreator, ClientBignumBigNumberUtil, ClientBignumByteArrayDeserializable>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientBignumBigIntegerCompanion *shared __attribute__((swift_name("shared")));
- (ClientBignumBigInteger *)createFromWordArrayWordArray:(id)wordArray requestedSign:(ClientBignumSign *)requestedSign __attribute__((swift_name("createFromWordArray(wordArray:requestedSign:)")));
- (ClientBignumBigInteger *)fromBigIntegerBigInteger:(ClientBignumBigInteger *)bigInteger __attribute__((swift_name("fromBigInteger(bigInteger:)")));
- (ClientBignumBigInteger *)fromByteByte:(int8_t)byte __attribute__((swift_name("fromByte(byte:)")));
- (ClientBignumBigInteger *)fromByteArraySource:(ClientKotlinByteArray *)source sign:(ClientBignumSign *)sign __attribute__((swift_name("fromByteArray(source:sign:)")));
- (ClientBignumBigInteger *)fromIntInt:(int32_t)int_ __attribute__((swift_name("fromInt(int:)")));
- (ClientBignumBigInteger *)fromLongLong:(int64_t)long_ __attribute__((swift_name("fromLong(long:)")));
- (ClientBignumBigInteger *)fromShortShort:(int16_t)short_ __attribute__((swift_name("fromShort(short:)")));
- (ClientBignumBigInteger *)fromUByteUByte:(uint8_t)uByte __attribute__((swift_name("fromUByte(uByte:)")));
- (ClientBignumBigInteger *)fromUByteArraySource:(id)source sign:(ClientBignumSign *)sign __attribute__((swift_name("fromUByteArray(source:sign:)")));
- (ClientBignumBigInteger *)fromUIntUInt:(uint32_t)uInt __attribute__((swift_name("fromUInt(uInt:)")));
- (ClientBignumBigInteger *)fromULongULong:(uint64_t)uLong __attribute__((swift_name("fromULong(uLong:)")));
- (ClientBignumBigInteger *)fromUShortUShort:(uint16_t)uShort __attribute__((swift_name("fromUShort(uShort:)")));
- (ClientBignumBigInteger *)maxFirst:(ClientBignumBigInteger *)first second:(ClientBignumBigInteger *)second __attribute__((swift_name("max(first:second:)")));
- (ClientBignumBigInteger *)minFirst:(ClientBignumBigInteger *)first second:(ClientBignumBigInteger *)second __attribute__((swift_name("min(first:second:)")));
- (ClientBignumBigInteger *)parseStringString:(NSString *)string base:(int32_t)base __attribute__((swift_name("parseString(string:base:)")));
- (ClientBignumBigInteger *)tryFromDoubleDouble:(double)double_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromDouble(double:exactRequired:)")));
- (ClientBignumBigInteger *)tryFromFloatFloat:(float)float_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromFloat(float:exactRequired:)")));
@property (readonly) double LOG_10_OF_2 __attribute__((swift_name("LOG_10_OF_2")));
@property (readonly) ClientBignumBigInteger *ONE __attribute__((swift_name("ONE")));
@property (readonly) ClientBignumBigInteger *TEN __attribute__((swift_name("TEN")));
@property (readonly) ClientBignumBigInteger *TWO __attribute__((swift_name("TWO")));
@property (readonly) ClientBignumBigInteger *ZERO __attribute__((swift_name("ZERO")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.QuotientAndRemainder")))
@interface ClientBignumBigIntegerQuotientAndRemainder : ClientBase
- (instancetype)initWithQuotient:(ClientBignumBigInteger *)quotient remainder:(ClientBignumBigInteger *)remainder __attribute__((swift_name("init(quotient:remainder:)"))) __attribute__((objc_designated_initializer));
- (ClientBignumBigIntegerQuotientAndRemainder *)doCopyQuotient:(ClientBignumBigInteger *)quotient remainder:(ClientBignumBigInteger *)remainder __attribute__((swift_name("doCopy(quotient:remainder:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientBignumBigInteger *quotient __attribute__((swift_name("quotient")));
@property (readonly) ClientBignumBigInteger *remainder __attribute__((swift_name("remainder")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumSign")))
@interface ClientBignumSign : ClientKotlinEnum<ClientBignumSign *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClientBignumSign *positive __attribute__((swift_name("positive")));
@property (class, readonly) ClientBignumSign *negative __attribute__((swift_name("negative")));
@property (class, readonly) ClientBignumSign *zero __attribute__((swift_name("zero")));
+ (ClientKotlinArray<ClientBignumSign *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClientBignumSign *> *entries __attribute__((swift_name("entries")));
- (ClientBignumSign *)not __attribute__((swift_name("not()")));
- (int32_t)toInt __attribute__((swift_name("toInt()")));
@end

__attribute__((swift_name("KotlinClosedRange")))
@protocol ClientKotlinClosedRange
@required
- (BOOL)containsValue:(id)value __attribute__((swift_name("contains(value:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
@property (readonly) id endInclusive __attribute__((swift_name("endInclusive")));
@property (readonly) id start __attribute__((swift_name("start")));
@end

__attribute__((swift_name("KotlinIterable")))
@protocol ClientKotlinIterable
@required
- (id<ClientKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.BigIntegerRange")))
@interface ClientBignumBigIntegerBigIntegerRange : ClientBase <ClientKotlinClosedRange, ClientKotlinIterable>
- (instancetype)initWithStart:(ClientBignumBigInteger *)start endInclusive:(ClientBignumBigInteger *)endInclusive __attribute__((swift_name("init(start:endInclusive:)"))) __attribute__((objc_designated_initializer));
- (id<ClientKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@property (readonly) ClientBignumBigInteger *endInclusive __attribute__((swift_name("endInclusive")));
@property (readonly) ClientBignumBigInteger *start __attribute__((swift_name("start")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.SqareRootAndRemainder")))
@interface ClientBignumBigIntegerSqareRootAndRemainder : ClientBase
- (instancetype)initWithSquareRoot:(ClientBignumBigInteger *)squareRoot remainder:(ClientBignumBigInteger *)remainder __attribute__((swift_name("init(squareRoot:remainder:)"))) __attribute__((objc_designated_initializer));
- (ClientBignumBigIntegerSqareRootAndRemainder *)doCopySquareRoot:(ClientBignumBigInteger *)squareRoot remainder:(ClientBignumBigInteger *)remainder __attribute__((swift_name("doCopy(squareRoot:remainder:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientBignumBigInteger *remainder __attribute__((swift_name("remainder")));
@property (readonly) ClientBignumBigInteger *squareRoot __attribute__((swift_name("squareRoot")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumModularBigInteger")))
@interface ClientBignumModularBigInteger : ClientBase <ClientBignumBigNumber, ClientBignumByteArraySerializable>
@property (class, readonly, getter=companion) ClientBignumModularBigIntegerCompanion *companion __attribute__((swift_name("companion")));
- (ClientBignumModularBigInteger *)abs __attribute__((swift_name("abs()")));
- (ClientBignumModularBigInteger *)addOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("add(other:)")));
- (int8_t)byteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("byteValue(exactRequired:)")));
- (int32_t)compareOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("compare(other:)")));
- (int32_t)compareToOther_:(id)other __attribute__((swift_name("compareTo(other_:)")));
- (ClientBignumModularBigInteger *)divideOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("divide(other:)")));
- (ClientKotlinPair<ClientBignumModularBigInteger *, ClientBignumModularBigInteger *> *)divideAndRemainderOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("divideAndRemainder(other:)")));
- (ClientBignumModularQuotientAndRemainder *)divremOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("divrem(other:)")));
- (double)doubleValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("doubleValue(exactRequired:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (float)floatValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("floatValue(exactRequired:)")));
- (id<ClientBignumBigNumberCreator>)getCreator __attribute__((swift_name("getCreator()")));
- (ClientBignumModularBigInteger *)getInstance __attribute__((swift_name("getInstance()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (int32_t)intValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("intValue(exactRequired:)")));
- (ClientBignumModularBigInteger *)inverse __attribute__((swift_name("inverse()")));
- (BOOL)isZero __attribute__((swift_name("isZero()")));
- (int64_t)longValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("longValue(exactRequired:)")));
- (ClientBignumModularBigInteger *)multiplyOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("multiply(other:)")));
- (ClientBignumModularBigInteger *)negate __attribute__((swift_name("negate()")));
- (int64_t)numberOfDecimalDigits __attribute__((swift_name("numberOfDecimalDigits()")));
- (ClientBignumModularBigInteger *)powExponent__:(ClientBignumBigInteger *)exponent __attribute__((swift_name("pow(exponent__:)")));
- (ClientBignumModularBigInteger *)powExponent___:(ClientBignumModularBigInteger *)exponent __attribute__((swift_name("pow(exponent___:)")));
- (ClientBignumModularBigInteger *)powExponent:(int32_t)exponent __attribute__((swift_name("pow(exponent:)")));
- (ClientBignumModularBigInteger *)powExponent_:(int64_t)exponent __attribute__((swift_name("pow(exponent_:)")));
- (ClientBignumModularBigInteger *)remOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("rem(other:)")));
- (ClientBignumModularBigInteger *)remainderOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("remainder(other:)")));
- (void)secureOverwrite __attribute__((swift_name("secureOverwrite()")));
- (int16_t)shortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("shortValue(exactRequired:)")));
- (int32_t)signum __attribute__((swift_name("signum()")));
- (ClientBignumModularBigInteger *)subtractOther:(ClientBignumModularBigInteger *)other __attribute__((swift_name("subtract(other:)")));
- (ClientBignumBigInteger *)toBigInteger __attribute__((swift_name("toBigInteger()")));
- (ClientKotlinByteArray *)toByteArray __attribute__((swift_name("toByteArray()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)toStringBase:(int32_t)base __attribute__((swift_name("toString(base:)")));
- (NSString *)toStringWithModuloBase:(int32_t)base __attribute__((swift_name("toStringWithModulo(base:)")));
- (id)toUByteArray_ __attribute__((swift_name("toUByteArray_()")));
- (uint8_t)ubyteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ubyteValue(exactRequired:)")));
- (uint32_t)uintValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("uintValue(exactRequired:)")));
- (uint64_t)ulongValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ulongValue(exactRequired:)")));
- (ClientBignumModularBigInteger *)unaryMinus __attribute__((swift_name("unaryMinus()")));
- (uint16_t)ushortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ushortValue(exactRequired:)")));
@property (readonly) ClientBignumBigInteger *modulus __attribute__((swift_name("modulus")));
@property (readonly) ClientBignumBigInteger *residue __attribute__((swift_name("residue")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesTypeValueCompanion")))
@interface ClientSecret_std_typesTypeValueCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecret_std_typesTypeValueCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeSerial0:(id<ClientKotlinx_serialization_coreKSerializer>)typeSerial0 __attribute__((swift_name("serializer(typeSerial0:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesStdSignature.Companion")))
@interface ClientSecret_std_typesStdSignatureCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecret_std_typesStdSignatureCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * [CompositeEncoder] is a part of encoding process that is bound to a particular structured part of
 * the serialized form, described by the serial descriptor passed to [Encoder.beginStructure].
 *
 * All `encode*` methods have `index` and `serialDescriptor` parameters with a strict semantics and constraints:
 *   * `descriptor` is always the same as one used in [Encoder.beginStructure]. While this parameter may seem redundant,
 *      it is required for efficient serialization process to avoid excessive field spilling.
 *      If you are writing your own format, you can safely ignore this parameter and use one used in `beginStructure`
 *      for simplicity.
 *   * `index` of the element being encoded. This element at this index in the descriptor should be associated with
 *      the one being written.
 *
 * The symmetric interface for the deserialization process is [CompositeDecoder].
 *
 * ### Not stable for inheritance
 *
 * `CompositeEncoder` interface is not stable for inheritance in 3rd party libraries, as new methods
 * might be added to this interface or contracts of the existing methods can be changed.
 */
__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol ClientKotlinx_serialization_coreCompositeEncoder
@required

/**
 * Encodes a boolean [value] associated with an element at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.BOOLEAN] kind.
 */
- (void)encodeBooleanElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));

/**
 * Encodes a single byte [value] associated with an element at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.BYTE] kind.
 */
- (void)encodeByteElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));

/**
 * Encodes a 16-bit unicode character [value] associated with an element at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.CHAR] kind.
 */
- (void)encodeCharElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));

/**
 * Encodes a 64-bit IEEE 754 floating point [value] associated with an element
 * at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.DOUBLE] kind.
 */
- (void)encodeDoubleElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));

/**
 * Encodes a 32-bit IEEE 754 floating point [value] associated with an element
 * at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.FLOAT] kind.
 */
- (void)encodeFloatElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));

/**
 * Returns [Encoder] for decoding an underlying type of a value class in an inline manner.
 * Serializable value class is described by the [child descriptor][SerialDescriptor.getElementDescriptor]
 * of given [descriptor] at [index].
 *
 * Namely, for the `@Serializable @JvmInline value class MyInt(val my: Int)`,
 * and `@Serializable class MyData(val myInt: MyInt)` the following sequence is used:
 * ```
 * thisEncoder.encodeInlineElement(MyData.serializer.descriptor, 0).encodeInt(my)
 * ```
 *
 * This method provides an opportunity for the optimization to avoid boxing of a carried value
 * and its invocation should be equivalent to the following:
 * ```
 * thisEncoder.encodeSerializableElement(MyData.serializer.descriptor, 0, MyInt.serializer(), myInt)
 * ```
 *
 * Current encoder may return any other instance of [Encoder] class, depending on provided descriptor.
 * For example, when this function is called on Json encoder with descriptor that has
 * `UInt.serializer().descriptor` at the given [index], the returned encoder is able
 * to encode unsigned integers.
 *
 * Note that this function returns [Encoder] instead of the [CompositeEncoder]
 * because value classes always have the single property.
 * Calling [Encoder.beginStructure] on returned instance leads to an unspecified behavior and, in general, is prohibited.
 *
 * @see Encoder.encodeInline
 * @see SerialDescriptor.getElementDescriptor
 */
- (id<ClientKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));

/**
 * Encodes a 32-bit integer [value] associated with an element at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.INT] kind.
 */
- (void)encodeIntElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));

/**
 * Encodes a 64-bit integer [value] associated with an element at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.LONG] kind.
 */
- (void)encodeLongElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));

/**
 * Delegates nullable [value] encoding of the type [T] to the given [serializer].
 * [value] is associated with an element at the given [index] in [serial descriptor][descriptor].
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ClientKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));

/**
 * Delegates [value] encoding of the type [T] to the given [serializer].
 * [value] is associated with an element at the given [index] in [serial descriptor][descriptor].
 */
- (void)encodeSerializableElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ClientKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));

/**
 * Encodes a 16-bit short [value] associated with an element at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.SHORT] kind.
 */
- (void)encodeShortElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));

/**
 * Encodes a string [value] associated with an element at the given [index] in [serial descriptor][descriptor].
 * The element at the given [index] should have [PrimitiveKind.STRING] kind.
 */
- (void)encodeStringElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));

/**
 * Denotes the end of the structure associated with current encoder.
 * For example, composite encoder of JSON format will write
 * a closing bracket in the underlying input and reduce the number of nesting for pretty printing.
 */
- (void)endStructureDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * Whether the format should encode values that are equal to the default values.
 * This method is used by plugin-generated serializers for properties with default values:
 * ```
 * @Serializable
 * class WithDefault(val int: Int = 42)
 * // serialize method
 * if (value.int != 42 || output.shouldEncodeElementDefault(serialDesc, 0)) {
 *    encoder.encodeIntElement(serialDesc, 0, value.int);
 * }
 * ```
 *
 * This method is never invoked for properties annotated with [EncodeDefault].
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));

/**
 * Context of the current serialization process, including contextual and polymorphic serialization and,
 * potentially, a format-specific configuration.
 */
@property (readonly) ClientKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end


/**
 * [SerializersModule] is a collection of serializers used by [ContextualSerializer] and [PolymorphicSerializer]
 * to override or provide serializers at the runtime, whereas at the compile-time they provided by the serialization plugin.
 * It can be considered as a map where serializers can be found using their statically known KClasses.
 *
 * To enable runtime serializers resolution, one of the special annotations must be used on target types
 * ([Polymorphic] or [Contextual]), and a serial module with serializers should be used during construction of [SerialFormat].
 *
 * Serializers module can be built with `SerializersModule {}` builder function.
 * Empty module can be obtained with `EmptySerializersModule()` factory function.
 *
 * @see Contextual
 * @see Polymorphic
 */
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface ClientKotlinx_serialization_coreSerializersModule : ClientBase

/**
 * Copies contents of this module to the given [collector].
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)dumpToCollector:(id<ClientKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));

/**
 * Returns a contextual serializer associated with a given [kClass].
 * If given class has generic parameters and module has provider for [kClass],
 * [typeArgumentsSerializers] are used to create serializer.
 * This method is used in context-sensitive operations on a property marked with [Contextual] by a [ContextualSerializer].
 *
 * @see SerializersModuleBuilder.contextual
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ClientKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<ClientKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));

/**
 * Returns a polymorphic serializer registered for a class of the given [value] in the scope of [baseClass].
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ClientKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ClientKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));

/**
 * Returns a polymorphic deserializer registered for a [serializedClassName] in the scope of [baseClass]
 * or default value constructed from [serializedClassName] if a default serializer provider was registered.
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ClientKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ClientKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end

__attribute__((swift_name("KotlinAnnotation")))
@protocol ClientKotlinAnnotation
@required
@end


/**
 * Serial kind is an intrinsic property of [SerialDescriptor] that indicates how
 * the corresponding type is structurally represented by its serializer.
 *
 * Kind is used by serialization formats to determine how exactly the given type
 * should be serialized. For example, JSON format detects the kind of the value and,
 * depending on that, may write it as a plain value for primitive kinds, open a
 * curly brace '{' for class-like structures and square bracket '[' for list- and array- like structures.
 *
 * Kinds are used both during serialization, to serialize a value properly and statically, and
 * to introspect the type structure or build serialization schema.
 *
 * Kind should match the structure of the serialized form, not the structure of the corresponding Kotlin class.
 * Meaning that if serializable class `class IntPair(val left: Int, val right: Int)` is represented by the serializer
 * as a single `Long` value, its descriptor should have [PrimitiveKind.LONG] without nested elements even though the class itself
 * represents a structure with two primitive fields.
 */
__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface ClientKotlinx_serialization_coreSerialKind : ClientBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end


/**
 * [CompositeDecoder] is a part of decoding process that is bound to a particular structured part of
 * the serialized form, described by the serial descriptor passed to [Decoder.beginStructure].
 *
 * Typically, for unordered data, [CompositeDecoder] is used by a serializer withing a [decodeElementIndex]-based
 * loop that decodes all the required data one-by-one in any order and then terminates by calling [endStructure].
 * Please refer to [decodeElementIndex] for example of such loop.
 *
 * All `decode*` methods have `index` and `serialDescriptor` parameters with a strict semantics and constraints:
 *   * `descriptor` argument is always the same as one used in [Decoder.beginStructure].
 *   * `index` of the element being decoded. For [sequential][decodeSequentially] decoding, it is always a monotonic
 *      sequence from `0` to `descriptor.elementsCount` and for indexing-loop it is always an index that [decodeElementIndex]
 *      has returned from the last call.
 *
 * The symmetric interface for the serialization process is [CompositeEncoder].
 *
 * ### Not stable for inheritance
 *
 * `CompositeDecoder` interface is not stable for inheritance in 3rd party libraries, as new methods
 * might be added to this interface or contracts of the existing methods can be changed.
 */
__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol ClientKotlinx_serialization_coreCompositeDecoder
@required

/**
 * Decodes a boolean value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.BOOLEAN] kind.
 */
- (BOOL)decodeBooleanElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));

/**
 * Decodes a single byte value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.BYTE] kind.
 */
- (int8_t)decodeByteElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));

/**
 * Decodes a 16-bit unicode character value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.CHAR] kind.
 */
- (unichar)decodeCharElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));

/**
 * Method to decode collection size that may be called before the collection decoding.
 * Collection type includes [Collection], [Map] and [Array] (including primitive arrays).
 * Method can return `-1` if the size is not known in advance, though for [sequential decoding][decodeSequentially]
 * knowing precise size is a mandatory requirement.
 */
- (int32_t)decodeCollectionSizeDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));

/**
 * Decodes a 64-bit IEEE 754 floating point value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.DOUBLE] kind.
 */
- (double)decodeDoubleElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));

/**
 *  Decodes the index of the next element to be decoded.
 *  Index represents a position of the current element in the serial descriptor element that can be found
 *  with [SerialDescriptor.getElementIndex].
 *
 *  If this method returns non-negative index, the caller should call one of the `decode*Element` methods
 *  with a resulting index.
 *  Apart from positive values, this method can return [DECODE_DONE] to indicate that no more elements
 *  are left or [UNKNOWN_NAME] to indicate that symbol with an unknown name was encountered.
 *
 * Example of usage:
 * ```
 * class MyPair(i: Int, d: Double)
 *
 * object MyPairSerializer : KSerializer<MyPair> {
 *     // ... other methods omitted
 *
 *    fun deserialize(decoder: Decoder): MyPair {
 *        val composite = decoder.beginStructure(descriptor)
 *        var i: Int? = null
 *        var d: Double? = null
 *        while (true) {
 *            when (val index = composite.decodeElementIndex(descriptor)) {
 *                0 -> i = composite.decodeIntElement(descriptor, 0)
 *                1 -> d = composite.decodeDoubleElement(descriptor, 1)
 *                DECODE_DONE -> break // Input is over
 *                else -> error("Unexpected index: $index)
 *            }
 *        }
 *        composite.endStructure(descriptor)
 *        require(i != null && d != null)
 *        return MyPair(i, d)
 *    }
 * }
 * ```
 * This example is a rough equivalent of what serialization plugin generates for serializable pair class.
 *
 * The need in such a loop comes from unstructured nature of most serialization formats.
 * For example, JSON for the following input `{"d": 2.0, "i": 1}`, will first read `d` key with index `1`
 * and only after `i` with the index `0`.
 *
 * A potential implementation of this method for JSON format can be the following:
 * ```
 * fun decodeElementIndex(descriptor: SerialDescriptor): Int {
 *     // Ignore arrays
 *     val nextKey: String? = myStringJsonParser.nextKey()
 *     if (nextKey == null) return DECODE_DONE
 *     return descriptor.getElementIndex(nextKey) // getElementIndex can return UNKNOWN_NAME
 * }
 * ```
 *
 * If [decodeSequentially] returns `true`, the caller might skip calling this method.
 */
- (int32_t)decodeElementIndexDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));

/**
 * Decodes a 32-bit IEEE 754 floating point value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.FLOAT] kind.
 */
- (float)decodeFloatElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));

/**
 * Returns [Decoder] for decoding an underlying type of a value class in an inline manner.
 * Serializable value class is described by the [child descriptor][SerialDescriptor.getElementDescriptor]
 * of given [descriptor] at [index].
 *
 * Namely, for the `@Serializable @JvmInline value class MyInt(val my: Int)`,
 * and `@Serializable class MyData(val myInt: MyInt)` the following sequence is used:
 * ```
 * thisDecoder.decodeInlineElement(MyData.serializer().descriptor, 0).decodeInt()
 * ```
 *
 * This method provides an opportunity for the optimization to avoid boxing of a carried value
 * and its invocation should be equivalent to the following:
 * ```
 * thisDecoder.decodeSerializableElement(MyData.serializer.descriptor, 0, MyInt.serializer())
 * ```
 *
 * Current decoder may return any other instance of [Decoder] class, depending on the provided descriptor.
 * For example, when this function is called on `Json` decoder with descriptor that has
 * `UInt.serializer().descriptor` at the given [index], the returned decoder is able
 * to decode unsigned integers.
 *
 * Note that this function returns [Decoder] instead of the [CompositeDecoder]
 * because value classes always have the single property.
 * Calling [Decoder.beginStructure] on returned instance leads to an unspecified behavior and, in general, is prohibited.
 *
 * @see Decoder.decodeInline
 * @see SerialDescriptor.getElementDescriptor
 */
- (id<ClientKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));

/**
 * Decodes a 32-bit integer value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.INT] kind.
 */
- (int32_t)decodeIntElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));

/**
 * Decodes a 64-bit integer value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.LONG] kind.
 */
- (int64_t)decodeLongElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));

/**
 * Decodes nullable value of the type [T] with the given [deserializer].
 *
 * If value at given [index] was already decoded with previous [decodeSerializableElement] call with the same index,
 * [previousValue] would contain a previously decoded value.
 * This parameter can be used to aggregate multiple values of the given property to the only one.
 * Implementation can safely ignore it and return a new value, efficiently using 'the last one wins' strategy,
 * or apply format-specific aggregating strategies, e.g. appending scattered Protobuf lists to a single one.
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ClientKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * Checks whether the current decoder supports strictly ordered decoding of the data
 * without calling to [decodeElementIndex].
 * If the method returns `true`, the caller might skip [decodeElementIndex] calls
 * and start invoking `decode*Element` directly, incrementing the index of the element one by one.
 * This method can be called by serializers (either generated or user-defined) as a performance optimization,
 * but there is no guarantee that the method will be ever called. Practically, it means that implementations
 * that may benefit from sequential decoding should also support a regular [decodeElementIndex]-based decoding as well.
 *
 * Example of usage:
 * ```
 * class MyPair(i: Int, d: Double)
 *
 * object MyPairSerializer : KSerializer<MyPair> {
 *     // ... other methods omitted
 *
 *    fun deserialize(decoder: Decoder): MyPair {
 *        val composite = decoder.beginStructure(descriptor)
 *        if (composite.decodeSequentially()) {
 *            val i = composite.decodeIntElement(descriptor, index = 0) // Mind the sequential indexing
 *            val d = composite.decodeIntElement(descriptor, index = 1)
 *            composite.endStructure(descriptor)
 *            return MyPair(i, d)
 *        } else {
 *            // Fallback to `decodeElementIndex` loop, refer to its documentation for details
 *        }
 *    }
 * }
 * ```
 * This example is a rough equivalent of what serialization plugin generates for serializable pair class.
 *
 * Sequential decoding is a performance optimization for formats with strictly ordered schema,
 * usually binary ones. Regular formats such as JSON or ProtoBuf cannot use this optimization,
 * because e.g. in the latter example, the same data can be represented both as
 * `{"i": 1, "d": 1.0}` and `{"d": 1.0, "i": 1}` (thus, unordered).
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));

/**
 * Decodes value of the type [T] with the given [deserializer].
 *
 * Implementations of [CompositeDecoder] may use their format-specific deserializers
 * for particular data types, e.g. handle [ByteArray] specifically if format is binary.
 *
 * If value at given [index] was already decoded with previous [decodeSerializableElement] call with the same index,
 * [previousValue] would contain a previously decoded value.
 * This parameter can be used to aggregate multiple values of the given property to the only one.
 * Implementation can safely ignore it and return a new value, effectively using 'the last one wins' strategy,
 * or apply format-specific aggregating strategies, e.g. appending scattered Protobuf lists to a single one.
 */
- (id _Nullable)decodeSerializableElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ClientKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * Decodes a 16-bit short value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.SHORT] kind.
 */
- (int16_t)decodeShortElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));

/**
 * Decodes a string value from the underlying input.
 * The resulting value is associated with the [descriptor] element at the given [index].
 * The element at the given index should have [PrimitiveKind.STRING] kind.
 */
- (NSString *)decodeStringElementDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));

/**
 * Denotes the end of the structure associated with current decoder.
 * For example, composite decoder of JSON format will expect (and parse)
 * a closing bracket in the underlying input.
 */
- (void)endStructureDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * Context of the current decoding process, including contextual and polymorphic serialization and,
 * potentially, a format-specific configuration.
 */
@property (readonly) ClientKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface ClientKotlinNothing : ClientBase
@end


/**
 * Class representing single JSON element.
 * Can be [JsonPrimitive], [JsonArray] or [JsonObject].
 *
 * [JsonElement.toString] properly prints JSON tree as valid JSON, taking into account quoted values and primitives.
 * Whole hierarchy is serializable, but only when used with [Json] as [JsonElement] is purely JSON-specific structure
 * which has a meaningful schemaless semantics only for JSON.
 *
 * The whole hierarchy is [serializable][Serializable] only by [Json] format.
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement.Companion")))
@interface ClientKotlinx_serialization_jsonJsonElementCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));

/**
 * Class representing single JSON element.
 * Can be [JsonPrimitive], [JsonArray] or [JsonObject].
 *
 * [JsonElement.toString] properly prints JSON tree as valid JSON, taking into account quoted values and primitives.
 * Whole hierarchy is serializable, but only when used with [Json] as [JsonElement] is purely JSON-specific structure
 * which has a meaningful schemaless semantics only for JSON.
 *
 * The whole hierarchy is [serializable][Serializable] only by [Json] format.
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientKotlinx_serialization_jsonJsonElementCompanion *shared __attribute__((swift_name("shared")));

/**
 * Class representing single JSON element.
 * Can be [JsonPrimitive], [JsonArray] or [JsonObject].
 *
 * [JsonElement.toString] properly prints JSON tree as valid JSON, taking into account quoted values and primitives.
 * Whole hierarchy is serializable, but only when used with [Json] as [JsonElement] is purely JSON-specific structure
 * which has a meaningful schemaless semantics only for JSON.
 *
 * The whole hierarchy is [serializable][Serializable] only by [Json] format.
 */
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPubKey.Companion")))
@interface ClientSecret_std_typesPubKeyCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecret_std_typesPubKeyCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(ClientKotlinArray<id<ClientKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end

__attribute__((swift_name("KotlinCharIterator")))
@interface ClientKotlinCharIterator : ClientBase <ClientKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id)next __attribute__((swift_name("next()")));
- (unichar)nextChar __attribute__((swift_name("nextChar()")));
@end


/**
 * The default instance of [Json] with default configuration.
 *
 * Example of usage:
 * ```
 * @Serializable
 * class Project(val name: String, val language: String)
 *
 * val data = Project("kotlinx.serialization", "Kotlin")
 * // Prints {"name":"kotlinx.serialization","language":"Kotlin"}
 * println(Json.encodeToString(data))
 * ```
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJson.Default")))
@interface ClientKotlinx_serialization_jsonJsonDefault : ClientKotlinx_serialization_jsonJson
+ (instancetype)alloc __attribute__((unavailable));

/**
 * The default instance of [Json] with default configuration.
 *
 * Example of usage:
 * ```
 * @Serializable
 * class Project(val name: String, val language: String)
 *
 * val data = Project("kotlinx.serialization", "Kotlin")
 * // Prints {"name":"kotlinx.serialization","language":"Kotlin"}
 * println(Json.encodeToString(data))
 * ```
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)default_ __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientKotlinx_serialization_jsonJsonDefault *shared __attribute__((swift_name("shared")));
@end


/**
 * Configuration of the current [Json] instance available through [Json.configuration]
 * and configured with [JsonBuilder] constructor.
 *
 * Can be used for debug purposes and for custom Json-specific serializers
 * via [JsonEncoder] and [JsonDecoder].
 *
 * Standalone configuration object is meaningless and can nor be used outside the
 * [Json], neither new [Json] instance can be created from it.
 *
 * Detailed description of each property is available in [JsonBuilder] class.
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJsonConfiguration")))
@interface ClientKotlinx_serialization_jsonJsonConfiguration : ClientBase

/** @suppress Dokka **/
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL allowComments __attribute__((swift_name("allowComments")));
@property (readonly) BOOL allowSpecialFloatingPointValues __attribute__((swift_name("allowSpecialFloatingPointValues")));
@property (readonly) BOOL allowStructuredMapKeys __attribute__((swift_name("allowStructuredMapKeys")));
@property (readonly) BOOL allowTrailingComma __attribute__((swift_name("allowTrailingComma")));
@property (readonly) NSString *classDiscriminator __attribute__((swift_name("classDiscriminator")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property ClientKotlinx_serialization_jsonClassDiscriminatorMode *classDiscriminatorMode __attribute__((swift_name("classDiscriminatorMode")));
@property (readonly) BOOL coerceInputValues __attribute__((swift_name("coerceInputValues")));
@property (readonly) BOOL decodeEnumsCaseInsensitive __attribute__((swift_name("decodeEnumsCaseInsensitive")));
@property (readonly) BOOL encodeDefaults __attribute__((swift_name("encodeDefaults")));
@property (readonly) BOOL explicitNulls __attribute__((swift_name("explicitNulls")));
@property (readonly) BOOL ignoreUnknownKeys __attribute__((swift_name("ignoreUnknownKeys")));
@property (readonly) BOOL isLenient __attribute__((swift_name("isLenient")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) id<ClientKotlinx_serialization_jsonJsonNamingStrategy> _Nullable namingStrategy __attribute__((swift_name("namingStrategy")));
@property (readonly) BOOL prettyPrint __attribute__((swift_name("prettyPrint")));
@property (readonly) NSString *prettyPrintIndent __attribute__((swift_name("prettyPrintIndent")));
@property (readonly) BOOL useAlternativeNames __attribute__((swift_name("useAlternativeNames")));
@property (readonly) BOOL useArrayPolymorphism __attribute__((swift_name("useArrayPolymorphism")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPubKeySecp256k1.Companion")))
@interface ClientSecret_std_typesPubKeySecp256k1Companion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecret_std_typesPubKeySecp256k1Companion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Secret_std_typesPermit.ParamsCompanion")))
@interface ClientSecret_std_typesPermitParamsCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientSecret_std_typesPermitParamsCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumModularBigInteger.Companion")))
@interface ClientBignumModularBigIntegerCompanion : ClientBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ClientBignumModularBigIntegerCompanion *shared __attribute__((swift_name("shared")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo:(ClientBignumBigInteger *)modulo __attribute__((swift_name("creatorForModulo(modulo:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo_:(int8_t)modulo __attribute__((swift_name("creatorForModulo(modulo_:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo__:(int32_t)modulo __attribute__((swift_name("creatorForModulo(modulo__:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo___:(int64_t)modulo __attribute__((swift_name("creatorForModulo(modulo___:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo____:(int16_t)modulo __attribute__((swift_name("creatorForModulo(modulo____:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo_____:(uint8_t)modulo __attribute__((swift_name("creatorForModulo(modulo_____:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo______:(uint32_t)modulo __attribute__((swift_name("creatorForModulo(modulo______:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo_______:(uint64_t)modulo __attribute__((swift_name("creatorForModulo(modulo_______:)")));
- (id<ClientBignumBigNumberCreator>)creatorForModuloModulo________:(uint16_t)modulo __attribute__((swift_name("creatorForModulo(modulo________:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumModularQuotientAndRemainder")))
@interface ClientBignumModularQuotientAndRemainder : ClientBase
- (instancetype)initWithQuotient:(ClientBignumModularBigInteger *)quotient remainder:(ClientBignumModularBigInteger *)remainder __attribute__((swift_name("init(quotient:remainder:)"))) __attribute__((objc_designated_initializer));
- (ClientBignumModularQuotientAndRemainder *)doCopyQuotient:(ClientBignumModularBigInteger *)quotient remainder:(ClientBignumModularBigInteger *)remainder __attribute__((swift_name("doCopy(quotient:remainder:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ClientBignumModularBigInteger *quotient __attribute__((swift_name("quotient")));
@property (readonly) ClientBignumModularBigInteger *remainder __attribute__((swift_name("remainder")));
@end


/**
 * [SerializersModuleCollector] can introspect and accumulate content of any [SerializersModule] via [SerializersModule.dumpTo],
 * using a visitor-like pattern: [contextual] and [polymorphic] functions are invoked for each registered serializer.
 *
 * ### Not stable for inheritance
 *
 * `SerializersModuleCollector` interface is not stable for inheritance in 3rd party libraries, as new methods
 * might be added to this interface or contracts of the existing methods can be changed.
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol ClientKotlinx_serialization_coreSerializersModuleCollector
@required

/**
 * Accept a provider, associated with generic [kClass] for contextual serialization.
 */
- (void)contextualKClass:(id<ClientKotlinKClass>)kClass provider:(id<ClientKotlinx_serialization_coreKSerializer> (^)(NSArray<id<ClientKotlinx_serialization_coreKSerializer>> *typeArgumentsSerializers))provider __attribute__((swift_name("contextual(kClass:provider:)")));

/**
 * Accept a serializer, associated with [kClass] for contextual serialization.
 */
- (void)contextualKClass:(id<ClientKotlinKClass>)kClass serializer:(id<ClientKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));

/**
 * Accept a serializer, associated with [actualClass] for polymorphic serialization.
 */
- (void)polymorphicBaseClass:(id<ClientKotlinKClass>)baseClass actualClass:(id<ClientKotlinKClass>)actualClass actualSerializer:(id<ClientKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));

/**
 * Accept a default deserializer provider, associated with the [baseClass] for polymorphic deserialization.
 *
 * This function affect only deserialization process. To avoid confusion, it was deprecated and replaced with [polymorphicDefaultDeserializer].
 * To affect serialization process, use [SerializersModuleCollector.polymorphicDefaultSerializer].
 *
 * [defaultDeserializerProvider] is invoked when no polymorphic serializers associated with the `className`
 * in the scope of [baseClass] were found. `className` could be `null` for formats that support nullable class discriminators
 * (currently only `Json` with `useArrayPolymorphism` set to `false`).
 *
 * [defaultDeserializerProvider] can be stateful and lookup a serializer for the missing type dynamically.
 *
 * @see SerializersModuleCollector.polymorphicDefaultDeserializer
 * @see SerializersModuleCollector.polymorphicDefaultSerializer
 */
- (void)polymorphicDefaultBaseClass:(id<ClientKotlinKClass>)baseClass defaultDeserializerProvider:(id<ClientKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable className))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)"))) __attribute__((deprecated("Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer")));

/**
 * Accept a default deserializer provider, associated with the [baseClass] for polymorphic deserialization.
 * [defaultDeserializerProvider] is invoked when no polymorphic serializers associated with the `className`
 * in the scope of [baseClass] were found. `className` could be `null` for formats that support nullable class discriminators
 * (currently only `Json` with `useArrayPolymorphism` set to `false`).
 *
 * Default deserializers provider affects only deserialization process. Serializers are accepted in the
 * [SerializersModuleCollector.polymorphicDefaultSerializer] method.
 *
 * [defaultDeserializerProvider] can be stateful and lookup a serializer for the missing type dynamically.
 */
- (void)polymorphicDefaultDeserializerBaseClass:(id<ClientKotlinKClass>)baseClass defaultDeserializerProvider:(id<ClientKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable className))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));

/**
 * Accept a default serializer provider, associated with the [baseClass] for polymorphic serialization.
 * [defaultSerializerProvider] is invoked when no polymorphic serializers for `value` in the scope of [baseClass] were found.
 *
 * Default serializers provider affects only serialization process. Deserializers are accepted in the
 * [SerializersModuleCollector.polymorphicDefaultDeserializer] method.
 *
 * [defaultSerializerProvider] can be stateful and lookup a serializer for the missing type dynamically.
 */
- (void)polymorphicDefaultSerializerBaseClass:(id<ClientKotlinKClass>)baseClass defaultSerializerProvider:(id<ClientKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id value))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end


/**
 * Defines which classes and objects should have their serial name included in the json as so-called class discriminator.
 *
 * Class discriminator is a JSON field added by kotlinx.serialization that has [JsonBuilder.classDiscriminator] as a key (`type` by default),
 * and class' serial name as a value (fully qualified name by default, can be changed with [SerialName] annotation).
 *
 * Class discriminator is important for serializing and deserializing [polymorphic class hierarchies](https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/polymorphism.md#sealed-classes).
 * Default [ClassDiscriminatorMode.POLYMORPHIC] mode adds discriminator only to polymorphic classes.
 * This behavior can be changed to match various JSON schemas.
 *
 * @see JsonBuilder.classDiscriminator
 * @see JsonBuilder.classDiscriminatorMode
 * @see Polymorphic
 * @see PolymorphicSerializer
 */
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonClassDiscriminatorMode")))
@interface ClientKotlinx_serialization_jsonClassDiscriminatorMode : ClientKotlinEnum<ClientKotlinx_serialization_jsonClassDiscriminatorMode *>
+ (instancetype)alloc __attribute__((unavailable));

/**
 * Defines which classes and objects should have their serial name included in the json as so-called class discriminator.
 *
 * Class discriminator is a JSON field added by kotlinx.serialization that has [JsonBuilder.classDiscriminator] as a key (`type` by default),
 * and class' serial name as a value (fully qualified name by default, can be changed with [SerialName] annotation).
 *
 * Class discriminator is important for serializing and deserializing [polymorphic class hierarchies](https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/polymorphism.md#sealed-classes).
 * Default [ClassDiscriminatorMode.POLYMORPHIC] mode adds discriminator only to polymorphic classes.
 * This behavior can be changed to match various JSON schemas.
 *
 * @see JsonBuilder.classDiscriminator
 * @see JsonBuilder.classDiscriminatorMode
 * @see Polymorphic
 * @see PolymorphicSerializer
 */
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ClientKotlinx_serialization_jsonClassDiscriminatorMode *none __attribute__((swift_name("none")));
@property (class, readonly) ClientKotlinx_serialization_jsonClassDiscriminatorMode *allJsonObjects __attribute__((swift_name("allJsonObjects")));
@property (class, readonly) ClientKotlinx_serialization_jsonClassDiscriminatorMode *polymorphic __attribute__((swift_name("polymorphic")));
+ (ClientKotlinArray<ClientKotlinx_serialization_jsonClassDiscriminatorMode *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ClientKotlinx_serialization_jsonClassDiscriminatorMode *> *entries __attribute__((swift_name("entries")));
@end


/**
 * Represents naming strategy — a transformer for serial names in a [Json] format.
 * Transformed serial names are used for both serialization and deserialization.
 * A naming strategy is always applied globally in the Json configuration builder
 * (see [JsonBuilder.namingStrategy]).
 *
 * Actual transformation happens in the [serialNameForJson] function.
 * It is possible to apply additional filtering inside the transformer using the `descriptor` parameter in [serialNameForJson].
 *
 * Original serial names are never used after transformation, so they are ignored in a Json input.
 * If the original serial name is present in the Json input but transformed is not,
 * [MissingFieldException] still would be thrown. If one wants to preserve the original serial name for deserialization,
 * one should use the [JsonNames] annotation, as its values are not transformed.
 *
 * ### Common pitfalls in conjunction with other Json features
 *
 * * Due to the nature of kotlinx.serialization framework, naming strategy transformation is applied to all properties regardless
 * of whether their serial name was taken from the property name or provided by @[SerialName] annotation.
 * Effectively, it means one cannot avoid transformation by explicitly specifying the serial name.
 *
 * * Collision of the transformed name with any other (transformed) properties serial names or any alternative names
 * specified with [JsonNames] will lead to a deserialization exception.
 *
 * * Naming strategies do not transform serial names of the types used for the polymorphism, as they always should be specified explicitly.
 * Values from [JsonClassDiscriminator] or global [JsonBuilder.classDiscriminator] also are not altered.
 *
 * ### Controversy about using global naming strategies
 *
 * Global naming strategies have one key trait that makes them a debatable and controversial topic:
 * They are very implicit. It means that by looking only at the definition of the class,
 * it is impossible to say which names it will have in the serialized form.
 * As a consequence, naming strategies are not friendly to refactorings. Programmer renaming `myId` to `userId` may forget
 * to rename `my_id`, and vice versa. Generally, any tools one can imagine work poorly with global naming strategies:
 * Find Usages/Rename in IDE, full-text search by grep, etc. For them, the original name and the transformed are two different things;
 * changing one without the other may introduce bugs in many unexpected ways.
 * The lack of a single place of definition, the inability to use automated tools, and more error-prone code lead
 * to greater maintenance efforts for code with global naming strategies.
 * However, there are cases where usage of naming strategies is inevitable, such as interop with an existing API or migrating a large codebase.
 * Therefore, one should carefully weigh the pros and cons before considering adding global naming strategies to an application.
 *
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_jsonJsonNamingStrategy")))
@protocol ClientKotlinx_serialization_jsonJsonNamingStrategy
@required

/**
 * Accepts an original [serialName] (defined by property name in the class or [SerialName] annotation) and returns
 * a transformed serial name which should be used for serialization and deserialization.
 *
 * Besides string manipulation operations, it is also possible to implement transformations that depend on the [descriptor]
 * and its element (defined by [elementIndex]) currently being serialized.
 * It is guaranteed that `descriptor.getElementName(elementIndex) == serialName`.
 * For example, one can choose different transformations depending on [SerialInfo]
 * annotations (see [SerialDescriptor.getElementAnnotations]) or element optionality (see [SerialDescriptor.isElementOptional]).
 *
 * Note that invocations of this function are cached for performance reasons.
 * Caching strategy is an implementation detail and should not be assumed as a part of the public API contract, as it may be changed in future releases.
 * Therefore, it is essential for this function to be pure: it should not have any side effects, and it should
 * return the same String for a given [descriptor], [elementIndex], and [serialName], regardless of the number of invocations.
 */
- (NSString *)serialNameForJsonDescriptor:(id<ClientKotlinx_serialization_coreSerialDescriptor>)descriptor elementIndex:(int32_t)elementIndex serialName:(NSString *)serialName __attribute__((swift_name("serialNameForJson(descriptor:elementIndex:serialName:)")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
