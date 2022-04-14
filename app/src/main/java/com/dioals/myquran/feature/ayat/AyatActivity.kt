package com.dioals.myquran.feature.ayat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dioals.myquran.databinding.FragmentAyatBinding

const val EXTRA_SURAH = ".mode"
const val EXTRA_NUMBER = ".number"
const val SURAH_NAME = ".name"

class AyatActivity : AppCompatActivity() {

    private lateinit var viewModel: AyatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FragmentAyatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isSurah = intent.getBooleanExtra(EXTRA_SURAH,false)
        val number = intent.getIntExtra(EXTRA_NUMBER,1)

        viewModel = ViewModelProvider(this, AyatModelFactory(this,isSurah, number)).get(AyatViewModel::class.java)
        binding.lifecycleOwner = this
        binding.rvData.adapter = AyatAdapter()
        binding.vm = viewModel

        if(isSurah) {
            val name = intent.getStringExtra(SURAH_NAME)
            setTitle("Surah $name")
        }else
            setTitle("Juz $number")
    }
}