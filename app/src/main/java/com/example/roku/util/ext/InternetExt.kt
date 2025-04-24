package com.example.remote.util.ext

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


/**
 * Check internet connection status
 */
fun Context.isOnline(): Boolean {
    val connectivityManager =
        getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) when {
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
    }
    return false
}
