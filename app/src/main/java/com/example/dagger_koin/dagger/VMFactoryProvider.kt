package com.example.dagger_koin.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit
import java.lang.IllegalArgumentException
import javax.inject.Inject

class VMFactoryProvider @Inject constructor (val daggerModel:daggerModel):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(daggerViewModel::class.java)->
                return daggerViewModel(daggerModel) as T
            else -> throw  IllegalArgumentException ("ViewModel is not  Provided")

        }
    }
}