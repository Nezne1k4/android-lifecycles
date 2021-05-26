package com.nezneika.diylifecycle.viewmodel

import androidx.lifecycle.ViewModel

class TimeViewModel : ViewModel() {
    private var mStartTime: Long? = null

    fun getStartTime(): Long? {
        return mStartTime
    }

    fun setStartTime(startTime: Long) {
        mStartTime = startTime
    }
}