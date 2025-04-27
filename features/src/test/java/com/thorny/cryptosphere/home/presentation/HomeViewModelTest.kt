package com.thorny.cryptosphere.home.presentation

import com.thorny.cryptosphere.home.domain.usecase.GetCryptoListUseCase
import com.thorny.cryptosphere.testutils.MockGetCryptoListUseCase
import com.thorny.cryptosphere.testutils.TestData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: HomeViewModel
    private lateinit var getCryptoListUseCase: GetCryptoListUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadCryptoList updates state with crypto list when successful`() = runTest {
        val expectedCryptoList = TestData.cryptoList
        getCryptoListUseCase = MockGetCryptoListUseCase(cryptoList = expectedCryptoList)
        viewModel = HomeViewModel(getCryptoListUseCase)

        viewModel.loadCryptoList()
        testDispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.state.first()
        assertFalse(state.isLoading)
        assertEquals(expectedCryptoList, state.cryptoList)
    }

    @Test
    fun `loadCryptoList updates state with error when exception occurs`() = runTest {

        getCryptoListUseCase = MockGetCryptoListUseCase(shouldThrowError = true)
        viewModel = HomeViewModel(getCryptoListUseCase)


        viewModel.loadCryptoList()
        testDispatcher.scheduler.advanceUntilIdle()


        val state = viewModel.state.first()
        assertFalse(state.isLoading)
        assertEquals("Network error", state.error)
    }
} 