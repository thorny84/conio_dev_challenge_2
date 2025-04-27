package com.thorny.cryptosphere.home.domain.model

data class Crypto(
    val id: String,
    val name: String,
    val symbol: String,
    val imageUrl: String,
    val priceInEur: Double,
    val priceChangePercentage24h: Double
) 