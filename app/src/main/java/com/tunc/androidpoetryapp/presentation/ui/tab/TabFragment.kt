package com.tunc.androidpoetryapp.presentation.ui.tab

import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.customviews.controller
import com.tunc.androidpoetryapp.databinding.FragmentTabBinding
import com.tunc.androidpoetryapp.presentation.ui.home.HomeFragment
import com.tunc.androidpoetryapp.presentation.ui.profile.ProfileFragment


class TabFragment : BaseFragment<TabvViewModel, FragmentTabBinding>() {

    override val classViewModel: Class<TabvViewModel> = TabvViewModel::class.java


    override fun setBinding() {
        binding = FragmentTabBinding.inflate(layoutInflater)
    }

    override fun initUI() {
        controller.childNavigate(HomeFragment.newInstance())
    }

    override fun clickListeners() {
        binding.menuButton.setOnClickListener {
            binding.tabDrawer.openDrawer(GravityCompat.START)
        }

        binding.messagesButton.setOnClickListener {

        }

        binding.leftMenu.ProfileButton.setOnClickListener {
            binding.tabDrawer.closeDrawers()
            controller.navigate(ProfileFragment.newInstance())
        }

        binding.sharePostButton.button.setOnClickListener {

        }
    }

    private fun openFragment(fragment: Fragment) {
        binding.tabDrawer.closeDrawers()
        controller.childNavigate(fragment)
    }

    companion object {
        fun newInstance() = TabFragment()
    }

}
