package com.thorny.cryptosphere.home.domain.usecase

import com.thorny.cryptosphere.home.domain.model.Crypto
import com.thorny.cryptosphere.testutils.MockMarketRepository
import com.thorny.cryptosphere.testutils.TestData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@OptIn(ExperimentalCoroutinesApi::class)
class GetCryptoListUseCaseTest {

    val mockMarketData = TestData.marketDataList


    @Test
    fun `invoke returns crypto list when successful`() = runTest {

        val expectedCryptoList: List<Crypto> = TestData.cryptoList
        val mockRepository = MockMarketRepository(marketData = mockMarketData)
        val useCase = GetCryptoListUseCaseImpl(mockRepository)

        val result = useCase().first()

        assertEquals(expectedCryptoList, result)
    }

    @Test
    fun `invoke throws exception when repository throws exception`() = runTest {

        val mockRepository = MockMarketRepository(marketData = mockMarketData, shouldThrowError = true)

        // Given
        val useCase = GetCryptoListUseCaseImpl(mockRepository)

        // When/Then
        assertFailsWith<Exception> {
            useCase().first()
        }
    }
} 