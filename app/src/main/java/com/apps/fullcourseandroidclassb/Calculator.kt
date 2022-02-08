package com.apps.fullcourseandroidclassb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btnPlus.setOnClickListener {
            val firstNumber = etFirstNumber.text.toString().toInt()
            val secondNumber = etSecondNumber.text.toString().toInt()
           var result = addition(firstNumber,secondNumber)
            tvResult.text = result.toString()
        }
        btnMinus.setOnClickListener {
            val firstNumber = etFirstNumber.text.toString().toInt()
            val secondNumber = etSecondNumber.text.toString().toInt()
            var result = subtraction(firstNumber,secondNumber)
            tvResult.text = result.toString()
        }
        btnMuliply.setOnClickListener {
            val firstNumber = etFirstNumber.text.toString().toInt()
            val secondNumber = etSecondNumber.text.toString().toInt()
            var result = multiplication(firstNumber,secondNumber)
            tvResult.text = result.toString()
        }
        btnDivide.setOnClickListener {
            val firstNumber = etFirstNumber.text.toString().toInt()
            val secondNumber = etSecondNumber.text.toString().toInt()
            var result = division(firstNumber,secondNumber)
            tvResult.text = result.toString()
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