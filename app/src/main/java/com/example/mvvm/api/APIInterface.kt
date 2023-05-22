package com.example.mvvm.api

import com.example.mvvm.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>
}