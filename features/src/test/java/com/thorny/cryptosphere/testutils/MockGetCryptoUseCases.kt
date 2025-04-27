package com.thorny.cryptosphere.testutils

import com.thorny.cryptosphere.detail.domain.model.ChartData
import com.thorny.cryptosphere.detail.domain.model.CryptoDetail
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoChartDataUseCase
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoDetailUseCase
import com.thorny.cryptosphere.home.domain.model.Crypto
import com.thorny.cryptosphere.home.domain.usecase.GetCryptoListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockGetCryptoListUseCase(
    private val cryptoList: List<Crypto> = emptyList(),
    private val shouldThrowError: Boolean = false
) : GetCryptoListUseCase {
    override fun invoke(): Flow<List<Crypto>> = flow {
        if (shouldThrowError) {
            throw Exception("Network error")
        }
        emit(cryptoList)
    }
}

class MockGetCryptoDetailUseCase(
    private val cryptoDetail: CryptoDetail? = null,
    private val shouldThrowError: Boolean = false
) : GetCryptoDetailUseCase {
    override fun invoke(id: String): Flow<CryptoDetail> = flow {
        if (shouldThrowError) {
            throw Exception("Network error")
        }
        emit(cryptoDetail!!)
    }
}

class MockGetCryptoChartDataUseCase(
    private val chartData: ChartData? = null,
    private val shouldThrowError: Boolean = false
) : GetCryptoChartDataUseCase {
    override fun invoke(id: String, days: Int): Flow<ChartData> = flow {
        if (shouldThrowError) {
            throw Exception("Network error")
        }
        emit(chartData!!)
    }
}