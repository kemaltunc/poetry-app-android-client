package com.tunc.androidpoetryapp.util

import android.app.Activity
import android.content.Intent

fun share(activity: Activity, text: String) {

    val intent = Intent()
    intent.action = Intent.ACTION_SEND
    intent.putExtra(Intent.EXTRA_TEXT, text)
    intent.type = "text/plain"
    activity.startActivity(intent)

}