package com.lya.thegoodice.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lya.thegoodice.R
import com.lya.thegoodice.databinding.ResultFragmentLayoutBinding

class ResultFragment : Fragment() {

    companion object {
        fun newInstance() = ResultFragment()
    }

    private lateinit var binding: ResultFragmentLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.result_fragment_layout, container, false)

        binding.buttonRepeat.setOnClickListener {
            this.findNavController().navigate(ResultFragmentDirections.actionResultFragmentToRollFragment())
        }

        //get the passed args from roll frag
        val args = ResultFragmentArgs.fromBundle(requireArguments())

        //create a string value that holds every rolled dice result
        var resultString = ""
        for (i in args.diceResults){
            resultString = resultString + i.toString() + " " //se queda un espacio en blanco al final; no es importante pero me da toc
        }

        //put the values of the results string in the text view
        binding.textViewResult.text = resultString
        return binding.root
    }
}