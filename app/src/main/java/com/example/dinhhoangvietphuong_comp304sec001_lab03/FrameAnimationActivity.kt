package com.example.dinhhoangvietphuong_comp304sec001_lab03

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FrameAnimationActivity : AppCompatActivity() {
    var FrameAnimation: AnimationDrawable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)

        val onButton: Button = findViewById<View>(R.id.ButtonStart) as Button
        onButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startAnimation()
            }
        })

        val offButton: Button = findViewById<View>(R.id.ButtonStop) as Button
        offButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                stopAnimation()
            }
        })
    }

    //
    private fun startAnimation() {
        val img: ImageView = findViewById<View>(R.id.ImageView_Boy) as ImageView
        val frame1 = resources.getDrawable(R.drawable.boy1) as BitmapDrawable
        val frame2 = resources.getDrawable(R.drawable.boy2) as BitmapDrawable
        val frame3 = resources.getDrawable(R.drawable.boy3) as BitmapDrawable
        val frame4 = resources.getDrawable(R.drawable.boy4) as BitmapDrawable


        // Get the background, which has been compiled to an AnimationDrawable object.
        val reasonableDuration = 250
        FrameAnimation = AnimationDrawable()
        FrameAnimation!!.isOneShot = false // loop continuously
        FrameAnimation!!.addFrame(frame1, reasonableDuration)
        FrameAnimation!!.addFrame(frame2, reasonableDuration)
        FrameAnimation!!.addFrame(frame3, reasonableDuration)
        FrameAnimation!!.addFrame(frame4, reasonableDuration)

        img.setBackground(FrameAnimation)
        FrameAnimation!!.setVisible(true, true)
        FrameAnimation!!.start()
    }

    private fun stopAnimation() {
        FrameAnimation!!.stop()
        FrameAnimation!!.setVisible(false, false)
    }
}
