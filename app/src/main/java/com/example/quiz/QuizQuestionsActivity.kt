package com.example.quiz

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

    private var tvQuestion: TextView? = null
    private var ivFlag: ImageView? = null
    private var pbProgress: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        //Log.i("The size of the question list is: ", "${Constants.getQuestions().size}")

        tvQuestion = findViewById(R.id.tv_question)
        ivFlag = findViewById(R.id.iv_flag)
        pbProgress = findViewById(R.id.pb_progress)
        tvProgress = findViewById(R.id.tv_progress)
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)

        val questions = Constants.getQuestions()

        var currentposition = 1

        var question : Question = questions[currentposition - 1]

        tvQuestion?.text = question.question
        ivFlag?.setImageResource(question.image)
        pbProgress?.progress = (question.id)
        tvProgress?.text = "${question.id} / ${pbProgress?.max}"
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
    }

    fun onOption(view: View) {

        var options = ArrayList<TextView?>()

        options.add(tvOptionOne)
        options.add(tvOptionTwo)
        options.add(tvOptionThree)
        options.add(tvOptionFour)


        for (i in options) {
            if (i?.text == (view as TextView).text) {
                i?.setTypeface(null, Typeface.BOLD)
            } else {
                i?.setTypeface(null, Typeface.NORMAL)
            }
        }

//        when ((view as TextView).text) {
//            "tv_optionOne" -> { tvOptionOne.setTypeface(null, Typeface.BOLD)
//                tvOptionTwo.setTypeface(null, Typeface.NORMAL)
//                tvOptionThree.setTypeface(null, Typeface.NORMAL)
//                tvOptionFour.setTypeface(null, Typeface.NORMAL)
//            }
//        }
//        (view as TextView).setTypeface(null, Typeface.BOLD)
    }

    fun onSubmit(view: View) {
        i++
        onUpdate()
    }

    private fun onUpdate() {

    }
}