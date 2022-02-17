package com.apps.fullcourseandroidclassb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_calculator.view.*

class Calculator : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_calculator, container, false)
        view.btnPlus.setOnClickListener {
            val firstNumber = view.etFirstNumber.text.toString().toInt()
            val secondNumber = view.etSecondNumber.text.toString().toInt()
            var result = addition(firstNumber, secondNumber)
            view.tvResult.text = result.toString()
        }
        view.btnMinus.setOnClickListener {
            val firstNumber = view.etFirstNumber.text.toString().toInt()
            val secondNumber = view.etSecondNumber.text.toString().toInt()
            var result = subtraction(firstNumber, secondNumber)
            view.tvResult.text = result.toString()
        }
        view.btnMuliply.setOnClickListener {
            val firstNumber = view.etFirstNumber.text.toString().toInt()
            val secondNumber = view.etSecondNumber.text.toString().toInt()
            var result = multiplication(firstNumber, secondNumber)
            view.tvResult.text = result.toString()
        }
        view.btnDivide.setOnClickListener {
            val firstNumber = view.etFirstNumber.text.toString().toInt()
            val secondNumber = view.etSecondNumber.text.toString().toInt()
            var result = division(firstNumber, secondNumber)
            view.tvResult.text = result.toString()
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