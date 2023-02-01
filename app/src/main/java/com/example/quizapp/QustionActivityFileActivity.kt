package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.Result

class QustionActivityFileActivity : AppCompatActivity(), View.OnClickListener {
    private var mcurrentposition:Int=1;
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelecetedOptionPosition:Int=0
    private var myusername:String?=null
    private var progressBar: ProgressBar?=null
    private var tvprogress: TextView?=null
    private var tvquestion: TextView?=null
    private var image: ImageView?=null

    private var optionone: TextView?=null
    private var optiontwo: TextView?=null
    private var optionthree: TextView?=null
    private var optionfour: TextView?=null
    private var mcorrectanswer:Int =0

    private var buttonsubmit:Button ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_activity_file1)
        myusername =intent.getStringExtra(Constants.User_name)
        progressBar=findViewById(R.id.progressBar)
        tvprogress=findViewById(R.id.status_bar)
        tvquestion=findViewById(R.id.textView1)
        image=findViewById(R.id.image)
        optionone=findViewById(R.id.optionone)
        optiontwo=findViewById(R.id.optiontwo)
        optionthree=findViewById(R.id.optionthree)
        optionfour=findViewById(R.id.optionfour)
        buttonsubmit=findViewById(R.id.btnSubmit)
        setQuestion()
        optionone?.setOnClickListener(this)
        optiontwo?.setOnClickListener(this)
        optionthree?.setOnClickListener(this)
        optionfour?.setOnClickListener(this)

        buttonsubmit?.setOnClickListener(this)
        mQuestionList = Constants.getQuestions()

    }

    private fun setQuestion() {
        defaultOptionsView()


        val question: Question = mQuestionList!![mcurrentposition - 1]
        image?.setImageResource(question.image)
        progressBar?.progress = mcurrentposition
        tvprogress?.text = "${mcurrentposition}/5"
        tvquestion?.text = question.question
        optionone?.text = question.optionOne
        optiontwo?.text = question.optionTwo
        optionthree?.text = question.optionThree
        optionfour?.text = question.optionFour




        if(mcurrentposition == mQuestionList!!.size){
            buttonsubmit?.text="Finish"
        }else{
            buttonsubmit?.text="Submit"
        }
    }
  private fun defaultOptionsView(){
      val options =ArrayList<TextView>()
      optionone?.let {
          options.add(0, it)
      }
      optiontwo?.let {
          options.add(1, it)
      }
      optionthree?.let {
          options.add(2, it)
      }
      optionfour?.let {
          options.add(3, it)
      }
      for(option in options){
          option.setTextColor(Color.parseColor("#7A8089"))
          option.typeface= Typeface.DEFAULT
          option.background= ContextCompat.getDrawable(this@QustionActivityFileActivity,R.drawable.default_ption_border_bg)
      }

  }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelecetedOptionPosition= selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selectedborderoption)
    }
    override fun onClick(view: View?) {
       when(view?.id){
           R.id.optionone ->{
               optionone?.let {
                   selectedOptionView(it,1)
               }
           }
           R.id.optiontwo ->{
               optiontwo?.let {
                   selectedOptionView(it,2)
               }
           }
           R.id.optionthree ->{
               optionthree?.let {
                   selectedOptionView(it,3)
               }
           }
           R.id.optionfour ->{
               optionfour?.let {
                   selectedOptionView(it,4)
               }
           }
           R.id.btnSubmit ->{
               if(mSelecetedOptionPosition == 0){
                   mcurrentposition++
               }
               when{
                   mcurrentposition <= mQuestionList!!.size ->{
                       setQuestion()
                   }
                   else->{
                       val intent= Intent(this,Result::class.java)
                       intent.putExtra(Constants.User_name,myusername)
                       intent.putExtra(Constants.correct_answer,mcorrectanswer)
                       intent.putExtra(Constants.total_question,mQuestionList?.size)
                       startActivity(intent)
                       finish()
                   }
               }
           }else->{
               val question =mQuestionList?.get(mcurrentposition -1)
               if(question!!.correctAnswer != mSelecetedOptionPosition){
                   answerView(mSelecetedOptionPosition,R.drawable.wrong_option_border_bg)
               }else{
                   mcorrectanswer++
               }
           answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
           if(mcurrentposition == mQuestionList!!.size){
               buttonsubmit?.text="Finish"
           }else{
               buttonsubmit?.text="Go to next question"
           }

           mSelecetedOptionPosition=0
           }
       }
    }
    private fun answerView(answer: Int,drawableView: Int ){
        when(answer){
            1-> {
                optionone?.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2-> {
                optiontwo?.background =ContextCompat.getDrawable(
                    this@QustionActivityFileActivity,
                    drawableView
                )
            } 3-> {
            optionthree?.background =ContextCompat.getDrawable(
                this@QustionActivityFileActivity,
                drawableView
            )
        } 4-> {
            optionfour?.background =ContextCompat.getDrawable(
                this@QustionActivityFileActivity,
                drawableView
            )
        }
        }
    }
}