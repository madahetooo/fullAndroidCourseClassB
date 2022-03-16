package com.apps.fullcourseandroidclassb.otherapps.ui.others

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.databinding.ActivityBullsCarsBinding
import com.apps.fullcourseandroidclassb.databinding.ActivityCalculatorBinding


class Calculator : Fragment() {
    private var _binding: ActivityCalculatorBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnPlus.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            var result = addition(firstNumber, secondNumber)
            binding.tvResult.text = result.toString()
        }
        binding.btnMinus.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            var result = subtraction(firstNumber, secondNumber)
            binding.tvResult.text = result.toString()
        }
        binding.btnMuliply.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            var result = multiplication(firstNumber, secondNumber)
            binding.tvResult.text = result.toString()
        }
        binding.btnDivide.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            var result = division(firstNumber, secondNumber)
            binding.tvResult.text = result.toString()
        }
        return view
    }


}

private fun addition(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}

private fun subtraction(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber - secondNumber
}

private fun multiplication(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber * secondNumber
}

private fun division(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber / secondNumber
}