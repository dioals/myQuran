package com.dioals.myquran.feature.surah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dioals.myquran.R
import com.dioals.myquran.databinding.FragmentSurahBinding
import com.dioals.myquran.feature.juz.JuzViewModel
import com.dioals.myquran.model.Surah

class SurahFragment : Fragment() {

    private val viewModel: SurahViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSurahBinding.inflate(inflater,container,false)
        binding.rvData.adapter = SurahAdapter(requireContext())
        binding.lifecycleOwner = this
        binding.vm = viewModel
        return binding.root
    }
}