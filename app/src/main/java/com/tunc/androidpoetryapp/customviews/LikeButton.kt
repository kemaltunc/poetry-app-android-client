package com.tunc.androidpoetryapp.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.databinding.CellLikeButtonBinding

class LikeButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var binding: CellLikeButtonBinding =
        CellLikeButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LikeButton)
        with(typedArray) {
            val imageId = getResourceId(R.styleable.LikeButton_img, R.drawable.ic_like)
            binding.buttonImage.run {
                setImageResource(imageId)
            }
            recycle()
        }
    }


}