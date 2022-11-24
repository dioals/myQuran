package com.dioals.myquran.feature.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dioals.myquran.R
import com.dioals.myquran.databinding.FragmentDashboardBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDashboardBinding.inflate(inflater,container,false)

        with(binding){
//            btnJuz.setOnClickListener { findNavController().navigate(R.id.action_dashboardFragment_to_juzFragment) }
            btnSurah.setOnClickListener { findNavController().navigate(R.id.action_dashboardFragment_to_surahFragment) }
            btnShalat.setOnClickListener { Toast.makeText(requireContext(),"Coming soon",Toast.LENGTH_SHORT).show() }
        }

        return binding.root
    }
}