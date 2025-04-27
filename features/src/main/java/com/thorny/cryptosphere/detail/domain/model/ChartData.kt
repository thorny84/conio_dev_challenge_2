package com.thorny.cryptosphere.detail.domain.model

data class ChartData(
    val prices: List<PricePoint>,
    val marketCaps: List<PricePoint>,
    val totalVolumes: List<PricePoint>,
    val minPrices: PricePoint
)

data class PricePoint(
    val timestamp: Long,
    val value: Double
) 