package com.dioals.myquran.feature.surah

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dioals.myquran.model.Surah
import com.dioals.myquran.model.SurahList
import com.dioals.myquran.model.VersesItem
import com.dioals.myquran.network.ApiStatus
import com.dioals.myquran.network.QuranApi
import com.dioals.myquran.network.moshi
import com.google.gson.Gson
import com.squareup.moshi.Types
import kotlinx.coroutines.launch
import java.lang.reflect.Type

/**
 * Created by Dio Als on 11/04/2022
 */

class SurahViewModel : ViewModel() {

    private val _surah = MutableLiveData<List<Surah>>()
    val surah: LiveData<List<Surah>> = _surah

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    init {
        getSurahList()
    }

    fun getSurahList() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try{
                val response = QuranApi.retrofitService.getSurahList()
                val json = Gson().toJson(response.data)
                val listMyData = Types.newParameterizedType(List::class.java, Surah::class.java)
                val jsonAdapter = moshi.adapter<List<Surah>>(listMyData)
                val surahs: List<Surah> = jsonAdapter.fromJson(json)!!
                _surah.value = surahs
                _status.value = ApiStatus.DONE
            }catch (e:Exception){
                e.printStackTrace()
                _surah.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }

}