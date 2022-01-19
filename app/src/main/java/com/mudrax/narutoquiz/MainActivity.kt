package com.mudrax.narutoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener()
        {
            if(et_name.text?.isEmpty() == true)
            {
                Toast.makeText(this, "Please Enter A Valid Name", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this,QuestionsActivity::class.java)
                intent.putExtra(Constant.FINAL_NAME , et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}