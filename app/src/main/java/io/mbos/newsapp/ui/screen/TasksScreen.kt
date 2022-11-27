package io.mbos.newsapp.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.mbos.newsapp.data.TaskModel
import io.mbos.newsapp.data.TaskStatus
import io.mbos.newsapp.data.remote.NetworkResult
import io.mbos.newsapp.ui.components.Task
import io.mbos.newsapp.ui.theme.WorkSans
import io.mbos.newsapp.viewmodel.NewsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NewsScreen(
    items: List<TaskModel>,
//    viewModel: NewsViewModel = viewModel(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {

//    val newsState = viewModel.fetchNews(items).collectAsState()
//
//    val onDelete: (Int) -> Unit = {
//        coroutineScope.launch {
//            viewModel.removeNews(it).collect {
//                Log.d("NEWS", "NewsScreen: Delete" )
//            }
//        }
//    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        Text(
            modifier = Modifier.padding(15.dp),
            text = "Tasks",
            fontFamily = WorkSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        )

        Divider(color = io.mbos.newsapp.ui.theme.Divider)

        NewsList(news = items, {  })
//
//        when(val result = newsState.value) {
//            is NetworkResult.Loading -> Loading()
//            is NetworkResult.Error -> Error(result.message)
//            is NetworkResult.Success ->
//        }
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

@Composable
private fun NewsList(news: List<TaskModel>, onDelete: (id: Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        items(
            items = news,
            key = { it.id }
        ) { item ->
            Task(item, onDelete)
        }
    }
}

val news = listOf(
    TaskModel(
        0,
        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "",
        TaskStatus.Assigned
    ),
    TaskModel(
        1,
        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto",
        TaskStatus.Completed
    ),
    TaskModel(
        2,
        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "",
        TaskStatus.Accepted
    ),
)

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    NewsScreen(items = news)
}