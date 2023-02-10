package com.example.mobileapp03_02_2022opgave3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.get
import com.example.mobileapp03_02_2022opgave3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // https://developer.android.com/topic/libraries/view-binding#kotlin
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        var result = ""


        binding.totalValue.setOnClickListener {

            if(binding.firstNumber.text.toString().trim().isEmpty()) {
                binding.firstNumber.error = "Missing Number"
                return@setOnClickListener
            }
            if(binding.secondNumber.text.toString().trim().isEmpty()) {
                binding.secondNumber.error = "Missing Number"
                return@setOnClickListener
            }
            var inputField = binding.firstNumber.text.toString().toFloat()
            var inputField2 = binding.secondNumber.text.toString().toFloat()
            var sign = binding.operators.selectedItem as String
            when(sign){
                "+" -> result = (inputField + inputField2).toString()
                "-" -> result = (inputField - inputField2).toString()
                "/" -> result = (inputField / inputField2).toString()
                "*" -> result = (inputField * inputField2).toString()
                else -> result = "No answer"
            }
            binding.result.text = result.toString()
        }
    }
}