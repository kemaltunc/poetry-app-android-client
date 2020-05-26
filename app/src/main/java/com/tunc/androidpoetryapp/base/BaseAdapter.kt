package com.tunc.androidpoetryapp.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

abstract class BaseAdapter<M : Any, VH : BaseViewHolder<M>> : RecyclerView.Adapter<VH>() {

    private var onItemClick: ((M) -> Unit) = {}

    private var onViewClick: ((M, View) -> Unit) = { _, _ -> }

    var items: List<M> by Delegates.observable(emptyList()) { prop, old, new ->
        notifyDataSetChanged()
    }


    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setOnViewClick(onViewClick).bindItem(items[position], onItemClick)
    }

    override fun getItemCount() = items.size


    fun onItemClick(onClick: ((M) -> Unit)): BaseAdapter<M, *> {
        this.onItemClick = onClick
        return this
    }


    fun onViewClick(onClick: ((M, View) -> Unit)): BaseAdapter<M, *> {
        this.onViewClick = onClick
        return this
    }


}