package com.dioals.myquran.feature.ayat

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dioals.myquran.R
import com.dioals.myquran.databinding.ItemAyatBinding
import com.dioals.myquran.model.VersesItem

/**
 * Created by Dio Als on 10/04/2022
 */

class AyatAdapter(): ListAdapter<VersesItem, AyatAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<VersesItem>() {
        override fun areItemsTheSame(oldItem: VersesItem, newItem: VersesItem): Boolean =
            oldItem==newItem

        override fun areContentsTheSame(oldItem: VersesItem, newItem: VersesItem): Boolean =
            oldItem.number==newItem.number
    }

    class ViewHolder(val binding:ItemAyatBinding, val mContext: Context):RecyclerView.ViewHolder(binding.root) {
        fun bind(ayat:VersesItem, isEven:Boolean){
            with(binding){
                bg.setBackgroundColor(ContextCompat.getColor(mContext, if(isEven) R.color.color_even else R.color.color_odd))
                tvNumber.text = ayat.number?.inSurah.toString()
                surahInfo.visibility = if(ayat.number?.inSurah==1)View.VISIBLE else View.GONE
                tvAyat.text = ayat.text?.arab
                tvRead.text = ayat.translation?.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemAyatBinding.inflate(LayoutInflater.from(parent.context)),parent.context)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position),position%2==0)
}