package com.example.quizapp

object Constants {

    const val User_name:String ="user_name"
    const val total_question:String= "total_question"
    const val correct_answer:String ="correct_answer"


    fun getQuestions():ArrayList<Question>{
        val questionsList =ArrayList<Question>()
        val que1=Question(
            1,"Identify the player?",
            R.drawable.virat,"Rohit Sharma","KL Rahul","Virat Kohli","Murli Vijay",3
        )
        questionsList.add(que1)

        val que2=Question(
            1,"Identify the player?",
            R.drawable.rohitsharma,"Rohit Sharma","R Ashwin","Virat Kohli","Dinesh Kartik",1
        )
        questionsList.add(que2)

        val que3=Question(
            1,"What his Pet name?",
            R.drawable.virat,"Kulcha","Universal Boss","Chiku","Tom",3
        )
        questionsList.add(que3)
        val que4=Question(
            1,"Identify the player?",
            R.drawable.ben,"Sam Curran","Tom Curren","Joe Root","Ben Stoke",4
        )
        questionsList.add(que4)
        val que5=Question(
            1,"Identify the player?",
            R.drawable.jasi,"Jusprit Buhmrah","M Shami","U Yadav","M Siraj",1
        )
        questionsList.add(que5)



        return questionsList
    }

}