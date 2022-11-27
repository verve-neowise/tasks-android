package io.mbos.newsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.mbos.newsapp.data.TaskModel
import io.mbos.newsapp.data.TaskStatus
import io.mbos.newsapp.ui.theme.Dark
import io.mbos.newsapp.ui.theme.DarkSecondary
import io.mbos.newsapp.ui.theme.Shapes
import io.mbos.newsapp.ui.theme.WorkSans

import io.mbos.newsapp.R

@Composable
fun Task(item: TaskModel, onDelete: (id: Int) -> Unit) {

    val colors = item.status.colors

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        backgroundColor = colors.primary,
        shape = Shapes.large,
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Task #${item.id}",
                    fontSize = 18.sp,
                    fontFamily = WorkSans,
                    fontWeight = FontWeight.SemiBold,
                    color = Dark
                )
                Text(
                    text = item.status.name,
                    fontSize = 14.sp,
                    fontFamily = WorkSans,
                    fontWeight = FontWeight.Normal,
                    color = Dark
                )
            }

            Text(
                text = item.message,
                fontSize = 14.sp,
                fontFamily = WorkSans,
                fontWeight = FontWeight.Normal,
                color = Dark
            )

            if (item.comment.isNotEmpty()) {
                Divider(
                    color = io.mbos.newsapp.ui.theme.Divider,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 10.dp
                    )
                )

                Text(
                    text = item.comment,
                    fontSize = 14.sp,
                    fontFamily = WorkSans,
                    fontWeight = FontWeight.Normal,
                    color = DarkSecondary
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.time),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(Dark)
                    )
                    Text(
                        text = "20.11.2022 13:00 - 19:00",
                        fontSize = 14.sp,
                        fontFamily = WorkSans,
                        fontWeight = FontWeight.Normal,
                        color = Dark,
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colors.onPrimary,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = item.status.name)
                }
            }
        }
    }
}

@Composable
@Preview
private fun DefaultPreview() {

    val comment = "magnam ut rerum iure earum ut voluptatem voluptate"
    val message =
        "ea velit perferendis earum ut voluptatem voluptate itaque iusto\\ntotam pariatur in\\nnemo voluptatem voluptatem autem magni tempora minima in\\nest distinctio qui assumenda accusamus dignissimos officia nesciunt nobis"

    Surface(modifier = Modifier.fillMaxSize()) {
        Task(TaskModel(0, message, comment, TaskStatus.Assigned)) { }
    }
}