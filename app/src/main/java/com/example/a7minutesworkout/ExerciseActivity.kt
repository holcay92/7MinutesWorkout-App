package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var restTimer: CountDownTimer? = null
    private var countDownDuration: Long = 10000
    private var restProgress = 0
    private var binding: ActivityExerciseBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExercise)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        setUpRestView()
    }
    // checks if we go back to the previous activity it will cancel the timer
    private fun setUpRestView(){
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        // this helps to set the progress bar to 0
        setRestProgressBar()
    }


    private fun setRestProgressBar() {
        binding?.progressBar?.progress = restProgress
        restTimer = object : CountDownTimer(countDownDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text = (10 - restProgress).toString()
            }
            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "Now, we will start the activity",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        binding = null
    }
}