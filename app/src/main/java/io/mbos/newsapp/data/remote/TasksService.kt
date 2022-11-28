package io.mbos.newsapp.data.remote

import io.mbos.newsapp.data.dto.TaskDto
import retrofit2.Response
import retrofit2.http.GET

interface TasksService {

    @GET("/tasks")
    suspend fun getTasks(): Response<List<TaskDto>>
}