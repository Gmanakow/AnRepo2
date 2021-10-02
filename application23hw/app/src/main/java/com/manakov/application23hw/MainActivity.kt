package com.manakov.application23hw

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = this.intent
        var uri : Uri? = intent.data

        var uriString = getString(R.string.uri_label) + uri?.toString()
        var textView : TextView = findViewById(R.id.text_uri_message)
        textView.text = uriString

    }
}