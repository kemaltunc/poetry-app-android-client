package com.tunc.androidpoetryapp.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.base.BaseTabsPagerAdapter
import com.tunc.androidpoetryapp.databinding.FragmentHomeBinding
import com.tunc.androidpoetryapp.presentation.ui.post.PostFragment
import com.tunc.androidpoetryapp.util.extension.init
import kotlinx.android.synthetic.main.tablayout_with_viewpager.view.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val layoutRes: Int = R.layout.fragment_home

    override val classViewModel: Class<HomeViewModel> = HomeViewModel::class.java


    private val adapter: BaseTabsPagerAdapter by lazy {
        BaseTabsPagerAdapter(
            childFragmentManager,
            requireContext()
        )
    }

    override fun initUI() {
        adapter.addFragment("Keşfet", PostFragment.newInstance())
        //adapter.addFragment("Takip ettiklerin", PostFragment.newInstance())
        binding.homeTab.homeTabLayout.init(requireContext(), binding.homeTab.homeViewPager, adapter)
    }


    companion object {
        fun newInstance() = HomeFragment()
    }


}
