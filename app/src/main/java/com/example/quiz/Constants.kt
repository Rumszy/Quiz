package com.example.quiz

object Constants {

    fun getQuestions():ArrayList<Question>{

        val questionList = ArrayList<Question>()

        var questionOne = Question(
            1, "Which country does this flag belong to?",
        R.drawable.ic_flag_of_belgium, "Belgium", "Belarus", "Hungary"
        , "Germany", 1)

        questionList.add(questionOne)

        var questionTwo = Question(
            2, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, "Belgium", "Argentina", "Greece"
            , "USA", 2)

        questionList.add(questionTwo)

        var questionThree = Question(
            3, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_australia, "Australia", "Argentina", "Greece"
            , "India", 1)

        questionList.add(questionThree)

        var questionFour = Question(
            4, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_brazil, "Austria", "Hungary", "Latvia"
            , "Brazil", 4)

        questionList.add(questionFour)

        var questionFive = Question(
            5, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_denmark, "Denmark", "Switzerland", "Norway"
            , "Belgium", 1)

        questionList.add(questionFive)

        var questionSix = Question(
            6, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_fiji, "Denmark", "Fiji", "Norway"
            , "China", 2)

        questionList.add(questionSix)

        var questionSeven = Question(
            7, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_germany, "Denmark", "Sweden", "Germany"
            , "Slovakia", 3)

        questionList.add(questionSeven)

        var questionEight = Question(
            8, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_india, "India", "Germany", "Belgium"
            , "None of them", 1)

        questionList.add(questionEight)

        var questionNine = Question(
            9, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait, "Romania", "None of them", "Hungary"
            , "USA", 2)

        questionList.add(questionNine)

        var questionTen = Question(
            10, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand, "Denmark", "Switzerland", "Norway"
            , "New Zealand", 4)

        questionList.add(questionTen)

        return questionList
    }
}