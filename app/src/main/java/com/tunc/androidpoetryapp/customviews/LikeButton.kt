package com.tunc.androidpoetryapp.customviews

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.databinding.CellLikeButtonBinding


class LikeButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var binding: CellLikeButtonBinding =
        CellLikeButtonBinding.inflate(LayoutInflater.from(context), this, true)

    fun setImg(drawable: Drawable?) {
        binding.buttonImage.setImageDrawable(drawable)
    }


    fun setCount(count: Int) {
        binding.countTv.text = count.toString()

        if (count > 0) {
            binding.countTv.visibility = View.VISIBLE
        } else {
            binding.countTv.visibility = View.GONE
        }

    }
}