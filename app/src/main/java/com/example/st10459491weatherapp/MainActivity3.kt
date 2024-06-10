// src/main/java/com/example/weatherapp/DetailedViewActivity.kt
package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.st10459491weatherapp.R

class DetailedViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val minTemps = intent.getDoubleArrayExtra("minTemps")
        val maxTemps = intent.getDoubleArrayExtra("maxTemps")
        val conditions = intent.getStringArrayExtra("conditions")
        var backButton = findViewById<Button>(R.id.backButton)
        val day1Details = findViewById<TextView>(R.id.day1Details)

        if (minTemps != null && maxTemps != null && conditions != null) {
            day1Details.text = "Monday: Min: ${minTemps[0]}, Max: ${maxTemps[0]}, Condition: ${conditions[0]}"
            // Repeat for other days
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
