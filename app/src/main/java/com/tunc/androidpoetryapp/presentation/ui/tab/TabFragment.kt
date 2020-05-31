package com.tunc.androidpoetryapp.presentation.ui.tab

import androidx.fragment.app.Fragment
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.databinding.FragmentTabBinding
import com.tunc.androidpoetryapp.util.extension.safeController
import kotlinx.android.synthetic.main.new_post_button.view.*


class TabFragment : BaseFragment<TabvViewModel, FragmentTabBinding>() {

    override val layoutRes: Int = R.layout.fragment_tab

    override val classViewModel: Class<TabvViewModel> = TabvViewModel::class.java

    override fun initUI() {

        binding.fragmentTabNavigationMenu.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.menu_home -> {

                }

                R.id.menu_messages -> {

                }
            }

            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun clickListeners() {
        binding.profileButton.setOnClickListener {
            safeController()?.navigate(R.id.action_tabFragment_to_profileFragment)
        }

        binding.sharePostButton.button.setOnClickListener {
            safeController()?.navigate(R.id.action_tabFragment_to_createPostFragment)
        }
    }

    private fun openFragment(fragment: Fragment) {
        // binding.tabDrawer.closeDrawers()
    }

    companion object {
        fun newInstance() = TabFragment()
    }

}
