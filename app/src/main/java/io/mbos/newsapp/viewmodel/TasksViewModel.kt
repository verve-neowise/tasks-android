package io.mbos.newsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import io.mbos.newsapp.data.remote.NetworkResult
import io.mbos.newsapp.data.remote.TasksRepository
import io.mbos.newsapp.data.remote.NewsResult
import io.mbos.newsapp.data.remote.RetrofitFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TasksViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TasksRepository(RetrofitFactory.tasksService())

    private val tasksState = MutableStateFlow<NewsResult>(NetworkResult.Loading())

    val uiTasks: StateFlow<NewsResult> = tasksState

    fun fetchTasks() {
        viewModelScope.launch {
            repository.fetchTasks().collect(tasksState::emit)
        }
    }
}