package com.ri.riix.utils

import com.ri.riix.model.COMMAND
import com.ri.riix.model.DEVICE_STATE
import java.util.UUID

fun String.toUUID(): UUID = UUID.fromString(this)

fun Int.toTime(): String {
    val minutes = this / 60
    val seconds = this - minutes * 60
    return if (minutes > 0)
    "${if (minutes.toString().length < 2) "0$minutes" else minutes}:${if (seconds.toString().length < 2) "0$seconds" else seconds}"
    else "$seconds"
}

fun COMMAND.toCommand() = "*${this}#"

fun DEVICE_STATE.toState() = "*${this}#"