package com.tunc.androidpoetryapp.presentation.ui.post

import androidx.lifecycle.MutableLiveData
import com.tunc.androidpoetryapp.base.BaseViewModel
import com.tunc.androidpoetryapp.domain.entity.Post
import com.tunc.androidpoetryapp.domain.usecases.PostUseCase
import javax.inject.Inject

class PostViewModel @Inject constructor(private val postUseCase: PostUseCase) : BaseViewModel() {

    val posts = MutableLiveData<List<Post>>()

    fun getPosts(page: Int) {
        execute({
            postUseCase.getPosts(page)
        }, result = {
            posts.value = it
        })
    }

}