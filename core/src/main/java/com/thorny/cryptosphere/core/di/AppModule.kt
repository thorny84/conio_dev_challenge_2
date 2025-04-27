package com.thorny.cryptosphere.core.di

import org.koin.dsl.module

val appModule = module {
    includes(networkModule)
} 