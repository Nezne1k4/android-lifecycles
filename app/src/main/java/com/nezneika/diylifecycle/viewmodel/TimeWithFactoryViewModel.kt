package com.nezneika.diylifecycle.viewmodel

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*

/**
 * https://medium.com/koderlabs/viewmodel-with-viewmodelprovider-factory-the-creator-of-viewmodel-8fabfec1aa4f
 */
class TimeWithFactoryViewModel(realInitTime: Int = 0) : ViewModel() {
    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long> = _elapsedTime

    private val timer = Timer()

    init {
        val initialTime = SystemClock.elapsedRealtime()

        timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    val newPeriod = realInitTime + (SystemClock.elapsedRealtime() - initialTime) / 1000;
                    _elapsedTime.postValue(newPeriod)
                }
            }, ONE_SECOND, ONE_SECOND
        )
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    companion object {
        private const val ONE_SECOND = 1000L
    }

    @Suppress("UNCHECKED_CAST")
    class CustomTimeFactoryViewModel(initTime: Int = 0) : ViewModelProvider.Factory {
        private val realInitTime = initTime * 50

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            // method 1
//            return modelClass
//                .getConstructor(Int::class.java)
//                .newInstance(realInitTime)
            // method 2
            return TimeWithFactoryViewModel(realInitTime) as T
        }
    }
}