package com.codebros.kbaseproject.util.mapper

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.codebros.kbaseproject.databinding.ViewholderEmptyBinding
import com.codebros.kbaseproject.databinding.ViewholderSamplePhotoBinding
import com.codebros.kbaseproject.model.CellType
import com.codebros.kbaseproject.model.Model
import com.codebros.kbaseproject.screen.base.BaseViewModel
import com.codebros.kbaseproject.util.provider.CustomResourcesProvider
import com.codebros.kbaseproject.widget.adapter.viewholder.EmptyViewHolder
import com.codebros.kbaseproject.widget.adapter.viewholder.ModelViewHolder
import com.codebros.kbaseproject.widget.adapter.viewholder.sample.SampleViewHolder

object ModelViewHolderMapper {

    @Suppress("UNCHECKED_CAST")
    fun <M : Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        customResourcesProvider: CustomResourcesProvider
    ): ModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (type) {
            CellType.EMPTY_CELL -> {
                Log.wtf("ModelViewHolderMapper", "CellType.EMPTY_CELL")
                Log.wtf("ModelViewHolderMapper", CellType.EMPTY_CELL.toString())
                Log.wtf("ModelViewHolderMapper", CellType.PHOTO_CELL.toString())
                EmptyViewHolder(
                    binding = ViewholderEmptyBinding.inflate(inflater, parent, false),
                    viewModel = viewModel,
                    customResourcesProvider = customResourcesProvider
                )
            }

            CellType.PHOTO_CELL -> {
                Log.wtf("ModelViewHolderMapper", "CellType.PHOTO_CELL")
                SampleViewHolder(
                    ViewholderSamplePhotoBinding.inflate(inflater, parent, false),
                    viewModel,
                    customResourcesProvider
                )
            }


        }

        return viewHolder as ModelViewHolder<M>
    }
}