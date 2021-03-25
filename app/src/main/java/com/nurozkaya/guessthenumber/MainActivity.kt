package com.nurozkaya.guessthenumber

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nurozkaya.guessthenumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var randomNum=0
    private var chance=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //for binding
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        randomNum=(1..100).random()
        //Write console random num
        Log.e("RandomNumber", randomNum.toString())

        binding.button.setOnClickListener {
            chance-=1
            enterGuess()
        }
    }

    private fun enterGuess() {
        if(binding.textInputEditTextGuess.text.toString() == "") {
            binding.textInputLayoutGuess.error=getString(R.string.error_message)
        } else {

            binding.textInputLayoutGuess.error=null
            val userGuess=binding.textInputEditTextGuess.text.toString().toInt()

            if(userGuess==randomNum) {
                binding.textViewEnterNumber.setText(R.string.congrats_message)
                binding.scoreText.setText("Score: $chance")
                return
            }
            if(userGuess>randomNum) {
                binding.textViewEnterNumber.setText(R.string.try_smaller)
                binding.scoreText.setText("Score: $chance")
                binding.textInputEditTextGuess.setText("")
            }
            if(userGuess<randomNum) {
                binding.textViewEnterNumber.setText(R.string.try_greater)
                binding.scoreText.setText("Score: $chance")
                binding.textInputEditTextGuess.setText("")
            }
        }



    }
}