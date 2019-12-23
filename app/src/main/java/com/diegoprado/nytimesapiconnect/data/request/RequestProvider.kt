package com.diegoprado.nytimesapiconnect.data.request

import androidx.lifecycle.Observer
import com.diegoprado.nytimesapiconnect.ui.model.BooksModel
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestProvider {

    @GET("lists.json")
    fun getListBooks(@Query("api-key")api_key: String,
            @Query ("list")list: String = "hardcover-fiction"): Call<BooksModel>

    @GET("reviews")
    fun getReviewBooks()
}