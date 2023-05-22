package com.example.mvvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.viewModels.MainViewModel
import com.example.mvvm.viewModels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteRepository = (application as QuoteApplication).quoteRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(quoteRepository))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this, Observer {
            Log.d("DEEPAK", it.results.size.toString())
        })
    }
}