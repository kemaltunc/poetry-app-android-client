package com.tunc.androidpoetryapp.util.extension

import android.content.Context
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.tunc.androidpoetryapp.base.BaseTabsPagerAdapter

fun TabLayout.init(
    context: Context,
    viewPager: ViewPager,
    adapter: BaseTabsPagerAdapter
) {

    viewPager.adapter = adapter
    this.setupWithViewPager(viewPager)
}