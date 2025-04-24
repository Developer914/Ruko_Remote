package com.example.remote.util.ext

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

/**
 * Show toast message
 */
fun Context.showToast(message: String) {
    Handler(Looper.getMainLooper()).post {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}