package com.dioals.myquran.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import com.google.gson.Gson

class PreferenceHelper(val mContext: Context) {
    companion object{
        const val ADMOB_INTERSTITIAL = "admob_interstitial"
    }
    private var sharedPreferences: SharedPreferences

    init { sharedPreferences = getSharedPreference(mContext) }

    private fun getSharedPreference(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun putString(key: String?, isi: String?) = sharedPreferences.edit().putString(key, isi).apply()

    fun getScreenHeight(): Int = Resources.getSystem().displayMetrics.heightPixels

    fun putInt(key: String?, num: Int) = sharedPreferences.edit().putInt(key, num).apply()

    fun <T> putList(key: String?, list: List<T>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        putString(key, json)
    }

    fun <T> putObj(key: String?, obj: T) {
        val gson = Gson()
        val json = gson.toJson(obj)
        putString(key, json)
    }

    fun getString(key: String?): String? = sharedPreferences.getString(key, "")

    fun getInt(key: String?): Int = sharedPreferences.getInt(key, 0)

    fun <T> getList(key: String?, cls: Class<Array<T>?>?): List<T>? {
        val gson = Gson()
        val json = getString(key)
        val list = gson.fromJson(json, cls)
        return if (list != null) listOf(*list) else null
    }

    fun <T> getObj(key: String?, cls: Class<T>?): T {
        val gson = Gson()
        val json = getString(key)
        return gson.fromJson(json, cls)
    }

    fun clear(key: String?) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}