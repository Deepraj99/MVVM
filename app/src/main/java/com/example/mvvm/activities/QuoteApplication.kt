package com.example.mvvm.activities

import android.app.Application
import com.example.mvvm.api.APIInterface
import com.example.mvvm.api.RetrofitHelper
import com.example.mvvm.db.QuoteDatabase
import com.example.mvvm.repositories.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository
    lateinit var apiInterface: APIInterface
    lateinit var quoteDatabase: QuoteDatabase

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
        apiInterface = RetrofitHelper.getInstance().create(APIInterface::class.java)
        quoteRepository = QuoteRepository(apiInterface, quoteDatabase, applicationContext)
    }
}