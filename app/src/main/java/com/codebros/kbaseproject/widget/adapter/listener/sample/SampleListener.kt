package com.codebros.kbaseproject.widget.adapter.listener.sample

import com.codebros.kbaseproject.model.sample.SamplePhoto
import com.codebros.kbaseproject.widget.adapter.listener.AdapterListener

interface SampleListener : AdapterListener {
    fun onClickItem(model: SamplePhoto)
}