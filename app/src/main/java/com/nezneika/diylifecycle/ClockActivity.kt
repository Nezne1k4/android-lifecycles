package com.nezneika.diylifecycle

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nezneika.diylifecycle.databinding.ActivityClockBinding
import com.nezneika.diylifecycle.viewmodel.TimeViewModel

class ClockActivity : AppCompatActivity() {

    private val viewModel: TimeViewModel by lazy {
        ViewModelProvider(this).get(TimeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_clock)
        val binding: ActivityClockBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_clock)

        // https://developer.android.com/codelabs/android-databinding#6
        //binding.lifecycleOwner = this

        // subscribe to time change
        viewModel.elapsedTime.observe(this, Observer { timePeriod ->
            binding.timerTextview.text = timePeriod.toString()
        })
    }

}