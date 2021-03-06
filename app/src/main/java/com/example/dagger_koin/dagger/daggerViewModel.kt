package com.example.dagger_koin.dagger

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class daggerViewModel @Inject constructor(private val daggerModel:daggerModel) : ViewModel() {


    val dispose = CompositeDisposable()
    private val ResponseSharei = MutableLiveData<Oghat>()

    fun GetShareidata(city: String, country: String, method: String) {
        dispose.add(
            daggerModel.GetShareiData(city, country, method)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ResponseSharei.value = it
                }, {
                    Log.d("Erorr ViewModel", it.message)
                })
        )
        //oghat_Model.GetShareiData(city, country, method)
    }

    fun GetLiveResponseSharei(): LiveData<Oghat> {
        return ResponseSharei
    }

    override fun onCleared() {
        dispose.dispose()
        super.onCleared()
    }
}