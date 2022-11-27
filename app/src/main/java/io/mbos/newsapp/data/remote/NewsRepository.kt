package io.mbos.newsapp.data.remote

import io.mbos.newsapp.data.TaskModel
import io.mbos.newsapp.data.RemoveResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

typealias NewsResult = NetworkResult<List<TaskModel>>

class NewsRepository(private val newsService: NewsService) : BaseRepository() {

    fun fetchNews() = flow {
        emit(
            safeApiCall { newsService.getPosts() }
        )
    }

    fun removeNews(id: Int) = flow {
        delay(1000)
        emit(RemoveResponse(id))
    }
}