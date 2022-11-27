package io.mbos.newsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import io.mbos.newsapp.data.TaskModel
import io.mbos.newsapp.data.remote.NetworkResult
import io.mbos.newsapp.data.remote.NewsRepository
import io.mbos.newsapp.data.remote.NewsResult
import io.mbos.newsapp.data.remote.RetrofitFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NewsRepository(RetrofitFactory.newsService())

    val newsState = MutableStateFlow<NewsResult>(NetworkResult.Loading())

    fun fetchNews(): MutableStateFlow<NewsResult> {
        viewModelScope.launch {
            repository.fetchNews().collect(newsState::emit)
        }
        return newsState
    }


    fun fetchNews(items: List<TaskModel>): MutableStateFlow<NewsResult> {
        viewModelScope.launch {
            newsState.emit(NetworkResult.Success(items))
        }
        return newsState
    }


    fun removeNews(id: Int) = flow {
        repository.removeNews(id).collect {
            newsState.getAndUpdate { result ->
                if (result is NetworkResult.Success) {
                    val data = result.response.filter { item -> item.id != id }
                    NetworkResult.Success(data)
                }
                else {
                    result
                }
            }
            emit(it)
        }
    }
}