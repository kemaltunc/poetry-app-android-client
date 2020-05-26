package com.tunc.androidpoetryapp.presentation.ui.profile

import androidx.fragment.app.Fragment
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.base.BaseTabsPagerAdapter
import com.tunc.androidpoetryapp.customviews.controller
import com.tunc.androidpoetryapp.databinding.FragmentProfileBinding
import com.tunc.androidpoetryapp.presentation.ui.post.PostFragment
import com.tunc.androidpoetryapp.util.extension.init

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

    override val classViewModel: Class<ProfileViewModel> = ProfileViewModel::class.java

    private val adapter: BaseTabsPagerAdapter by lazy {
        BaseTabsPagerAdapter(
            childFragmentManager,
            requireContext()
        )
    }

    override fun setBinding() {
        binding = FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun clickListeners() {

        binding.backButton.setOnClickListener {
            controller.navigateUp()
        }

    }


    override fun initUI() {
        adapter.addFragment("Keşfet", PostFragment.newInstance())
        adapter.addFragment("Takip ettiklerin", PostFragment.newInstance())
        binding.tablayout.homeTabLayout.init(
            requireContext(),
            binding.tablayout.homeViewPager,
            adapter
        )
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}
