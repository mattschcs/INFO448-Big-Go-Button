package edu.uw.ischool.chuns4.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var bigGoButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bigGoButton = findViewById(R.id.pushMeButton)

        bigGoButton.setOnClickListener {
            counter++
            buttonClickCounter()
            changeColor()

        }

    }

    private fun buttonClickCounter() {
        if (counter == 1) {
            bigGoButton.text = getString(R.string.pushed_one_time)
        } else {
            bigGoButton.text = getString(R.string.pushed_times, counter)
        }

    }

    private fun changeColor() {
        val backgroundColor =  Color.rgb(
            (0..256).random(),
            (0..256).random(),
            (0..256).random()
        )
        bigGoButton.setBackgroundColor(backgroundColor)
        val textColor =  Color.rgb(
            (0..256).random(),
            (0..256).random(),
            (0..256).random()
        )
        bigGoButton.setTextColor(textColor)
    }
}


