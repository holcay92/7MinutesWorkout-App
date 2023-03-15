package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var restCountDownDuration: Long = 10000
    private var exerciseCountDownDuration: Long = 30000
    private var binding: ActivityExerciseBinding? = null
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0
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
    private fun setUpExerciseView(){
        binding?.flProgressBar?.visibility = View.INVISIBLE
        binding?.tvTitle?.text = "Exercise Name"
        binding?.flExerciseView?.visibility = View.VISIBLE


        if(exerciseTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        // this helps to set the progress bar to 0
        setExerciseProgressBar()
    }


    private fun setRestProgressBar() {
        binding?.progressBar?.progress = restProgress
        restTimer = object : CountDownTimer(restCountDownDuration, 1000) {
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
                setUpExerciseView()
            }
        }.start()
    }
    private fun setExerciseProgressBar() {
        binding?.progressBarExercise?.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(exerciseCountDownDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                binding?.progressBarExercise?.progress = (exerciseCountDownDuration/1000).toInt() - exerciseProgress
                binding?.tvTimerExercise?.text = ((exerciseCountDownDuration/1000).toInt() - exerciseProgress).toString()
            }
            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "30 seconds are over, lets go ot the rest view...",
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
        if(exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        binding = null
    }
}