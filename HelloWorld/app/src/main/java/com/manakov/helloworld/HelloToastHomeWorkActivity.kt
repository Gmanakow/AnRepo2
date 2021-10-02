package com.manakov.helloworld

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

//lesson 1.2B homework

class HelloToastHomeWorkActivity : AppCompatActivity() {
    private var mCount = 0;

    companion object{
        const val extraCounter = "com/manakov/helloworld/HelloToastHomeWorkActivity.EXTRA"
    }

    private lateinit var mShowCount : TextView
    private lateinit var countButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_toast_homework)

        mShowCount = findViewById(R.id.helloToast_hw_show_count)
        countButton = findViewById(R.id.helloToast_hw_button_count)
    }

    fun showToast(view: View) {
        var intent = Intent(this, HomeWork21Activity::class.java)
        intent.putExtra(extraCounter, mCount)
        startActivity(intent)

    }

    fun countUp(view: View) {
        mCount++
        refresh()
    }

    fun zero(view: View) {
        mCount = 0;
        refresh()
    }

    private fun refresh(){
        mShowCount.text = mCount.toString()
        if (mCount % 2 == 0){
            countButton.setBackgroundColor(Color.CYAN)
        } else {
            countButton.setBackgroundColor(Color.MAGENTA)
        }
    }
}