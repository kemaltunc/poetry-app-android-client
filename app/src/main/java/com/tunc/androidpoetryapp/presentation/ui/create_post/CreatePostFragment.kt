package com.tunc.androidpoetryapp.presentation.ui.create_post

import androidx.lifecycle.Observer
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.data.model.request.PostRequest
import com.tunc.androidpoetryapp.databinding.FragmentCreatePostBinding
import com.tunc.androidpoetryapp.util.extension.safeController


class CreatePostFragment : BaseFragment<CreatePostViewModel, FragmentCreatePostBinding>() {


    override val layoutRes: Int = R.layout.fragment_create_post
    override val classViewModel: Class<CreatePostViewModel> = CreatePostViewModel::class.java


    override fun initUI() {
        binding.createButton.setOnClick {
            lockUI(false)
            val title = binding.titleEd.text()
            val description = binding.descriptionEd.text()

            val postRequest = PostRequest(title, description)

            viewModel.createPost(postRequest)
        }
    }

    override fun subscribeObservers() {
        viewModel.result.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                showMessage("Şiir oluşturuldu")
                safeController()?.navigateUp()
            } else {
                showMessage("Biir sorun meydana geldi")
            }

            unLockUI()
            binding.createButton.hideProgress()
        })
    }

}
