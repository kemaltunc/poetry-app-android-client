package com.tunc.androidpoetryapp.presentation.ui.login_signup

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.base.BaseTabsPagerAdapter
import com.tunc.androidpoetryapp.databinding.FragmentLoginSignupBinding
import com.tunc.androidpoetryapp.util.enums.LoginType
import com.tunc.androidpoetryapp.util.extension.init


class LoginSignupFragment : BaseFragment<LoginSignupViewModel, FragmentLoginSignupBinding>() {

    override val layoutRes: Int = R.layout.fragment_login_signup

    override val classViewModel: Class<LoginSignupViewModel> = LoginSignupViewModel::class.java


    private val adapter: BaseTabsPagerAdapter by lazy {
        BaseTabsPagerAdapter(
            childFragmentManager,
            requireContext()
        )
    }


    override fun initUI() {
        adapter.addFragment("Giriş yap", FormFragment.newInstance(LoginType.TYPE_LOGIN))
        adapter.addFragment("Üye ol", FormFragment.newInstance(LoginType.TYPE_SIGNUP))
        binding.tablayout.init(requireContext(), binding.viewpager, adapter)
    }

    companion object {
        fun newInstance() = LoginSignupFragment()
    }


}
