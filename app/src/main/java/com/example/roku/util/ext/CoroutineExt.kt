package com.example.remote.util.ext

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

fun ViewModel.launchViewModelScopeCoroutine(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    onCoroutineLaunch: suspend CoroutineScope.() -> Unit
): Job {
    return viewModelScope.launch(dispatcher) {
        onCoroutineLaunch.invoke(this@launch)
    }
}

fun LifecycleOwner.launchLifecycleScopeCoroutine(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    onCoroutineLaunch: suspend CoroutineScope.() -> Unit
): Job {
    return lifecycleScope.launch(dispatcher) {
        onCoroutineLaunch.invoke(this@launch)
    }
}

fun Context.launchMainScopeCoroutine(onCoroutineLaunch: suspend CoroutineScope.() -> Unit): Job {
    return MainScope().launch {
        onCoroutineLaunch.invoke(this@launch)
    }
}

fun Context.launchCoroutineScope(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    onCoroutineLaunch: suspend CoroutineScope.() -> Unit
): Job {
    return CoroutineScope(dispatcher).launch {
        onCoroutineLaunch.invoke(this@launch)
    }
}

fun launchCoroutineScope(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    onCoroutineLaunch: suspend CoroutineScope.() -> Unit
): Job {
    return CoroutineScope(dispatcher).launch {
        onCoroutineLaunch.invoke(this@launch)
    }
}
