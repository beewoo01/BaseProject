package com.codebros.kbaseproject.widget.adapter.viewholder

import com.codebros.kbaseproject.databinding.ViewholderEmptyBinding
import com.codebros.kbaseproject.model.Model
import com.codebros.kbaseproject.screen.base.BaseViewModel
import com.codebros.kbaseproject.util.provider.CustomResourcesProvider
import com.codebros.kbaseproject.widget.adapter.listener.AdapterListener

class EmptyViewHolder(
    private val binding: ViewholderEmptyBinding,
    viewModel : BaseViewModel,
    customResourcesProvider : CustomResourcesProvider
) : ModelViewHolder<Model>(binding, viewModel, customResourcesProvider){

    override fun reset() = Unit

    override fun bindViews(model: Model, adapterListener: AdapterListener) = Unit
}