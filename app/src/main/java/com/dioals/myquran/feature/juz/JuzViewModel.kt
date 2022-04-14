package com.dioals.myquran.feature.juz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dioals.myquran.model.Juz
import com.dioals.myquran.network.ApiStatus
import kotlinx.coroutines.launch

/**
 * Created by Dio Als on 11/04/2022
 */

class JuzViewModel : ViewModel() {
    private var _juz = MutableLiveData<List<Juz>>()
    val juz: LiveData<List<Juz>> = _juz

    init {
        populateJuz()
    }

    fun populateJuz() {
        val data: MutableList<Juz> = ArrayList()
        repeat(30) {
            data.add(Juz(it+1))
        }
        viewModelScope.launch {
            _juz.value = data
        }
    }
}