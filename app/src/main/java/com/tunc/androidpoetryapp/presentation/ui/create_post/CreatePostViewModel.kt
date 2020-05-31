package com.tunc.androidpoetryapp.presentation.ui.create_post

import androidx.lifecycle.MutableLiveData
import com.tunc.androidpoetryapp.base.BaseViewModel
import com.tunc.androidpoetryapp.data.model.request.PostRequest
import com.tunc.androidpoetryapp.domain.usecases.PostUseCase
import javax.inject.Inject

class CreatePostViewModel @Inject constructor(private val postUseCase: PostUseCase) :
    BaseViewModel() {

    val result = MutableLiveData<Boolean>()

    fun createPost(postRequest: PostRequest) {

        when {
            postRequest.title.isEmpty() -> ""
            postRequest.content.isEmpty() -> ""
            else -> {
                execute({
                    postUseCase.createPost(postRequest)
                }, result = {
                    result.value = it
                })
            }
        }

    }

}