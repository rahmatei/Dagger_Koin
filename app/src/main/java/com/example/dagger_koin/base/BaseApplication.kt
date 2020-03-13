package com.example.dagger_koin.base

import android.app.Application
import com.example.dagger_koin.koin.ClassModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@BaseApplication)
            modules(ClassModule)
        }
    }
}