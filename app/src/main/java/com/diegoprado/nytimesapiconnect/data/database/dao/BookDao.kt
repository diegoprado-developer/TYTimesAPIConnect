package com.diegoprado.nytimesapiconnect.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diegoprado.nytimesapiconnect.data.database.entity.BooksEntity

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookDetail(bookDetail: BooksEntity.BookDetail)

    @Query("SELECT * FROM books_details WHERE bookName = :nameBook")
    fun selectBookDetail(nameBook: String): BooksEntity.BookDetail

    @Query("SELECT * FROM books_details")
    fun getBookDetail(): BooksEntity.BookDetail

    @Query("SELECT COUNT(bookName) FROM books_details")
    fun getCount(): Int
}