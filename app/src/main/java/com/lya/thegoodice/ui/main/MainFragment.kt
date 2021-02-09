package com.lya.thegoodice.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.lya.thegoodice.R
import com.lya.thegoodice.databinding.MainFragmentLayoutBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    private lateinit var binding: MainFragmentLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment_layout, container, false)

        binding.buttonStart.setOnClickListener {
            this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToRollFragment())
        }

        return binding.root
    }
}