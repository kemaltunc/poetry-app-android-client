package com.tunc.androidpoetryapp.presentation.ui.post

import androidx.lifecycle.MutableLiveData
import com.tunc.androidpoetryapp.base.BaseViewModel
import com.tunc.androidpoetryapp.data.model.request.PostId
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


    fun postLike(post: Post) {
        val postId = PostId(post.postId)
        if (post.isLiked) {
            execute({
                postUseCase.postLike(postId)
            })
        } else {
            execute({
                postUseCase.postunLike(postId)
            })

        }
    }

    fun postFavorite(post: Post) {
        val postId = PostId(post.postId)
        if (post.isFavorite) {
            execute({
                postUseCase.addFavoritePost(postId)
            })
        } else {
            execute({
                postUseCase.removeFavoritePost(postId)
            })
        }
    }

}