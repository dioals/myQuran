package com.dioals.myquran.feature.prayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dioals.myquran.databinding.ActivityPrayerBinding

class PrayerActivity : AppCompatActivity() {

    private var _binding : ActivityPrayerBinding?=null
    private val binding = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPrayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}