package com.tunc.androidpoetryapp.base

import androidx.annotation.LayoutRes

abstract class RecyclerItem constructor(@LayoutRes val layoutId: Int, val compareId: Int)