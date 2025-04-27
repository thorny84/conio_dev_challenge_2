package com.thorny.cryptosphere

import android.app.Application
import com.thorny.cryptosphere.core.di.appModule
import com.thorny.cryptosphere.detail.di.detailModule
import com.thorny.cryptosphere.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CryptoSphereApp : Application() {
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidContext(this@CryptoSphereApp)
            modules(
                appModule,
                homeModule,
                detailModule
            )
        }
    }
} 