package com.example.simplegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1 = findViewById<Button>(R.id.playButton)
        b1?.setOnClickListener {
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }
    }
}