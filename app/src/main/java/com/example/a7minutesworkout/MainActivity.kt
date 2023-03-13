package com.example.a7minutesworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.FrameLayout
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var countDownTimer : CountDownTimer? = null
    private var timerDuration : Long = 60000
    private var pauseOffset : Long = 0
    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
      /* val flStartButton = findViewById<FrameLayout>(R.id.flStart)
        flStartButton.setOnClickListener {
          Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }*/
        /*
        tvTimer.text = "${(timerDuration/1000).toString()}"
        btnStart.setOnClickListener {
            startTimer(pauseOffset)
        }
        btnPause.setOnClickListener {
            pauseTimer()
        }
        btnStop.setOnClickListener {
            resetTimer()
        }

        private fun startTimer(pauseOffset: Long) {
            countDownTimer = object : CountDownTimer(timerDuration - pauseOffset, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                pauseOffset = timerDuration - millisUntilFinished
                    tvTimer.text = "${(millisUntilFinished/1000).toString()}"
                }

                override fun onFinish() {
                    Toast.makeText(this@MainActivity, "Timer Finished", Toast.LENGTH_SHORT).show()
                }
            }.start()
        }

        private fun pauseTimer() {
            if(countDownTimer != null){
                countDownTimer?.cancel()
            }
        }
        private fun resetTimer() {
            if(countDownTimer != null){
                countDownTimer?.cancel()
                pauseOffset = 0
                countDownTimer = null
                tvTimer.text = "${(timerDuration/1000).toString()}"
             }
         }

        */
        binding?.flStart?.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }
    }

    // To avoid memory leak we need to set the binding to null in onDestroy
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}