package com.thorny.cryptosphere.detail.domain.model

data class CryptoDetail(
    val id: String,
    val symbol: String,
    val name: String,
    val imageUrl: String,
    val currentPrice: Double,
    val marketCap: Double,
    val marketCapRank: Int,
    val priceChangePercentage24h: Double,
    val description: String,
    val marketData: MarketDataDetail
)

data class MarketDataDetail(
    val currentPrice: Double,
    val marketCap: Double,
    val totalVolume: Double,
    val high24h: Double,
    val low24h: Double,
    val priceChange24h: Double,
    val priceChangePercentage24h: Double,
    val marketCapChange24h: Double,
    val marketCapChangePercentage24h: Double,
    val circulatingSupply: Double,
    val totalSupply: Double?,
    val maxSupply: Double?,
    val ath: Double,
    val athChangePercentage: Double,
    val athDate: String,
    val atl: Double,
    val atlChangePercentage: Double,
    val atlDate: String,
    val lastUpdated: String
) 