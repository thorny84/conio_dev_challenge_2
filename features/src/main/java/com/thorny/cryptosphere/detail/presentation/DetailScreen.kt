package com.thorny.cryptosphere.detail.presentation

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.thorny.cryptosphere.detail.domain.model.ChartData
import com.thorny.cryptosphere.detail.domain.model.CryptoDetail
import com.thorny.cryptosphere.detail.domain.model.MarketDataDetail
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.GridProperties
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.Line
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    id: String,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel = koinViewModel { parametersOf(id) }
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    if (state.cryptoDetail != null) {
                        AsyncImage(
                            model = state.cryptoDetail?.imageUrl,
                            contentDescription = "Crypto Icon",
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 16.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        DetailContent(
            state = state,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}

@Composable
private fun DetailContent(
    state: DetailState,
    modifier: Modifier = Modifier
) {
    when {
        state.isLoading -> LoadingContent(modifier)
        state.error != null -> ErrorContent(state.error, modifier)
        state.cryptoDetail != null && state.chartData != null -> {
            SuccessContent(
                cryptoDetail = state.cryptoDetail,
                chartData = state.chartData,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun LoadingContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorContent(
    error: Exception,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = error.message ?: "An error occurred",
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun SuccessContent(
    cryptoDetail: CryptoDetail,
    chartData: ChartData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        CryptoHeader(cryptoDetail)
        Spacer(modifier = Modifier.height(16.dp))
        PriceChart(chartData)
        Spacer(modifier = Modifier.height(16.dp))
        MarketDataSection(cryptoDetail.marketData)
        Spacer(modifier = Modifier.height(16.dp))
        DescriptionSection(cryptoDetail.description)
    }
}

@Composable
private fun CryptoHeader(cryptoDetail: CryptoDetail) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = cryptoDetail.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = cryptoDetail.symbol.uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = "€${cryptoDetail.currentPrice}",
                style = MaterialTheme.typography.headlineMedium,
                color = if (cryptoDetail.priceChangePercentage24h >= 0) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.error
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${cryptoDetail.priceChangePercentage24h}%",
            style = MaterialTheme.typography.titleMedium,
            color = if (cryptoDetail.priceChangePercentage24h >= 0) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.error
            }
        )
    }
}

@Composable
private fun PriceChart(chartData: ChartData) {
    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 22.dp),
        data = remember {
            listOf(
                Line(
                    values = chartData.prices.map { it.value },
                    color = SolidColor(Color(0xFF23af92)),
                    firstGradientFillColor = Color(0xFF2BC0A1).copy(alpha = .5f),
                    secondGradientFillColor = Color.Transparent,
                    strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                    gradientAnimationDelay = 1000,
                    drawStyle = DrawStyle.Stroke(width = 2.dp),
                    label = "price"
                )
            )
        },
        labelHelperProperties = LabelHelperProperties(false),
        indicatorProperties = HorizontalIndicatorProperties(false),
        gridProperties = GridProperties(false),
        minValue = chartData.minPrices.value,
        animationMode = AnimationMode.Together(delayBuilder = {
            it * 500L
        }),
    )
}

@Composable
private fun MarketDataSection(marketData: MarketDataDetail) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Market Data",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            MarketDataItem("Market Cap", "€${marketData.marketCap}")
            MarketDataItem("24h Volume", "€${marketData.totalVolume}")
            MarketDataItem("24h High", "€${marketData.high24h}")
            MarketDataItem("24h Low", "€${marketData.low24h}")
            MarketDataItem("Circulating Supply", marketData.circulatingSupply.toString())
            marketData.totalSupply?.let {
                MarketDataItem("Total Supply", it.toString())
            }
            marketData.maxSupply?.let {
                MarketDataItem("Max Supply", it.toString())
            }
        }
    }
}

@Composable
private fun MarketDataItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun DescriptionSection(description: String) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Description",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
} 