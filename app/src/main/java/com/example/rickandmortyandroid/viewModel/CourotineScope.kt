package com.example.rickandmortyandroid.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class CoroutineViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext = Main

    private val jobs = ArrayList<Job>()

    override fun onCleared() {
        jobs.forEach { if (!it.isCancelled) it.cancel() }
        super.onCleared()
    }

    fun run(block: () -> Job) {
        jobs.add(block.invoke())
    }

}