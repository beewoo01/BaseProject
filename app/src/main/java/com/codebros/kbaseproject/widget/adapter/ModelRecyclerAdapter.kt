package com.codebros.kbaseproject.widget.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.codebros.kbaseproject.model.CellType
import com.codebros.kbaseproject.model.Model
import com.codebros.kbaseproject.screen.base.BaseViewModel
import com.codebros.kbaseproject.util.mapper.ModelViewHolderMapper
import com.codebros.kbaseproject.util.provider.CustomResourcesProvider
import com.codebros.kbaseproject.widget.adapter.listener.AdapterListener
import com.codebros.kbaseproject.widget.adapter.viewholder.ModelViewHolder

class ModelRecyclerAdapter<M : Model, VM : BaseViewModel>(
    private var modelList: List<Model>,
    private var viewModel: VM,
    private val customResourcesProvider: CustomResourcesProvider,
    private val adapterListener: AdapterListener

) : ListAdapter<Model, ModelViewHolder<M>>(Model.DIFF_CALLBACK) {

    override fun getItemCount(): Int = modelList.size

    override fun getItemViewType(position: Int): Int = modelList[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder<M> {
        Log.wtf("ModelRecyclerAdapter", "onCreateViewHolder")
        Log.wtf("ModelRecyclerAdapter", "viewType = $viewType")
        return ModelViewHolderMapper.map(
            parent,
            CellType.values()[viewType],
            viewModel,
            customResourcesProvider
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ModelViewHolder<M>, position: Int) {
        with(holder) {
            bindData(modelList[position] as M)
            bindViews(modelList[position] as M, adapterListener)
        }
    }

    override fun submitList(list: MutableList<Model>?) {
        Log.wtf("ModelRecyclerAdapter", "list size = ${list?.size}")
        Log.wtf("ModelRecyclerAdapter", "list size = ${list?.size}")
        list?.let { modelList = it }
        super.submitList(list)
    }

}