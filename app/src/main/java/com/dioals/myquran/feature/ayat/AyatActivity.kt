package com.dioals.myquran.feature.ayat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dioals.myquran.databinding.FragmentAyatBinding
import com.dioals.myquran.utils.InterstitialManager

const val EXTRA_SURAH = ".mode"
const val EXTRA_NUMBER = ".number"
const val SURAH_NAME = ".name"

class AyatActivity : AppCompatActivity() {

    private val tag = "ayatActivity"
    private lateinit var viewModel: AyatViewModel
    private var interstitial: InterstitialManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FragmentAyatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupInterstitial()

        val isSurah = intent.getBooleanExtra(EXTRA_SURAH,false)
        val number = intent.getIntExtra(EXTRA_NUMBER,1)

        viewModel = ViewModelProvider(this, AyatModelFactory(isSurah, number))[AyatViewModel::class.java]
        binding.lifecycleOwner = this
        binding.rvData.adapter = AyatAdapter()
        binding.vm = viewModel

        title = if(isSurah) {
            val name = intent.getStringExtra(SURAH_NAME)
            "Surah $name"
        }else
            "Juz $number"
    }

    fun setupInterstitial(){
        //google admob //disabled until get many download
        interstitial = InterstitialManager(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        interstitial?.showAdmob()
    }
}