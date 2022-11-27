package io.mbos.newsapp.data.remote

import io.mbos.newsapp.data.TaskModel
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<TaskModel>>
}