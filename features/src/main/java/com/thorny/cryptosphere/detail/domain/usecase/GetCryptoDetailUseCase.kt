package com.thorny.cryptosphere.detail.domain.usecase

import com.thorny.cryptosphere.core.network.model.CoinDetails
import com.thorny.cryptosphere.core.repository.MarketRepository
import com.thorny.cryptosphere.detail.domain.model.CryptoDetail
import com.thorny.cryptosphere.detail.domain.model.MarketDataDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetCryptoDetailUseCase {
    operator fun invoke(id: String): Flow<CryptoDetail>
}

class GetCryptoDetailUseCaseImpl(
    private val marketRepository: MarketRepository
) : GetCryptoDetailUseCase {
    override fun invoke(id: String): Flow<CryptoDetail> = flow {
        try {
            val coinDetails = marketRepository.getCoinDetails(id)
            val cryptoDetail = coinDetails.toCryptoDetail()
            emit(cryptoDetail)
        } catch (e: Exception) {
            throw e
        }
    }

    private fun CoinDetails.toCryptoDetail() = CryptoDetail(
        id = id,
        symbol = symbol,
        name = name,
        imageUrl = image.large,
        currentPrice = marketData.currentPrice["eur"] ?: 0.0,
        marketCap = marketData.marketCap["eur"] ?: 0.0,
        marketCapRank = marketCapRank,
        priceChangePercentage24h = marketData.priceChangePercentage24h,
        description = description["en"] ?: "",
        marketData = marketData.toMarketDataDetail()
    )

    private fun com.thorny.cryptosphere.core.network.model.MarketDataDetails.toMarketDataDetail() = MarketDataDetail(
        currentPrice = currentPrice["eur"] ?: 0.0,
        marketCap = marketCap["eur"] ?: 0.0,
        totalVolume = totalVolume["eur"] ?: 0.0,
        high24h = high24h?.get("eur") ?: 0.0,
        low24h = low24h?.get("eur") ?: 0.0,
        priceChange24h = priceChange24h,
        priceChangePercentage24h = priceChangePercentage24h,
        marketCapChange24h = marketCapChange24h,
        marketCapChangePercentage24h = marketCapChangePercentage24h,
        circulatingSupply = circulatingSupply,
        totalSupply = totalSupply,
        maxSupply = maxSupply,
        ath = ath["eur"] ?: 0.0,
        athChangePercentage = athChangePercentage["eur"] ?: 0.0,
        athDate = athDate["eur"] ?: "",
        atl = atl["eur"] ?: 0.0,
        atlChangePercentage = atlChangePercentage["eur"] ?: 0.0,
        atlDate = atlDate["eur"] ?: "",
        lastUpdated = lastUpdated
    )
} 