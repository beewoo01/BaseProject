package com.codebros.kbaseproject.data.repository

import com.codebros.kbaseproject.data.entity.DefaultEntity
import com.codebros.kbaseproject.data.entity.SamplePhotoEntity
import com.codebros.kbaseproject.model.sample.Post
import com.codebros.kbaseproject.model.sample.SamplePhoto
import retrofit2.Response
import retrofit2.http.Query

interface DefaultRepository {

    suspend fun getComments(id: Int): Response<List<Post>>

    suspend fun getPosts(): Response<List<Post>>

    suspend fun getPhotos() : Response<List<SamplePhotoEntity>>

}