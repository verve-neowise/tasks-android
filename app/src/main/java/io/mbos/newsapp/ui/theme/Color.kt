package io.mbos.newsapp.ui.theme

import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Dark = Color(0xFF232323)
val DarkSecondary = Color(0x7D232323)
val Divider = Color(0x56C2C2C2)

class Colors(
    val primary: Color,
    val onPrimary: Color
)

val AcceptedColors = Colors(
    primary = Color(0xFFEFE9FF),
    onPrimary = Color(0xFFAD91FF),
)

val AssignedColors = Colors(
    primary = Color(0xFFE6EEF8),
    onPrimary = Color(0xFF81B0DC),
)

val CompletedColors = Colors(
    primary = Color(0xFFE6F8F2),
    onPrimary = Color(0xFFA3E0CC)
)

val DeclinedColors = Colors(
    primary = Color(0xFFFFE0E0),
    onPrimary = Color(0xFFE57E7E)
)