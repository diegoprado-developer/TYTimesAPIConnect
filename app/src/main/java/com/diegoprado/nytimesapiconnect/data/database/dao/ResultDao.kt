package com.diegoprado.nytimesapiconnect.data.database.dao

import androidx.room.*
import com.diegoprado.nytimesapiconnect.data.database.entity.BooksEntity

//import com.diegoprado.nytimesapiconnect.data.database.entity.ResultEntity

@Dao
interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(result: BooksEntity.Results)

    @Delete
    fun deleteResult()

    @Update
    fun updateResult()

    @Query("SELECT * FROM result")
    fun getResultList(): BooksEntity.Results
}