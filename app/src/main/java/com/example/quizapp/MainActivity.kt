package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart : Button =findViewById(R.id.btnstart)
        val etText : AppCompatEditText = findViewById(R.id.name)
        btnStart.setOnClickListener{
            if(etText.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }else{
                val intent =Intent(this,QustionActivityFileActivity::class.java)
                intent.putExtra(Constants.User_name,etText.text.toString())
                startActivity(intent)

            }
        }
    }
}