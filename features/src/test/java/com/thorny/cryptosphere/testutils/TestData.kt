package com.thorny.cryptosphere.testutils

import com.thorny.cryptosphere.core.network.model.CodeChanges
import com.thorny.cryptosphere.core.network.model.CoinDetails
import com.thorny.cryptosphere.core.network.model.CommunityData
import com.thorny.cryptosphere.core.network.model.ConvertedPrice
import com.thorny.cryptosphere.core.network.model.ConvertedVolume
import com.thorny.cryptosphere.core.network.model.DeveloperData
import com.thorny.cryptosphere.core.network.model.Image
import com.thorny.cryptosphere.core.network.model.Links
import com.thorny.cryptosphere.core.network.model.Market
import com.thorny.cryptosphere.core.network.model.MarketChartResponse
import com.thorny.cryptosphere.core.network.model.MarketData
import com.thorny.cryptosphere.core.network.model.MarketDataDetails
import com.thorny.cryptosphere.core.network.model.PlatformDetail
import com.thorny.cryptosphere.core.network.model.ReposUrl
import com.thorny.cryptosphere.core.network.model.Ticker
import com.thorny.cryptosphere.detail.domain.model.ChartData
import com.thorny.cryptosphere.detail.domain.model.CryptoDetail
import com.thorny.cryptosphere.detail.domain.model.MarketDataDetail
import com.thorny.cryptosphere.detail.domain.model.PricePoint
import com.thorny.cryptosphere.home.domain.model.Crypto

object TestData {
    val bitcoinMarketData = MarketData(
        id = "bitcoin",
        symbol = "btc",
        name = "Bitcoin",
        image = "https://bitcoin.png",
        currentPrice = 50000.0,
        marketCap = 1000000000,
        marketCapRank = 1,
        priceChangePercentage24h = 5.2,
        totalVolume = 500000000,
        high24h = 51000.0,
        low24h = 49000.0,
        priceChange24h = 2500.0,
        marketCapChange24h = 50000000,
        marketCapChangePercentage24h = 5.0,
        circulatingSupply = 19000000.0,
        totalSupply = 21000000.0,
        maxSupply = 21000000,
        ath = 69000.0,
        athChangePercentage = -27.5,
        athDate = "2021-11-10T14:24:11.849Z",
        atl = 67.81,
        atlChangePercentage = 73600.0,
        atlDate = "2013-07-06T00:00:00.000Z",
        lastUpdated = "2024-03-20T10:00:00.000Z",
        roi = null,
        fullyDilutedValuation = 1050000000
    )

    val ethereumMarketData = MarketData(
        id = "ethereum",
        symbol = "eth",
        name = "Ethereum",
        image = "https://ethereum.png",
        currentPrice = 3000.0,
        marketCap = 500000000,
        marketCapRank = 2,
        priceChangePercentage24h = -2.5,
        totalVolume = 200000000,
        high24h = 3100.0,
        low24h = 2900.0,
        priceChange24h = -75.0,
        marketCapChange24h = -25000000,
        marketCapChangePercentage24h = -5.0,
        circulatingSupply = 120000000.0,
        totalSupply = 120000000.0,
        maxSupply = 21000000,
        ath = 4800.0,
        athChangePercentage = -37.5,
        athDate = "2021-11-10T14:24:11.849Z",
        atl = 0.42,
        atlChangePercentage = 714000.0,
        atlDate = "2015-10-20T00:00:00.000Z",
        lastUpdated = "2024-03-20T10:00:00.000Z",
        roi = null,
        fullyDilutedValuation = 600000000
    )

    val marketDataList = listOf(bitcoinMarketData, ethereumMarketData)

    val bitcoinCrypto = Crypto(
        id = "bitcoin",
        symbol = "btc",
        name = "Bitcoin",
        imageUrl = "https://bitcoin.png",
        priceInEur = 50000.0,
        priceChangePercentage24h = 5.2
    )

    val ethereumCrypto = Crypto(
        id = "ethereum",
        symbol = "eth",
        name = "Ethereum",
        imageUrl = "https://ethereum.png",
        priceInEur = 3000.0,
        priceChangePercentage24h = -2.5
    )

    val cryptoList = listOf(bitcoinCrypto, ethereumCrypto)

    val marketChartResponse = MarketChartResponse(
        prices = listOf(listOf(1678886400000.0, 100.0), listOf(1678972800000.0, 110.0)),
        marketCaps = listOf(listOf(1678886400000.0, 200.0), listOf(1678972800000.0, 220.0)),
        totalVolumes = listOf(listOf(1678886400000.0, 300.0), listOf(1678972800000.0, 330.0))
    )

    val chartData = ChartData(
        prices = listOf(PricePoint(2,100.0), PricePoint(2,110.0)),
        marketCaps = listOf(PricePoint(2,100.0), PricePoint(2,110.0)),
        totalVolumes = listOf(PricePoint(2,100.0), PricePoint(2,110.0)),
        minPrices = PricePoint(2,100.0)
    )

    val coinDetails = CoinDetails(
        id = "bitcoin",
        symbol = "btc",
        name = "Bitcoin",
        webSlug = "bitcoin",
        assetPlatformId = "ethereum",
        platforms = mapOf("ethereum" to "0x...", "binance-smart-chain" to "0x..."),
        detailPlatforms = mapOf("ethereum" to PlatformDetail(18, "0x...")),
        blockTimeInMinutes = 10,
        hashingAlgorithm = "SHA256",
        categories = listOf("Cryptocurrency"),
        previewListing = false,
        publicNotice = "Trading is risky",
        additionalNotices = listOf("Be careful"),
        localization = mapOf("en" to "Bitcoin", "it" to "Bitcoin"),
        description = mapOf(
            "en" to "Decentralized digital currency",
            "it" to "Criptovaluta decentralizzata"
        ),
        links = Links(
            homepage = listOf("https://bitcoin.org/"),
            whitepaper = "https://bitcoin.org/bitcoin.pdf",
            blockchainSite = listOf("https://www.blockchain.com/"),
            officialForumUrl = listOf("https://bitcointalk.org/"),
            chatUrl = listOf("https://example.com/chat"),
            announcementUrl = listOf("https://example.com/announcements"),
            snapshotUrl = "https://example.com/snapshot.png",
            twitterScreenName = "bitcoin",
            facebookUsername = "Bitcoin",
            bitcointalkThreadIdentifier = "12345",
            telegramChannelIdentifier = "BitcoinOfficial",
            subredditUrl = "https://www.reddit.com/r/Bitcoin/",
            reposUrl = ReposUrl(
                github = listOf("https://github.com/bitcoin/bitcoin"),
                bitbucket = listOf("https://bitbucket.org/bitcoin/bitcoin")
            )
        ),
        image = Image(
            thumb = "https://example.com/thumb.png",
            small = "https://example.com/small.png",
            large = "https://example.com/large.png"
        ),
        countryOrigin = "Global",
        genesisDate = "2009-01-03",
        sentimentVotesUpPercentage = 75.0,
        sentimentVotesDownPercentage = 25.0,
        watchlistPortfolioUsers = 1000000,
        marketCapRank = 1,
        marketData = MarketDataDetails(
            currentPrice = mapOf("usd" to 50000.0, "eur" to 45000.0),
            totalValueLocked = 1000000000.0,
            mcapToTvlRatio = 0.5,
            fdvToTvlRatio = 1.0,
            roi = null,
            ath = mapOf("usd" to 60000.0, "eur" to 55000.0),
            athChangePercentage = mapOf("usd" to -10.0, "eur" to -5.0),
            athDate = mapOf("usd" to "2021-12-01", "eur" to "2021-12-01"),
            atl = mapOf("usd" to 100.0, "eur" to 90.0),
            atlChangePercentage = mapOf("usd" to 10000.0, "eur" to 10000.0),
            atlDate = mapOf("usd" to "2013-07-06", "eur" to "2013-07-06"),
            marketCap = mapOf("usd" to 900000000000.0, "eur" to 800000000000.0),
            marketCapRank = 1,
            fullyDilutedValuation = mapOf("usd" to 10000000000.0, "eur" to 9500000000.0),
            marketCapFdvRatio = 0.9,
            totalVolume = mapOf("usd" to 11000000000.0, "eur" to 1000000000.0),
            high24h = mapOf("usd" to 51000.0, "eur" to 46000.0),
            low24h = mapOf("usd" to 49000.0, "eur" to 44000.0),
            priceChange24h = -1000.0,
            priceChangePercentage24h = -2.0,
            priceChangePercentage7d = -5.0,
            priceChangePercentage14d = -7.0,
            priceChangePercentage30d = -12.0,
            priceChangePercentage60d = -15.0,
            priceChangePercentage200d = -20.0,
            priceChangePercentage1y = 50.0,
            marketCapChange24h = -20000000000.0,
            marketCapChangePercentage24h = -2.5,
            priceChange24hInCurrency = mapOf("usd" to -1100.0, "eur" to -1000.0),
            priceChangePercentage1hInCurrency = mapOf("usd" to -0.5, "eur" to -0.6),
            priceChangePercentage24hInCurrency = mapOf("usd" to -2.0, "eur" to -2.2),
            priceChangePercentage7dInCurrency = mapOf("usd" to -5.0, "eur" to -5.5),
            priceChangePercentage14dInCurrency = mapOf("usd" to -7.0, "eur" to -7.7),
            priceChangePercentage30dInCurrency = mapOf("usd" to -12.0, "eur" to -13.2),
            priceChangePercentage60dInCurrency = mapOf("usd" to -15.0, "eur" to -16.5),
            priceChangePercentage200dInCurrency = mapOf("usd" to -20.0, "eur" to -22.0),
            priceChangePercentage1yInCurrency = mapOf("usd" to 50.0, "eur" to 55.0),
            marketCapChange24hInCurrency = mapOf("usd" to -20000000000.0, "eur" to -22000000000.0),
            marketCapChangePercentage24hInCurrency = mapOf("usd" to -2.5, "eur" to -2.75),
            totalSupply = 21000000.0,
            maxSupply = 21000000.0,
            circulatingSupply = 19000000.0,
            lastUpdated = "2024-04-24T11:55:00Z"
        ),
        communityData = CommunityData(
            facebookLikes = 1000000,
            twitterFollowers = 5000000,
            redditAveragePosts48h = 100,
            redditAverageComments48h = 500,
            redditSubscribers = 2000000,
            redditAccountsActive48h = 50000,
            telegramChannelUserCount = 1000000
        ),
        developerData = DeveloperData(
            forks = 10000,
            stars = 50000,
            subscribers = 20000,
            totalIssues = 5000,
            closedIssues = 4000,
            pullRequestsMerged = 3000,
            pullRequestContributors = 500,
            codeAdditionsDeletions4Weeks = CodeChanges(additions = 1000, deletions = 500),
            commitCount4Weeks = 1000,
            last4WeeksCommitActivitySeries = listOf(100, 110, 120, 130)
        ),
        statusUpdates = listOf(Any()), // You might want to create a proper mock for this
        lastUpdated = "2024-04-24T12:00:00Z",
        tickers = listOf(
            Ticker(
                base = "BTC",
                target = "USD",
                market = Market(
                    name = "Coinbase",
                    identifier = "coinbase",
                    hasTradingIncentive = false
                ),
                last = 50000.0,
                volume = 100000000.0,
                convertedLast = ConvertedPrice(btc = 1.0, eth = 20.0, usd = 50000.0),
                convertedVolume = ConvertedVolume(btc = 1000.0, eth = 20000.0, usd = 100000000.0),
                trustScore = "10",
                bidAskSpreadPercentage = 0.01,
                timestamp = "2024-04-24T12:00:00Z",
                lastTradedAt = "2024-04-24T11:59:00Z",
                lastFetchAt = "2024-04-24T12:01:00Z",
                isAnomaly = false,
                isStale = false,
                tradeUrl = "https://www.coinbase.com/trade/btc-usd",
                tokenInfoUrl = null,
                coinId = "bitcoin",
                targetCoinId = "usd"
            )
        )
    )

    val cryptoDetail = CryptoDetail(
        id = coinDetails.id,
        symbol = coinDetails.symbol,
        name = coinDetails.name,
        imageUrl = coinDetails.image.large,
        currentPrice = coinDetails.marketData.currentPrice["eur"] ?: 0.0,
        marketCap = coinDetails.marketData.marketCap["eur"] ?: 0.0,
        marketCapRank = coinDetails.marketCapRank,
        priceChangePercentage24h = coinDetails.marketData.priceChangePercentage24h,
        description = coinDetails.description["en"] ?: "",
        marketData = marketDataDetail(coinDetails.marketData)
    )

    private fun marketDataDetail(marketData: MarketDataDetails) = MarketDataDetail(
        currentPrice = marketData.currentPrice["eur"] ?: 0.0,
        marketCap = marketData.marketCap["eur"] ?: 0.0,
        totalVolume = marketData.totalVolume["eur"] ?: 0.0,
        high24h = marketData.high24h?.get("eur") ?: 0.0,
        low24h = marketData.low24h?.get("eur") ?: 0.0,
        priceChange24h = marketData.priceChange24h,
        priceChangePercentage24h = marketData.priceChangePercentage24h,
        marketCapChange24h = marketData.marketCapChange24h,
        marketCapChangePercentage24h = marketData.marketCapChangePercentage24h,
        circulatingSupply = marketData.circulatingSupply,
        totalSupply = marketData.totalSupply,
        maxSupply = marketData.maxSupply,
        ath = marketData.ath["eur"] ?: 0.0,
        athChangePercentage = marketData.athChangePercentage["eur"] ?: 0.0,
        athDate = marketData.athDate["eur"] ?: "",
        atl = marketData.atl["eur"] ?: 0.0,
        atlChangePercentage = marketData.atlChangePercentage["eur"] ?: 0.0,
        atlDate = marketData.atlDate["eur"] ?: "",
        lastUpdated = marketData.lastUpdated
    )

} 