package com.example.remote.util.ext

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment

/**
 *  Run task on main thread after given delay in milliseconds. Default delay is 200L
 */
fun Context.runAfterDelay(delay: Long = 200, onCompletion: (() -> (Unit))? = null) {
    Handler(Looper.getMainLooper()).postDelayed({
        onCompletion?.invoke()
    }, delay)
}


/**
 *  Run task on main thread after given delay in milliseconds. Default delay is 200L
 */
fun Activity.runAfterDelay(delay: Long = 200, onCompletion: (() -> (Unit))? = null) {
    Handler(Looper.getMainLooper()).postDelayed({
        // Activity exist
        if (isFinishing.not()) {
            onCompletion?.invoke()
        }
    }, delay)
}

/**
 *  Run task on main thread after given delay in milliseconds. Default delay is 200L.
 *  It is specially written for fragment to fire callback only if fragment exist
 */
fun Fragment.runAfterDelay(delay: Long = 200, onCompletion: (() -> (Unit))? = null) {
    Handler(Looper.getMainLooper()).postDelayed({
        // check fragment exist
        if (isAdded) {
            onCompletion?.invoke()
        }
    }, delay)
}

