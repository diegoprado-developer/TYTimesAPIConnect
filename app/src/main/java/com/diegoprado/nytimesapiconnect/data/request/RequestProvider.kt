package com.diegoprado.nytimesapiconnect.data.request

<<<<<<< HEAD
import com.diegoprado.nytimesapiconnect.data.database.entity.BooksEntity
=======
import androidx.lifecycle.Observer
import com.diegoprado.nytimesapiconnect.ui.model.BooksModel
>>>>>>> refactor
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