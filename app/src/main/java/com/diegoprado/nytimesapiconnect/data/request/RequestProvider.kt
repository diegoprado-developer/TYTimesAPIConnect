package com.diegoprado.nytimesapiconnect.data.request

import com.diegoprado.nytimesapiconnect.data.database.entity.BooksEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestProvider {

    @GET("lists.json")
    fun getListBooks(@Query("api-key")api_key: String,
            @Query ("list")list: String = "hardcover-fiction"): Call<BooksEntity>

    @GET("reviews")
    fun getReviewBooks()
}