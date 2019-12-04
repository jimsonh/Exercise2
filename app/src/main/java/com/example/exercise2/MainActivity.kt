package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var weight:EditText
    lateinit var height:EditText
    lateinit var bmi:TextView
    lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight.findViewById<EditText>(R.id.editTextWeight)
        height.findViewById<EditText>(R.id.editTextHeight)
        bmi.findViewById<TextView>(R.id.textViewBMI)
        image.findViewById<ImageView>(R.id.imageViewProfile)
        image.setImageResource(R.drawable.empty)

        val calButton = findViewById<Button>(R.id.buttonCalculate)
        val resetButton = findViewById<Button>(R.id.buttonReset)
        calButton.setOnClickListener{cal()}
        resetButton.setOnClickListener{reset()}

    }

    private fun cal(){
        val bmiDouble = weight.toString().toDouble()/(height.toString().toDouble()/100).pow(2)
        bmi.text="BMI: "+bmiDouble

        if(bmiDouble<18.5)
            image.setImageResource(R.drawable.under)
        else if(bmiDouble<25)
            image.setImageResource(R.drawable.normal)
        else
            image.setImageResource(R.drawable.over)

    }

    private fun reset(){
        image.setImageResource(R.drawable.empty)
        weight.setText(R.string.weight)
        height.setText(R.string.height)
        bmi.setText(R.string.bmi)

    }
}
