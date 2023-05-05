package com.example.quiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition: Int = 1
    private var questionList: ArrayList<Question>? = null
    private var selectedAnswerOption: Int = 0

    private var tvQuestion: TextView? = null
    private var ivFlag: ImageView? = null
    private var pbProgress: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tvQuestion = findViewById(R.id.tv_question)
        ivFlag = findViewById(R.id.iv_flag)
        pbProgress = findViewById(R.id.pb_progress)
        tvProgress = findViewById(R.id.tv_progress)
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)
        btnSubmit = findViewById(R.id.btn_submit)

        questionList = Constants.getQuestions()

        setQuestion()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
    }
    private fun setQuestion() {

        defaultOptions()

        if (currentPosition == questionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }

        val question:Question = questionList!![currentPosition - 1]

        tvQuestion?.text = question.question
        ivFlag?.setImageResource(question.image)
        pbProgress?.progress = currentPosition
        tvProgress?.text = "$currentPosition" + "/" + "${pbProgress?.max}"
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
    }

    private fun selectedOption(tv: TextView, selectedOption: Int) {

        defaultOptions()

        selectedAnswerOption = selectedOption

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#000000"))
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }
    private fun defaultOptions() {

        tvOptionOne?.isClickable = true
        tvOptionTwo?.isClickable = true
        tvOptionThree?.isClickable = true
        tvOptionFour?.isClickable = true

        val options = ArrayList<TextView>()

        tvOptionOne?.let {
            options.add(0, it)
        }

        tvOptionTwo?.let {
            options.add(1, it)
        }

        tvOptionThree?.let {
            options.add(2, it)
        }

        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.setTextColor(Color.parseColor("#7A8089"))
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }
    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.tv_optionOne -> {
                tvOptionOne?.let {
                    selectedOption(it, 1)
                }
            }

            R.id.tv_optionTwo -> {
                tvOptionTwo?.let {
                    selectedOption(it, 2)
                }
            }

            R.id.tv_optionThree -> {
                tvOptionThree?.let {
                    selectedOption(it, 3)
                }
            }

            R.id.tv_optionFour -> {
                tvOptionFour?.let {
                    selectedOption(it, 4)
                }
            }

            R.id.btn_submit -> {

                if (selectedAnswerOption == 0) {

                    currentPosition++

                    when {
                        currentPosition <= questionList!!.size -> {
                            setQuestion()
                        }

                        else -> {
                            finish()
                        }

                    }
                } else {

                    val question = questionList?.get(currentPosition - 1)

                    if (question?.correctOption != selectedAnswerOption) {
                        onAnswer(selectedAnswerOption, R.drawable.wrong_option_border_bg)
                    }

                    onAnswer(question!!.correctOption, R.drawable.correct_option_border_bg)

                    if (currentPosition == questionList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "NEXT QUESTION"
                    }

                    selectedAnswerOption = 0

                    tvOptionOne?.isClickable = false
                    tvOptionTwo?.isClickable = false
                    tvOptionThree?.isClickable = false
                    tvOptionFour?.isClickable = false

                }
            }
        }
    }

    private fun onAnswer(selectedAnswer: Int, selectedBackground: Int) {

        when (selectedAnswer) {
        1 -> {
            tvOptionOne?.background = ContextCompat.getDrawable(this, selectedBackground)
        }
        2 -> {
            tvOptionTwo?.background = ContextCompat.getDrawable(this, selectedBackground)
        }
        3 -> {
            tvOptionThree?.background = ContextCompat.getDrawable(this, selectedBackground)
        }
        4 -> {
            tvOptionFour?.background = ContextCompat.getDrawable(this, selectedBackground)
        }
        }
    }
}