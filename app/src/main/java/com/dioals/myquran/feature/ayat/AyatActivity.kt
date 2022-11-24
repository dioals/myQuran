package com.dioals.myquran.feature.ayat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dioals.myquran.databinding.FragmentAyatBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.interstitial.InterstitialAd

const val EXTRA_SURAH = ".mode"
const val EXTRA_NUMBER = ".number"
const val SURAH_NAME = ".name"

class AyatActivity : AppCompatActivity() {

    private val tag = "ayatActivity"
    private lateinit var viewModel: AyatViewModel
    private var mInterstitialAd: InterstitialAd? = null
    private var adRequest:AdRequest?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FragmentAyatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //google admob //disabled until get many download
//        MobileAds.initialize(this) {}
//        adRequest = AdRequest.Builder().build()
//        InterstitialAd.load(this, ADMOB_INTERSTITIAL, adRequest!!, object : InterstitialAdLoadCallback() {
//            override fun onAdFailedToLoad(adError: LoadAdError) {
//                Log.d(tag, adError.message)
//                mInterstitialAd = null
//            }
//
//            override fun onAdLoaded(interstitialAd: InterstitialAd) {
//                Log.d(tag, "Ad was loaded.")
//                mInterstitialAd = interstitialAd
//            }
//        })
        mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(tag, "Ad was dismissed.")
            }

//            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
//                Log.d(tag, "Ad failed to show.")
//            }

            override fun onAdShowedFullScreenContent() {
                Log.d(tag, "Ad showed fullscreen content.")
                mInterstitialAd = null
            }
        }

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

    override fun onDestroy() {
        super.onDestroy()
//        if (mInterstitialAd != null) {
//            mInterstitialAd?.show(this)
//        } else {
//            Log.d(tag, "The interstitial ad wasn't ready yet.")
//        }
    }
}