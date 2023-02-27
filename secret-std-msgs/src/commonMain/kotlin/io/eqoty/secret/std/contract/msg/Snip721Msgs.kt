package io.eqoty.secret.std.contract.msg

import io.eqoty.secretk.types.extensions.Permit
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline


object Snip721Msgs {
    @Serializable
    data class Instantiate(
        val name: String,
        val symbol: String,
        val admin: String? = null,
        val entropy: String,
    )

    @Serializable
    data class SerialNumber(
        @SerialName("mint_run")
        val mintRun: UInt? = null,
        @SerialName("serial_number")
        val serialNumber: UInt,
        @SerialName("quantity_minted_this_run")
        val quantityMintedThisRun: UInt? = null,
    )

    @Serializable
    data class Metadata(
        @SerialName("token_uri") val tokenUri: String? = null,
        val extension: Extension? = null
    ) {
        @Serializable
        data class Extension(
            /// url to the image
            val image: String? = null,
            /// raw SVG image data (not recommended). Only use this if you're not including the image parameter
            @SerialName("image_data")
            val imageData: String? = null,
            /// url to allow users to view the item on your site
            @SerialName("external_url")
            val externalUrl: String? = null,
            /// item description
            val description: String? = null,
            /// name of the item
            val name: String? = null,
            /// item attributes
            val attributes: List<Trait>? = null,
            /// background color represented as a six-character hexadecimal without a pre-pended #
            @SerialName("background_color")
            val backgroundColor: String? = null,
            /// url to a multimedia attachment
            @SerialName("animation_url")
            val animationUrl: String? = null,
            /// url to a YouTube video
            @SerialName("youtube_url")
            val youtubeUrl: String? = null,
            /// media files as specified on Stashh that allows for basic authenticatiion and decryption keys.
            /// Most of the above is used for bridging public eth NFT metadata easily, whereas `media` will be used
            /// when minting NFTs on Stashh
            val media: List<MediaFile>? = null,
            /// a select list of trait_types that are in the private metadata.  This will only ever be used
            /// in public metadata
            @SerialName("protected_attributes")
            val protectedAttributes: List<String>? = null,
            /// token subtypes used by Stashh for display groupings (primarily used for badges, which are specified
            /// by using "badge" as the token_subtype)
            @SerialName("token_subtype")
            val tokenSubtype: String? = null,
        )

        @Serializable
        data class Trait(
            /// indicates how a trait should be displayed
            @SerialName("display_type")
            val displayType: String? = null,
            /// name of the trait
            @SerialName("trait_type")
            val traitType: String? = null,
            /// trait value
            val value: String,
            /// optional max value for numerical traits
            @SerialName("max_value")
            val maxValue: String? = null,
        )

        @Serializable
        data class MediaFile(
            /// file type
            /// Stashh currently uses: "image", "video", "audio", "text", "font", "application"
            @SerialName("file_type")
            val fileType: String? = null,
            /// file extension
            val extension: String? = null,
            /// authentication information
            val authentication: Authentication? = null,
            /// url to the file.  Urls should be prefixed with `http://`, `https://`, `ipfs://`, or `ar://`
            val url: String,
        ) {
            @Serializable
            data class Authentication(
                /// either a decryption key for encrypted files or a password for basic authentication
                val key: String? = null,
                /// username used in basic authentication
                val user: String? = null,
            )
        }

    }

    @Serializable
    data class RoyaltyInfo(
        @SerialName("decimal_places_in_rates")
        val decimalPlacesInRates: UByte,
        val royalties: List<Royalty>,
    )

    @Serializable
    data class Royalty(
        val recipient: String,
        val rate: UShort,
    )

    /// display for a single royalty
    @Serializable
    data class DisplayRoyalty(
        /// address to send royalties to.  Can be None to keep addresses private
        val recipient: String?,
        /// royalty rate
        val rate: UShort,
    )

    @Serializable
    data class DisplayRoyaltyInfo(
        /// decimal places in royalty rates
        @SerialName("decimal_places_in_rates")
        val decimalPlacesInRates: UByte,
        /// list of royalties
        val royalties: List<DisplayRoyalty>,
    )

    @Serializable
    data class MintRunInfo(
        /// optional address of the SNIP-721 contract creator
        @SerialName("collection_creator")
        val collectionCreator: String?,
        /// optional address of this NFT's creator
        @SerialName("token_creator")
        val tokenCreator: String?,
        /// optional time of minting (in seconds since 01/01/1970)
        @SerialName("time_of_minting")
        val timeOfMinting: ULong?,
        /// optional number of the mint run this token was minted in.  A mint run represents a
        /// batch of NFTs released at the same time.  So if a creator decided to make 100 copies
        /// of an NFT, they would all be part of mint run number 1.  If they sold quickly, and
        /// the creator wanted to rerelease that NFT, he could make 100 more copies which would all
        /// be part of mint run number 2.
        @SerialName("mint_run")
        val mintRun: UInt?,
        /// optional serial number in this mint run.  This is used to serialize
        /// identical NFTs
        @SerialName("serial_number")
        val serialNumber: UInt?,
        /// optional total number of NFTs minted on this run.  This is used to
        /// represent that this token is number m of n
        @SerialName("quantity_minted_this_run")
        val quantityMintedThisRun: UInt?,
    )

    @Serializable
    sealed interface Expiration {
        @Serializable
        data class AtHeight(
            /// expires at this block height
            @SerialName("at_height") val atHeight: ULong? = null,
        ) : Expiration

        @Serializable
        data class AtTime(
            /// expires at the time in seconds since 01/01/1970
            @SerialName("at_time") val atTime: ULong? = null,
        ) : Expiration

        @JvmInline
        @Serializable
        value class ExpirationNever(private val never: String) : Expiration
    }


    @Serializable
    data class Snip721Approval(
        /// whitelisted address
        val address: String,
//        https://github.com/Kotlin/kotlinx.serialization/issues/2049
//        /// optional expiration if the address has view owner permission
//        @SerialName("view_owner_expiration")
//        val viewOwnerExpiration: Expiration? = null,
//            https://github.com/Kotlin/kotlinx.serialization/issues/2049
        /// optional expiration if the address has view private metadata permission
//        @SerialName("view_private_metadata_expiration")
//        val viewPrivateMetadataExpiration: Expiration? = null,
//            https://github.com/Kotlin/kotlinx.serialization/issues/2049
//        /// optional expiration if the address has transfer permission
//        @SerialName("transfer_expiration")
//        val transferExpiration: Expiration? = null,
    )


    @Serializable
    data class ViewerInfo(
        /// querying address
        val address: String,
        /// authentication key string
        @SerialName("viewing_key") val viewingKey: String,
    )

    @Serializable
    data class Tx(
        /// tx id
        @SerialName("tx_id") val txId: ULong,
        /// the block containing this tx
        @SerialName("block_height") val blockHeight: ULong,
        /// the time (in seconds since 01/01/1970) of the block containing this tx
        @SerialName("block_time") val blockTime: ULong,
        /// token id
        @SerialName("token_id") val tokenId: String,
        /// tx type and specifics
        val action: TxAction,
        /// optional memo
        val memo: String?,
    )

    @Serializable
    data class TxAction(
        val transfer: Transfer? = null,
        val mint: Mint? = null,
        val burn: Burn? = null,
    ) {

        @Serializable
        data class Transfer(
            /// previous owner
            val from: String,
            /// optional sender if not owner
            val sender: String?,
            /// new owner
            val recipient: String,
        )

        @Serializable
        data class Mint(
            /// minter's address
            val minter: String,
            /// token's first owner
            val recipient: String,
        )

        @Serializable
        data class Burn(
            /// previous owner
            val owner: String,
            /// burner's address if not owner
            val burner: String?,
        )
    }

    @Serializable
    data class Execute(
        @SerialName("mint_nft") val mintNft: MintNft? = null,
        @SerialName("add_minters") val addMinters: AddMinters? = null,
        @SerialName("remove_minters") val removeMinters: RemoveMinters? = null,
        @SerialName("set_minters") val setMinters: SetMinters? = null,
        @SerialName("transfer_nft") val transferNft: TransferNft? = null,
    ) {
        @Serializable
        data class MintNft(
            @SerialName("token_id")
            val tokenId: String? = null,
            val owner: String? = null,
            @SerialName("public_metadata")
            val publicMetadata: Metadata? = null,
            @SerialName("private_metadata")
            val privateMetadata: Metadata? = null,
            @SerialName("serial_number")
            val serialNumber: SerialNumber? = null,
            @SerialName("royalty_info")
            val royaltyInfo: RoyaltyInfo? = null,
            val transferable: Boolean? = null,
            val memo: String? = null,
            val padding: String? = null,
        )

        /// add addresses with minting authority
        @Serializable
        data class AddMinters(
            /// list of addresses that can now mint
            val minters: List<String>,
            /// optional message length padding
            val padding: String? = null,
        )

        /// revoke minting authority from addresses
        @Serializable
        data class RemoveMinters(
            /// list of addresses no longer allowed to mint
            val minters: List<String>,
            /// optional message length padding
            val padding: String? = null,
        )

        /// define list of addresses with minting authority
        @Serializable
        data class SetMinters(
            /// list of addresses with minting authority
            val minters: List<String>,
            /// optional message length padding
            val padding: String? = null,
        )

        @Serializable
        data class TransferNft(
            /// recipient of the transfer
            val recipient: String,
            /// id of the token to transfer
            @SerialName("token_id")
            val tokenId: String,
            /// optional memo for the tx
            val memo: String? = null,
            /// optional message length padding
            val padding: String? = null,
        )
    }

    @Serializable
    data class ExecuteAnswer(
        @SerialName("mint_nft") val mintNft: MintNft? = null,
        @SerialName("add_minters") val addMinters: AddMinters? = null,
        @SerialName("remove_minters") val removeMinters: RemoveMinters? = null,
        @SerialName("set_minters") val setMinters: SetMinters? = null,
    ) {

        enum class ResponseStatus {
            success, failure
        }

        @Serializable
        data class MintNft(
            @SerialName("token_id")
            val tokenId: String,
        )

        @Serializable
        data class AddMinters(
            val status: ResponseStatus,
        )

        @Serializable
        data class RemoveMinters(
            val status: ResponseStatus,
        )

        @Serializable
        data class SetMinters(
            val status: ResponseStatus,
        )
    }

    @Serializable
    data class Query(
        val minters: Minters? = null,
        @SerialName("contract_info") val contractInfo: ContractInfo? = null,
        @SerialName("contract_config") val contractConfig: ContractConfig? = null,
        @SerialName("all_tokens") val allTokens: AllTokens? = null,
        @SerialName("num_tokens") val numTokens: NumTokens? = null,
        @SerialName("num_tokens_of_owner") val numTokensOfOwner: NumTokensOfOwner? = null,
        @SerialName("nft_info") val nftInfo: NftInfo? = null,
        @SerialName("nft_dossier") val nftDossier: NftDossier? = null,
        @SerialName("batch_nft_dossier") val batchNftDossier: BatchNftDossier? = null,
        @SerialName("tokens") val tokens: Tokens? = null,
        @SerialName("with_permit") val withPermit: WithPermit? = null,
    ) {

        @Serializable
        class ContractInfo

        @Serializable
        data class AllTokens(
            /// optional address and key requesting to view the list of tokens
            val viewer: ViewerInfo? = null,
            /// paginate by providing the last token_id received in the previous query
            @SerialName("start_after") val startAfter: String? = null,
            /// optional number of token ids to display
            val limit: UInt? = null,
        )

        @Serializable
        class Minters

        @Serializable
        class ContractConfig

        @Serializable
        data class NumTokens(
            @SerialName("viewing_key")
            val viewingKey: String? = null
        )

        @Serializable
        data class NumTokensOfOwner(
            val owner: String,
            @SerialName("viewing_key")
            val viewingKey: String? = null
        )

        @Serializable
        data class NftInfo(
            @SerialName("token_id") val tokenId: String,
        )

        @Serializable
        data class NftDossier(
            @SerialName("token_id")
            val tokenId: String,
            /// optional address and key requesting to view the token information
            val viewer: ViewerInfo? = null,
            /// optionally include expired Approvals in the response list.  If ommitted or
            /// false, expired Approvals will be filtered out of the response
            @SerialName("include_expired")
            val includeExpired: Boolean? = null,
        )

        @Serializable
        data class BatchNftDossier(
            @SerialName("token_ids")
            val tokenIds: List<String>,
            /// optional address and key requesting to view the token information
            val viewer: ViewerInfo? = null,
            /// optionally include expired Approvals in the response list.  If ommitted or
            /// false, expired Approvals will be filtered out of the response
            @SerialName("include_expired")
            val includeExpired: Boolean? = null,
        )

        @Serializable
        data class Tokens(
            val owner: String,
            /// optional address of the querier if different from the owner
            val viewer: String? = null,
            /// optional viewing key
            @SerialName("viewing_key")
            val viewing_key: String? = null,
            /// paginate by providing the last token_id received in the previous query
            @SerialName("start_after")
            val startAfter: String? = null,
            /// optional number of token ids to display
            val limit: UInt? = null,
        )


        @Serializable
        data class WithPermit(
            val permit: Permit,
            val query: QueryWithPermit?
        )

    }


    @Serializable
    data class QueryWithPermit(
        @SerialName("num_tokens_of_owner") val numTokensOfOwner: NumTokensOfOwner? = null,
        @SerialName("num_tokens") val numTokens: NumTokens? = null,
        @SerialName("tokens") val tokens: Tokens? = null,
        @SerialName("private_metadata") val privateMetadata: PrivateMetadata? = null,
        @SerialName("nft_dossier") val nftDossier: NftDossier? = null,
        @SerialName("batch_nft_dossier") val batchNftDossier: BatchNftDossier? = null,
        @SerialName("transaction_history") val transactionHistory: TransactionHistory? = null
    ) {
        @Serializable
        data class NumTokensOfOwner(
            val owner: String
        )

        @Serializable
        class NumTokens

        @Serializable
        data class Tokens(
            val owner: String,
            /// paginate by providing the last token_id received in the previous query
            @SerialName("start_after")
            val startAfter: String? = null,
            /// optional number of token ids to display
            val limit: UInt? = null,
        )

        @Serializable
        data class PrivateMetadata(
            @SerialName("token_id")
            val tokenId: String
        )

        @Serializable
        data class NftDossier(
            @SerialName("token_id")
            val tokenId: String,
            /// optionally include expired Approvals in the response list.  If ommitted or
            /// false, expired Approvals will be filtered out of the response
            @SerialName("include_expired")
            val includeExpired: Boolean? = null,
        )

        @Serializable
        data class BatchNftDossier(
            @SerialName("token_ids")
            val tokenIds: List<String>,
            /// optionally include expired Approvals in the response list.  If ommitted or
            /// false, expired Approvals will be filtered out of the response
            @SerialName("include_expired")
            val includeExpired: Boolean? = null,
        )

        @Serializable
        data class TransactionHistory(
            /// optional page to display
            val page: UInt? = null,
            /// optional number of transactions per page
            @SerialName("page_size")
            val pageSize: UInt? = null,
        )
    }

    @Serializable
    data class QueryAnswer(
        @SerialName("contract_info")
        val contractInfo: ContractInfo? = null,
        @SerialName("contract_config")
        val contractConfig: ContractConfig? = null,
        val minters: Minters? = null,
        @SerialName("nft_info")
        val nftInfo: Metadata? = null,
        @SerialName("nft_dossier")
        val nftDossier: NftDossier? = null,
        @SerialName("batch_nft_dossier")
        val batchNftDossier: BatchNftDossier? = null,
        @SerialName("private_metadata")
        val privateMetadata: Metadata? = null,
        @SerialName("num_tokens")
        val numTokens: NumTokens? = null,
        @SerialName("token_list")
        val tokenList: TokenList? = null,
        @SerialName("transaction_history")
        val transactionHistory: TransactionHistory? = null,
    ) {

        @Serializable
        data class ContractInfo(
            val name: String,
            val symbol: String,
        )

        @Serializable
        data class ContractConfig(
            val token_supply_is_public: Boolean,
            val owner_is_public: Boolean,
            val sealed_metadata_is_enabled: Boolean,
            val unwrapped_metadata_is_private: Boolean,
            val minter_may_update_metadata: Boolean,
            val owner_may_update_metadata: Boolean,
            val burn_is_enabled: Boolean,
            val implements_non_transferable_tokens: Boolean,
            val implements_token_subtype: Boolean,
        )

        @Serializable
        data class Minters(
            val minters: List<String>,
        )

        @Serializable
        data class NumTokens(val count: Int)

        @Serializable
        data class TokenList(
            val tokens: List<String>,
        )

        @Serializable
        data class NftDossier(
            @SerialName("token_id")
            val tokenId: String? = null,
            val owner: String?,
            @SerialName("public_metadata")
            val publicMetadata: Metadata?,
            @SerialName("private_metadata")
            val privateMetadata: Metadata?,
            @SerialName("display_private_metadata_error")
            val displayPrivateMetadataError: String?,
            @SerialName("royalty_info")
            val royaltyInfo: DisplayRoyaltyInfo?,
            @SerialName("mint_run_info")
            val mintRunInfo: MintRunInfo?,
            val transferable: Boolean,
            val unwrapped: Boolean,
            @SerialName("owner_is_public")
            val ownerIsPublic: Boolean,
//            https://github.com/Kotlin/kotlinx.serialization/issues/2049
//            @SerialName("public_ownership_expiration")
//            val publicOwnershipExpiration: Expiration?,
            @SerialName("private_metadata_is_public")
            val privateMetadataIsPublic: Boolean,
//            https://github.com/Kotlin/kotlinx.serialization/issues/2049
//            @SerialName("private_metadata_is_public_expiration")
//            val privateMetadataIsPublicExpiration: Expiration?,
            @SerialName("token_approvals")
            val tokenApprovals: List<Snip721Approval>?,
            @SerialName("inventory_approvals")
            val inventoryApprovals: List<Snip721Approval>?
        )

        @Serializable
        data class BatchNftDossier(
            @SerialName("nft_dossiers")
            val nftDossiers: List<NftDossier>,
        )

        @Serializable
        data class TransactionHistory(
            /// total transaction count
            val total: ULong,
            val txs: List<Tx>,
        )
    }
}