package io.mbos.newsapp.ui.components

import androidx.compose.material.Button
import androidx.compose.runtime.*
import io.mbos.newsapp.data.TaskStatus

@Composable
fun StateButton(callback: (TaskStatus) -> Unit) {

    var expanded = remember { mutableStateOf(false) }

    var selectedItem by remember { mutableStateOf(TaskStatus.values()[0]) }

    Button(onClick = { /*TODO*/ }) {

    }

    ExposedDropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        listItems.forEach { selectedOption ->
            // menu item
            DropdownMenuItem(onClick = {
                selectedItem = selectedOption
                Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT).show()
                expanded = false
            }) {
                Text(text = selectedOption)
            }
        }
    }
}