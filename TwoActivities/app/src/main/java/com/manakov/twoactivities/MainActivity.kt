package com.manakov.twoactivities

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val logTag = MainActivity::class.java.simpleName

    companion object {
        const val extraMessage: String = "com.example.android.twoActivities.extra.MESSAGE";
        const val textRequest = 1
    }

    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyTextView: TextView
    private lateinit var mReplyHeadTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(logTag, "-------");
        Log.d(logTag, "onCreate");

        if (savedInstanceState != null) {
            var isVisible = savedInstanceState.getBoolean("replyVisible")
            if (isVisible) {
                mReplyTextView.setText(savedInstanceState.getString("replyText"))
                mReplyTextView.visibility = View.VISIBLE
                mReplyHeadTextView.visibility = View.VISIBLE
            }
        }

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyTextView = findViewById(R.id.text_message_reply)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
    }

    fun launchSecondActivity(view: View) {
        Log.d(logTag, "Button clicked!");

        var intent = Intent(this, SecondActivity::class.java).putExtra(
            Companion.extraMessage, mMessageEditText.text
        )
        startActivityForResult(intent, textRequest);
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == textRequest) {
            if (resultCode == RESULT_OK) {
                var reply = data?.getStringExtra(SecondActivity.extraReply)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }

        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (mReplyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("replyVisible", true)
            outState.putString("replyText", mReplyTextView.text.toString())
        }
    }

}