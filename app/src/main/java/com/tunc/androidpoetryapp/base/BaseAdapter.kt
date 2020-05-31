package com.tunc.androidpoetryapp.base

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.tunc.androidpoetryapp.presentation.adapter.LoadingHolder
import kotlin.properties.Delegates


abstract class BaseAdapter<Data : BaseEntity> :
    ListAdapter<Data, BaseViewHolder<Data, *>>(DiffCallback<Data>()) {


    private var onItemClick: ((Data) -> Unit) = {}

    private var onViewClick: ((Data, View) -> Unit) = { _, _ -> }


    var newData: Boolean = true

    var items: List<Data> by Delegates.observable(emptyList()) { prop, old, new ->
        this.submitList(new)
        newData = old == new

        if (newData) {
            removeLoading()
        }
    }

    abstract override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Data, *>


    override fun onBindViewHolder(holder: BaseViewHolder<Data, *>, position: Int) {
        holder.setOnViewClick(onViewClick).bindItem(getItem(position), onItemClick)
    }

    private fun removeLoading() {
        this.notifyItemChanged(itemCount - 1)
    }


    override fun getItemViewType(position: Int): Int {
        return if (itemCount > 1 && itemCount == position + 1) {
            if (!newData) {
                LoadingHolder.LAYOUT_ID
            } else 0
        } else return getItem(position).layoutId
    }


    fun onItemClick(onClick: ((Data) -> Unit)): BaseAdapter<Data> {
        this.onItemClick = onClick
        return this
    }


    fun onViewClick(onClick: ((Data, View) -> Unit)): BaseAdapter<Data> {
        this.onViewClick = onClick
        return this
    }


    class DiffCallback<Data : BaseEntity> : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data) =
            oldItem.compareId == newItem.compareId

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Data, newItem: Data) = oldItem == newItem
    }

}