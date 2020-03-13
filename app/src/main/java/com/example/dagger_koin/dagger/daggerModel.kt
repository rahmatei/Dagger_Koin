package com.example.dagger_koin.dagger

import android.util.Log
import com.example.dagger_koin.RetrofitInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class daggerModel @Inject constructor (private val retrofit: Retrofit , private val oghat:Oghat)  {

    val disposable = CompositeDisposable()

    fun GetShareiData(city: String, country: String, method: String): Observable<Oghat> {
        var oghat = Oghat()
        val timingInterface = retrofit.create(RetrofitInterface::class.java)
        disposable.add(
            timingInterface.GetSharei(city, country, method)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    oghat.sunrise = it.data.timings.Sunrise
                    oghat.sunset = it.data.timings.Sunset
                }, {
                    Log.d("Error", it.message.toString())
                })
        )
        return Observable.just(oghat)
    }
}