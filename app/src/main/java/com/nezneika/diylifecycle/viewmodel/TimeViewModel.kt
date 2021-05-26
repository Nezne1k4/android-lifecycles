package com.nezneika.diylifecycle.viewmodel

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TimeViewModel : ViewModel() {
    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long> = _elapsedTime

    private val timer = Timer()

    init {
        val initialTime = SystemClock.elapsedRealtime()

        timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    val newPeriod = (SystemClock.elapsedRealtime() - initialTime) / 1000;
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
}