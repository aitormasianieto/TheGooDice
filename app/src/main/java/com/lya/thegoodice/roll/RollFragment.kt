package com.lya.thegoodice.roll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.lya.thegoodice.R
import com.lya.thegoodice.databinding.RollFragmentLayoutBinding

class RollFragment : Fragment() {

    companion object {
        fun newInstance() = RollFragment()
    }
    private lateinit var binding: RollFragmentLayoutBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.roll_fragment_layout, container, false)

        return binding.root
    }
}