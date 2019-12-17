package com.diegoprado.nytimesapiconnect.data.request

import retrofit2.http.GET

interface RequestProvider {

    @GET("lists/names.json")
    fun getListBooks()
}