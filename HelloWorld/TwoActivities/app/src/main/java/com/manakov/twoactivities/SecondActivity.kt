package com.manakov.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private val logTag = SecondActivity::class.java.simpleName
    private lateinit var textView : TextView
    private lateinit var mReply : EditText

    companion object {
        const val extraReply : String = "com.example.android.twoActivities.extra.REPLY";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(logTag, "-------");
        Log.d(logTag, "onCreate");



        textView = findViewById(R.id.text_message)
        textView.text = this.intent.getStringExtra(MainActivity.extraMessage)

        mReply = findViewById(R.id.editText_second)
    }

    fun returnReply(view: View) {
        var reply = mReply.text.toString()
        var intent = Intent()
        intent.putExtra(extraReply, reply)
        setResult(RESULT_OK, intent)
        Log.d(logTag, "onfinish second activity");
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "onStart");
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "onPause");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "onReStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "onResume");
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "onDestroy");
    }


}