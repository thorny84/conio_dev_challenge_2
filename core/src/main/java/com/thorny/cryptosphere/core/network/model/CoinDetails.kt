package com.thorny.cryptosphere.core.network.model


data class CoinDetails(
    val id: String,
    val symbol: String,
    val name: String,
    val webSlug: String,
    val assetPlatformId: String?,
    val platforms: Map<String, String>,
    val detailPlatforms: Map<String, PlatformDetail>,
    val blockTimeInMinutes: Int,
    val hashingAlgorithm: String,
    val categories: List<String>,
    val previewListing: Boolean,
    val publicNotice: String?,
    val additionalNotices: List<String>,
    val localization: Map<String, String>,
    val description: Map<String, String>,
    val links: Links,
    val image: Image,
    val countryOrigin: String,
    val genesisDate: String,
    val sentimentVotesUpPercentage: Double,
    val sentimentVotesDownPercentage: Double,
    val watchlistPortfolioUsers: Int,
    val marketCapRank: Int,
    val marketData: MarketDataDetails,
    val communityData: CommunityData,
    val developerData: DeveloperData,
    val statusUpdates: List<Any>,
    val lastUpdated: String,
    val tickers: List<Ticker>
)

data class PlatformDetail(
    val decimalPlace: Int?,
    val contractAddress: String
)

data class Links(
    val homepage: List<String>,
    val whitepaper: String,
    val blockchainSite: List<String>,
    val officialForumUrl: List<String>,
    val chatUrl: List<String>,
    val announcementUrl: List<String>,
    val snapshotUrl: String?,
    val twitterScreenName: String,
    val facebookUsername: String,
    val bitcointalkThreadIdentifier: String?,
    val telegramChannelIdentifier: String,
    val subredditUrl: String,
    val reposUrl: ReposUrl
)

data class ReposUrl(
    val github: List<String>,
    val bitbucket: List<String>
)

data class Image(
    val thumb: String,
    val small: String,
    val large: String
)

data class MarketDataDetails(
    val currentPrice: Map<String, Double>,
    val totalValueLocked: Double?,
    val mcapToTvlRatio: Double?,
    val fdvToTvlRatio: Double?,
    val roi: Roi?,
    val ath: Map<String, Double>,
    val athChangePercentage: Map<String, Double>,
    val athDate: Map<String, String>,
    val atl: Map<String, Double>,
    val atlChangePercentage: Map<String, Double>,
    val atlDate: Map<String, String>,
    val marketCap: Map<String, Double>,
    val marketCapRank: Int,
    val fullyDilutedValuation: Map<String, Double>,
    val marketCapFdvRatio: Double,
    val totalVolume: Map<String, Double>,
    val high24h: Map<String, Double>?,
    val low24h: Map<String, Double>?,
    val priceChange24h: Double,
    val priceChangePercentage24h: Double,
    val priceChangePercentage7d: Double,
    val priceChangePercentage14d: Double,
    val priceChangePercentage30d: Double,
    val priceChangePercentage60d: Double,
    val priceChangePercentage200d: Double,
    val priceChangePercentage1y: Double,
    val marketCapChange24h: Double,
    val marketCapChangePercentage24h: Double,
    val priceChange24hInCurrency: Map<String, Double>,
    val priceChangePercentage1hInCurrency: Map<String, Double>,
    val priceChangePercentage24hInCurrency: Map<String, Double>,
    val priceChangePercentage7dInCurrency: Map<String, Double>,
    val priceChangePercentage14dInCurrency: Map<String, Double>,
    val priceChangePercentage30dInCurrency: Map<String, Double>,
    val priceChangePercentage60dInCurrency: Map<String, Double>,
    val priceChangePercentage200dInCurrency: Map<String, Double>,
    val priceChangePercentage1yInCurrency: Map<String, Double>,
    val marketCapChange24hInCurrency: Map<String, Double>,
    val marketCapChangePercentage24hInCurrency: Map<String, Double>,
    val totalSupply: Double,
    val maxSupply: Double,
    val circulatingSupply: Double,
    val lastUpdated: String
)

data class CommunityData(
    val facebookLikes: Int?,
    val twitterFollowers: Int,
    val redditAveragePosts48h: Int,
    val redditAverageComments48h: Int,
    val redditSubscribers: Int,
    val redditAccountsActive48h: Int,
    val telegramChannelUserCount: Int?
)

data class DeveloperData(
    val forks: Int,
    val stars: Int,
    val subscribers: Int,
    val totalIssues: Int,
    val closedIssues: Int,
    val pullRequestsMerged: Int,
    val pullRequestContributors: Int,
    val codeAdditionsDeletions4Weeks: CodeChanges,
    val commitCount4Weeks: Int,
    val last4WeeksCommitActivitySeries: List<Int>
)

data class CodeChanges(
    val additions: Int,
    val deletions: Int
)

data class Ticker(
    val base: String,
    val target: String,
    val market: Market,
    val last: Double,
    val volume: Double,
    val convertedLast: ConvertedPrice,
    val convertedVolume: ConvertedVolume,
    val trustScore: String,
    val bidAskSpreadPercentage: Double,
    val timestamp: String,
    val lastTradedAt: String,
    val lastFetchAt: String,
    val isAnomaly: Boolean,
    val isStale: Boolean,
    val tradeUrl: String?,
    val tokenInfoUrl: String?,
    val coinId: String,
    val targetCoinId: String
)

data class Market(
    val name: String,
    val identifier: String,
    val hasTradingIncentive: Boolean
)

data class ConvertedPrice(
    val btc: Double,
    val eth: Double,
    val usd: Double
)

data class ConvertedVolume(
    val btc: Double,
    val eth: Double,
    val usd: Double
) 