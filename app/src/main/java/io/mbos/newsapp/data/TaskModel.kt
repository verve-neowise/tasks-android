package io.mbos.newsapp.data

import androidx.compose.ui.graphics.Color
import io.mbos.newsapp.data.dto.TaskDto
import io.mbos.newsapp.ui.theme.*

data class TaskModel(
    val id: Int,
    val message: String,
    val comment: String,
    val createTime: String,
    val updateTime: String,
    val deadline: String,
    val status: TaskStatus
) {
    companion object {
        fun from(taskDto: TaskDto): TaskModel {
            return TaskModel(
                id = taskDto.id,
                message = taskDto.message,
                comment = taskDto.comment,
                createTime = taskDto.createAt.toDateString(),
                updateTime = taskDto.updateAt.toDateString(),
                deadline = taskDto.deadline.toDateString(),
                status = TaskStatus.values()[taskDto.status]
            )
        }
    }
}

private fun Long.toDateString(): String {
    return "15.12.22 16:40"
}

enum class TaskStatus(
    val colors: Colors,
) {
    Accepted(AcceptedColors),
    Assigned(AssignedColors),
    Completed(CompletedColors),
    Declined(DeclinedColors)
}