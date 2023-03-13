package com.example.a7minutesworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
      /* val flStartButton = findViewById<FrameLayout>(R.id.flStart)
        flStartButton.setOnClickListener {
          Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }*/
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