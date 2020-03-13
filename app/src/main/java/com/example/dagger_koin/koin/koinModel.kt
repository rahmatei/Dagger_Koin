package com.example.dagger_koin.koin

import android.util.Log
import com.example.dagger_koin.RetrofitInterface
import com.example.dagger_koin.dagger.Oghat
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class koinModel (private val retrofit: Retrofit, private val oghat: Oghat)  {

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