package com.example.thequizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit private var questionword:TextView
    lateinit private var rightanswertextview:TextView
    lateinit private var useranswer:EditText
    lateinit private var checkanswer:Button
    lateinit private var changeword:Button
    lateinit private var showanswer:Button

    lateinit private var day:String
    lateinit private var random: Random
    internal var days= arrayOf("sunday","monday","tuesday","wednesday","thursday","friday","saturday")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionword=findViewById(R.id.question_word)
        rightanswertextview=findViewById(R.id.right_answer)
        useranswer=findViewById(R.id.user_answer)
        checkanswer=findViewById(R.id.check_answer)
        changeword=findViewById(R.id.change_question)
        showanswer=findViewById(R.id.show_answer)

        random= Random()

        playquiz()

        showanswer.setOnClickListener()
        {
            rightanswertextview.text=day
        }

        checkanswer.setOnClickListener()
        {
            rightanswertextview.text=day
        }

        changeword.setOnClickListener()
        {
            playquiz()
        }

    }

    private fun mixLetters(word:String): String
    {
        var words=Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray())
        Collections.shuffle(words)
        var mixes:String=""
        for (i in words)
        {
            mixes+=i
        }
        return mixes
    }

    private fun playquiz()
    {
        day =days[random.nextInt(days.size)]
        questionword.text = mixLetters(day)
    }

}
