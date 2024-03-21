package com.codebros.kbaseproject.model.sample

import android.os.Parcelable
import com.codebros.kbaseproject.model.CellType
import com.codebros.kbaseproject.model.Model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class SamplePhoto(

    override val uid: Long,
    override val type: CellType = CellType.PHOTO_CELL,

    val albumId: Int,
    val photoId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String

) : Model(uid, type)
