package com.thorny.cryptosphere.core.network.model

data class MarketChartResponse(
    val prices: List<List<Double>>,
    val marketCaps: List<List<Double>>,
    val totalVolumes: List<List<Double>>
) 