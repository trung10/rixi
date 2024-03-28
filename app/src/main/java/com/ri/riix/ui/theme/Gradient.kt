package com.ri.riix.ui.theme

import androidx.compose.ui.graphics.Brush

val colorStops = arrayOf(
    0.0f to White50,
    1.1f to Gray1A50
)

val pinkButton = Brush.linearGradient(listOf(ColorA76CC6, ColorCE6260))

val grayButton = Brush.linearGradient(listOf(White50, Gray1A50))

val grayBrush = Brush.linearGradient(listOf(White20, White5))

/*
val signGradient = Brush.linearGradient(
    colorStops,
    start = 0f,
    end = 1000f
)*/
