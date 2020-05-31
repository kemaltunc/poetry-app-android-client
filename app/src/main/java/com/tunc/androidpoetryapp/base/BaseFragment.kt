package com.tunc.androidpoetryapp.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tunc.androidpoetryapp.util.Loading
import dagger.android.support.DaggerFragment
import javax.inject.Inject


abstract class BaseFragment<VM : BaseViewModel, VB : ViewDataBinding> : DaggerFragment() {


    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected abstract val classViewModel: Class<VM>


    lateinit var viewModel: VM

    private var baseActivity: BaseActivity<*>? = null

    private lateinit var uiLock: Dialog


    lateinit var binding: VB

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var createPage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(classViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!this::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
            binding.lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (!createPage) {
            createPage = true
            initUI()
        }

        viewModelSubscriber()
        clickListeners()
        subscribeObservers()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            this.baseActivity = context
        }

    }

    private fun viewModelSubscriber() {
        viewModel.showMessage.observe(this, Observer {
            showMessage(it)
            viewModel.requestEnd.value = true
        })
    }

    open fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    open fun lockUI(showLoading: Boolean = true) {
        if (!this::uiLock.isInitialized) {
            uiLock = Loading.showLoadingDialog(requireContext(), showLoading)
        } else {
            if (!uiLock.isShowing) {
                uiLock.show()
            }
        }
    }

    open fun unLockUI() {
        if (this::uiLock.isInitialized) {
            uiLock.dismiss()
            uiLock.cancel()
        }
    }


    open fun initUI() {}
    open fun subscribeObservers() {}
    open fun clickListeners() {}

    open fun changeTheme(themeId: Int) {
        baseActivity?.changeTheme(themeId)
    }

    open fun changeStatusColor(color: Int) {
        baseActivity?.changeStatusColor(color)
    }


}