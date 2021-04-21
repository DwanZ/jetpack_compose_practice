package com.dwanz.jetpack_practice

import android.app.Application
import com.dwanz.jetpack_practice.data.di.DataModule
import com.dwanz.jetpack_practice.domain.di.DomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(DataModule, DomainModule)
        }
    }
}