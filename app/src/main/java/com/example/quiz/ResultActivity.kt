package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    var tvResultName: TextView? = null
    var tvResultScore: TextView? = null
    var btnResultFinish: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvResultName = findViewById(R.id.tv_resultName)
        tvResultScore = findViewById(R.id.tv_resultScore)
        btnResultFinish = findViewById(R.id.btn_resultFinish)
    }

    fun onClick(view: View) {
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
        finish()
    }
}