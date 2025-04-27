package com.thorny.cryptosphere.core.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.thorny.cryptosphere.core.config.AppConfig
import com.thorny.cryptosphere.core.network.ApiKeyInterceptor
import com.thorny.cryptosphere.core.network.ApiService
import com.thorny.cryptosphere.core.network.NetworkConstants
import com.thorny.cryptosphere.core.repository.MarketRepository
import com.thorny.cryptosphere.core.repository.MarketRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(ApiKeyInterceptor(AppConfig.coinGeckoApiKey))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    single {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    single<MarketRepository> { MarketRepositoryImpl(get()) }
}