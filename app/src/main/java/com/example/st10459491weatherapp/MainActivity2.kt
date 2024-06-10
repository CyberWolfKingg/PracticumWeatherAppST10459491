package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.st10459491weatherapp.R

class MainActivity2 : AppCompatActivity() {
    private val minTemps = DoubleArray(7)
    private val maxTemps = DoubleArray(7)
    private val conditions = arrayOfNulls<String>(7)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val detailedViewButton = findViewById<Button>(R.id.detailedViewButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val enterDate = findViewById<EditText>(R.id.enterDate)
        var day1MinTemp = findViewById<EditText>(R.id.day1MinTemp)
        var day1MaxTemp = findViewById<EditText>(R.id.day1MaxTemp)
        var day1Condition = findViewById<EditText>(R.id.day1Condition)
        var averageTempTextView = findViewById<TextView>(R.id.averageTempTextView)

        calculateButton.setOnClickListener {
            try {
                minTemps[0] = day1MinTemp.text.toString().toDouble()
                maxTemps[0] = day1MaxTemp.text.toString().toDouble()
                conditions[0] = day1Condition.text.toString()

                // Repeat for other days

                val averageTemp = calculateAverageTemperature()
                averageTempTextView.text = "Average Temperature: $averageTemp °C"
            } catch (e: Exception) {
                Toast.makeText(this, "Please enter valid data!", Toast.LENGTH_SHORT).show()
            }
        }

        detailedViewButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("minTemps", minTemps)
            intent.putExtra("maxTemps", maxTemps)
            intent.putExtra("conditions", conditions)
            startActivity(intent)
        }

        clearButton.setOnClickListener {
            day1MinTemp.text.clear()
            day1MaxTemp.text.clear()
            day1Condition.text.clear()
            // Repeat for other days
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }

    private fun calculateAverageTemperature(): Double {
        var totalTemp = 0.0
        for (i in minTemps.indices) {
            totalTemp += (minTemps[i] + maxTemps[i]) / 2
        }
        return totalTemp / minTemps.size
    }
}
