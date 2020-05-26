package com.tunc.androidpoetryapp.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.tunc.androidpoetryapp.R

class ClassicTextView : AppCompatTextView {
    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init()
    }

    private fun init() {
        this.setTextColor(ContextCompat.getColor(context, R.color.light_black))
    }
}