package com.dioals.myquran

import android.app.Application
import com.google.android.gms.ads.MobileAds


/**
 * Created by Dio Als on 25/05/2022
 */

class QuranApplication: Application() {

    private var appOpenManager: AppOpenManager? = null

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) { }
        appOpenManager = AppOpenManager(this);
    }

}