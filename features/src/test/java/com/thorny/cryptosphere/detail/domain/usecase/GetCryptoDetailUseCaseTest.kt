package com.thorny.cryptosphere.detail.domain.usecase

import com.thorny.cryptosphere.home.domain.usecase.GetCryptoListUseCaseImpl
import com.thorny.cryptosphere.testutils.MockMarketRepository
import com.thorny.cryptosphere.testutils.TestData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GetCryptoDetailUseCaseTest {

    val mockCoinDetails = TestData.coinDetails

    @Test
    fun `invoke returns crypto detail when successful`() = runTest {
        val expectedValue = TestData.cryptoDetail
        val mockRepository = MockMarketRepository(coinDetails = mockCoinDetails)
        val useCase = GetCryptoDetailUseCaseImpl(mockRepository)

        val result = useCase(expectedValue.id).first()

        assertEquals(expectedValue, result)
    }

    @Test
    fun `invoke throws exception when repository throws exception`() = runTest {

        val mockRepository = MockMarketRepository(coinDetails = null, shouldThrowError = true)

        val useCase = GetCryptoListUseCaseImpl(mockRepository)

        assertFailsWith<Exception> {
            useCase().first()
        }
    }

}