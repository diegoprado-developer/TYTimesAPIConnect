package com.diegoprado.nytimesapiconnect.ui.model

import com.google.gson.annotations.SerializedName
import java.util.*

class BooksModel {

     @SerializedName("status")
     var status: String? = null

     @SerializedName("results")
     var result: List<Results>? = null

    class Results{
        @SerializedName("list_name")
        var listName: String? = null

        @SerializedName( "amazon_product_url")
        var amazonProduct: String? = null

        @SerializedName("book_details")
        var books: List<BooksList>? = null
    }

    class BooksList{
        @SerializedName("author")
        var authorName: String? = null

        @SerializedName("title")
        var bookName: String? = null

        @SerializedName("description")
        var descriptionBook: String? = null
    }
}