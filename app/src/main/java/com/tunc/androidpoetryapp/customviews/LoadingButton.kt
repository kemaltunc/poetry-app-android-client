package com.tunc.androidpoetryapp.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.tunc.androidpoetryapp.R
import kotlinx.android.synthetic.main.loading_button.view.*

class LoadingButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.loading_button, this, true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton)

        with(typedArray) {
            val text = getString(R.styleable.LoadingButton_android_text)
            loading_button_title.run {
                setText(text)
            }
            recycle()
        }
    }

    fun setText(text: String) {
        loading_button_title.text = text
    }

    fun hideProgress() {
        loading_progressbar.visibility = View.GONE
    }

    fun showProgress() {
        loading_progressbar.visibility = View.VISIBLE
    }

    fun setOnClick(click: () -> Unit) {
        loading_material.setOnClickListener {
            click()
        }
    }

}