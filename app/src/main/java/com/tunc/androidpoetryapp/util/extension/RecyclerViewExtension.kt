package com.tunc.androidpoetryapp.util.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tunc.androidpoetryapp.util.EndlessOnScrollListener

fun RecyclerView.vertical(
    adapter: RecyclerView.Adapter<*>,
    layoutManager: RecyclerView.LayoutManager? = null,
    scrollBottom: () -> Unit = {}
) {
    this.run {
        this.layoutManager = layoutManager ?: LinearLayoutManager(context)
        this.adapter = adapter
    }

    this.addOnScrollListener(object :
        EndlessOnScrollListener(this@vertical.layoutManager as LinearLayoutManager) {
        override fun onScrolledToEnd() {
            scrollBottom()
        }
    })
}