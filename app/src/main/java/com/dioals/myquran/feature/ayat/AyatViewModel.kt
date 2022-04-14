package com.dioals.myquran.feature.ayat

import android.util.Log
import androidx.lifecycle.*
import com.dioals.myquran.model.Ayat
import com.dioals.myquran.model.Juz
import com.dioals.myquran.model.Surah
import com.dioals.myquran.model.VersesItem
import com.dioals.myquran.network.ApiStatus
import com.dioals.myquran.network.QuranApi
import com.dioals.myquran.network.moshi
import com.google.gson.Gson
import com.squareup.moshi.Types
import kotlinx.coroutines.launch

/**
 * Created by Dio Als on 11/04/2022
 */

class AyatViewModel(val act: AyatActivity,isSurah: Boolean, number:Int) : ViewModel() {

    private var _surahName =MutableLiveData<String>()
    val surahName : LiveData<String> = _surahName

    private var _ayat = MutableLiveData<List<VersesItem>>()
    val ayat: LiveData<List<VersesItem>> = _ayat

    private var _status = MutableLiveData<ApiStatus>()
    val status :LiveData<ApiStatus> = _status

    init {
        getAyatList(isSurah, number)
    }

    fun getAyatList(isSurah:Boolean, number: Int) {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val response = if(isSurah) QuranApi.retrofitService.getSurah(number) else QuranApi.retrofitService.getJuz(number)
                val json = Gson().toJson(response.data)
                if(isSurah){
                    val adapter = moshi.adapter(Ayat::class.java)
                    val data = adapter.fromJson(json)
                    _ayat.value = data?.verses!!
                }else{
                    val adapter = moshi.adapter(Juz::class.java)
                    val data = adapter.fromJson(json)
                    _ayat.value = data?.verses!!
                }
                _status.value = ApiStatus.DONE
            }catch (e:Exception){
                e.printStackTrace()
                _ayat.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }
}

class AyatModelFactory constructor(val act:AyatActivity,val isSurah: Boolean, val number: Int):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AyatViewModel(act,isSurah, number) as T
    }

}