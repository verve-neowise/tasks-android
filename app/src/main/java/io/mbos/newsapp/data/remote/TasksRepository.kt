package io.mbos.newsapp.data.remote

import android.util.Log
import io.mbos.newsapp.data.TaskModel
import io.mbos.newsapp.data.RemoveResponse
import io.mbos.newsapp.data.dto.TaskDto
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

typealias NewsResult = NetworkResult<List<TaskDto>>

class TasksRepository(private val tasksService: TasksService) : BaseRepository() {

    fun fetchTasks() = flow {
        Log.d("Network", "fetchTasks")
        emit(
            safeApiCall { tasksService.getTasks() }
        )
    }

    fun removeNews(id: Int) = flow {
        delay(1000)
        emit(RemoveResponse(id))
    }
}