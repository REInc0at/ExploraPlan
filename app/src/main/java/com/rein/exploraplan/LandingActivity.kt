package com.rein.exploraplan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class LandingActivity : AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_landing)

        val toExplore: Button = findViewById(R.id.toExplore_btn)

        toExplore.setOnClickListener {
            val intent = Intent(this@LandingActivity, SigninActivity::class.java)

            startActivity(intent)
            finish() // Finish current activity
        }

    }

}