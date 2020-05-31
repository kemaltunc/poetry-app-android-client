package com.tunc.androidpoetryapp.presentation.ui.post

import androidx.lifecycle.Observer
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.databinding.FragmentPostBinding
import com.tunc.androidpoetryapp.domain.entity.Post
import com.tunc.androidpoetryapp.presentation.adapter.PostAdapter
import com.tunc.androidpoetryapp.presentation.adapter.PostCallbacks
import com.tunc.androidpoetryapp.util.extension.vertical
import com.tunc.androidpoetryapp.util.share


class PostFragment : BaseFragment<PostViewModel, FragmentPostBinding>(), PostCallbacks {

    override val layoutRes: Int = R.layout.fragment_post

    override val classViewModel: Class<PostViewModel> = PostViewModel::class.java

    private val adapter: PostAdapter by lazy {
        PostAdapter(this)
    }

    var page = 0

    var canRequest = true

    override fun initUI() {
        binding.rvList.vertical(
            adapter = adapter,
            scrollBottom = this::pagination
        )
        viewModel.getPosts(++page)
    }

    private fun pagination() {
        if (canRequest) viewModel.getPosts(++page)
    }

    override fun clickListeners() {
        binding.refreshLayout.setOnRefreshListener {
            page = 0
            adapter.items = emptyList()
            viewModel.getPosts(++page)
        }
    }

    override fun subscribeObservers() {
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            val tempList = adapter.items.toMutableList()
            tempList.addAll(it)
            adapter.items = tempList
            hideLoadings()
            canRequest = it.isNotEmpty()
        })
    }

    private val hideLoadings = {
        binding.refreshLayout.isRefreshing = false
    }

    override fun postLike(item: Post) {
        viewModel.postLike(item)
    }

    override fun favoritePost(item: Post) {
        viewModel.postFavorite(item)
    }

    override fun sharePost(item: Post) {
        val content = item.title + "\n" + item.content
        share(requireActivity(), content)
    }

    companion object {
        fun newInstance() = PostFragment()
    }
}
