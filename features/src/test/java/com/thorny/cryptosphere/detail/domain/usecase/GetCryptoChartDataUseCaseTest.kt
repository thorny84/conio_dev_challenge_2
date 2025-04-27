package com.thorny.cryptosphere.detail.domain.usecase

import com.thorny.cryptosphere.testutils.MockMarketRepository
import com.thorny.cryptosphere.testutils.TestData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class GetCryptoChartDataUseCaseTest {

    val mockResponse = TestData.marketChartResponse

    @Test
    fun `getCryptoChartDataUseCase returns ChartData on success`() = runTest {

        val mockRepository = MockMarketRepository(marketChartResponse = mockResponse)
        val useCase = GetCryptoChartDataUseCaseImpl(mockRepository)


        val result = useCase("bitcoin", 7).first()

        // Assert
        assertNotNull(result)
        assertEquals(2, result.prices.size)
        assertEquals(100.0, result.prices[0].value)
        assertEquals(110.0, result.prices[1].value)
        assertEquals(100.0, result.minPrices.value)
    }

    @Test
    fun `getCryptoChartDataUseCase throws exception on failure`() = runTest {
        // Arrange
        val mockRepository = MockMarketRepository()
        val useCase = GetCryptoChartDataUseCaseImpl(mockRepository)

        // Act & Assert
        assertFailsWith<Exception> {
            useCase("bitcoin", 7).first()
        }
    }
}