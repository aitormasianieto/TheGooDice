package com.lya.thegoodice.roll

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lya.thegoodice.R
import com.lya.thegoodice.databinding.RollFragmentLayoutBinding
import kotlin.random.Random

class RollFragment : Fragment(), AdapterView.OnItemSelectedListener {

    companion object {
        fun newInstance() = RollFragment()

        var diceType: Int = 2
        var numberOfDices: Int = 0
        var results = arrayOf("")
    }
    private lateinit var binding: RollFragmentLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.roll_fragment_layout, container, false)

        // Button Actions
        binding.buttonToResult.setOnClickListener {
            rollDices()
            this.findNavController().navigate(RollFragmentDirections.actionRollFragmentToResultFragment(results))
        }

        // Spinner
        val spinner: Spinner = binding.spinnerDices
        val dices = arrayOf(2, 3, 4, 6, 8, 10, 12, 20, 100)
        //Create an ArrayAdapter using the string array and a default spinner layout
        val spinnerArrayAdapter: ArrayAdapter<Int> =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dices)
        // Set layout to use when the list of choices appear
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner.adapter = spinnerArrayAdapter
        //spinner.onItemSelectedListener = this

        //Real Time Update of Number of dices
        binding.editTextNumbers.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                numberOfDices = binding.editTextNumbers.text.toString().toInt()
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        return binding.root
    }

    //Esto es u poco mierder, habría que arreglarlo, mas bien hacerlo funcionar
    fun rollDices() {
        for (i in 0 until numberOfDices) {
            var data = Random.nextInt(1, diceType).toString()
            results.set(i, data)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        //Change dice type
        diceType = parent?.getItemAtPosition(pos).toString().toInt()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
        // Another interface callback
    }
}