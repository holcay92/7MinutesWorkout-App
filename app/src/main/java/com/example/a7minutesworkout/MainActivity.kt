package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flStartButton = findViewById<FrameLayout>(R.id.flStart)
        flStartButton.setOnClickListener {
          Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}