package com.mudrax.narutoquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_questions.*
import android.media.MediaPlayer


class QuestionsActivity : AppCompatActivity() , View.OnClickListener {

    var mMediaPlayer : MediaPlayer ?= null
    private var mQuesobj : ArrayList<Question> ?= null
    private var mcurrQues = 1
    private var mcurrOptionPos =0
    private var mUserName:String?=null
    private var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        this.playSound(this)
        mUserName = intent.getStringExtra(Constant.FINAL_NAME)
        mQuesobj = Constant.getallques()
        setQues()

        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)
        btn_act2.setOnClickListener(this)
    }


    /////////////////////////////////////////////////               FOR BACKGROUND SOUND                /////////////////////////////////////////////////////
    fun playSound(view: QuestionsActivity)
    {
        if(mMediaPlayer==null)
        {
            mMediaPlayer = MediaPlayer.create(this , R.raw.sound)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        }
        else
        {
            mMediaPlayer!!.start()
        }
    }
    fun pauseSound(view: View)
    {
        if(mMediaPlayer!!.isPlaying && mMediaPlayer!=null)
            mMediaPlayer!!.pause()
    }

    override fun onStop()
    {
        super.onStop()
        if(mMediaPlayer!=null)
        {
            mMediaPlayer!!.release()
            mMediaPlayer = null

        }
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private fun defaultView()
    {
        val optionsarr = ArrayList<TextView>()
        optionsarr.add(0,tv_optionOne)
        optionsarr.add(1,tv_optionTwo)
        optionsarr.add(2,tv_optionThree)
        optionsarr.add(3,tv_optionFour)

        for(option in optionsarr)
        {
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.custom_option_bg)
        }
    }
    private fun setQues()
    {
        val quesArrElement = mQuesobj!![mcurrQues-1]
        defaultView()
        if(mcurrQues==mQuesobj!!.size)
        {
            btn_act2.text = "FINISH"
        }
        else
        {
            btn_act2.text = "SUBMIT"
        }
        tv_ques.text = quesArrElement.question
        iv_image.setImageResource(quesArrElement.image)
        pb_progressBar.progress = mcurrQues
        tv_pb.text = "$mcurrQues" + "/" + pb_progressBar.max
        tv_optionOne.text = quesArrElement.optionOne
        tv_optionTwo.text = quesArrElement.optionTwo
        tv_optionThree.text = quesArrElement.optionThree
        tv_optionFour.text = quesArrElement.optionFour
    }
    private fun selectedOptionView(tv : TextView , selectedOptionNumber :Int)
    {
        defaultView()
        mcurrOptionPos = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface , Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this , R.drawable.selectedoption_bg)

    }
    private fun answerView(ans : Int , drawableView : Int)
    {
        when(ans)
        {
            1->{tv_optionOne.background = ContextCompat.getDrawable(this, drawableView)}
            2->{tv_optionTwo.background = ContextCompat.getDrawable(this, drawableView)}
            3->{tv_optionThree.background = ContextCompat.getDrawable(this, drawableView)}
            4->{tv_optionFour.background = ContextCompat.getDrawable(this, drawableView)}
        }
    }

    override fun onClick(v: View?) {

        when(v?.id)
        {
            R.id.tv_optionOne->{selectedOptionView(tv_optionOne , 1)}
            R.id.tv_optionTwo->{selectedOptionView(tv_optionTwo , 2)}
            R.id.tv_optionThree->{selectedOptionView(tv_optionThree , 3)}
            R.id.tv_optionFour->{selectedOptionView(tv_optionFour , 4)}
            R.id.btn_act2->
            {
                if(mcurrOptionPos == 0 )
                {
                    mcurrQues++
                    when
                    {
                        mcurrQues <= mQuesobj!!.size -> {setQues()}
                        else->
                        {
                            val intent = Intent(this , resultActivity::class.java)
                            intent.putExtra(Constant.FINAL_NAME , mUserName)
                            intent.putExtra(Constant.COUNT_OF_ANS , count.toString())
                            startActivity(intent)
                            finish()
                        }

                    }

                }
                else
                {
                    val arrele2 = mQuesobj!![mcurrQues-1]
                    if(arrele2.correctAnswer != mcurrOptionPos)
                    {
                        answerView(mcurrOptionPos , R.drawable.wrong_ans_bg)
                    }
                    else
                    {
                        count++
                    }
                    answerView(arrele2.correctAnswer , R.drawable.answer_option_bg)

                    if(mcurrQues == mQuesobj!!.size)
                        btn_act2.text = "finish"
                    else
                        btn_act2.text = "go to next question"

                    mcurrOptionPos = 0
//                    btn_act2.text = "submit"-------------------------------------------------------------------------------------------------------------------------
                }
            }
        }

    }



}