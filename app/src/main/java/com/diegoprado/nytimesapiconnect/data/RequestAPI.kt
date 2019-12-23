package com.diegoprado.nytimesapiconnect.data

import com.diegoprado.nytimesapiconnect.data.request.RequestProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RequestAPI {

    private var accessAPI: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/books/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
        .build()

    fun request(): RequestProvider =
        accessAPI.create(RequestProvider::class.java)
}