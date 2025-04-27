package com.thorny.cryptosphere.core.repository

import com.thorny.cryptosphere.core.network.ApiService
import com.thorny.cryptosphere.core.network.model.CoinDetails
import com.thorny.cryptosphere.core.network.model.MarketChartResponse
import com.thorny.cryptosphere.core.network.model.MarketData

interface MarketRepository {
    suspend fun getMarketData(): List<MarketData>
    suspend fun getCoinDetails(id: String): CoinDetails
    suspend fun getCoinMarketChart(id: String, days: Int): MarketChartResponse
}

class MarketRepositoryImpl(
    private val service: ApiService
) : MarketRepository {
    override suspend fun getMarketData(): List<MarketData> {
        return service.getMarketData(
            vsCurrency = "eur",
            order = "market_cap_desc",
            perPage = 10,
            page = 1,
            sparkline = false
        )
    }

    override suspend fun getCoinDetails(id: String): CoinDetails {
        return service.getCoinDetails(id)
    }

    override suspend fun getCoinMarketChart(id: String, days: Int): MarketChartResponse {
        return service.getCoinMarketChart(
            id = id,
            vsCurrency = "eur",
            days = days
        )
    }
}