package com.tunc.androidpoetryapp.presentation.adapter

import android.view.ViewGroup
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseEntity
import com.tunc.androidpoetryapp.base.BaseViewHolder
import com.tunc.androidpoetryapp.databinding.CellHolderLoadingBinding

class LoadingHolder(
    parent: ViewGroup
) : BaseViewHolder<BaseEntity, CellHolderLoadingBinding>(parent, LAYOUT_ID) {
    override fun bind(item: BaseEntity, binding: CellHolderLoadingBinding) {

    }


    companion object {
        const val LAYOUT_ID = R.layout.cell_holder_loading
    }

}