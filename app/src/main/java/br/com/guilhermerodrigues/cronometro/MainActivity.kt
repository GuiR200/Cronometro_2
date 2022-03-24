package br.com.guilhermerodrigues.cronometro

import android.os.Binder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.Choreographer
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var chronometer: Chronometer
    var isPlay = false
    var pauseOffSet: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.play)
        pauseButton = findViewById(R.id.pause)
        chronometer = findViewById(R.id.chronometer)

        playButton.setOnClickListener {
            if (!isPlay) {
                chronometer.base = SystemClock.elapsedRealtime() - pauseOffSet
                chronometer.start()
                pauseButton.visibility = View.VISIBLE
                playButton.background = getDrawable(R.drawable.ic_baseline_pause_circle_filled_24)
                isPlay = true

            } else {
                chronometer.base = SystemClock.elapsedRealtime()
                pauseOffSet = 0
                chronometer.stop()
                playButton.background = getDrawable(R.drawable.ic_baseline_play_circle_filled_24)
                isPlay = false
            }
        }
        pauseButton.setOnClickListener {
            if (!isPlay) {
                chronometer.stop()
                pauseOffSet = SystemClock.elapsedRealtime() - chronometer.base
                isPlay = false
                pauseButton.background = getDrawable(R.drawable.ic_baseline_play_circle_filled_24)
            }
            else {
                chronometer.base = SystemClock.elapsedRealtime() - pauseOffSet
                chronometer.start()
                pauseButton.background = getDrawable(R.drawable.ic_baseline_reset_24)
                isPlay = true
            }
        }

    }
}






