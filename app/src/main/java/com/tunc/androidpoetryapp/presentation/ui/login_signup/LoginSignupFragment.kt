package com.tunc.androidpoetryapp.presentation.ui.login_signup

import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.base.BaseTabsPagerAdapter
import com.tunc.androidpoetryapp.databinding.FragmentLoginSignupBinding
import com.tunc.androidpoetryapp.util.enums.LoginType
import com.tunc.androidpoetryapp.util.extension.init


class LoginSignupFragment : BaseFragment<LoginSignupViewModel, FragmentLoginSignupBinding>() {

    override val classViewModel: Class<LoginSignupViewModel> = LoginSignupViewModel::class.java

    override fun setBinding() {
        binding = FragmentLoginSignupBinding.inflate(layoutInflater)
    }

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
