package com.lya.thegoodice.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.lya.thegoodice.R
import com.lya.thegoodice.databinding.ResultFragmentLayoutBinding
import com.lya.thegoodice.roll.RollFragmentDirections

class ResultFragment : Fragment() {

    companion object {
        fun newInstance() = ResultFragment()
    }

    private lateinit var binding: ResultFragmentLayoutBinding

    private val args: ResultFragmentArgs by navArgs()
    private lateinit var data: Array<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.result_fragment_layout, container, false)

        binding.buttonRepeat.setOnClickListener {
            this.findNavController().navigate(ResultFragmentDirections.actionResultFragmentToRollFragment())
        }

        data = args.dicesData
        binding.textViewResult.text = data.toString()

        return binding.root
    }
}