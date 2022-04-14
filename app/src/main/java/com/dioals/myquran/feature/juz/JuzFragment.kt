package com.dioals.myquran.feature.juz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dioals.myquran.R
import com.dioals.myquran.databinding.FragmentJuzBinding

class JuzFragment : Fragment() {

    private val viewModel: JuzViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentJuzBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.rvData.adapter = JuzAdapter(requireContext())
        return binding.root
    }
}