package com.example.dagger_koin.koin

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val ClassModule = module {
    factory { Oghat() }
    factory {
        Retrofit.Builder()
            .baseUrl("http://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    factory { koinModel(get(), get()) }
    viewModel { KoinViewModel(get()) }
}