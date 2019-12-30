package com.diegoprado.nytimesapiconnect.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diegoprado.nytimesapiconnect.data.database.converts.Converters
import com.diegoprado.nytimesapiconnect.data.database.dao.BookDao
import com.diegoprado.nytimesapiconnect.data.database.dao.ResultDao
import com.diegoprado.nytimesapiconnect.data.database.entity.BooksEntity

@Database(entities = [BooksEntity.Results::class ,BooksEntity.BookDetail::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ResultsBooksDatabase: RoomDatabase() {

    abstract fun resultDao(): ResultDao
    // será necessario criar? vamos ver
    abstract fun bookDetailsDao(): BookDao

    companion object {
        private var INSTANCE: ResultsBooksDatabase? = null

        fun getInstance(context: Context): ResultsBooksDatabase? {
            if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ResultsBooksDatabase::class.java, "resultsbooks")
                        .allowMainThreadQueries()
                        .build()
            }
                return INSTANCE
        }
    }
}