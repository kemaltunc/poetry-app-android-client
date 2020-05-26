package com.tunc.androidpoetryapp.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import com.tunc.androidpoetryapp.R
import kotlinx.android.synthetic.main.loading_bar.*


object Loading {
    fun showLoadingDialog(context: Context, showLoading: Boolean = true): Dialog {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.loading_bar)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

        if (showLoading) {
            dialog.loading.visibility = View.VISIBLE
        } else {
            dialog.loading.visibility = View.GONE
        }

        return dialog
    }
}