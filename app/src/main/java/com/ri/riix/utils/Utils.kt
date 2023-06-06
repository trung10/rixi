package com.ri.riix.utils

import java.util.UUID

fun String.toUUID(): UUID = UUID.fromString(this)

fun Int.toTime(): String {
    val minutes = this / 60
    val seconds = this - minutes * 60
    return if (minutes > 0)
    "${if (minutes.toString().length < 2) "0$minutes" else minutes}:${if (seconds.toString().length < 2) "0$seconds" else seconds}"
    else "$seconds"
}