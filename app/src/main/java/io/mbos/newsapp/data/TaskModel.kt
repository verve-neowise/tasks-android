package io.mbos.newsapp.data

import androidx.compose.ui.graphics.Color
import io.mbos.newsapp.ui.theme.*

data class TaskModel(
    val id: Int,
    val message: String,
    val comment: String,
    val status: TaskStatus
)

enum class TaskStatus(
    val colors: Colors,
) {
    Accepted(AcceptedColors),
    Assigned(AssignedColors),
    Completed(CompletedColors),
    Declined(DeclinedColors)
}