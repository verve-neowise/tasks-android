package io.mbos.newsapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.mbos.newsapp.data.TaskModel
import io.mbos.newsapp.data.remote.NetworkResult
import io.mbos.newsapp.ui.components.Task
import io.mbos.newsapp.viewmodel.TasksViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun TasksScreen(
    viewModel: TasksViewModel = viewModel(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {

    val uiTasks = viewModel.uiTasks.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTasks()
    }

    when (val result = uiTasks.value) {
        is NetworkResult.Loading -> Loading()
        is NetworkResult.Error -> Error(result.message)
        is NetworkResult.Success -> NewsList(
            news = result.response.map(TaskModel::from), onDelete = {})
    }
}

@Composable
private fun NewsList(news: List<TaskModel>, onDelete: (id: Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 10.dp
            ),
    ) {
        items(
            items = news,
            key = { it.id }
        ) { item ->
            Task(item, onDelete)
        }
    }
}

@Composable
private fun Loading() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun Error(message: String) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = message,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    TasksScreen()
}