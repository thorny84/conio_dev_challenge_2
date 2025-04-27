package com.thorny.cryptosphere.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thorny.cryptosphere.home.domain.model.Crypto
import com.thorny.cryptosphere.home.domain.usecase.GetCryptoListUseCase
import com.thorny.cryptosphere.home.presentation.model.HomeState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class HomeViewModel(
    private val getCryptoListUseCase: GetCryptoListUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    init {
        loadCryptoList()
    }

    fun loadCryptoList() {
        getCryptoListUseCase()
            .flowOn(dispatcher)
            .onStart { _state.value = _state.value.copy(isLoading = true) }
            .onEach { cryptoList ->
                _state.value = _state.value.copy(
                    cryptoList = cryptoList.map { crypto ->
                        Crypto(
                            id = crypto.id,
                            name = crypto.name,
                            symbol = crypto.symbol,
                            imageUrl = crypto.imageUrl,
                            priceInEur = crypto.priceInEur,
                            priceChangePercentage24h = crypto.priceChangePercentage24h
                        )
                    },
                    isLoading = false,
                    error = null
                )
            }
            .catch { error ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = error.message ?: "unknown error"
                )
            }
            .launchIn(viewModelScope)
    }
} 