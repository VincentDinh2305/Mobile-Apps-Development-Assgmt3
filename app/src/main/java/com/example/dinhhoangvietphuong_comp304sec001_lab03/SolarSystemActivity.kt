package com.example.dinhhoangvietphuong_comp304sec001_lab03

import android.app.Activity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class SolarSystemActivity : Activity() {
    private lateinit var sunImageView: ImageView
    private lateinit var earthImageView: ImageView
    private lateinit var fadeButton: Button
    private lateinit var growButton: Button
    private lateinit var moveButton: Button
    private lateinit var spinButton: Button
    private lateinit var allButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_system)

        sunImageView = findViewById(R.id.sunImageView)
        earthImageView = findViewById(R.id.earthImageView)
        fadeButton = findViewById(R.id.ButtonFade)
        growButton = findViewById(R.id.ButtonGrow)
        moveButton = findViewById(R.id.ButtonMove)
        spinButton = findViewById(R.id.ButtonSpin)
        allButton = findViewById(R.id.ButtonAll)

        fadeButton.setOnClickListener { onFadeClicked() }
        growButton.setOnClickListener { onGrowClicked() }
        moveButton.setOnClickListener { onMoveClicked() }
        spinButton.setOnClickListener { onSpinClicked() }
        allButton.setOnClickListener { onAllClicked() }
    }

    private fun onFadeClicked() {
        val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_out)
        sunImageView.startAnimation(fadeAnimation)
        earthImageView.startAnimation(fadeAnimation)
    }

    private fun onGrowClicked() {
        val growAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_earth)
        earthImageView.startAnimation(growAnimation)
    }

    private fun onMoveClicked() {
        val moveAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_earth)
        earthImageView.startAnimation(moveAnimation)
    }

    private fun onSpinClicked() {
        val spinAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_sun)
        sunImageView.startAnimation(spinAnimation)
    }

    private fun onAllClicked() {
        val allAnimation = AnimationUtils.loadAnimation(this, R.anim.all)
        earthImageView.startAnimation(allAnimation)

        val rotateSunAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_sun)
        sunImageView.startAnimation(rotateSunAnimation)
    }

    private fun toggleButtons(enabled: Boolean) {
        fadeButton.isEnabled = enabled
        growButton.isEnabled = enabled
        moveButton.isEnabled = enabled
        spinButton.isEnabled = enabled
        allButton.isEnabled = enabled
    }

    private fun setAnimationListener() {
        val allAnimation = AnimationUtils.loadAnimation(this, R.anim.all)
        allAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                toggleButtons(false)
            }

            override fun onAnimationEnd(animation: Animation) {
                toggleButtons(true)
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        })
        earthImageView.startAnimation(allAnimation)
    }
}

