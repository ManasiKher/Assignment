package com.kotlin.mvvm.synerzip.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Manasi on 31,March,2021
 */

object ConnectivityUtil {

    @Suppress("DEPRECATION")
    fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}