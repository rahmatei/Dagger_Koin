package com.example.dagger_koin

import com.example.dagger_koin.pojoModel.AladhanResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("timingsByCity")
    fun GetSharei(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: String
    ): Observable<AladhanResponseModel>
}