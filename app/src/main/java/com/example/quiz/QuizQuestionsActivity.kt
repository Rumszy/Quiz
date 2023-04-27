package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        //Log.i("The size of the question list is: ", "${Constants.getQuestions().size}")

        var tvQuestion: TextView = findViewById(R.id.tv_question)
        var ivFlag: ImageView = findViewById(R.id.iv_flag)
        var tvOptionOne: TextView = findViewById(R.id.tv_optionOne)
        var tvOptionTwo: TextView = findViewById(R.id.tv_optionTwo)
        var tvOptionThree: TextView = findViewById(R.id.tv_optionThree)
        var tvOptionFour: TextView = findViewById(R.id.tv_optionFour)

        var questions = Constants.getQuestions()

        tvQuestion.text = questions[0].question
        ivFlag.setImageResource(questions[0].image)
        tvOptionOne.text = questions[0].optionOne
        tvOptionTwo.text = questions[0].optionTwo
        tvOptionThree.text = questions[0].optionThree
        tvOptionFour.text = questions[0].optionFour


    }
}