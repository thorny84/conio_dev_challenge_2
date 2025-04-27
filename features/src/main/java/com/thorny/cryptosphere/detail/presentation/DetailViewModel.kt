package com.thorny.cryptosphere.detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thorny.cryptosphere.detail.domain.model.ChartData
import com.thorny.cryptosphere.detail.domain.model.CryptoDetail
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoChartDataUseCase
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoDetailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DetailState(
    val cryptoDetail: CryptoDetail? = null,
    val chartData: ChartData? = null,
    val isLoading: Boolean = true,
    val error: Exception? = null
)

class DetailViewModel(
    private val id: String,
    private val getCryptoDetailUseCase: GetCryptoDetailUseCase,
    private val getCryptoChartDataUseCase: GetCryptoChartDataUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState> = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(dispatcher) {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val cryptoDetailDeferred = async { getCryptoDetailUseCase(id).first() }
                val chartDataDeferred = async { getCryptoChartDataUseCase(id, 7).first() }

                val cryptoDetail = cryptoDetailDeferred.await()
                val chartData = chartDataDeferred.await()
                _state.update { it.copy(
                    cryptoDetail = cryptoDetail,
                    chartData = chartData,
                    isLoading = false
                ) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e, isLoading = false) }
            }
        }
    }
} 