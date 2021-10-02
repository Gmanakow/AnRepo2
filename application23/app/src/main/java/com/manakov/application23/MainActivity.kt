package com.manakov.application23

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.app.ShareCompat
import java.lang.Exception

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var mWebSiteEditText: EditText
    lateinit var mLocationEditText : EditText
    lateinit var mShareTextEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebSiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)

    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openWebsite(view: View) {
        var url = mWebSiteEditText.text.toString()
        var webPage: Uri = Uri.parse(url)
        var intent = Intent(Intent.ACTION_VIEW, webPage)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openLocation(view: View) {
        var loc = mLocationEditText.text.toString()
        var addressUri = Uri.parse("geo:0,0?q=" + loc)
        var intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun shareText(view: View) {
        var txt = mShareTextEditText.text.toString()
        var mimeType = "text/plain"

        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this text with: ")
            .setText(txt)
            .startChooser();

    }

    fun onSnap(view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try{
            startActivityForResult(intent, 1)
        } catch (e : Exception){}
    }
}