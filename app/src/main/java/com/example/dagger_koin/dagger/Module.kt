package com.example.dagger_koin.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class Module {
    @Provides
    fun retrofitProvider():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}