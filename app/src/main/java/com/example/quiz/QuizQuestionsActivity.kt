package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        //Log.i("The size of the question list is: ", "${Constants.getQuestions().size}")

        val tvQuestion: TextView = findViewById(R.id.tv_question)
        val ivFlag: ImageView = findViewById(R.id.iv_flag)
        val pbProgress: ProgressBar = findViewById(R.id.pb_progress)
        val tvProgress: TextView = findViewById(R.id.tv_progress)
        val tvOptionOne: TextView = findViewById(R.id.tv_optionOne)
        val tvOptionTwo: TextView = findViewById(R.id.tv_optionTwo)
        val tvOptionThree: TextView = findViewById(R.id.tv_optionThree)
        val tvOptionFour: TextView = findViewById(R.id.tv_optionFour)

        val questions = Constants.getQuestions()

        var i = 0

            tvQuestion.text = questions[i].question
            ivFlag.setImageResource(questions[0].image)
            pbProgress.progress = (questions[i].id)
            tvProgress.text = "${questions[i].id} / ${pbProgress.max}"
            tvOptionOne.text = questions[i].optionOne
            tvOptionTwo.text = questions[i].optionTwo
            tvOptionThree.text = questions[i].optionThree
            tvOptionFour.text = questions[i].optionFour


    }
}