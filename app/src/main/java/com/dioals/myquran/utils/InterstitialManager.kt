package com.dioals.myquran.utils

import android.app.Activity
import android.util.Log
import com.dioals.myquran.model.ADMOB_INTERSTITIAL
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialManager(private val mContext: Activity) {

    val tag = "interstitialmgr"
    private var ad: InterstitialAd? = null

    init {
        initializeAdmob()
    }

    private fun initializeAdmob() {
        if (DateHelper.getCurrentDate() == DateHelper.getDailySavedDate(mContext))
            return
        MobileAds.initialize(mContext) {}
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            mContext,
            ADMOB_INTERSTITIAL,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(tag, adError.message)
                    ad = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(tag, "Ad was loaded.")
                    ad = interstitialAd

                    DateHelper.saveDailySavedDate(mContext)
                }
            })
        ad?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(tag, "Ad was dismissed.")
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(tag, "Ad showed fullscreen content.")
                ad = null
            }
        }
    }

    fun showAdmob() {
        if (ad != null)
            ad?.show(mContext)
    }
}