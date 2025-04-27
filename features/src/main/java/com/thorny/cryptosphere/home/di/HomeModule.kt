package com.thorny.cryptosphere.home.di

import com.thorny.cryptosphere.home.domain.usecase.GetCryptoListUseCase
import com.thorny.cryptosphere.home.domain.usecase.GetCryptoListUseCaseImpl
import com.thorny.cryptosphere.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<GetCryptoListUseCase> { GetCryptoListUseCaseImpl(get()) }
    viewModel { HomeViewModel(get()) }
} 