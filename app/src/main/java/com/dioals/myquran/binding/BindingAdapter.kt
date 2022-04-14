package com.dioals.myquran.binding

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dioals.myquran.R
import com.dioals.myquran.feature.ayat.AyatAdapter
import com.dioals.myquran.feature.juz.JuzAdapter
import com.dioals.myquran.feature.surah.SurahAdapter
import com.dioals.myquran.model.Juz
import com.dioals.myquran.model.Surah
import com.dioals.myquran.model.VersesItem
import com.dioals.myquran.network.ApiStatus

/**
 * Created by Dio Als on 12/04/2022
 */

@BindingAdapter("listSurah")
fun bindSurah(rvData: RecyclerView, data: List<Surah>?) {
    val adapter = rvData.adapter as SurahAdapter
    adapter.submitList(data)
}

@BindingAdapter("listJuz")
fun bindJuz(rvData: RecyclerView, data: List<Juz>?) {
    val adapter = rvData.adapter as JuzAdapter
    adapter.submitList(data)
}

@BindingAdapter("listAyat")
fun bindAyat(rvData: RecyclerView, data: List<VersesItem>?) {
    val adapter = rvData.adapter as AyatAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView,
               status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_anim)
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}