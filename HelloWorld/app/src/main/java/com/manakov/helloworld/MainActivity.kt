package com.manakov.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

//lesson 1.1

class MainActivity : AppCompatActivity() {
    private var logTag = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(logTag, "Hello World")
    }

    override fun onResume() {
        super.onResume()

        intent = Intent(this, ScrollingTextActivity::class.java)

        startActivity(
            intent
        )
    }


}