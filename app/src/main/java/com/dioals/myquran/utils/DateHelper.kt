package com.dioals.myquran.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    fun getCurrentDate():String{
        val sdf = SimpleDateFormat("yyyyMMdd")
        val date = sdf.format(Date())
        return date
    }

    fun getDailySavedDate(mContext: Context):String =
        PreferenceHelper(mContext).getString(PreferenceHelper.ADMOB_INTERSTITIAL).toString()

    fun saveDailySavedDate(mContext: Context)=
        PreferenceHelper(mContext).putString(PreferenceHelper.ADMOB_INTERSTITIAL, getCurrentDate())
}