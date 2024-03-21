package com.codebros.kbaseproject.screen.sample

import androidx.annotation.StringRes
import com.codebros.kbaseproject.model.sample.SamplePhoto

sealed class SampleState {

    object Uninitialized : SampleState()

    object Loading : SampleState()

    data class Success(
        val samplePhotoModelList : List<SamplePhoto>? = null
    ) : SampleState()

    data class Error(
        @StringRes val messageId : Int
    ) : SampleState()
}