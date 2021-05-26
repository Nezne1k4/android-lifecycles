package com.nezneika.diylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nezneika.diylifecycle.databinding.ActivityClockBinding

class ClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_clock)
        val binding: ActivityClockBinding = DataBindingUtil.setContentView(this, R.layout.activity_clock)

        // https://developer.android.com/codelabs/android-databinding#6
        //binding.lifecycleOwner = this
        binding.chronometer.start()
    }
}