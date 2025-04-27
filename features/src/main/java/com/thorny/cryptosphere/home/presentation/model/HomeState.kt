package com.thorny.cryptosphere.home.presentation.model

import com.thorny.cryptosphere.home.domain.model.Crypto

data class HomeState(
    val cryptoList: List<Crypto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 