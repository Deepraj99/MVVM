package com.example.mvvm.utils

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtil {
    companion object{
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!
                .isConnected
        }
    }
}