package com.tunc.androidpoetryapp.presentation.ui.post

import android.util.Log
import androidx.lifecycle.Observer
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.databinding.FragmentPostBinding
import com.tunc.androidpoetryapp.domain.entity.Post
import com.tunc.androidpoetryapp.presentation.adapter.PostAdapter
import com.tunc.androidpoetryapp.presentation.adapter.PostCallbacks
import com.tunc.androidpoetryapp.util.extension.vertical


class PostFragment : BaseFragment<PostViewModel, FragmentPostBinding>(), PostCallbacks {


    override val classViewModel: Class<PostViewModel> = PostViewModel::class.java


    private val adapter: PostAdapter by lazy {
        PostAdapter(this)
    }


    var page = 0

    override fun setBinding() {
        binding = FragmentPostBinding.inflate(layoutInflater)
    }

    override fun initUI() {
        binding.rvList.vertical(
            adapter = adapter
        )

        viewModel.getPosts(++page)
    }

    override fun subscribeObservers() {
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            adapter.items = it
        })
    }

    override fun postLike(item: Post) {
        Log.d("postId", item.postId.toString())
    }


    companion object {
        fun newInstance() = PostFragment()
    }
}
