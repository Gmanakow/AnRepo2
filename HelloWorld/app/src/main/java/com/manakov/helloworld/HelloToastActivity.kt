package com.manakov.helloworld

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

//lesson 1.2A

class HelloToastActivity : AppCompatActivity() {
    private var mCount = 0;
    private lateinit var mShowCount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_toast)

        mShowCount = findViewById(R.id.helloToast_show_count)
    }

    fun showToast(view: View) {
        Toast
            .makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
            .show()

    }

    fun countUp(view: View) {
        mCount++
        mShowCount.text = mCount.toString()
    }
}