package com.manakov.homework22app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var textView: TextView

    var data = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.button = findViewById(R.id.counterButton)
        this.textView = findViewById(R.id.count)

        if (savedInstanceState != null){
            Log.d("aAAAAAAAAAAAA", "get")
            this.textView.text = savedInstanceState.getString("putString")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d("aAAAAAAAAAAAA", "saves")
        if (this.data != 0){
            outState.putString("putString", data.toString())
        }
    }

    fun onClick(view: View) {
        this.data++
        this.textView.text = data.toString()
    }
}
