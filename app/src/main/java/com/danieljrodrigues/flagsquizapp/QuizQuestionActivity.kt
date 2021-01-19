package com.danieljrodrigues.flagsquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.supportActionBar?.hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionList = Constants.getQuestions()
        val currentPosition = 1
        val question: Question? = questionList[currentPosition - 1]

        questionLabel.text = question!!.question
        flagImg.setImageResource(question.image)
        progressBar.progress = currentPosition
        textProgress.text = "$currentPosition/${progressBar.max}"

        optionOne.text = question.optOne
        optionTwo.text = question.optTwo
        optionThree.text = question.optThree
        optionFour.text = question.optFour
    }
}