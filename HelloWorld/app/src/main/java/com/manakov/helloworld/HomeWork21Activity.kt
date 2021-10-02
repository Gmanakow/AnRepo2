package com.manakov.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

//lesson 1.1

class HomeWork21Activity : AppCompatActivity() {
    private var logTag = HomeWork21Activity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework21)

        var textView : TextView = findViewById(R.id.HelloCount)
        textView.text = this.intent.getStringExtra(HelloToastHomeWorkActivity.extraCounter)
        textView.visibility = View.VISIBLE
    }



}