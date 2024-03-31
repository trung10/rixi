package com.ri.riix.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val colorStops = arrayOf(
    0.0f to White50,
    1.1f to Gray1A50
)

val pinkButton = Brush.linearGradient(listOf(ColorA76CC6, ColorCE6260))

val grayButton = Brush.linearGradient(listOf(White50, Gray1A50))

val grayBrush = Brush.linearGradient(listOf(White20, White5))

val buttonBorderBrush = Brush.linearGradient(listOf(ColorWhite36, Color47A86CC3, Color5C6655E9))

val pinkBrush = Brush.linearGradient(listOf(ColorA76CC6, ColorCE6260))

val nextBrush = Brush.linearGradient(listOf(ColorFF9154DC, ColorFF6155EA))


/*
val signGradient = Brush.linearGradient(
    colorStops,
    start = 0f,
    end = 1000f
)*/
