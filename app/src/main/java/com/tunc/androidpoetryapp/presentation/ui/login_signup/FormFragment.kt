package com.tunc.androidpoetryapp.presentation.ui.login_signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.databinding.FragmentFormBinding
import com.tunc.androidpoetryapp.util.BundleConstants
import com.tunc.androidpoetryapp.util.enums.LoginType
import com.tunc.androidpoetryapp.util.extension.safeController


class FormFragment : BaseFragment<FormViewModel, FragmentFormBinding>() {

    override val layoutRes: Int = R.layout.fragment_form
    override val classViewModel: Class<FormViewModel> = FormViewModel::class.java


    lateinit var type: LoginType



    override fun initUI() {
        arguments?.let {
            type = it.getSerializable(BundleConstants.FRAGMENT_TYPE) as LoginType
        }

        if (type == LoginType.TYPE_LOGIN) {
            login()
        } else {
            signup()
        }
    }

    override fun subscribeObservers() {
        viewModel.user.observe(viewLifecycleOwner, Observer {
            safeController()?.navigate(R.id.action_formFragment_to_tabFragment)
        })
        viewModel.requestEnd.observe(viewLifecycleOwner, Observer { hideLoading() })
    }

    override fun clickListeners() {
        binding.loginButton.setOnClick {
            showLoading()
            val loginRequest = LoginRequest(binding.emailEd.text(), binding.passwordEd.text())
            viewModel.login(loginRequest)
        }
    }


    private val login = {
        binding.loginButton.setText(getString(R.string.button_login))
    }

    private val signup = {
        binding.nameSurnameContainer.visibility = View.VISIBLE
        binding.confirmPasswordEd.visibility = View.VISIBLE
        binding.loginButton.setText(getString(R.string.button_signup))
    }

    private val showLoading = {
        lockUI(false)
        binding.loginButton.showProgress()
    }

    private val hideLoading = {
        unLockUI()
        binding.loginButton.hideProgress()
    }

    companion object {
        fun newInstance(type: LoginType): FormFragment {

            val formFragment = FormFragment()

            val bundle = Bundle()
            bundle.putSerializable(BundleConstants.FRAGMENT_TYPE, type)

            formFragment.arguments = bundle

            return formFragment
        }
    }
}
