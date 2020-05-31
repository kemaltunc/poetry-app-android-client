package com.tunc.androidpoetryapp.presentation.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.base.BaseTabsPagerAdapter
import com.tunc.androidpoetryapp.databinding.FragmentProfileBinding
import com.tunc.androidpoetryapp.presentation.ui.post.PostFragment
import com.tunc.androidpoetryapp.util.extension.init
import com.tunc.androidpoetryapp.util.extension.safeController
import kotlinx.android.synthetic.main.tablayout_with_viewpager.view.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

    override val layoutRes: Int = R.layout.fragment_profile

    override val classViewModel: Class<ProfileViewModel> = ProfileViewModel::class.java

    private val adapter: BaseTabsPagerAdapter by lazy {
        BaseTabsPagerAdapter(
            childFragmentManager,
            requireContext()
        )
    }



    override fun clickListeners() {

        binding.backButton.setOnClickListener {
            safeController()?.navigateUp()
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
