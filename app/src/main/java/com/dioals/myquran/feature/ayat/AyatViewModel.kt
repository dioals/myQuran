package com.dioals.myquran.feature.ayat

import androidx.lifecycle.*
import com.dioals.myquran.model.Pagination
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

class AyatViewModel(isSurah: Boolean, number:Int) : ViewModel() {

    private var _surahName =MutableLiveData<String>()
    val surahName : LiveData<String> = _surahName

    private var _ayat = MutableLiveData<List<VersesItem>>()
    val ayat: LiveData<List<VersesItem>> = _ayat

    private var _status = MutableLiveData<ApiStatus>()
    val status :LiveData<ApiStatus> = _status

    init {
        getAyatList(isSurah, number)
    }

    private fun getAyatList(isSurah:Boolean, number: Int, page:Int=1) {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val response = QuranApi.retrofitService.getSurah(number,page)
                val json = Gson().toJson(response.verses)
                val listMyData = Types.newParameterizedType(List::class.java, VersesItem::class.java)
                val jsonAdapter = moshi.adapter<List<VersesItem>>(listMyData)
                val data = jsonAdapter.fromJson(json)
                val existingData = ArrayList<VersesItem>()
                _ayat.value?.let { existingData.addAll(it) }
                data?.let { existingData.addAll(it) }
                _ayat.value = existingData
                _status.value = ApiStatus.DONE

                val infoResponse = Gson().toJson(response.pagination)
                val info = Gson().fromJson(infoResponse,Pagination::class.java)
                if(info.next_page != null)
                    getAyatList(true,number,info.next_page)
            }catch (e:Exception){
                e.printStackTrace()
                _ayat.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }
}

class AyatModelFactory constructor(private val isSurah: Boolean, private val number: Int):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AyatViewModel(isSurah, number) as T
    }
}