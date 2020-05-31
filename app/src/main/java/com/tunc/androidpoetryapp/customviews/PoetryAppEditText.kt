package com.tunc.androidpoetryapp.customviews

import android.content.Context
import android.content.res.TypedArray
import android.text.InputType
import android.text.InputType.TYPE_TEXT_VARIATION_NORMAL
import android.text.method.ScrollingMovementMethod
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.util.extension.dp
import kotlinx.android.synthetic.main.custom_edittext.view.*


class PoetryAppEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {

        LayoutInflater.from(context)
            .inflate(R.layout.custom_edittext, this, true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PoetryAppEditText)

        with(typedArray) {
            val hint = getString(R.styleable.PoetryAppEditText_android_hint)
            val hintColor = getColor(
                R.styleable.PoetryAppEditText_hintTextColor,
                ContextCompat.getColor(context, R.color.dark_grey)
            )

            val textColor = getColor(
                R.styleable.PoetryAppEditText_android_textColor,
                ContextCompat.getColor(context, R.color.light_black)
            )


            val typedCount = typedArray.indexCount

            for (i in 0 until typedCount) {
                when (val attr = typedArray.getIndex(i)) {
                    R.styleable.PoetryAppEditText_android_inputType -> setInputType(
                        typedArray,
                        attr
                    )
                }
            }

            custom_edittext.run {
                setHint(hint)
                setHintTextColor(hintColor)
                setTextColor(textColor)
            }
            recycle()
        }
    }

    fun text(): String {
        return custom_edittext.text.toString()
    }

    fun disable() {
        custom_edittext.isEnabled = false
    }

    fun enable() {
        custom_edittext.isEnabled = true
    }

    private fun setInputType(typedArray: TypedArray, attr: Int) {
        val inputType = typedArray.getInt(attr, TYPE_TEXT_VARIATION_NORMAL)
        custom_edittext.inputType = inputType
    }


    fun setLine(line: Int) {
        custom_edittext.apply {
            isSingleLine = false
            imeOptions = EditorInfo.IME_FLAG_NO_ENTER_ACTION
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
            setLines(line)
            maxLines = 10
            isVerticalScrollBarEnabled = true
            movementMethod = ScrollingMovementMethod.getInstance()
            scrollBarStyle = View.SCROLLBARS_INSIDE_INSET
            gravity = Gravity.TOP or Gravity.START


            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 200.dp)
        }
    }
}
