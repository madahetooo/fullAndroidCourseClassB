package com.apps.fullcourseandroidclassb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apps.fullcourseandroidclassb.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
           var result = addition(firstNumber,secondNumber)
            binding.tvResult.text = result.toString()
        }
        binding.btnMinus.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            var result = subtraction(firstNumber,secondNumber)
            binding.tvResult.text = result.toString()
        }
        binding.btnMuliply.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            var result = multiplication(firstNumber,secondNumber)
            binding.tvResult.text = result.toString()
        }
        binding.btnDivide.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            var result = division(firstNumber,secondNumber)
            binding.tvResult.text = result.toString()
        }
    }

    private fun addition ( firstNumber : Int,  secondNumber:Int):Int{
        return firstNumber+secondNumber
    }
    private fun subtraction ( firstNumber : Int,  secondNumber:Int):Int{
        return firstNumber-secondNumber
    }
    private fun multiplication ( firstNumber : Int,  secondNumber:Int):Int{
        return firstNumber*secondNumber
    }
    private fun division ( firstNumber : Int,  secondNumber:Int):Int{
        return firstNumber/secondNumber
    }
    private fun getNumber(){

    }
}