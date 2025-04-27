package com.thorny.cryptosphere.core.network

import com.thorny.cryptosphere.core.network.model.CoinDetails
import com.thorny.cryptosphere.core.network.model.MarketChartResponse
import com.thorny.cryptosphere.core.network.model.MarketData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("coins/markets")
    suspend fun getMarketData(
        @Query("vs_currency") vsCurrency: String = "eur",
        @Query("order") order: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean
    ): List<MarketData>

    @GET("coins/{id}")
    suspend fun getCoinDetails(
        @Path("id") id: String,
        @Query("localization") vsCurrency: Boolean = false,
        @Query("tickers") tickers: Boolean = false,
        @Query("community_data") communityData: Boolean = false,
        @Query("developer_data") developerData: Boolean = false,
        @Query("sparkline") sparkline: Boolean = false,
    ): CoinDetails

    @GET("coins/{id}/market_chart")
    suspend fun getCoinMarketChart(
        @Path("id") id: String,
        @Query("vs_currency") vsCurrency: String = "eur",
        @Query("days") days: Int
    ): MarketChartResponse
}