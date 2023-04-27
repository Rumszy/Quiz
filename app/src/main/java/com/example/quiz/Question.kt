package com.example.quiz

data class Question(
    val id: Int,
    var question: String,
    var image: Int,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour: String,
    var correctOption: Int
)