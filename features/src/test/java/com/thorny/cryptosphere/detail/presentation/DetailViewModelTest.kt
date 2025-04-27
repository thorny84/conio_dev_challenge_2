package com.thorny.cryptosphere.detail.presentation

import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoChartDataUseCase
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoDetailUseCase
import com.thorny.cryptosphere.testutils.MockGetCryptoChartDataUseCase
import com.thorny.cryptosphere.testutils.MockGetCryptoDetailUseCase
import com.thorny.cryptosphere.testutils.TestData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: DetailViewModel
    private lateinit var getCryptoDetailUseCase: GetCryptoDetailUseCase
    private lateinit var getCryptoChartDataUseCase: GetCryptoChartDataUseCase

    @Test
    fun `loadData updates state with detail and chart when successful`() = runTest {

        getCryptoDetailUseCase = MockGetCryptoDetailUseCase(TestData.cryptoDetail)
        getCryptoChartDataUseCase = MockGetCryptoChartDataUseCase(TestData.chartData)
        viewModel = DetailViewModel(
            id = "bitcoin",
            getCryptoDetailUseCase = getCryptoDetailUseCase,
            getCryptoChartDataUseCase = getCryptoChartDataUseCase,
            dispatcher = testDispatcher
        )

        val initialState = viewModel.state.first()
        assertTrue(initialState.isLoading)

        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.state.first()
        assertFalse(state.isLoading)
        assertEquals(TestData.cryptoDetail, state.cryptoDetail)
        assertEquals(TestData.chartData, state.chartData)
    }

    @Test(expected = NullPointerException::class)
    fun `loadData updates state with detail or chart when exception occurs`() = runTest {

        getCryptoDetailUseCase = MockGetCryptoDetailUseCase(null)
        getCryptoChartDataUseCase = MockGetCryptoChartDataUseCase(TestData.chartData)
        viewModel = DetailViewModel(
            id = "bitcoin",
            getCryptoDetailUseCase = getCryptoDetailUseCase,
            getCryptoChartDataUseCase = getCryptoChartDataUseCase,
            dispatcher = testDispatcher
        )

        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.state.first()
        assertFalse(state.isLoading)
        assertNotNull(state.error)
    }
}