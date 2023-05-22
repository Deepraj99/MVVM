package com.example.mvvm.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.api.APIInterface
import com.example.mvvm.db.QuoteDatabase
import com.example.mvvm.models.QuoteList
import com.example.mvvm.utils.NetworkUtil

class QuoteRepository(
    private val apiInterface: APIInterface,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quoteMutableLiveData = MutableLiveData<QuoteList>()
    val quoteLiveData: LiveData<QuoteList>
    get() = quoteMutableLiveData

    suspend fun getQuotes(page: Int) {
        val quotes = apiInterface.getQuotes(page)
        if (NetworkUtil.isNetworkAvailable(applicationContext)) {
            if(quotes.body() != null) {
                quoteDatabase.quoteDao().addQuote(quotes.body()!!.results)
                quoteMutableLiveData.postValue(quotes.body())
            }
        } else {
            val result = quoteDatabase.quoteDao().getQuotes()
//            val quotes = QuoteList(1, 1, 1, result, 1, 1)
//            quoteMutableLiveData.postValue(quotes)
        }
    }
}