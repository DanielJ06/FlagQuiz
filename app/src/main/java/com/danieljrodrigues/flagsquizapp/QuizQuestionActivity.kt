package com.danieljrodrigues.flagsquizapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOption : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        this.supportActionBar?.hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptions()

        questionLabel.text = question.question
        flagImg.setImageResource(question.image)
        progressBar.progress = mCurrentPosition
        textProgress.text = "$mCurrentPosition/${progressBar.max}"

        optionOne.text = question.optOne
        optionTwo.text = question.optTwo
        optionThree.text = question.optThree
        optionFour.text = question.optFour
    }

    private fun defaultOptions() {
        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)

        for (opt in options) {
            opt.typeface = Typeface.DEFAULT
            opt.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.optionOne -> {
                selectedOption(optionOne, 1)
            }
            R.id.optionTwo -> {
                selectedOption(optionTwo, 2)
            }
            R.id.optionThree -> {
                selectedOption(optionThree, 3)
            }
            R.id.optionFour -> {
                selectedOption(optionFour, 4)
            }
        }
    }

    private fun selectedOption(tv: TextView, selectedOptNum: Int) {
        defaultOptions()
        mSelectedOption = selectedOptNum
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
    }
}