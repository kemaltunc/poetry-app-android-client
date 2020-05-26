package com.tunc.androidpoetryapp.presentation.ui.home

import androidx.fragment.app.Fragment
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.base.BaseTabsPagerAdapter
import com.tunc.androidpoetryapp.databinding.FragmentHomeBinding
import com.tunc.androidpoetryapp.presentation.ui.post.PostFragment
import com.tunc.androidpoetryapp.util.extension.init

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val classViewModel: Class<HomeViewModel> = HomeViewModel::class.java

    override fun setBinding() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    private val adapter: BaseTabsPagerAdapter by lazy {
        BaseTabsPagerAdapter(
            childFragmentManager,
            requireContext()
        )
    }

    override fun initUI() {
        adapter.addFragment("Keşfet", PostFragment.newInstance())
        adapter.addFragment("Takip ettiklerin", PostFragment.newInstance())
        binding.homeTab.homeTabLayout.init(requireContext(), binding.homeTab.homeViewPager, adapter)
    }


    companion object {
        fun newInstance() = HomeFragment()
    }


}
