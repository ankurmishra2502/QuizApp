package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvname:TextView= findViewById(R.id.tv_name)
        val tvscore:TextView =findViewById(R.id.tv_score)
        val btnFinish: Button =findViewById(R.id.btn_finish)

        tvname.text =intent.getStringExtra(Constants.User_name)
        val total_score= intent.getIntExtra(Constants.total_question,0)
        val correct= intent.getIntExtra(Constants.correct_answer,0)

        tvscore.text="Your score is ${correct} out of ${total_score}"
        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}