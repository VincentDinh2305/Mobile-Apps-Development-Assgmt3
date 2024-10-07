package com.example.dinhhoangvietphuong_comp304sec001_lab03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bnExercise1 = findViewById<Button>(R.id.btnExercise1)
        val bnExercise2 = findViewById<Button>(R.id.btnExercise2)
        val bnExercise3 = findViewById<Button>(R.id.btnExercise3)


        bnExercise1.setOnClickListener {
            val intent1 = Intent(applicationContext, DrawingActivity::class.java)
            startActivity(intent1)
        }

        bnExercise2.setOnClickListener {
            val intent2 = Intent(applicationContext, FrameAnimationActivity::class.java)
            startActivity(intent2)
        }

        bnExercise3.setOnClickListener {
            val intent3 = Intent(applicationContext, SolarSystemActivity::class.java)
            startActivity(intent3)
        }
    }
}