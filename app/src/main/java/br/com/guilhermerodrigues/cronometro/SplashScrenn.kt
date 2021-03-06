package br.com.guilhermerodrigues.cronometro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScrenn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screnn)

        val handle = Handler()
        handle.postDelayed(Runnable { mostrarLogin() }, 2000)
    }

    private fun mostrarLogin() {
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }
}