package com.thorny.cryptosphere.detail.domain.usecase

import com.thorny.cryptosphere.core.network.model.MarketChartResponse
import com.thorny.cryptosphere.core.repository.MarketRepository
import com.thorny.cryptosphere.detail.domain.model.ChartData
import com.thorny.cryptosphere.detail.domain.model.PricePoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetCryptoChartDataUseCase {
    operator fun invoke(id: String, days: Int): Flow<ChartData>
}

class GetCryptoChartDataUseCaseImpl(
    private val marketRepository: MarketRepository
) : GetCryptoChartDataUseCase {
    override fun invoke(id: String, days: Int): Flow<ChartData> = flow {
        try {
            val marketChartResponse = marketRepository.getCoinMarketChart(id, days)
            val chartData = marketChartResponse.toChartData()
            emit(chartData)
        } catch (e: Exception) {
            throw e
        }
    }

    private fun MarketChartResponse.toChartData() = ChartData(
        prices = prices.map { PricePoint(it[0].toLong(), it[1]) },
        minPrices = prices.map { PricePoint(it[0].toLong(), it[1])  }.minBy { it.value },
        marketCaps = marketCaps.map { PricePoint(it[0].toLong(), it[1]) },
        totalVolumes = totalVolumes.map { PricePoint(it[0].toLong(), it[1]) }
    )
} 