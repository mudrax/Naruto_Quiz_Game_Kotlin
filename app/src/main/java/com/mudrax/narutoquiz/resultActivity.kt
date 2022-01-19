package com.mudrax.narutoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var finalName = intent.getStringExtra(Constant.FINAL_NAME)
        var correctAns = intent.getStringExtra(Constant.COUNT_OF_ANS)

        tv_resultscreen_name.text = "Well Done! $finalName "
        tv_resultscreen_marks.text = "Your score is $correctAns out of 15"


    }

    fun resetIntent(view: android.view.View) {
        val intent = Intent(this , MainActivity :: class.java)
        startActivity(intent)
        finish()
    }
}