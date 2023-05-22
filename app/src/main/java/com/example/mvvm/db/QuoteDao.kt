package com.example.mvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm.models.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuote(quotes: List<Result>)

    @Query("SELECT * FROM quotes")
    fun getQuotes() : List<Result>
}