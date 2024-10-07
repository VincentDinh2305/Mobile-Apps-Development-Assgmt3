package com.example.dinhhoangvietphuong_comp304sec001_lab03

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.SeekBar

class DrawingActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var bitmap: Bitmap
    private lateinit var canvas: Canvas
    private val paint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 20f
    }

    private var currentX = 10f
    private var currentY = 10f
    private val stepSize = 30f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing)

        imageView = findViewById(R.id.ImageViewForDrawing)
        setupDrawingCanvas()
        setupDirectionButtons()

        val seekBarThickness = findViewById<SeekBar>(R.id.seekBarThickness)
        seekBarThickness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                onThicknessChanged(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Optional implementation if needed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Optional implementation if needed
            }
        })

        val radioGroupColors = findViewById<RadioGroup>(R.id.radioGroupColors)
        radioGroupColors.setOnCheckedChangeListener { group, checkedId ->
            // Change the paint color based on the selected radio button
            paint.color = when (checkedId) {
                R.id.btnColorGreen -> Color.GREEN
                R.id.btnColorBlue -> Color.BLUE
                R.id.btnColorRed -> Color.RED
                else -> paint.color
            }
        }
    }



    private fun setupDrawingCanvas() {
//        bitmap = Bitmap.createBitmap(imageView.width, imageView.height, Bitmap.Config.ARGB_8888)
        bitmap = Bitmap.createBitmap(1080, 1920, Bitmap.Config.ARGB_8888)
        canvas = Canvas(bitmap)
        imageView.setImageBitmap(bitmap)
        canvas.drawColor(Color.WHITE)
    }

    private fun setupDirectionButtons() {
        findViewById<ImageButton>(R.id.btnUp).setOnClickListener { moveUp() }
        findViewById<ImageButton>(R.id.btnDown).setOnClickListener { moveDown() }
        findViewById<ImageButton>(R.id.btnLeft).setOnClickListener { moveLeft() }
        findViewById<ImageButton>(R.id.btnRight).setOnClickListener { moveRight() }
    }

    private fun drawLine(newX: Float, newY: Float) {
        canvas.drawLine(currentX, currentY, newX, newY, paint)
        currentX = newX
        currentY = newY
        imageView.invalidate()
    }

    private fun moveUp() = drawLine(currentX, (currentY - stepSize).coerceAtLeast(0f))
    private fun moveDown() = drawLine(currentX, (currentY + stepSize).coerceAtMost(bitmap.height.toFloat()))
    private fun moveLeft() = drawLine((currentX - stepSize).coerceAtLeast(0f), currentY)
    private fun moveRight() = drawLine((currentX + stepSize).coerceAtMost(bitmap.width.toFloat()), currentY)

    fun clearCanvas(view: View) {
            canvas.drawColor(Color.WHITE)
        imageView.invalidate()
    }


    fun onThicknessChanged(thickness: Int) {
        // Assuming thickness is between 1 and 100
        paint.strokeWidth = thickness.toFloat()
    }

    fun startCanvas(view: View) {
        // Reset the bitmap and canvas
        bitmap = Bitmap.createBitmap(imageView.width, imageView.height, Bitmap.Config.ARGB_8888)
        canvas = Canvas(bitmap)
        imageView.setImageBitmap(bitmap)

        // Clear the canvas with a white background
        canvas.drawColor(Color.WHITE)

        // Reset the starting drawing position if necessary
        currentX = 10f
        currentY = 10f

        // Update the ImageView to reflect the reset
        imageView.invalidate()
    }
}
