package com.codebros.kbaseproject.data.repository

import com.codebros.kbaseproject.data.entity.SamplePhotoEntity
import com.codebros.kbaseproject.data.network.ApiService
import com.codebros.kbaseproject.data.url.RetrofitGenerator
import com.codebros.kbaseproject.model.sample.Post
import com.codebros.kbaseproject.model.sample.SamplePhoto
import retrofit2.Response

class SampleRepository : ApiService {

    private val apiService: ApiService = RetrofitGenerator.getApiService()

    override suspend fun getPosts(): Response<List<Post>> = apiService.getPosts()

    override suspend fun getComments(id: Int): Response<List<Post>> = apiService.getComments(id = id)

    override suspend fun getPhotos(): Response<List<SamplePhotoEntity>> = apiService.getPhotos()

}