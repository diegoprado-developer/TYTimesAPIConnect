package com.diegoprado.nytimesapiconnect.ui.model

import com.google.gson.annotations.SerializedName

 class BooksModel {

         @SerializedName("status")
         var status: String? = null

     @SerializedName("results")
     var results: Results? = null

    class Results{
        @SerializedName("list_name")
        var listName: String? = null

        @SerializedName("books")
        var books: BooksList? = null
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