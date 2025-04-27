package com.thorny.cryptosphere.home.domain.usecase

import com.thorny.cryptosphere.core.repository.MarketRepository
import com.thorny.cryptosphere.home.domain.model.Crypto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetCryptoListUseCase {
    operator fun invoke(): Flow<List<Crypto>>
}

class GetCryptoListUseCaseImpl(
    private val marketRepository: MarketRepository
) : GetCryptoListUseCase {
    override fun invoke(): Flow<List<Crypto>> = flow {
        try {
            val marketData = marketRepository.getMarketData()
            val cryptoList = marketData.map { marketData ->
                Crypto(
                    id = marketData.id,
                    symbol = marketData.symbol,
                    name = marketData.name,
                    imageUrl = marketData.image,
                    priceInEur = marketData.currentPrice,
                    priceChangePercentage24h = marketData.priceChangePercentage24h
                )
            }
            emit(cryptoList)
        } catch (e: Exception) {
            throw e
        }
    }
}