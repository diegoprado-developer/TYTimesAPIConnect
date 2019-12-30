package com.diegoprado.nytimesapiconnect.data.database.entity

import androidx.room.*
import com.diegoprado.nytimesapiconnect.data.database.converts.Converters
import com.google.gson.annotations.SerializedName

class BooksEntity {

    @SerializedName("status")
    var status: String? = null

    @TypeConverters(Converters::class)
    @SerializedName("results")
    var result: List<Results>? = null

    @Entity(tableName = "result")
    class Results {
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0

        @SerializedName("list_name")
        var listName: String? = null

        @SerializedName("amazon_product_url")
        var amazonProduct: String? = null

        @SerializedName("book_details")
        @TypeConverters(Converters::class)
        var books: List<BookDetail>? = null
    }

    @Entity(tableName = "books_details")
//    , foreignKeys = [
//        ForeignKey(
//            entity = Results::class,
//            parentColumns = arrayOf("id"),
//            childColumns = arrayOf("idResult"))])
//    @TypeConverters(Converters::class)
    class BookDetail {
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0

        var idResult: Int = 0

        @SerializedName("author")
        var authorName: String? = null

        //@ColumnInfo(name = "title")
        @SerializedName("title")
        var bookName: String? = null

        @SerializedName("description")
        var descriptionBook: String? = null
    }
}