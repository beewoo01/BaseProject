package com.codebros.kbaseproject.widget.adapter.viewholder.sample

import android.util.Log
import com.codebros.kbaseproject.databinding.ViewholderSamplePhotoBinding
import com.codebros.kbaseproject.extention.clear
import com.codebros.kbaseproject.extention.load
import com.codebros.kbaseproject.model.sample.SamplePhoto
import com.codebros.kbaseproject.screen.base.BaseViewModel
import com.codebros.kbaseproject.screen.sample.SampleViewModel
import com.codebros.kbaseproject.util.provider.CustomResourcesProvider
import com.codebros.kbaseproject.widget.adapter.listener.AdapterListener
import com.codebros.kbaseproject.widget.adapter.listener.sample.SampleListener
import com.codebros.kbaseproject.widget.adapter.viewholder.ModelViewHolder

class SampleViewHolder(
    private val binding : ViewholderSamplePhotoBinding,
    viewModel: BaseViewModel,
    customResourcesProvider: CustomResourcesProvider
) : ModelViewHolder<SamplePhoto>(binding, viewModel, customResourcesProvider) {

    override fun reset() = with(binding){
        Log.wtf("SampleViewHolder", "reset")
        thumbnailImage.clear()
    }

    override fun bindData(model: SamplePhoto) {
        super.bindData(model)
        Log.wtf("SampleViewHolder", "bindData")
        with(binding) {
            Log.wtf("SampleViewHolder", "bindData with(binding)")
            thumbnailImage.load(model.thumbnailUrl + ".png", 24f)
            titleTxv.text = model.title
        }
    }

    override fun bindViews(model: SamplePhoto, adapterListener: AdapterListener) {
        Log.wtf("SampleViewHolder", "bindViews")
        with(binding) {
            Log.wtf("SampleViewHolder", "bindViews with(binding)")
            if (adapterListener is SampleListener) {
                root.setOnClickListener {
                    adapterListener.onClickItem(model)
                }
            }
        }
    }
}