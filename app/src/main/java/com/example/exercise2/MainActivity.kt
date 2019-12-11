package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.exercise2.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            cal(it)
        }

        binding.buttonReset.setOnClickListener{
            reset()
        }






    }

    private fun cal(view: View){
        binding.apply {


            val height = editTextHeight.text.toString().toDouble()
            val weight = editTextWeight.text.toString().toDouble()
            val bmi = weight/((height/100).pow(2))
            textViewBMI.text= "BMI: %.2f ".format(bmi)

            when {
                bmi<18.5 -> imageViewProfile.setImageResource(R.drawable.under)
                bmi<25 -> imageViewProfile.setImageResource(R.drawable.normal)
                else -> imageViewProfile.setImageResource(R.drawable.over)
            }


        }



    }

    private fun reset(){
        binding.apply {
            imageViewProfile.setImageResource(R.drawable.empty)
            editTextWeight.setText(R.string.weight)
            editTextHeight.setText(R.string.height)
            textViewBMI.setText(R.string.bmi)

        }



    }
}
