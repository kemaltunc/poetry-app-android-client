package com.tunc.androidpoetryapp.base


import android.content.Context
import android.os.Parcelable
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class BaseTabsPagerAdapter(fm: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mFragmentList = ArrayList<Fragment>()
    private var mFragmentTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(title: String, fragment: Fragment) {
        mFragmentTitle.add(title)
        mFragmentList.add(fragment)
    }


    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitle[position]
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val ret = super.instantiateItem(container, position)
        mFragmentList[position] = ret as Fragment
        return ret
    }

    fun clearFragments() {
        mFragmentList = ArrayList()
        mFragmentTitle = ArrayList()
    }

    override fun saveState(): Parcelable? {
        return null
    }
}