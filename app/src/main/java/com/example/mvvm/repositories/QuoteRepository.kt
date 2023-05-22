package com.example.mvvm.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.api.APIInterface
import com.example.mvvm.models.QuoteList

class QuoteRepository(private val apiInterface: APIInterface) {

    private val quoteMutableLiveData = MutableLiveData<QuoteList>()
    val quoteLiveData: LiveData<QuoteList>
    get() = quoteMutableLiveData

    suspend fun getQuotes(page: Int) {
        val quotes = apiInterface.getQuotes(page)
        if(quotes?.body() != null) {
            quoteMutableLiveData.postValue(quotes.body())
        }
    }
}