package com.dioals.myquran.feature.juz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dioals.myquran.R
import com.dioals.myquran.databinding.ItemJuzBinding
import com.dioals.myquran.feature.ayat.AyatActivity
import com.dioals.myquran.feature.ayat.EXTRA_NUMBER
import com.dioals.myquran.feature.ayat.EXTRA_SURAH
import com.dioals.myquran.model.Juz

/**
 * Created by Dio Als on 10/04/2022
 */

class JuzAdapter(val mContext: Context): ListAdapter<Juz, JuzAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Juz>() {
        override fun areItemsTheSame(oldItem: Juz, newItem: Juz): Boolean =
            oldItem==newItem

        override fun areContentsTheSame(oldItem: Juz, newItem: Juz): Boolean =
            oldItem.number==newItem.number
    }

    class ViewHolder(private val binding: ItemJuzBinding, val mContext:Context):RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(juz:Juz, isEven:Boolean){
            with(binding){
                bg.setBackgroundColor(ContextCompat.getColor(mContext, if(isEven) R.color.color_even else R.color.color_odd))
                tvNumber.text = "Juz ${juz.number}"
                bg.setOnClickListener {
                    val intent = Intent(mContext, AyatActivity::class.java)
                    intent.putExtra(EXTRA_SURAH,false)
                    intent.putExtra(EXTRA_NUMBER,juz.number)
                    mContext.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemJuzBinding.inflate(LayoutInflater.from(parent.context)), mContext)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), position%2==0)
}