package com.tunc.androidpoetryapp.customviews

import android.content.Context
import android.content.res.TypedArray
import android.text.InputType.TYPE_TEXT_VARIATION_NORMAL
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.databinding.CustomEdittextBinding

class PoetryAppEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    var binding: CustomEdittextBinding =
        CustomEdittextBinding.inflate(LayoutInflater.from(context), this, true)

    init {
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

            binding.customEdittext.run {
                setHint(hint)
                setHintTextColor(hintColor)
                setTextColor(textColor)
            }
            recycle()
        }
    }

    fun text(): String {
        return binding.customEdittext.text.toString()
    }

    fun disable() {
        binding.customEdittext.isEnabled = false
    }

    fun enable() {
        binding.customEdittext.isEnabled = true
    }

    private fun setInputType(typedArray: TypedArray, attr: Int) {
        val inputType = typedArray.getInt(attr, TYPE_TEXT_VARIATION_NORMAL)
        binding.customEdittext.inputType = inputType
    }
}
