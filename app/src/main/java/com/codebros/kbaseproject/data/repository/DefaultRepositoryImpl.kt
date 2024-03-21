package com.codebros.kbaseproject.data.repository

import com.codebros.kbaseproject.data.entity.DefaultEntity
import com.codebros.kbaseproject.data.entity.SamplePhotoEntity
import com.codebros.kbaseproject.data.network.ApiService
import com.codebros.kbaseproject.model.sample.Post
import com.codebros.kbaseproject.model.sample.SamplePhoto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

class DefaultRepositoryImpl(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher
) : DefaultRepository {

    override suspend fun getComments(id: Int): Response<List<Post>> = apiService.getComments(id)

    override suspend fun getPosts(): Response<List<Post>> = apiService.getPosts()

    override suspend fun getPhotos(): Response<List<SamplePhotoEntity>> = apiService.getPhotos()


}