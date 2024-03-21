package com.codebros.kbaseproject.widget.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.codebros.kbaseproject.model.Model
import com.codebros.kbaseproject.screen.base.BaseViewModel
import com.codebros.kbaseproject.util.provider.CustomResourcesProvider
import com.codebros.kbaseproject.widget.adapter.listener.AdapterListener

abstract class ModelViewHolder<M : Model>(
    binding : ViewBinding,
    protected val viewModel : BaseViewModel,
    protected val customResourcesProvider : CustomResourcesProvider
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M) {
        reset()
    }

    abstract fun bindViews(model: M, adapterListener: AdapterListener)
}