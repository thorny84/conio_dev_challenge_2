package com.thorny.cryptosphere.detail.di

import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoChartDataUseCase
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoChartDataUseCaseImpl
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoDetailUseCase
import com.thorny.cryptosphere.detail.domain.usecase.GetCryptoDetailUseCaseImpl
import com.thorny.cryptosphere.detail.presentation.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    single<GetCryptoDetailUseCase> { GetCryptoDetailUseCaseImpl(get()) }
    single<GetCryptoChartDataUseCase> { GetCryptoChartDataUseCaseImpl(get()) }
    viewModel { (id: String) -> DetailViewModel(id, get(), get()) }
}