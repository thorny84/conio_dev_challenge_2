package com.thorny.cryptosphere.testutils

import com.thorny.cryptosphere.core.network.model.CoinDetails
import com.thorny.cryptosphere.core.network.model.MarketChartResponse
import com.thorny.cryptosphere.core.network.model.MarketData
import com.thorny.cryptosphere.core.repository.MarketRepository

class MockMarketRepository(
    private val marketData: List<MarketData> = emptyList(),
    private val coinDetails: CoinDetails? = null,
    private val marketChartResponse: MarketChartResponse? = null,
    private val shouldThrowError: Boolean = false
) : MarketRepository {
    override suspend fun getMarketData(): List<MarketData> {
        setError(shouldThrowError)
        return marketData
    }

    override suspend fun getCoinDetails(id: String): CoinDetails {
        setError(shouldThrowError)
        return coinDetails!!
    }

    override suspend fun getCoinMarketChart(id: String, days: Int): MarketChartResponse {
        setError(shouldThrowError)
        return marketChartResponse!!
    }

    private fun setError(shouldThrowError: Boolean){
        if (shouldThrowError) {
            throw Exception("Network error")
        }
    }
}