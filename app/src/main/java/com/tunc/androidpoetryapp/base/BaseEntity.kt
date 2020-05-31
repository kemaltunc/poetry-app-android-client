package com.tunc.androidpoetryapp.base

import androidx.annotation.LayoutRes

abstract class BaseEntity constructor(val compareId: String, @LayoutRes val layoutId: Int = 0)