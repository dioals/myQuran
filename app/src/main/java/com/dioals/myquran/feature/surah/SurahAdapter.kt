package com.dioals.myquran.feature.surah

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dioals.myquran.R
import com.dioals.myquran.databinding.ItemSurahBinding
import com.dioals.myquran.feature.ayat.AyatActivity
import com.dioals.myquran.feature.ayat.EXTRA_NUMBER
import com.dioals.myquran.feature.ayat.EXTRA_SURAH
import com.dioals.myquran.feature.ayat.SURAH_NAME
import com.dioals.myquran.model.Surah

/**
 * Created by Dio Als on 10/04/2022
 */

class SurahAdapter(val mContext: Context):ListAdapter<Surah,SurahAdapter.ViewHolder>(DiffCallback)
{
    class ViewHolder(val binding:ItemSurahBinding, val mContext: Context):RecyclerView.ViewHolder(binding.root) {
        fun bind(surah:Surah, isEven:Boolean){
            with(binding){
                tvNumber.text = surah.number.toString()
                tvTitle.text = surah.name?.transliteration?.id
                tvAyat.text = surah.name?.jsonMemberShort
                bg.setBackgroundColor(ContextCompat.getColor(mContext, if(isEven) R.color.color_even else R.color.color_odd))
                bg.setOnClickListener {
                    val intent = Intent(mContext, AyatActivity::class.java)
                    intent.putExtra(EXTRA_SURAH,true)
                    intent.putExtra(EXTRA_NUMBER,surah.number)
                    intent.putExtra(SURAH_NAME,surah.name?.transliteration?.id)
                    mContext.startActivity(intent)
                }
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Surah>() {
        override fun areItemsTheSame(oldItem: Surah, newItem: Surah): Boolean =
            oldItem==newItem

        override fun areContentsTheSame(oldItem: Surah, newItem: Surah): Boolean =
            oldItem.number==newItem.number
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder=
        ViewHolder(ItemSurahBinding.inflate(LayoutInflater.from(parent.context)),mContext)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getItem(position), position%2==0)
    }
}